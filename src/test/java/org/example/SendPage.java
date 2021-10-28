package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendPage {

    private WebDriver driver;

    public SendPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath="//*[contains(@class, 'mail-ComposeButton js-main-action-compose')]")
    private WebElement writeBtn;

    @FindBy(xpath="//*[contains(@class, 'composeYabbles')]")
    private WebElement addressField;

    @FindBy(xpath="//*[contains(@class, 'composeTextField ComposeSubject-TextField')]")
    private WebElement themeField;

    @FindBy(xpath="//*[@id=\"cke_1_contents\"]/div/div")
    private WebElement textField;

    @FindBy(xpath="//*[contains(@class, 'Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l')]")
    private WebElement sendBtn;

    public void clickWriteBtn() {
        writeBtn.click();
    }

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
