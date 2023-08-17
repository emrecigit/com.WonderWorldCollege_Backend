Feature: [API_US_O17] As an administrator, I want to be able to delete a Vehicle record from the system through
                      API connection.

  Scenario: [TC_01_API_US017] When valid authorization information and correct data (id) are sent in the
  DELETE body to the api/vehicleDelete endpoint, the expected status code is 200,
  and the message in the response body should be "Success."

    * Set "api/vehicleDelete" parameters
    * The user prepares the deletion body containing the correct data ilk
    * Verifies status code is 200
    * Verifies the message information is "Success"



  Scenario: [TC_02_API_US017] When invalid authorization information or incorrect data (id) are sent in the
  DELETE body to the api/vehicleDelete endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/vehicleDelete" parameters
    * Verifies Status Code of the failed connection from the endpoint "api/vehicleDelete" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"



  Scenario: [TC_03_API_US017] The DeletedId in the response body should be verified to be the same as the id
                              sent in the DELETE request body to the api/vehicleDelete endpoint.

    * Set "api/vehicleDelete" parameters
    * Create a delete body the correct data
    * Verifies that the id in the DELETE request body sent to "api/vehicleDelete" in the response is correct



  Scenario: [TC_04_API_US017] The successful deletion of the desired vehicle record via the API should be validated.

    * Set "api/vehicleId" parameters
    * Delete body containing correct data is prepared.
    * The deletion of the desired notice record through the API should be validated.