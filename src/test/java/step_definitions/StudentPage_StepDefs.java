package step_definitions;

import Utilities.DBUtility;
import Utilities.Driver;
import Utilities.SeleniumUtil;
import Utilities.TemporaryStorage;
import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.sql.SQLException;
import java.util.*;

public class StudentPage_StepDefs{

    HomePage homePage = new HomePage ();
    AddStudentPage addstudentPage = new AddStudentPage ();
    AllStudentsPage allStudentsPage = new AllStudentsPage ();
    StudentProfilePage profilePage = new StudentProfilePage ();
    StudentsListPage studentsListPage = new StudentsListPage ();

    Faker faker = new Faker ();

    @When("Click Students")
    public void clickStudents() {
        SeleniumUtil.pause (2);
        homePage.students.click ();
    }

    @When("click Add Student")
    public void clickAddStudent() {
        SeleniumUtil.pause (1);
        homePage.addStudent.click ();
    }

    @When("Input {string} firstname")
    public void input_firstname( String string ) {
        WebDriverWait webDriverWait = new WebDriverWait (Driver.getDriver () , 15);
        webDriverWait.until (ExpectedConditions.visibilityOf (addstudentPage.firstName));
        SeleniumUtil.pause (2);
        addstudentPage.firstName.clear ();
        addstudentPage.firstName.sendKeys (string);
    }

    @When("Input {string} email")
    public void input_email( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.email.sendKeys (string);
    }

    @When("Input {string} password")
    public void input_password( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.password.clear ();
        addstudentPage.password.sendKeys (string);
    }

    @When("Input {string} subject")
    public void input_subject( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.subject.sendKeys (string);
    }

    @And("Select gender")
    public void selectGender() {
        SeleniumUtil.pause (1);
        Select selectGender = new Select (addstudentPage.gender);
        selectGender.selectByVisibleText ("Female");

    }

    @When("Input {string} birth date")
    public void input_birth_date( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.birthday.sendKeys (string);

    }

    @And("Select batch")
    public void selectBatch() {
        SeleniumUtil.pause (1);
        Select selectBatch = new Select (addstudentPage.batch);
        selectBatch.selectByIndex (5);

    }

    @When("Input {string} lastname")
    public void input_lastname( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.lastname.sendKeys (string);
    }

    @When("Input {string} joining date")
    public void input_joining_date( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.joiningDate.sendKeys (string);
    }

    @When("Input {string} confirm password")
    public void input_confirm_password( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.confirmPassword.clear ();
        addstudentPage.password.sendKeys (string);
    }

    @When("Input {string} mobile number")
    public void input_mobile_number( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.mobileNumber.sendKeys (string);
    }

    @When("Input {string} admission no")
    public void input_admission_no( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.admissionNo.clear ();
        addstudentPage.admissionNo.sendKeys (string);
    }

    @When("Input {string} major")
    public void input_major( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.major.sendKeys (string);
    }

    @When("Input {string} section")
    public void input_section( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.section.clear ();
        addstudentPage.section.sendKeys (string);
    }

    @When("Input {string} address")
    public void input_address( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.permanentAddress.sendKeys (string);
    }

    @When("Input {string} company name")
    public void input_company_name( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.companyName.sendKeys (string);
    }

    @When("Input {string} startdate")
    public void input_startdate( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.startDate.sendKeys (string);
    }

    @When("Input {string} street")
    public void input_street( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.street.sendKeys (string);
    }

    @When("Input {string} state")
    public void input_state( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.state.sendKeys (string);
    }

    @When("Input {string} title")
    public void input_title( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.title.sendKeys (string);
    }

    @When("Input {string} city")
    public void input_city( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.city.sendKeys (string);
    }

    @When("Input {string} zipcode")
    public void input_zipcode( String string ) {
        SeleniumUtil.pause (1);
        addstudentPage.zipCode.sendKeys (string);
    }

    @Then("Submit form")
    public void submitForm() {
        SeleniumUtil.pause (1);
        addstudentPage.submitButton.click ();
    }


