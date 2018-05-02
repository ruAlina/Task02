package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage {
    @FindBy(xpath = "//div[@id='views']")
    public WebElement insurance;

    @FindBy(xpath = "//span [contains(text(),'Оформить')]")
    public WebElement sendButton;

    @FindBy(name = "insured0_surname")
    public WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    public WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    public WebElement insuredBirthdate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "male")
    public WebElement male;

    @FindBy(name = "passport_series")
    public WebElement passportSeries;

    @FindBy(name = "passport_number")
    public WebElement passportNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//span [contains(text(),'Продолжить')]")
    public WebElement buttonNext;

    @FindBy(xpath = "//div [text()='Заполнены не все обязательные поля']")
    public WebElement alertText;

    public InsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void fillField(String fildName, String value) {
        switch (fildName) {
            case "Фамилия латиница":
                fullFillRefactor(insuredSurname, value);
                break;
            case "Имя латиница":
                fullFillRefactor(insuredName, value);
                break;
            case "Дата рождения латиница":
                fullFillRefactor(insuredBirthdate, value);
                break;
            case "Фамилия":
                fullFillRefactor(surname, value);
                break;
            case "Имя":
                fullFillRefactor(name, value);
                break;
            case "Отчество":
                fullFillRefactor(middlename, value);
                break;
            case "Дата рождения":
                fullFillRefactor(birthDate, value);
                break;
            case "Пол":
                fullFillRefactor(male, value);
                break;
            case "Серия":
                fullFillRefactor(passportSeries, value);
                break;
            case "Номер":
                fullFillRefactor(passportNumber, value);
                break;
            case "Дата паспорта":
                fullFillRefactor(issueDate, value);
                break;
            case "Кем выдан":
                fullFillRefactor(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fildName + "' не объявлено на странице");
        }
    }

    protected void fullFillRefactor(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public WebElement selectInsurance(String menuItem) {
        return insurance.findElement(By.xpath(".//div[text()='" + menuItem + "']"));
    }

    public void pressButton() {
        sendButton.click();
    }
}