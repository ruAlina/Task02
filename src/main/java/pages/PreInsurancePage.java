package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreInsurancePage {

    @FindBy(xpath = "//div[@class='sbrf-rich-outer']")
    public WebElement title;

    @FindBy(xpath = "//img [contains(@src,'banner-zashita-traveler.jpg')]")
    public WebElement sendButton;

    public PreInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton));
    }
}