
Feature: [API_US52] As an administrator (teacher), I want to be able to delete a Questions record from the system through API connection.


  @api
  Scenario: [TC_01_API_US052] When valid authorization and correct data (id) are used to send a DELETE body to the "apiteacher/questionDelete" endpoint, the response status code should be 200, and the response body's message should be "Success."