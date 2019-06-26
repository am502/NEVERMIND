package ru.itis.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ModifiedWebDriver {
    private static final String URL = "https://elb.athuman.com/rpv/";

    private static final String LOGIN = "HAJL-*";
    private static final String PASSWORD = "*";

    private static final String PATH_TO_RESOURCES = "src/main/resources/homework/modified_web_driver/";

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        // Нужно скачать chrome driver в зависимости от вашего браузера и указать путь к нему
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\artur\\Desktop\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.name("ctl00$cplPageContent$txtUserID"));
        username.sendKeys(LOGIN);
        WebElement password = driver.findElement(By.name("ctl00$cplPageContent$txtPassword"));
        password.sendKeys(PASSWORD);

        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.xpath("//img")).click();
        driver.findElement(By.xpath("//a[@class='list-group-item']")).click();

        String mainUrl = driver.getCurrentUrl();

        Scanner scanner = new Scanner(new File(PATH_TO_RESOURCES + "tasks.txt"));
        while (scanner.hasNextLine()) {
            String task = scanner.nextLine();
            String type;
            int questionCount;
            if (task.contains("-")) {
                task = "L" + task;
                type = "test";
                questionCount = 10;
            } else {
                task = "L" + task;
                type = "summary test";
                questionCount = 20;
            }

            String xpath = "//a[@class='unit-btn' and starts-with(., '%s') and " +
                    "'%s' = substring(., string-length(.) - string-length('%<s') + 1)]";
            if (!driver.findElement(By.xpath(String.format(xpath + "/ancestor::li", task, type)))
                    .getAttribute("class").contains("finished")) {
                Map<String, String> answers = null;

                try {
                    answers = deserialize(task);
                } catch (IOException ignored) {
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                click(wait, String.format(xpath, task, type));
                click(wait, "//a[@class='btn btn-info btn-lg btn-block']");

                if (answers == null) {
                    answers = new HashMap<>();
                    for (int i = 0; i < questionCount; i++) {
                        click(wait, String.format("//input[@value='%s']", "1"));

                        click(wait, "//a[@class='player-btn btn-default btn-next']");

                        String text = waitAndGet(wait, "//div[@class='well']//p").getText();
                        String src = "";
                        try {
                            src = driver.findElement(By.xpath("//div[@class='well']//p//img")).getAttribute("src");
                        } catch (Exception ignored) {
                        }

                        String answer = waitAndGet(wait, "//nobr").getText();

                        Thread.sleep(3000);

                        answers.put(text + src, answer);

                        if (i != questionCount - 1) {
                            click(wait, "//a[@class='player-btn btn-default btn-next']");
                        } else {
                            click(wait, "//a[@class='player-btn btn-default btn-close']");
                            driver.switchTo().alert().accept();
                            serialize(answers, task);
                            click(wait, String.format(xpath, task, type));
                            click(wait, "//a[@class='btn btn-info btn-lg btn-block']");
                        }
                    }
                }

                System.out.println(answers.size());

                for (int i = 0; i < questionCount; i++) {
                    Thread.sleep(5000);

                    String text = waitAndGet(wait, "//div[@class='well']//p").getText();
                    String src = "";
                    try {
                        src = driver.findElement(By.xpath("//div[@class='well']//p//img"))
                                .getAttribute("src");
                    } catch (Exception ignored) {
                    }

                    click(wait, String.format("//input[@value='%s']", answers.get(text + src)));

                    click(wait, "//a[@class='player-btn btn-default btn-next']");

                    if (driver.findElement(By.xpath("//span[@class='result-txt']")).getText().equals("不正解")) {
                        System.exit(0);
                    }

                    click(wait, "//a[@class='player-btn btn-default btn-next']");
                }

                Thread.sleep(4000);

                driver.get(mainUrl);
            }
        }
    }

    private static void click(WebDriverWait wait, String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    private static WebElement waitAndGet(WebDriverWait wait, String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private static void serialize(Map<String, String> answers, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(PATH_TO_RESOURCES + "answers/" + fileName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(answers);
            out.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<String, String> deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(PATH_TO_RESOURCES + "answers/" + fileName + ".ser");
        ObjectInputStream in = new ObjectInputStream(fis);
        HashMap<String, String> result = (HashMap<String, String>) in.readObject();
        in.close();
        fis.close();
        return result;
    }
}