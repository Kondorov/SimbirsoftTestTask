package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static LoginPage loginPage;
    private static MailPage mailPage;
    private static SendPage sendPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //driver = new ChromeDriver();
        DesiredCapabilities capability=DesiredCapabilities.chrome();
        driver=new RemoteWebDriver(new URL(ConfProperties.getProperty("seleniumhub")), capability);
        loginPage=new LoginPage(driver);
        mailPage=new MailPage(driver);
        sendPage=new SendPage(driver);
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        loginPage.clickInBtn();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        mailPage.clickSearchField();
        mailPage.inputRequest("Simbirsoft Тестовое задание");
        mailPage.clickSearchBtn();
        String lettersCount = mailPage.getLettersCount();
        sendPage.clickWriteBtn();
        sendPage.inputAddress(ConfProperties.getProperty("login"));
        sendPage.inputTheme("Simbirsoft Тестовое задание. Кондоров");
        sendPage.inputText(lettersCount);
        sendPage.clickSendBtn();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
