package step_definitions;

import Utilities.*;
import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TeacherPage_StepDefs{

    HomePage homePage = new HomePage ();
    AddTeacherPage addteacherPage = new AddTeacherPage ();
    AllTeachersPage allTeachersPage = new AllTeachersPage ();
    TeachersListPage teachersListPage = new TeachersListPage ();
    ProfilePage profilePage = new ProfilePage ();
    Faker faker = new Faker ();

// CREATING TEACHER SCENARIO
    @When("User should be able to fill out the Teacher form")
    public void userShouldBeAbleToFillOutTheForm() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait (Driver.getDriver () , 10);
        webDriverWait.until (ExpectedConditions.visibilityOf (addteacherPage.firstName));
        Random random = new Random ();
// input first name
        SeleniumUtil.pause (1);
        String firstname = faker.name ().firstName ();
        TemporaryStorage.addData ("FIRST_NAME" , firstname);
        addteacherPage.firstName.sendKeys (firstname);
//input email
        SeleniumUtil.pause (1);
        String email = faker.internet ().emailAddress ();
        TemporaryStorage.addData ("EMAIL_ADDRESS" , email);
        addteacherPage.email.sendKeys (email);
//input password
        SeleniumUtil.pause (1);
        String password = faker.internet ().password ();
        addteacherPage.password.clear ();
        TemporaryStorage.addData ("PASSWORD" , password);
        addteacherPage.password.sendKeys (password);

//input subject
        SeleniumUtil.pause (1);
        String subject = faker.educator ().course ();
        TemporaryStorage.addData ("SUBJECT" , subject);
        addteacherPage.subject.sendKeys (subject);
        addteacherPage.gender.click ();
//input gender
        SeleniumUtil.pause (1);
        Select selectGender = new Select (addteacherPage.gender);
        String gender = "Male";
        if (random.nextInt (2) == 0) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        TemporaryStorage.addData ("GENDER" , gender);

//input birthdate
        SeleniumUtil.pause (1);
        addteacherPage.birthday.sendKeys ("1/1/1980");
        TemporaryStorage.addData ("BIRTH_DATE" , "1/1/1980");
//input batch
        SeleniumUtil.pause (1);
        Select selectBatch = new Select (addteacherPage.batch);
        int batchNumber = random.nextInt (12);
        selectBatch.selectByIndex (batchNumber);
        TemporaryStorage.addData ("BATCH" , String.valueOf (batchNumber));
//input last name
        SeleniumUtil.pause (1);
        String lastname = faker.name ().lastName ();
        TemporaryStorage.addData ("LAST_NAME" , lastname);
        addteacherPage.lastname.sendKeys (lastname);
//input joining date
        SeleniumUtil.pause (1);
        addteacherPage.joiningDate.sendKeys ("2/2/2010");
        TemporaryStorage.addData ("JOIN_DATE" , "2/2/2010");
//input password
        SeleniumUtil.pause (1);
        addteacherPage.confirmPassword.sendKeys (password);

//input mobile number
        SeleniumUtil.pause (1);
        String mobilenumber = faker.number ().digits (10);
        addteacherPage.mobileNumber.sendKeys (mobilenumber);
        TemporaryStorage.addData ("PHONE" , mobilenumber);
//input department
        SeleniumUtil.pause (1);
        Select selectDepartment = new Select (addteacherPage.department);
        int deparmentnumber = random.nextInt (5);
        selectDepartment.selectByIndex (deparmentnumber);
        String department = "Computer";
        if (deparmentnumber == 1)
            department = "Science";
        else if (deparmentnumber == 2)
            department = "Maths";
        else if (deparmentnumber == 3)
            department = "English";
        else if (deparmentnumber == 4)
            department = "Social Science";
        TemporaryStorage.addData ("DEPARTMENT" , department);
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

//input salary
        SeleniumUtil.pause (2);
        addteacherPage.salary.clear ();
        String salary = String.valueOf (faker.number ().numberBetween (25000 , 100000));
        addteacherPage.salary.sendKeys (salary);
        TemporaryStorage.addData ("SALARY" , salary);
//input section
        SeleniumUtil.pause (1);
        String section = faker.educator ().campus ();
        addteacherPage.section.sendKeys (section);
        TemporaryStorage.addData ("SECTION" , section);
//input permanent address
        SeleniumUtil.pause (1);
        String address = faker.address ().fullAddress ();
        addteacherPage.permanentAddress.sendKeys (address);
        TemporaryStorage.addData ("PREMANENT_ADDRESS" , address);
    }


    @Then("User should be able to submit the Teacher form")
    public void userShouldBeAbleToSubmitTheForm() throws InterruptedException {
        addteacherPage.submitButton.click ();
    }


    @Then("Teacher should be displayed on the teacher grid")
    public void teacherShouldBeAbleToBeCreatedOnTheTeacherList() {

        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)" , "");
        SeleniumUtil.pause (2);
        Assert.assertTrue (allTeachersPage.lastCreatedTeacher.isDisplayed ());
        SeleniumUtil.pause (2);
        js.executeScript ("window.scrollBy(0,-document.body.scrollHeight || -document.documentElement.scrollHeight)" , "");
        allTeachersPage.lastCreatedTeacher.click ();
        String ID = profilePage.ID.getText ();
        TemporaryStorage.addData ("ID" , ID);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver ();
        jse.executeScript ("window.history.go(-1)");
    }

    @Then("User should be able to click list toggle button on All Teachers")
    public void userShouldBeAbleToClickListToggleButtonOnAddTeachers() {
        WebDriverWait webDriverWait = new WebDriverWait (Driver.getDriver () , 10);
        webDriverWait.until (ExpectedConditions.visibilityOf (allTeachersPage.listToggleButton));
        Actions actions = new Actions(Driver.getDriver ());
        actions.moveToElement(allTeachersPage.listToggleButton).click().perform();
    }

    @Then("Teacher should be created on the teacher list")
    public void teacherShouldBeAbleToBeUpdatedOnTheTeacherList() {

        SeleniumUtil.pause (2);
        teachersListPage.headerTableID.click ();
        SeleniumUtil.pause (2);
        teachersListPage.headerTableID.click ();
        SeleniumUtil.pause (2);
        Assert.assertEquals (teachersListPage.firstColumnTableID.getText () , TemporaryStorage.getData ("ID"));

    }

    @Then("Teacher should be created on the database")
    public void teacherShouldBeAbleToBeCreatedOnTheDatabase() throws SQLException {

        String[] keyNames = { "TEACHER_ID" , "FIRST_NAME" , "EMAIL_ADDRESS" , "PASSWORD" , "SUBJECT" ,
                "GENDER" , "BIRTH_DATE" , "BATCH" , "LAST_NAME" , "JOIN_DATE" ,
                "PHONE" , "DEPARTMENT" , "SALARY" , "SECTION" , "PREMANENT_ADDRESS" };

        DBUtility.createConnection ();

        List<Map<Object, Object>> data =
                DBUtility.executeQuery ("select TEACHER_ID from teacher");
        DBUtility.close ();
        boolean result = false;
        for (Map<Object, Object> map : data) {
            if (map.get ("TEACHER_ID").toString ().equals (TemporaryStorage.getData ("ID"))) {
                result = true;
                break;
            }
        }
        Assert.assertTrue (result);
    }

 //UPDATING TEACHER SCENARIO

    @When("User should be able to click All Teacher")
    public void userShouldBeAbleToClickAllTeacher() {
        homePage.allTeachers.click ();
        SeleniumUtil.pause (2);
        allTeachersPage.listToggleButton.click ();

    }

    @When("User should be able to find her profile on table")
    public void userShouldBeAbleToFindHerProfileOnTable() {
        SeleniumUtil.pause (2);
        teachersListPage.headerTableID.click ();
        SeleniumUtil.pause (2);
        teachersListPage.headerTableID.click ();
        SeleniumUtil.pause (2);

    }

    @And("User should be able to click edit button")
    public void userShouldBeAbleToClickEditButton() {
        teachersListPage.editButton.click ();
    }

    @When("User should be able to update email")
    public void userInputNewEmailAddress() {
        addteacherPage.email.click ();
        SeleniumUtil.pause (1);
        addteacherPage.email.clear ();
        String email = faker.internet ().emailAddress ();
        TemporaryStorage.addData ("EMAIL_ADDRESS_UPDATED" , email);
        addteacherPage.email.sendKeys (email);
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)" , "");
        SeleniumUtil.pause (2);
        addteacherPage.submitButton.click ();


    }

    @Then("Teacher should be updated on the profile page")
    public void teacherShouldBeUpdatedOnTheProfilePage() {
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)" , "");
        SeleniumUtil.pause (2);
        allTeachersPage.lastCreatedTeacher.click ();
        SeleniumUtil.pause (2);
        String ID = profilePage.email.getText ();
        Assert.assertEquals (profilePage.email.getText (),(TemporaryStorage.getData ("EMAIL_ADDRESS_UPDATED")));
    }

    @Then("Teacher should be updated on the teacher list")
    public void teacherShouldBeUpdatedOnTheTeacherList() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver ();
        jse.executeScript ("window.history.go(-1)");
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        SeleniumUtil.pause (2);
        js.executeScript ("window.scrollBy(0,-document.body.scrollHeight || -document.documentElement.scrollHeight)" , "");
        allTeachersPage.listToggleButton.click ();
        SeleniumUtil.pause (2);
        SeleniumUtil.pause (2);
        teachersListPage.headerTableID.click ();
        SeleniumUtil.pause (2);
        teachersListPage.headerTableID.click ();
        SeleniumUtil.pause (2);
        Assert.assertEquals (teachersListPage.firstColumntableEmail.getText ()
                ,TemporaryStorage.getData ("EMAIL_ADDRESS_UPDATED"));

    }

    @Then("Teacher should be updated on the database")
    public void teacherShouldBeUpdatedOnTheDatabase() throws SQLException {

        DBUtility.createConnection ();

        List<Map<Object, Object>> data =
                DBUtility.executeQuery ("select EMAIL_ADDRESS from teacher");

        DBUtility.close ();
        boolean result = false;
        for (Map<Object, Object> map : data) {
            if (map.get ("EMAIL_ADDRESS").toString ().equals (TemporaryStorage.getData ("EMAIL_ADDRESS_UPDATED"))) {
                result =true;
                break;
            }
        }
        Assert.assertTrue (result);

    }

