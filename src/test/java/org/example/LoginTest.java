package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static MailPage mailPage;
    public static SendPage sendPage;
    public static WebDriver driver;
    public static String login = "SimbirsoftKondorov@yandex.ru";
    public static String password = "SimbirsoftKondorovTest";

    //аннотация указывает на то, что метод будет выполняться один раз до выполнения всех тестов в классе
    @BeforeClass
    public static void setup(){

        //указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //подключаем драйвер
        driver = new ChromeDriver();

        // создаем экземпляры классов созданных страниц
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        mailPage = new MailPage(driver);
        sendPage = new SendPage(driver);

        //отображаем процесс
        driver.manage().window();

        //ожидаем загрузку страницы
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //указываем страницу
        driver.get("https://passport.yandex.ru/auth");
    }

    @Test
    public void loginTest() {

        //ЛОГИНИМСЯ

        //вводим логин
        loginPage.inputLogin(login);

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //вводим пароль
        loginPage.inputPasswd(password);

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //входим в меню пользователя
        profilePage.entryMenu();

        //входим в почту
        profilePage.entryMail();

        //ПОИСК КОЛИЧЕСТВА ПИСЕМ

        //нажатие на поле поиска
        mailPage.clickSearchField();

        //вводим в поиск нужную тему
        mailPage.inputRequest("Simbirsoft Тестовое задание");

        //нажимаем кнопку поиска
        mailPage.clickSearchBtn();

        //вывод количества писем
        String lettersCount = mailPage.getLettersCount();

        System.out.println(lettersCount);

        //ОТПРАВКА ПИСЬМА

        //нажимаем кнопку написать
        sendPage.clickWriteBtn();

        //нажимаем на поле адресата
        sendPage.clickAddressField();

        //вводим адрес
        sendPage.inputAddress(login);

        //нажимаем на поле темы
        sendPage.clickThemeField();

        //вводим тему
        sendPage.inputTheme("Simbirsoft Тестовое задание. Кондоров");

        //нажимаем на поле текста
        sendPage.clickTextField();

        //вводим текст
        sendPage.inputText(lettersCount);

        //нажимаем кнопку отправить
        sendPage.clickSendBtn();
    }

    //методы помеченные этой аннотацией выполняются один раз, после завершения всех тестовых методов класса
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
