
Feature: [API_US039] As an administrator, I want to access the Notice information of a user with a given ID through API connection.


  @api
  Scenario: [TC_01_API_US039] When a valid authorization and correct data (id) are sent with a POST body to the api/getNoticeById endpoint, the response status code should be 200, and the response body's message should be "Success" to be verified.