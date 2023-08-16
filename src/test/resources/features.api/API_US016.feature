Feature: [API_US_O16] As an administrator, I want to update the registered Vehicle information in the
                      system through API connection.


  Scenario: [TC_01_API_US016] When valid authorization information and correct data
  are sent in the PATCH body to the api/vehicleUpdate endpoint, the expected status code is 200,
  and the message in the response body should be "Success."






  Scenario: [TC_02_API_US016] When invalid authorization information or missing/incorrect data (id)
  are sent in the PATCH body to the api/vehicleUpdate endpoint the expected status code is 403,
  and the message in the response body should be "failed."






  Scenario: [TC_03_API_US016] The updateId in the response body should be verified to be the same as the id sent
                               in the PATCH request body to the api/vehicleUpdate endpoint.



  Scenario: [TC_04_API_US016] The successful update of the desired vehicle record via the API should be validated.

