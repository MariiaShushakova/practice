package page_objects;

import enums.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class PasterbinPage {
    private WebDriver driver;

    @FindBy(css = ".paste_textarea")
    private WebElement pasteTextArea;

    @FindBy(css = "[name = 'paste_format']")
    private WebElement syntaxHighlDropdown;

    @FindBy(css = "[name = 'paste_expire_date']")
    private WebElement pasteExpirationDropdown;

    @FindBy(xpath = "//span[text() = 'Public']")
    private WebElement pasteExposureDropdown;

    @FindBy(css = "[name = 'paste_name']")
    private WebElement pasteNameTitle;

    @FindBy(css = "#submit")
    private WebElement createNewPasteButton;

    @FindBy(css = "#header_new_paste")
    private WebElement headerNewPasteButton;

    @FindBy(css = ".paste_box_line1")
    private WebElement title;

    @FindBy(css = ".h_640 .buttonsm")
    private WebElement syntaxLabel;

    @FindBy(css = ".li1")
    private List<WebElement> linesOfCode;


    public PasterbinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillNewPaste(Data text){
        pasteTextArea.sendKeys(text.getValue());
    }
    public void setExpiration(Data expiration){
        Select dropdown = new Select(pasteExpirationDropdown);
        dropdown.selectByValue(expiration.getValue());
    }
    public void setName(Data name){
        pasteNameTitle.sendKeys(name.getValue());
    }
    public void createNewPaste(){
        createNewPasteButton.click();
    }
    public void newSession(){
        headerNewPasteButton.click();
    }
    public void setHighlighting(Data highlighting){
        Select dropdown = new Select(syntaxHighlDropdown);
        dropdown.selectByValue(highlighting.getValue());
    }
    public void verifyTitleOfPaste(Data name){
        title.isDisplayed();
        Assert.assertEquals(title.getText(), name.getValue());
    }
    public void verifySyntax(String syntax){
        syntaxLabel.isDisplayed();
        Assert.assertEquals(syntaxLabel.getText(), syntax);
    }

    public List<String> listCode = new ArrayList<String>();
    String textCode = "";
    public void verifyCode(){
        for (int i = 0; i < linesOfCode.size() ; i++) {
            listCode.add(i, linesOfCode.get(i).getText());
        }
        for (String s : listCode) {
            textCode += s + "\n";
        }
//        System.out.println(textCode);
        Assert.assertEquals(textCode, Data.TEXT2.getValue() + "\n");
    }
}
