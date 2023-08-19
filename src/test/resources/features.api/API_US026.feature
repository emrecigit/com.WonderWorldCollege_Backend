
Feature: [API_US_026] As an administrator, I would like to update the Alumni List via API connection.

  @api
  Scenario: [TC_01_API_US_026] When a PATCH body with valid authorization information and correct
  data is sent to the api/alumniEventsUpdate endpoint, it should be verified that the status code
  returned is 200 and the message information in the response body is "Success"

    * Set "api/alumniUpdate" parameters


  @api
  Scenario: [TC_02_API_US_026] When invalid authorization information or missing/wrong data (id) are sent in the
  PATCH body to the api/alumniEventsUpdate endpoint, the expected status code is 403, and the message in the
  response body should be "failed."

    * Set "api/alumniUpdate" parameters
    * Patch body containing correct data is prepared rumeysa.


  @api
  Scenario: [TC_03_API_US_026] The updateId information in the response body should be validated to be the
  same as the id information in the PATCH request body sent to the api/alumniEventsUpdate endpoint.

    * Set "api/alumniUpdate" parameters



  @api
  Scenario: [TC_04_API_US_026] The successful update of the Alumni Events record via the API should be validated.

    * Set "api/alumniId" parameters
    * Verification is done by sending POST body to alumniEventsId endpoint with the updateId returned in the response body rumeysa.

