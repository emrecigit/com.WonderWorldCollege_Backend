
Feature: [API_US_44] As a teacher, I want to be able to access the homework information with a given ID through the API connection.



  Scenario:[TC01_US_44] When a valid authorization and correct data (id) are sent in a POST body to the "apiTeacher/homeworkById" endpoint,
  the response status code should be 200, and the response body's message should be "Success."

    * Set "apiTeacher/homeworkById" parameters
    * A Post body with valid authorization information and correct data "id" is sent to the "apiTeacher/homeworkById" endpoint
    * Verifies that status code is 200
    * Verifies that the message information is "Success"




  Scenario: [TC02_US_44] When Invalid Authorization is Used for POST Request to apiTeacher/homeworkListById, Expect 403 Status and 'failed' Message

    * Set "apiTeacher/homeworkListById" parameters
    * Record the response of the endpoint "apiTeacher/homeworkListById" with the current authorization "Teacher"
    * Verifies that status code is 403
    * Verifies that the message information is "failed"



  @api
  Scenario: [TC03_US_44] The content of the "list" data in the response body should be verified.

