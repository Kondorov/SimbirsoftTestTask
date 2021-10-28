package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendPage {

    private WebDriver driver;

    public SendPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определение локатора кнопки создания письма
    @FindBy(xpath = "//*[contains(@class, 'mail-ComposeButton js-main-action-compose')]")
    private WebElement writeBtn;

    //определение локатора поля адресата
    @FindBy(xpath = "//*[contains(@class, 'composeYabbles')]")
    private WebElement addressField;

    //определение локатора поля темы письма
    @FindBy(xpath = "//*[contains(@class, 'composeTextField ComposeSubject-TextField')]")
    private WebElement themeField;

    //определение локатора поля текста письма
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div/div")
    private WebElement textField;

    //определение локатора кнопки отправить
    @FindBy(xpath = "//*[contains(@class, 'Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l')]")
    private WebElement sendBtn;

    //нажимаем кнопку написать
    public void clickWriteBtn() {
        writeBtn.click();
    }

    //нажимаем кнопку отправить
    public void clickSendBtn() {
        sendBtn.click();
    }

    public void inputAddress(String address) { addressField.sendKeys(address); }

    public void inputTheme(String theme) {
        themeField.sendKeys(theme);
    }

    public void inputText(String text) {
        textField.sendKeys(text);
    }
}
