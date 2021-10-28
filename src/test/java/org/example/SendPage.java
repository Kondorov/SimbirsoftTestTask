package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendPage {

    public WebDriver driver;

    public SendPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определение локатора кнопки создания письма
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[8]/div/div[3]/div[2]/div[1]/div/div/div/a/span")
    private WebElement writeBtn;

    //определение локатора поля адресата
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")
    private WebElement addressField;

    //определение локатора поля темы письма
    @FindBy(xpath = "//*[contains(@class, 'composeTextField ComposeSubject-TextField')]")
    private WebElement themeField;

    //определение локатора поля текста письма
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div/div")
    private WebElement textField;

    //определение локатора кнопки отправить
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    private WebElement sendBtn;

    //нажимаем кнопку написать
    public void clickWriteBtn() {
        writeBtn.click();
    }

    //нажимаем кнопку отправить
    public void clickSendBtn() {
        sendBtn.click();
    }

    public void clickAddressField() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")));
        addressField.click(); }

    public void clickThemeField() { themeField.click(); }

    public void clickTextField() {
        textField.click();
    }

    public void inputAddress(String address) { addressField.sendKeys(address); }

    public void inputTheme(String theme) {
        themeField.sendKeys(theme);
    }

    public void inputText(String text) {
        textField.sendKeys(text);
    }
}
