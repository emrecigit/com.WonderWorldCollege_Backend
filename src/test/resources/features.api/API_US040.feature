
Feature: [API_US40] As an administrator, I want to create a new Notice record through API connection.


  @api
  Scenario: [TC_01_API_US040] When a valid authorization and correct data (type, title, description, slug) are sent with a POST body to the api/addNotice endpoint, the response status code should be 200, and the response body's message should be "Success" to be verified.