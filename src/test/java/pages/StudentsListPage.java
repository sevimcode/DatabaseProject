package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentsListPage{


    public StudentsListPage(){

        PageFactory.initElements (Driver.getDriver (), this);
    }

    @FindBy (className = "fa fa-th")
    public WebElement listGridButton;

    @FindBy(xpath = "//tbody/tr[1]/td/a/../h2/a")
    public WebElement tableFirstNameLastName;

    @FindBy (xpath = "//tbody/tr[1]/td[2]")
    public WebElement tableID;

    @FindBy (xpath = "//tbody/tr[1]/td[3]")
    public WebElement tableGender;

    @FindBy (xpath = "//tbody/tr[1]/td[4]")
    public WebElement tableAddress;

    @FindBy (xpath = "//tbody/tr[1]/td[5]")
    public WebElement tableDateofBirth;

    @FindBy (xpath = "//tbody/tr[1]/td[6]")
    public WebElement tableEmail;

    @FindBy (xpath = "//tbody/tr[1]/td[7]")
    public WebElement tableMobile;

    @FindBy (xpath = "//tbody/tr[1]/td[8]/button")
    public WebElement tableDeleteButton;

}


