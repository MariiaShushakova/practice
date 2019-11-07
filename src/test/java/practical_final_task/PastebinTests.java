package practical_final_task;

import enums.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.PasterbinPage;

public class PastebinTests {
    private WebDriver driver;
    private PasterbinPage pasterbinPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSettup(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        pasterbinPage = new PasterbinPage(driver);
        driver.get("https://pastebin.com/");
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
    }

    @Test(description = "I Can Win")
    public void createNewPasteTest(){
        pasterbinPage.fillNewPaste(Data.TEXT);
        pasterbinPage.setExpiration(Data.EXPIRATION);
        pasterbinPage.setName(Data.NAME);
        pasterbinPage.createNewPaste();
    }

    @Test(description = "Bring It On")
    public void createNewPasteBashTest(){
        pasterbinPage.newSession();
        pasterbinPage.fillNewPaste(Data.TEXT2);
        pasterbinPage.setHighlighting(Data.HIGHLIGHTING_BASH);
        pasterbinPage.setExpiration(Data.EXPIRATION);
        pasterbinPage.setName(Data.NAME2);
        pasterbinPage.createNewPaste();
        pasterbinPage.verifyTitleOfPaste(Data.NAME2);
        pasterbinPage.verifySyntax("Bash");
        pasterbinPage.verifyCode();
    }
}
