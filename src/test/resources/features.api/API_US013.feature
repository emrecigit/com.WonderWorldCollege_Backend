Feature: [API_US_013] As an administrator, I want to access the Vehicle List through API connection.

  Scenario: [TC_01_API_US013] When a valid authorization information is used to send a GET request to the
  api/vehicleList endpoint,the expected status code is 200, and the message in the response body should be "Success."



    * Set "api/vehicleList" parameters
    * Record the response of the endpoint "api/vehicleList" with the current authorization "Admin"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  Scenario:[TC_02_API_US_013] When invalid authorization information is used to send a GET request to the
  api/vehicleList endpoint, the expected status code is 403, and the message in the response body should be "failed."


    * Set "api/vehicleList" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/vehicleList" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"

    Scenario: