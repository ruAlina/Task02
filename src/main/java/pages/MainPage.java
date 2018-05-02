package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//ul[contains(@class,'alt-menu-mid')]")
    public WebElement mainMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement selectMainMenu(String menuItem) {
        return mainMenu.findElement(By.xpath(".//*[contains(text(), '" + menuItem + "')]"));
    }

    public WebElement selectSubMenu(String menuItem) {
        return mainMenu.findElement(By.xpath(".//A[text()='" + menuItem+ "']"));
    }

}
