
Feature: [API_US_44] As a teacher, I want to be able to access the homework information with a given ID through the API connection.


  @api
  Scenario:[TC01_US_44] When a valid authorization and correct data (id) are sent in a POST body to the "apiTeacher/homeworkById" endpoint,
  the response status code should be 200, and the response body's message should be "Success."

    * Set "apiTeacher/homeworkById" parameters



  @api
  Scenario: [TC02_US_44] When Invalid Authorization is Used for POST Request to apiTeacher/homeworkListById, Expect 403 Status and 'failed' Message

    * Set "apiTeacher/homeworkListById" parameters



  @api
  Scenario: [TC03_US_44] The content of the "list" data in the response body should be verified.

