package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // определение локатора поля поиска писем
    @FindBy(xpath = "//*[contains(@class, 'textinput__control')]")
    private WebElement searchField;

    // определение кнопки найти
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[8]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/form/button")
    private WebElement searchBtn;

    // определение локатора поля с количеством найденных писем
    @FindBy(xpath = "//*[contains(@class, 'mail-MessagesSearchInfo-Title_misc')]")
    private WebElement lettersCountLabel;

    //получаем из лэйбла количество писем
    public String getLettersCount() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'mail-MessagesSearchInfo-Title_misc')]")));
        String lettersCount = lettersCountLabel.getText();
        return lettersCount;
    }

    //нажатие на поле поиска
    public void clickSearchField() {
        searchField.click();
    }

    //вводим тему письма
    public void inputRequest(String request) {
        searchField.sendKeys(request);
    }

    //нажатие кнопки поиска
    public void clickSearchBtn() {
        searchBtn.click();
    }
}