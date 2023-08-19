
Feature: [API_US41] As an administrator, I want to update the registered Notice information in the system through API connection.


  @api
  Scenario: [TC_01_API_US041] When a valid authorization and correct data (id, type, title, description, slug) are sent with a PATCH body to the api/updateNotice endpoint, the response status code should be 200, and the response body's message should be "Success" to be verified.