// TEACHER DELETING SCENARIO

    @And("User should be able to click delete button")
    public void userShouldBeAbleToClickDeleteButton() {
        SeleniumUtil.pause (2);
        teachersListPage.deleteButton.click ();
    }


    @When("User should be able to click alert box delete button")
    public void userShouldBeAbleToClickAlertBoxDeleteButton() {
        SeleniumUtil.pause (2);
        teachersListPage.deleteAlertButton.click ();

    }

    @Then("Teacher should NOT be displayed on the be displayed on teacher grid")
    public void teacherShouldNOTBeDisplayedOnTheBeDisplayedOnTeacherGrid() {
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)" , "");
        SeleniumUtil.pause (2);
        Assert.assertTrue (allTeachersPage.lastCreatedTeacher.isDisplayed ());
        SeleniumUtil.pause (2);
        js.executeScript ("window.scrollBy(0,-document.body.scrollHeight || -document.documentElement.scrollHeight)" , "");
        allTeachersPage.lastCreatedTeacher.click ();
        String ID = profilePage.ID.getText ();
        TemporaryStorage.addData ("ID" , ID);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver ();
        jse.executeScript ("window.history.go(-1)");

    }

    @Then("Teacher should NOT be displayed by search on the teacher list")
    public void teacherShouldNOTBeDisplayedBySearchOnTheTeacherList() {

        SeleniumUtil.pause (2);
        teachersListPage.headerTableID.click ();
        SeleniumUtil.pause (2);
        teachersListPage.headerTableID.click ();
        SeleniumUtil.pause (2);
        Assert.assertNotEquals (teachersListPage.firstColumnTableID.getText () , TemporaryStorage.getData ("ID"));

    }

    @Then("Teacher should be deleted on the database")
    public void teacherShouldBeDeletedOnTheDatabase() throws SQLException {
        DBUtility.createConnection ();

        List<Map<Object, Object>> data =
                DBUtility.executeQuery ("select TEACHER_ID from teacher");
        DBUtility.close ();
        boolean result = false;
        for (Map<Object, Object> map : data) {
            if (map.get ("TEACHER_ID").toString ().equals (TemporaryStorage.getData ("ID"))) {
                result =false;
                break;
            } else {
                result = true;
            }

        }
        Assert.assertTrue (result);
    }



}




