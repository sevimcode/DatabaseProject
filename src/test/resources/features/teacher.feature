Feature: Teacher feature
  Background:
When User on home page
When User should be able to click Teachers
When User should be able to click Add Teacher
When User should be able to fill out the Teacher form
Then User should be able to submit the Teacher form
When User should be able to click Teachers

  Scenario: Creating teacher and verifying on UI and DB

Then Teacher should be displayed on the teacher grid
When User should be able to click list toggle button on All Teachers
Then Teacher should be created on the teacher list
Then Teacher should be created on the database


    Scenario: Updating teacher and verifying on UI and DB
When User should be able to click All Teacher
When User should be able to click list toggle button on All Teachers
When User should be able to find her profile on table
And User should be able to click edit button
When User should be able to update email
Then Teacher should be updated on the profile page
Then Teacher should be updated on the teacher list
Then  Teacher should be updated on the database

   Scenario: Deleting teacher and verifying on UI and DB
When User should be able to click All Teacher
When User should be able to click list toggle button on All Teachers
When User should be able to find her profile on table
And User should be able to click delete button
When User should be able to click alert box delete button
Then Teacher should NOT be displayed on the be displayed on teacher grid
When User should be able to click list toggle button on All Teachers
Then Teacher should NOT be displayed by search on the teacher list
Then  Teacher should be deleted on the database

