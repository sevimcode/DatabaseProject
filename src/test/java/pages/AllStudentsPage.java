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


    @FindBy (linkText = "//div[@class='content-page']/div[2]/div[last()]/div/h4/a")
    public WebElement lastCreatedStudent;

    //div[@class='content-page']/div[2]/div[last()]/div/div/following-sibling::*/a

    @FindBy (xpath = "//div[@class='dropdown-menu dropdown-menu-right'][last()]")
    public WebElement dropDownMenu;

    public WebElement locateStudent(String name){
        return Driver.getDriver ().findElement (By.xpath ("//a[.='" + name + "']"));
    }



}
