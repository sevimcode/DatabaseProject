package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    public HomePage(){

        PageFactory.initElements (Driver.getDriver (), this);
    }


    @FindBy (xpath = "//*[@id=\"sidebar\"]/div")
    public WebElement sideBar;

    @FindBy (xpath = "//span[contains(text(),'Teachers')]")
    public WebElement teachers;

    @FindBy (xpath = "//a[contains(text(),'All Teacher')]")
    public WebElement allTeachers;

    @FindBy (xpath = "//a[contains(text(),'Add Teacher')]")
    public WebElement addTeacher;


    @FindBy (xpath = "//span[contains(text(),'Students')]")
    public WebElement students;

    @FindBy (xpath = "//span[contains(text(),'All Student')]")
    public WebElement allStudents;

    @FindBy (xpath = "//a[contains(text(),'Add Student')]")
    public WebElement addStudent;


}
