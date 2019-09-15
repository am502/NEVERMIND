package ru.itis.worker.impl;

import ru.itis.worker.StartPauseFrame;
import ru.itis.worker.Worker;

import java.awt.*;
import java.util.Scanner;

import static java.awt.event.KeyEvent.*;

// Ставить русскую раскладку
public class ScanAndPaste implements Worker {
    private static final int DELAY = 2000;

    private Robot robot;
    private String text;

    public ScanAndPaste() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        text = new Scanner(System.in).nextLine();
    }

    private void processChar(char c) {
        boolean upper = Character.isUpperCase(c);
        c = Character.toLowerCase(c);
        switch (c) {
            case 'й': typeChar(VK_Q, upper); break;
            case 'ц': typeChar(VK_W, upper); break;
            case 'у': typeChar(VK_E, upper); break;
            case 'к': typeChar(VK_R, upper); break;
            case 'е': typeChar(VK_T, upper); break;
            case 'н': typeChar(VK_Y, upper); break;
            case 'г': typeChar(VK_U, upper); break;
            case 'ш': typeChar(VK_I, upper); break;
            case 'щ': typeChar(VK_O, upper); break;
            case 'з': typeChar(VK_P, upper); break;
            case 'х': typeChar(VK_OPEN_BRACKET, upper); break;
            case 'ъ': typeChar(VK_CLOSE_BRACKET, upper); break;
            case 'ф': typeChar(VK_A, upper); break;
            case 'ы': typeChar(VK_S, upper); break;
            case 'в': typeChar(VK_D, upper); break;
            case 'а': typeChar(VK_F, upper); break;
            case 'п': typeChar(VK_G, upper); break;
            case 'р': typeChar(VK_H, upper); break;
            case 'о': typeChar(VK_J, upper); break;
            case 'л': typeChar(VK_K, upper); break;
            case 'д': typeChar(VK_L, upper); break;
            case 'ж': typeChar(VK_SEMICOLON, upper); break;
            case 'э': typeChar(VK_QUOTE, upper); break;
            case 'я': typeChar(VK_Z, upper); break;
            case 'ч': typeChar(VK_X, upper); break;
            case 'с': typeChar(VK_C, upper); break;
            case 'м': typeChar(VK_V, upper); break;
            case 'и': typeChar(VK_B, upper); break;
            case 'т': typeChar(VK_N, upper); break;
            case 'ь': typeChar(VK_M, upper); break;
            case 'б': typeChar(VK_COMMA, upper); break;
            case 'ю': typeChar(VK_PERIOD, upper); break;

            case 'ё': typeChar(VK_BACK_QUOTE, upper); break;

            case '!': typeChar(VK_1, true); break;
            case '?': typeChar(VK_7, true); break;
            case '.': typeChar(VK_SLASH, false); break;
            case ',': typeChar(VK_SLASH, true); break;
            case '№': typeChar(VK_3, true); break;
            case ':': typeChar(VK_6, true); break;
            case '-': typeChar(VK_MINUS, false); break;
            case ' ': typeChar(VK_SPACE, false); break;
            case '(': typeChar(VK_9, true); break;
            case ')': typeChar(VK_0, true); break;
            case '/': typeChar(VK_BACK_SLASH, true); break;
            case '"': typeChar(VK_2, true); break;

            case '0': typeChar(VK_0, false); break;
            case '1': typeChar(VK_1, false); break;
            case '2': typeChar(VK_2, false); break;
            case '3': typeChar(VK_3, false); break;
            case '4': typeChar(VK_4, false); break;
            case '5': typeChar(VK_5, false); break;
            case '6': typeChar(VK_6, false); break;
            case '7': typeChar(VK_7, false); break;
            case '8': typeChar(VK_8, false); break;
            case '9': typeChar(VK_9, false); break;
        }
    }

    private void typeChar(int code, boolean shift) {
        if (shift) {
            robot.keyPress(VK_SHIFT);
        }
        robot.keyPress(code);
        robot.keyRelease(code);
        if (shift) {
            robot.keyRelease(VK_SHIFT);
        }
    }

	@Override
	public void workOneTime() {
		robot.delay(DELAY);

		for (char c : text.toCharArray()) {
			processChar(c);
			robot.delay(30);
		}

		typeChar(VK_ENTER, false);

		robot.delay(DELAY);
	}

	public static void main(String[] args) {
		Worker worker = new ScanAndPaste();
		EventQueue.invokeLater(() -> new StartPauseFrame(worker));
	}
}
