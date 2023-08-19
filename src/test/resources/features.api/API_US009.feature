
Feature: [API_US_009] As an administrator, I want to access the Alumni Events information with a given ID through API connection.



  @api
  Scenario: [TC_01_API_US_009] When a valid authorization information and correct data
  (id) are sent in the POST body to the api/alumniEventsId endpoint, the expected status code is 200,
  and the message in the response body should be "Success."

    * Set "api/alumniEventsId" parameters



  @api
  Scenario: [TC_02_API_US_009] When invalid authorization information or invalid data (id) are sent in
  the POST body to the api/alumniEventsId endpoint, the expected status code is 403, and the message in
  the response body should be "failed."

    * Set "api/alumniEventsId" parameters
    * Record the response of the endpoint "api/alumniEventsId" with the current authorization "Admin"
    * Verifies that status code is 403
    * Verifies that the message information is "failed"


  @api
  Scenario: [TC_03_API_US_009] The content of the list data in the response body should be validated.

    * Set "api/alumniEventsId" parameters

