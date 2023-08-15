Feature: [API_US_011] As an administrator, I would like to update the Alumni List via API connection.

  @nur
  Scenario: [TC_01_API_US_011] When a PATCH body with valid authorization information and correct
  data is sent to the api/alumniEventsUpdate endpoint, it should be verified that the status code
  returned is 200 and the message information in the response body is "Success"

    * Set "api/alumniEventsUpdate" parameters
    * Patch body containing correct data is prepared.
    * Verifies that status code is 200.

  Scenario: [TC_02_API_US_011] When invalid authorization information or missing/wrong data (id) are sent in the
  PATCH body to the api/alumniEventsUpdate endpoint, the expected status code is 403, and the message in the
  response body should be "failed."

    * Set "api/alumniEventsUpdate" parameters
    * Verifies that status code is 403.

  Scenario: [TC_03_API_US_011] The updateId information in the response body should be validated to be the
  same as the id information in the PATCH request body sent to the api/alumniEventsUpdate endpoint.

    * Set "api/alumniEventsUpdate" parameters
    * Patch body containing correct data is prepared.
    * It should be verified that the updateId information and the id information in the request body are the same.

  Scenario: [TC_04_API_US_011] The successful update of the Alumni Events record via the API should be validated.

    * Set "api/alumniEventsId" parameters
    * Verification is done by sending POST body to alumniEventsId endpoint with the updateId returned in the response body.




