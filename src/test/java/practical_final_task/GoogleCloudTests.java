package practical_final_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudTests {
    private WebDriver driver;
//    private PasterbinPage pasterbinPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSettup(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        pasterbinPage = new PasterbinPage(driver);
        driver.get("https://cloud.google.com/");
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
    }

    @Test(description = "Hurt Me Plenty")
    public void googleCloudPlatformPricingCalculatorTest(){

    }
}
