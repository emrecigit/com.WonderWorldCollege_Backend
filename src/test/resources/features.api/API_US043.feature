
Feature: [API_US_043]As an administrator (teacher), I want to access the Homework List through API connection.


  @api
  Scenario: [TC01_US_43] When a valid authorization is provided with a GET request to the "apiTeacher/homeworkList" endpoint,
  the response status code should be 200, and the response message should be "Success."

    * Set "apiTeacher/homeworkList" parameters


  @api
  Scenario: [TC02_US_43] When an invalid authorization is provided with a GET request to the "apiTeacher/homeworkList" endpoint,
  the response status code should be 403, and the response message should be "failed."


    * Set "apiTeacher/homeworkList" parameters



  @api
  Scenario: [TC03_US_43] The contents of the list data in the response body should be verified.



