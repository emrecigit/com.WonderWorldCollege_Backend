
Feature:[API_US_O10] As an administrator, I want to create a new Alumni Events record through API connection.

  @api
  Scenario: [TC_01_API_US010] When valid authorization information and correct data
  are sent in the POST body to the api/alumniEventsAdd endpoint, the expected status code is 200,
  and the message in the response body should be "Success."

    * Set "api/alumniEventsAdd" parameters
    * A POST body is sent to the "api/alumniEventsAdd" endpoint with valid authorization information and correct data
    * Verifies that status code is 200


  @api
  Scenario: [TC_02_API_010] When invalid authorization information or wrong data
  are sent in the POST body to the api/alumniEventsAdd endpoint, the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/vehicleAdd" parameters


  @api
  Scenario: [TC_03_API_010] The successful creation of a new Alumni Events record via the API should be validated.

    * Set "api/vehicleAdd" parameters

