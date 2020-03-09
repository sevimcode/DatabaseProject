package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTeacherPage{

    public AddTeacherPage() {

        PageFactory.initElements (Driver.getDriver () , this);
    }


    @FindBy(xpath = "//label[contains(text(),\"Firstname\")]/preceding-sibling::*[1]")
    public WebElement firstName;

    @FindBy(xpath = "//label[contains(text(),\"Email\")]/preceding-sibling::*[1]")
    public WebElement email;

    @FindBy(xpath = "//label[contains(text(),\"Password\")]/preceding-sibling::*[1]")
    public WebElement password;

    @FindBy(xpath = "//label[contains(text(),\"Subject\")]/preceding-sibling::*[1]")
    public WebElement subject;

    @FindBy(xpath = "//label[contains(text(),\"Gender\")]/preceding-sibling::*[1]")
    public WebElement gender;

    @FindBy(xpath = "//label[contains(text(),\"Birth Date\")]/preceding-sibling::*[1]")
    public WebElement birthday;

    @FindBy(xpath = "//label[contains(text(),\"Batch\")]/preceding-sibling::*[1]")
    public WebElement batch;

    @FindBy(xpath = "//label[contains(text(),\"Lastname\")]/preceding-sibling::*[1]")
    public WebElement lastname;

    @FindBy(xpath = "//label[contains(text(),\"Joining Date\")]/preceding-sibling::*[1]") //8 -9
    public WebElement joiningDate;

    @FindBy(xpath = "//label[contains(text(),\"Confirm Password\")]/preceding-sibling::*[1]")
    public WebElement confirmPassword;

    @FindBy(xpath = "//label[contains(text(),\"Mobile number\")]/preceding-sibling::*[1]")
    public WebElement mobileNumber;

    @FindBy(xpath = "//label[contains(text(),\"Department\")]/preceding-sibling::*[1]")
    public WebElement department;

    @FindBy(xpath = "//label[contains(text(),\"Salary\")]/preceding-sibling::*[1]")
    public WebElement salary;

    @FindBy(xpath = "//label[contains(text(),\"Section\")]/preceding-sibling::*[1]")
    public WebElement section;

    @FindBy(xpath = "//label[contains(text(),\"Premanent Address\")]/preceding-sibling::*[1]")
    public WebElement permanentAddress;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitButton;

}













