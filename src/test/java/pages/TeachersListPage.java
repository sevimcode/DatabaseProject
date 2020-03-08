package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeachersListPage{


    public TeachersListPage(){

        PageFactory.initElements (Driver.getDriver (), this);
    }

    @FindBy(xpath = "//thead/tr/th[2]")
    public WebElement headerTableID;

    @FindBy(xpath = "//tbody/tr[1]/td/a/../h2/a")
    public WebElement firstColumntableFirstNameLastName;

    @FindBy (xpath = "//tbody/tr[1]/td[2]")
    public WebElement firstColumnTableID;

    @FindBy (xpath = "//tbody/tr[1]/td[3]")
    public WebElement firstColumnTableGender;

    @FindBy (xpath = "//tbody/tr[1]/td[4]")
    public WebElement firstColumntableAddress;

    @FindBy (xpath = "//tbody/tr[1]/td[5]")
    public WebElement firstColumntableDateofBirth;

    @FindBy (xpath = "//tbody/tr[1]/td[6]")
    public WebElement firstColumntableEmail;

    @FindBy (xpath = "//tbody/tr[1]/td[7]")
    public WebElement firstColumntableMobile;

    @FindBy (xpath = "//tbody/tr[1]/td[8]/button")
    public WebElement firstColumntableDeleteButton;

    @FindBy (xpath = "//tbody/tr/td[8]/button/preceding-sibling::*")
    public WebElement editButton;
    @FindBy (xpath = "//tbody/tr/td[8]/button")
    public WebElement deleteButton;


    @FindBy (xpath = "//button[contains(text(),'Delete')]")
    public WebElement deleteAlertButton;


}
