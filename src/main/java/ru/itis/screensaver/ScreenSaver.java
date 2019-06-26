package ru.itis.screensaver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenSaver {
    private static int id = 0;
    private Robot robot;
    private BufferedImage screenOriginal;
    private BufferedImage screenCopy;
    private Rectangle area;

    public ScreenSaver() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        JFrame mainFrame = new JFrame();

        JFrame secondaryFrame = new JFrame();
        JLabel screenLabel = new JLabel();
        secondaryFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    secondaryFrame.setVisible(false);
                    mainFrame.setVisible(true);
                    BufferedImage result = screenOriginal.getSubimage(area.x, area.y, area.width, area.height);
                    try {
                        ImageIO.write(result, "png",
                                new File("src/main/resources/homework/screens/" + getId() + ".png"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    area = null;
                }
            }
        });
        screenLabel.addMouseMotionListener(new MouseMotionAdapter() {
            int x1, y1, x2, y2;

            @Override
            public void mouseMoved(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                draw(screenOriginal, screenCopy);
                screenLabel.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                area = new Rectangle(x1, y1, x2 - x1, y2 - y1);
                draw(screenOriginal, screenCopy);
                screenLabel.repaint();
            }
        });

        JButton screenButton = new JButton();
        Action screenButtonAction = new AbstractAction("Screen") {
            public void actionPerformed(ActionEvent event) {
                mainFrame.setVisible(false);
                secondaryFrame.setVisible(true);

                screenOriginal = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                screenCopy = new BufferedImage(screenOriginal.getWidth(),
                        screenOriginal.getHeight(), screenOriginal.getType());

                screenLabel.setIcon(new ImageIcon(screenCopy));
            }
        };
        screenButton.setAction(screenButtonAction);

        mainFrame.getRootPane().registerKeyboardAction(screenButtonAction, KeyStroke.getKeyStroke("SPACE"),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        mainFrame.add(screenButton);
        mainFrame.setResizable(false);
        mainFrame.setTitle("Screen Saver");
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        secondaryFrame.add(screenLabel);
        secondaryFrame.setResizable(false);
        secondaryFrame.setUndecorated(true);
        secondaryFrame.pack();
        secondaryFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        secondaryFrame.setLocationByPlatform(true);
        secondaryFrame.setVisible(false);
    }

    private void draw(BufferedImage original, BufferedImage copy) {
        Graphics2D g2 = copy.createGraphics();
        g2.drawImage(original, 0, 0, null);
        g2.setColor(Color.GREEN);
        if (area == null) {
            return;
        }
        g2.draw(area);
        g2.dispose();
    }

    private static int getId() {
        id++;
        return id;
    }

    public static void main(String[] args) {
        new ScreenSaver();
    }
}
