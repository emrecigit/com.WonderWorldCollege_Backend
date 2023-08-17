
  Feature: [API_US_014] As an administrator, I want to access the Vehicle information of a vehicle with a given
    ID through API connection.

    Scenario: [TC_01_API_US014] When valid authorization information and correct data id are sent in the
    POST body to the api/vehicleId endpoint,the expected status code is 200
    and the message in the response body should be "Success."

      * Set "api/vehicleId" parameters
      * Request body for admin "api/vehicleId" endpoint and record response
      * Confirms CODE is 200.
      * Message information is"SUCCESS"




    Scenario: [TC_02_API_US014] When invalid authorization information or invalid data "id" are sent in the
    POST body to the api/vehicleId endpoint, the expected status code is 403,
    and the message in the response body should be "failed."

      *





    Scenario: [TC_03_API_US014] The content of the list in the response body should be validated.