    @Then("Student should be displayed on the {string} grid")
    public void studentShouldBeDisplayedOnTheGridm( String firstname ) {
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)" , "");
        Assert.assertEquals (allStudentsPage.locateStudent (firstname).getText () , firstname);
        SeleniumUtil.pause (2);
        allStudentsPage.locateStudent (firstname).click ();
    }

    @Then("Student should be displayed on the profile page {string} {string}")
    public void studentShouldBeDisplayedOnTheProfilePageM( String firstname , String lastname ) {

        SeleniumUtil.pause (2);
        TemporaryStorage.addData ("ID" , profilePage.ID.getText ());
        String actualName = profilePage.fullName.getText ().trim ();
        String expectedName = firstname + " " + lastname;
        Assert.assertEquals (actualName , expectedName);
    }

    @Then("Student should be created on the database")
    public void studentShouldBeCreatedOnTheDatabase() throws SQLException {
        DBUtility.createConnection ();

        List<Map<Object, Object>> data =
                DBUtility.executeQuery ("select STUDENT_ID from student");
        DBUtility.close ();
        boolean result = false;
        for (Map<Object, Object> map : data) {
            if (map.get ("STUDENT_ID").toString ().equals (TemporaryStorage.getData ("ID"))) {
                result = true;
                break;
            }
        }
        Assert.assertTrue (result);
    }

    @And("Click edit button on the last created student {string}")
    public void clickEditButtonOnTheGrid( String firstname ) {
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)" , "");
        allStudentsPage.dropDownMenu.click ();
        Select select = new Select (allStudentsPage.dropDownMenu);
        select.selectByIndex (1);


    }

    @And("Click first student")
    public void clickFirstStudent() {
        SeleniumUtil.pause (3);
        allStudentsPage.firstStudent.click ();

    }

    @When("Get ID from profile page")
    public void getIDFromProfilePage() {
        SeleniumUtil.pause (2);
        TemporaryStorage.addData ("ID_firstStudent" , profilePage.ID.getText ());
        TemporaryStorage.addData ("FULLNAME_firstStudent", profilePage.fullName.getText ());

    }

    @And("Click edit button on the first student")
    public void clickEditButtonOnTheFirstStudent() {
        SeleniumUtil.pause (1);
        allStudentsPage.threeDots.click ();
        SeleniumUtil.pause (1);
        allStudentsPage.edit.click ();

    }

    @When("Update subject and submit")
    public void updateEmailAndSubmit() {
        SeleniumUtil.pause (1);
        addstudentPage.subject.click ();
        SeleniumUtil.pause (1);
        addstudentPage.subject.clear ();
        String subject = faker.educator ().course ();
        TemporaryStorage.addData ("SUBJECT_UPDATED" , subject);
        addstudentPage.subject.sendKeys (subject);
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)" , "");
        SeleniumUtil.pause (2);
        addstudentPage.submitButton.click ();
    }

    @Then("Student should be updated on the profile page")
    public void studentShouldBeUpdatedOnTheProfilePage() {
        JavascriptExecutor js = ( (JavascriptExecutor) Driver.getDriver () );
        js.executeScript ("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)" , "");
        SeleniumUtil.pause (2);
        allStudentsPage.lastCreatedStudent.click ();
        SeleniumUtil.pause (2);
        String ID = profilePage.subject.getText ();
        Assert.assertEquals (profilePage.subject.getText () , ( TemporaryStorage.getData ("SUBJECT_UPDATED") ));
    }

    @Then("Student should be updated on the database")
    public void studentShouldBeUpdatedOnTheDatabase() throws SQLException {
        DBUtility.createConnection ();

        List<Map<Object, Object>> data =
                DBUtility.executeQuery ("select FIRST_NAME,STUDENT_ID,SUBJECT from student");


        boolean result = false;
        for (Map<Object, Object> map : data) {

            if (map.get ("STUDENT_ID").toString ().equals (TemporaryStorage.getData ("ID_firstStudent"))
                    && ( map.get ("SUBJECT").toString ().equals (TemporaryStorage.getData ("SUBJECT_UPDATED")) )) {

                result = true;
                break;
            }
        }

        DBUtility.close ();

        Assert.assertTrue (result);

    }


    @When("Click All Student")
    public void clickAllStudent() {
        SeleniumUtil.pause (2);
        homePage.allStudents.click ();
    }

    @And("Click delete button on the first student")
    public void clickDeleteButtonOnTheFirstStudent() {
        SeleniumUtil.pause (1);
        allStudentsPage.threeDots.click ();
        SeleniumUtil.pause (1);
        allStudentsPage.delete.click ();
    }

    @When("Click delete button on the alert box")
    public void clickDeleteButtonOnTheAlertBox() {
        SeleniumUtil.pause (1);
        allStudentsPage.alertDelete.click ();

    }

    @When("Click list toggle button")
    public void clickListToggleButton() {
        SeleniumUtil.pause (1);
        allStudentsPage.listButton.click ();

    }


    @Then("Student should NOT be found on list")
    public void studentShouldNOTBeFoundOnList() {

   //     List<WebElement> list = Driver.getDriver ().findElements (By.xpath ("//tbody/tr[1]"));
    //    6181 Female math 14 union IT 09/01/2020 tommie.jakubowski@hotmail.com 2244198787 // gets everthing in row 1st

      boolean result = false;
        List<WebElement> list = Driver.getDriver ().findElements (By.xpath ("//tbody/tr/td[2]"));

        SeleniumUtil.pause (1);
        for (int i = 0; i<list.size () ; i++) {
            System.out.println (list.get (i).getText ());
            if (!list.get (i).getText ().equals (TemporaryStorage.getData ("ID_firstStudent"))){
                result = true;
            }
        }
        System.out.println (TemporaryStorage.getData ("ID_firstStudent"));
        Assert.assertTrue (result);
    }

    @Then("Student should be deleted on the database")
    public void studentShouldBeDeletedOnTheDatabase() throws SQLException {

        DBUtility.createConnection ();

        List<Map<Object, Object>> data =
                DBUtility.executeQuery ("select STUDENT_ID from student");


        boolean result = false;
        for (Map<Object, Object> map : data) {

            if (!map.get ("STUDENT_ID").toString ().equals (TemporaryStorage.getData ("ID_firstStudent"))){
                result = true;

            }
        }

        DBUtility.close ();

        Assert.assertTrue (result);


    }
}
