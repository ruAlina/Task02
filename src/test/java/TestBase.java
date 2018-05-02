import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import prop.TestProperties;

public class TestBase {
    protected static WebDriver driver;
    protected static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();


    @BeforeClass
    public static void setUp() throws Exception {
        String browser = properties.getProperty("browser");
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void click(By locator) {
        click(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(WebElement element) {
        click(ExpectedConditions.elementToBeClickable(element));
    }

    private void click(ExpectedCondition<WebElement> condition) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(condition).click();
    }

    boolean switchTo(String titlePart) {
        String old = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (handle.equals(old))
                continue;
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(titlePart))
                return true;
        }
        driver.switchTo().window(old);
        return false;
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}