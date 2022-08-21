package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.Robot;
import java.awt.AWTException;

public class App 
{
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://piensoluegoinstalo.com");

        try {
            Robot robot = new Robot();
            robot.mouseMove(300, 600);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        //driver.quit();
    }
}
