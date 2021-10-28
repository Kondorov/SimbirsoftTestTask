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

    //аннотация указывает на то, что метод будет выполняться один раз до выполнения всех тестов в классе
    @BeforeClass
    public static void setup() throws MalformedURLException {

        //указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        //подключаем драйвер
        //driver = new ChromeDriver();
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://192.168.1.102:4444"), capability);

        // создаем экземпляры классов созданных страниц
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        sendPage = new SendPage(driver);

        //отображаем процесс
        driver.manage().window();

        //ожидаем загрузку страницы
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //указываем страницу
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {

        //ЛОГИНИМСЯ

        //нажимаем кнопку войти
        loginPage.clickInBtn();

        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //ПОИСК КОЛИЧЕСТВА ПИСЕМ

        //нажатие на поле поиска
        mailPage.clickSearchField();

        //вводим в поиск нужную тему
        mailPage.inputRequest("Simbirsoft Тестовое задание");

        //нажимаем кнопку поиска
        mailPage.clickSearchBtn();

        //сохранение значения количества писем
        String lettersCount = mailPage.getLettersCount();

        //ОТПРАВКА ПИСЬМА

        //нажимаем кнопку написать
        sendPage.clickWriteBtn();

        //вводим адрес
        sendPage.inputAddress(ConfProperties.getProperty("login"));

        //вводим тему
        sendPage.inputTheme("Simbirsoft Тестовое задание. Кондоров");

        //вводим текст
        sendPage.inputText(lettersCount);

        //нажимаем кнопку отправить
        sendPage.clickSendBtn();
    }

    //методы помеченные этой аннотацией выполняются один раз, после завершения всех тестовых методов класса
    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
