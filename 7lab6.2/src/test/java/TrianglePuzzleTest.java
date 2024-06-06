//package org.example;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrianglePuzzleTest {

    @Test
    public void solveTrianglePuzzle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://playground.learnqa.ru/puzzle/triangle");

        WebElement giveUpButton = driver.findElement(By.xpath("//button[contains(text(), 'Я сдаюсь')]"));
        if (giveUpButton.isDisplayed()) {
            giveUpButton.click();

            WebElement button2 = driver.findElement(By.xpath("//a[contains(text(), 'Ссылка на ответы')]"));
            WebElement button3 = driver.findElement(By.xpath("//button[contains(text(), 'Спрятать ответы')]"));

            if (button2.isDisplayed() && button3.isDisplayed()) {
                System.out.println("Всё ок");
            }
            else{
                System.out.println("Новые кнопки не найдены!");
            }

        } else {
            System.out.println("Кнопка 'Я сдаюсь' не найдена на странице!");
        }
        driver.quit();
    }
}