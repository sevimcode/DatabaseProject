Feature: Teacher feature

    Scenario Outline:
    When User on home page
    When Click Students
    When click Add Student
      And Input "<firstname>" firstname
      And Input "<email>" email
      And Input "<password>" password
      And Input "<subject>" subject
      And Select gender
      And Input "<birth date>" birth date
      And Select batch
      And Input "<lastname>" lastname
      And Input "<joining date>" joining date
      And Input "<confirmpassword>" confirm password
      And Input "<mobilenumber>" mobile number
      And Input "<admissionno>" admission no
      And Input "<major>" major
      And Input "<section>" section
      And Input "<address>" address
      And Input "<company name>" company name
      And Input "<startdate>" startdate
      And Input "<street>" street
      And Input "<state>" state
      And Input "<title>" title
      And Input "<city>" city
      And Input "<zipcode>" zipcode
      Then Submit form
    When Click Students
Examples:
   |firstname |email|password| subject|birth date|lastname|joining date|confirmpassword|mobilenumber|admissionno|major|section|address|company name|startdate|street|state|title|city|zipcode|
   |Gina | wilkinson@gmail.com| 12345| math  |01/01/1990|Wilkinson|02/02/2018|1234|7735654343|567|math|150700|45 State st. Chicago, IL 60055 |TechCom|02/02/2005|Wabash street|Illinois|Teacher|Chicago|60078|


  Scenario Outline: Creating teacher and verifying on UI and DB

    Then Student should be displayed on the "<firstname>" grid
    Then Student should be displayed on the profile page "<firstname>" "<lastname>"
    Then Student should be created on the database
 Examples:
    |firstname | lastname |
    |Gina     |Wilkinson |


  Scenario: Updating teacher and verifying on UI and DB
    When Click Students
    And Click edit button on the last created student "<firstname>"
    When Update email and submit
    Then Student should be updated on the profile page
    Then  Student should be updated on the database


  Scenario: Deleting teacher and verifying on UI and DB
    When Click All Student
    When Find student
    And  Click delete button on the grid
    When Click alert box delete button
    Then Student should NOT be displayed on the be displayed
    Then  Student should be deleted on the database

