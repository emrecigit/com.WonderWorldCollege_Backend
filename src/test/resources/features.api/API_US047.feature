
Feature: [US_47]As an Teacher, I want to be able to delete a Homework record from the system through API connection.


  @api
  Scenario: [TC01_US_47] When valid authorization and correct data (id) are sent in a DELETE body to the "apiteacher/homeworkDelete" endpoint,
  the response status code should be 200,
  and the response body's message should be "Success."

    * Set "apiteacher/homeworkDelete" parameters




  @api
  Scenario: [TC02_US_47] When invalid authorization or incorrect data (id) are sent in a DELETE body to the "apiteacher/homeworkDelete" endpoint,
  the response status code should be 403, and the response body's message should be "failed."

    * Set "apiteacher/homeworkDelete" parameters




  @api
  Scenario: [TC03_US_47] The "DeletedId" field in the response body should match
  the "id" field sent in the DELETE request body to the "apiteacher/homeworkDelete" endpoint.

    * Set "apiteacher/homeworkDelete" parameters




  @api
  Scenario:  [TC04_US_47] TThe successful deletion of the alumni homework record can be verified through the API.
  The response body should contain a "DeletedId" field, and this ID can be used to verify that the record was deleted
  by sending a POST body to the "apiteacher/homeworkbyId" endpoint.

    * Set "apiteacher/homeworkDelete" parameters
