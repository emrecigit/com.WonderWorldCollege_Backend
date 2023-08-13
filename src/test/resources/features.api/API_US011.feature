Feature: [API_US_011] As an administrator, I would like to update the Alumni List via API connection.

  @nur
  Scenario: [TC_01_API_US_011] When a PATCH body with valid authorization information and correct
  data is sent to the api/alumniEventsUpdate endpoint, it should be verified that the status code
  returned is 200 and the message information in the response body is "Success"

    * Set a url parameters
    * Records response for an Admin with valid authorization information
    * Patch body containing correct data is prepared.
    * Verifies that status code is 200.
    * Verifies that the message information is "Success".

  Scenario:

    * Set a url parameters
    * Records response for an Admin with valid authorization information
    * Patch body containing correct data is prepared.
