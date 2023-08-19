

Feature: [API_US035] As an administrator, I want to create a new Visitor record through API connection.


  @api
  Scenario: [TC_01_API_US_035] When a POST body with valid authorization information and correct data is sent to the api/visitorsAdd endpoint,
            it should be verified that the status code returned is 200 and "Success".



  @api
  Scenario: [TC_02_API_US_035] When a POST body with invalid authorization information or missing data is sent to the api/visitorsAdd endpoint,
             it should be verified that the status code returned is 403 and "failed".



  @api
  Scenario: [TC_03_API_US_035] The new visitor record to be created from the API must be verified from the API.



