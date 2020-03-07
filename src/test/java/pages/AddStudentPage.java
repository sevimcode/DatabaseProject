package pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddStudentPage{

    public AddStudentPage(){

        PageFactory.initElements (Driver.getDriver (), this);
    }

    @FindBy(xpath = "//label[contains(text(),\"Firstname\")]/preceding-sibling::*[1]")
    public WebElement firstName;

    @FindBy (xpath = "//label[contains(text(),\"Email\")]/preceding-sibling::*[1]")
    public WebElement email;

    @FindBy (xpath = "//label[contains(text(),\"Password\")]/preceding-sibling::*[1]")
    public WebElement password;

    @FindBy (xpath = "//label[contains(text(),\"Subject\")]/preceding-sibling::*[1]")
    public WebElement subject;

    @FindBy (xpath = "//label[contains(text(),\"Gender\")]/preceding-sibling::*[1]")
    public WebElement gender;

    @FindBy (xpath = "//label[contains(text(),\"Birth Date\")]/preceding-sibling::*[1]")
    public WebElement birthday;

    @FindBy (xpath = "//label[contains(text(),\"Batch\")]/preceding-sibling::*[1]")
    public WebElement batch;

    @FindBy (xpath = "//label[contains(text(),\"Lastname\")]/preceding-sibling::*[1]")
    public WebElement lastname;

    @FindBy (xpath = "//label[contains(text(),\"Joining Date\")]/preceding-sibling::*[1]") //8 -9
    public WebElement joiningDate;

    @FindBy (xpath = "//label[contains(text(),\"Comfirm Password\")]/preceding-sibling::*[1]")
    public WebElement confirmPassword;

    @FindBy (xpath = "//label[contains(text(),\"Mobile number\")]/preceding-sibling::*[1]")
    public WebElement mobileNumber;

    @FindBy (xpath = "//label[contains(text(),\"Admission No\")]/preceding-sibling::*[1]")
    public WebElement admissionNo;

    @FindBy (xpath = "//label[contains(text(),\"Major\")]/preceding-sibling::*[1]")
    public WebElement major;

    @FindBy (xpath = "//label[contains(text(),\"Section\")]/preceding-sibling::*[1]")
    public WebElement section;

    @FindBy (xpath = "//label[contains(text(),\"Premanent Address\")]/preceding-sibling::*[1]")
    public WebElement permanentAddress;

    @FindBy (xpath = "//label[contains(text(),\"Company Name\")]/preceding-sibling::*[1]")
    public WebElement companyName;

    @FindBy (xpath = "//label[contains(text(),\"Start Date\")]/preceding-sibling::*[1]")
    public WebElement startDate ;

    @FindBy (xpath = "//label[contains(text(),\"Street\")]/preceding-sibling::*[1]")
    public WebElement street;

    @FindBy (xpath = "//label[contains(text(),\"State\")]/preceding-sibling::*[1]")
    public WebElement state;

    @FindBy (xpath = "//label[contains(text(),\"Title\")]/preceding-sibling::*[1]")
    public WebElement title;

    @FindBy (xpath = "//label[contains(text(),\"City\")]/preceding-sibling::*[1]")
    public WebElement city;

    @FindBy (xpath = "//label[contains(text(),\"ZipCode\")]/preceding-sibling::*[1]")
    public WebElement zipCode;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    public WebElement submitButton;




}
