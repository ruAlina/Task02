import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.InsurancePage;
import pages.MainPage;
import pages.PreInsurancePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyRefactoringTest extends TestBase {

    @Test
    public void newSeleniumTest() {
        MainPage mainPage = new MainPage(driver);
        click(mainPage.selectMainMenu("Застраховать"));
//        click(By.xpath("//div[contains(@class,'list__item_level')]//A[text()='Страхование путешественников']"));
        click(mainPage.selectSubMenu("Страхование путешественников"));

        PreInsurancePage preInsurancePage = new PreInsurancePage(driver);
        assertEquals("Страхование путешественников", preInsurancePage.title.getText());
        new PreInsurancePage(driver).sendButton.click();
        assertTrue(switchTo("Сбербанк страхование"));

        InsurancePage insurancePage = new InsurancePage(driver);
        click(insurancePage.selectInsurance("Минимальная"));
        insurancePage.pressButton();
        insurancePage.fillField("Фамилия латиница", "Ivanov");
        insurancePage.fillField("Имя латиница", "Ivan");
        insurancePage.fillField("Дата рождения латиница", "25.03.2000");
        insurancePage.fillField("Фамилия", "Иванов");
        insurancePage.fillField("Имя", "Иван");
        insurancePage.fillField("Отчество", "Иванович");
        insurancePage.fillField("Дата рождения", "25.03.2000");
        driver.findElement(By.name("male")).click();
        insurancePage.fillField("Серия", "5525");
        insurancePage.fillField("Номер", "587469");
        insurancePage.fillField("Дата паспорта", "25.03.2015");
        insurancePage.fillField("Кем выдан", "кем-то выдан");

        Assert.assertEquals("Ivanov", insurancePage.insuredSurname.getAttribute("value"));
        Assert.assertEquals("Ivan", insurancePage.insuredName.getAttribute("value"));
        Assert.assertEquals("25.03.2000", insurancePage.insuredBirthdate.getAttribute("value"));
        Assert.assertEquals("Иванов", insurancePage.surname.getAttribute("value"));
        Assert.assertEquals("Иван", insurancePage.name.getAttribute("value"));
        Assert.assertEquals("Иванович", insurancePage.middlename.getAttribute("value"));
        Assert.assertEquals("25.03.2000", insurancePage.birthDate.getAttribute("value"));
        Assert.assertEquals("0", driver.findElement(By.name("male")).getAttribute("value"));
        Assert.assertEquals("5525", insurancePage.passportSeries.getAttribute("value"));
        Assert.assertEquals("587469", insurancePage.passportNumber.getAttribute("value"));
        Assert.assertEquals("25.03.2015", insurancePage.issueDate.getAttribute("value"));
        Assert.assertEquals("кем-то выдан", insurancePage.issuePlace.getAttribute("value"));

        insurancePage.buttonNext.click();
        //    assertEquals("Заполнены не все обязательные поля", driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid']")).getText());
        assertEquals("Заполнены не все обязательные поля", insurancePage.alertText.getText());
    }

}
