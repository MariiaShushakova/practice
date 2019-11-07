package first_test_pacctice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebDriverSeleniumHQTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSettup(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://seleniumhq.org");
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver =null;
    }
    @Test (description = "First test, JIRA binding can be here")
    public void commonSearchTermTest(){
        WebElement searchInput = waitForElementLacatedBy(driver, By.id("q"));
        searchInput.sendKeys("selenium java");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@value='Go']"));
        searchBtn.get(0).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'gsc-webResult') and contains(.,'selenium') and  contains(.,'java')]")));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'gsc-webResult') and contains(.,'selenium') and  contains(.,'java')]"));
        System.out.println("Search result: " + searchResults.size());

        Assert.assertTrue(searchResults.size()>0, "Search res are not empty!");
    }
    private static WebElement waitForElementLacatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
