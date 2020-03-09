package pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllStudentsPage{

    public AllStudentsPage(){

        PageFactory.initElements (Driver.getDriver (), this);
    }


    @FindBy (xpath = "//a[@href='teachers-list.html']")
    public WebElement listToggleButton;


    @FindBy (xpath = "//div[@class='content-page']/div[2]/div[last()]/div/h4/a")
    public WebElement lastCreatedStudent;

    @FindBy (css = "#app > div > div:nth-child(3) > div > div.row.staff-grid-row > div:nth-child(1) > div > h4 > a")
    public WebElement firstStudent;

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


    public WebElement locateStudent(String name){
        return Driver.getDriver ().findElement (By.xpath ("//a[.='" + name + "']"));
    }



}
