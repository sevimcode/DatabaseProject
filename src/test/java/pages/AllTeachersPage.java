package pages;

import Utilities.Driver;
import Utilities.TemporaryStorage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllTeachersPage{



    public AllTeachersPage(){

        PageFactory.initElements (Driver.getDriver (), this);
    }


    @FindBy (xpath = "//*[@id=\"app\"]/div/div/div[2]/div[last()]/div/h4/a")
    public WebElement lastCreatedTeacherName;

    @FindBy (css = "#app > div > div > div.row.staff-grid-row > div:nth-child(1) > div > div.profile-img > a")
    public WebElement firstTeacher;

    @FindBy (xpath = "(//i[@class='fa fa-ellipsis-v'])[2]")
    public WebElement threeDots;
    @FindBy (xpath = "//i[@class='fa fa-pencil m-r-5']")
    public WebElement edit;

    @FindBy (xpath = "//i[@class='fa fa-trash-o m-r-5']")
    public WebElement delete;

    @FindBy (xpath = "//form/div/div/button")
    public WebElement alertDelete;

    @FindBy (xpath = "//div[@class='dropdown-menu dropdown-menu-right'][last()]")
    public WebElement dropDownMenu;

    @FindBy (xpath = "//a[2]/i")
    public WebElement listButton;

    @FindBy (xpath = "//a[@href='teachers-list.html']")
    public WebElement listToggleButton;


//    @FindBy (xpath = "//*[@id='app']/div/div/div[2]/div[last()]/div/div/a")
//    public WebElement lastCreatedTeacher;

}
