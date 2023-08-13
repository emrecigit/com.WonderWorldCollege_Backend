
Feature: [US_001] As an administrator, I want to access the Purpose List through an API connection.


Scenario: [TC_02_API_US_007] When invalid authorization information is sent with a GET request to the
api/alumniEventsList endpoint the expected status code is 403,
and the message in the response body should be "failed."

* Set "api/alumniEventsList" parameters
* Records response for Admin with invalid authorization information
* Verifies that status code is 403
* Verifies that the message information is "Failed"

Feature: [API_US_007] As an administrator, I want to access the Alumni List through API connection.

  @nur
  Scenario: [TC_01_API_US_007] Valid authorization information to api/alumniEventsList endpoint
  a GET request is sent with a GET request, the status code returned is 200 and the response message information
  "Success" must be confirmed.

    * Set "api/alumniEventsList" parameters
    * Records response for Admin with valid authorization information
    * Verifies that status code is 200
    * Verifies that the message information is "Success"

  Scenario: [TC_02_API_US_007] When invalid authorization information is sent with a GET request to the
  api/alumniEventsList endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/alumniEventsList" parameters
    * Records response for Admin with invalid authorization information
    * Verifies that status code is 403
    * Verifies that the message information is "failed"

  Scenario: [TC_03_API_US_007] The lists content in the response body must be validated.




