Feature: [API_US_O16] As an administrator, I want to update the registered Vehicle information in the
  system through API connection.


  Scenario: [TC_01_API_US016] When valid authorization information and correct data
  are sent in the PATCH body to the api/vehicleUpdate endpoint, the expected status code is 200,
  and the message in the response body should be "Success."

    * Set "api/vehicleUpdate" parameters
    * Patch Body with the correct data is sent


  Scenario: [TC_02_API_US016] When invalid authorization information or missing/incorrect data (id)
  are sent in the PATCH body to the api/vehicleUpdate endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/vehicleUpdate" parameters
    * Verifies that Status Code is 403.



  Scenario: [TC_03_API_US016] The updateId in the response body should be verified to be the same as the id sent
  in the PATCH request body to the api/vehicleUpdate endpoint.

    * Set "api/vehicleUpdate" parameters
    * Patch body containing correct data which is prepared
    * It should be verified the updateId information and the id information in the request body are the same


  Scenario: [TC_04_API_US016] The successful update of the desired vehicle record via the API should be validated.

    * Set "api/vehicleId" parameters
    * POST body api vehicleId endpoint to verify that the record has been updated
