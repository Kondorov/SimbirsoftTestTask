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
        this.driver=driver;
    }

    @FindBy(xpath="//*[contains(@class, 'textinput__control')]")
    private WebElement searchField;

    @FindBy(xpath="//*[@id=\"js-apps-container\"]/div[2]/div[8]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/form/button")
    private WebElement searchBtn;

    @FindBy(xpath="//*[contains(@class, 'mail-MessagesSearchInfo-Title_misc')]")
    private WebElement lettersCountLabel;

    public String getLettersCount() {
        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'mail-MessagesSearchInfo-Title_misc')]")));
        String lettersCount=lettersCountLabel.getText();
        return lettersCount;
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void inputRequest(String request) {
        searchField.sendKeys(request);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }
}