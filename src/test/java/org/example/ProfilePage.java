package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определение локатора меню пользователя
    @FindBy(xpath = "//*[contains(@class, 'user-pic__image')]")
    private WebElement userMenu;

    //определение локатора раздела с почтой
    @FindBy(xpath = "//*[contains(@class, 'legouser__menu-counter')]")
    private WebElement mailBtn;

    // метод для нажатия кнопки меню пользователя
    public void entryMenu() {
        userMenu.click(); }

    // метод для нажатия кнопки почты
    public void entryMail() {
        mailBtn.click(); }
}
