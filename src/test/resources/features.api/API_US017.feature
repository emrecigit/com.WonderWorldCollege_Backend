
Feature: [API_US_O17] As an administrator, I want to be able to delete a Vehicle record from the system through API connection.


  @api
  Scenario: [TC_01_API_US017] When valid authorization information and correct data (id) are sent in the
  DELETE body to the api/vehicleDelete endpoint, the expected status code is 200,
  and the message in the response body should be "Success."

    * Set "api/vehicleDelete" parameters


  @api
  Scenario: [TC_02_API_US017] When invalid authorization information or incorrect data (id) are sent in the
  DELETE body to the api/vehicleDelete endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/vehicleDelete" parameters




  @api
  Scenario: [TC_03_API_US017] The DeletedId in the response body should be verified to be the same as the id
  sent in the DELETE request body to the api/vehicleDelete endpoint.


    * Set "api/vehicleDelete" parameters


  @api
  Scenario: [TC_04_API_US017] The successful deletion of the desired vehicle record via the API should be validated.

    * Set "api/vehicleId" parameters
