package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage{


    public ProfilePage(){

        PageFactory.initElements (Driver.getDriver (),this);
    }

    @FindBy (xpath = "//ul/li/span[2]/a")
    public WebElement ID;

    @FindBy (xpath = "//ul/li[3]/span[2]/a")
    public WebElement email;



}
