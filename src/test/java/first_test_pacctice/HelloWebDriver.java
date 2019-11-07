package first_test_pacctice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("q")));

//        WebElement searchInput = driver.findElement(By.id("q"));
        WebElement searchInput = waitForElementLacatedBy(driver, By.id("q"));
        searchInput.sendKeys("selenium java");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@value='Go']"));
        searchBtn.get(0).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'gsc-webResult') and contains(.,'selenium') and  contains(.,'java')")));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'gsc-webResult') and contains(.,'selenium') and  contains(.,'java')"));
        System.out.println("Search result: " + searchResults.size());


        driver.quit();
    }

    private static WebElement waitForElementLacatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
