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




    @FindBy (xpath = "//a[@href='teachers-list.html']")
    public WebElement listToggleButton;


    @FindBy (xpath = "//*[@id='app']/div/div/div[2]/div[last()]/div/div/a")
    public WebElement lastCreatedTeacher;

}
