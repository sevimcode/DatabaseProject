package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditTeacherPage{

    public EditTeacherPage(){
        PageFactory.initElements (Driver.getDriver (), this);
    }

    @FindBy (xpath = "//label[contains(text(),\"Email\")]/preceding-sibling::*[1]")
    public WebElement email;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitButton;

}
