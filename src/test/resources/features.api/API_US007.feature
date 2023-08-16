Feature: [API_US_007] As an administrator, I want to access the Alumni List through API connection.
  @nur
  Scenario: [TC_01_API_US_007] Valid authorization information to api/alumniEventsList endpoint
  a GET request is sent with a GET request, the status code returned is 200 and the response message information
  "Success" must be confirmed.

    * Set "api/alumniEventsList" parameters
    * Record the response of the endpoint "api/alumniEventsList" with the current authorization "Admin"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"

  Scenario: [TC_02_API_US_007] When invalid authorization information is sent with a GET request to the
  api/alumniEventsList endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/alumniEventsList" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/alumniEventsList" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"

  Scenario: [TC_03_API_US_007] The lists content in the response body must be validated.

    * Set "api/alumniEventsList" parameters
    * Record the response of the endpoint "api/alumniEventsList" with the current authorization "Admin"
    * The data alumni event list  purpose "12" and created at "art" in the list with id number "13"                                      " must be validated




