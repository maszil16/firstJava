package ru.yandex;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Test05 {
    public ChromeDriver driver;
    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver","/test/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void Test05() {

        driver.get("https://yandex.ru");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Дзен"));
        WebElement signIn = driver.findElement(By.cssSelector("body > div.content > div > div.loading-boundary-stacked-layout__content-24 > div > div.dzen-header-desktop__header-ST > div > div.dzen-header-desktop__rightItems-3y > div.dzen-header-desktop__profileMenu-3q > a > span > span"));
        signIn.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div.passp-page > div.passp-flex-wrapper > div > div > div.passp-auth-content")));
        driver.findElement(By.cssSelector("#root > div > div.passp-page > div.passp-flex-wrapper > div > div > div.passp-auth-content > div:nth-child(3) > div > div > div > div.passp-login-form > form > div.AuthLoginInputToggle-wrapper > div:nth-child(1) > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-login")));
        driver.findElement(By.id("passp-field-login")).sendKeys("omariyovchinnikova");
        driver.findElement(By.id("passp:sign-in")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-passwd")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys("714229mM");

    }
    @After
    public void Close() {
        driver.quit();

    }
}
