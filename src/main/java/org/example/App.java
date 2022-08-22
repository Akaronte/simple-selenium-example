package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.network.Network;

import java.awt.Robot;
import java.awt.AWTException;
import java.util.Optional;

public class App 
{
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Request URL: "+request.getRequest().getUrl());
            System.out.println("Request METHOD: "+request.getRequest().getMethod());
            System.out.println("Request HEADERS: "+request.getRequest().getHeaders());
        });

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
