
  Feature: [API_US_014] As an administrator, I want to access the Vehicle information of a vehicle with a given
    ID through API connection.

    Scenario: [TC_01_API_US014] When valid authorization information and correct data id are sent in the
    POST body to the api/vehicleId endpoint,the expected status code is 200
    and the message in the response body should be "Success."

      * Set "api/vehicleId" parameters
      * Prepare request body for admin api vehicleId endpoint and record response ilk
      * Code is 200
      * Message information is "Success"





    Scenario: [TC_02_API_US014] When invalid authorization information or invalid data "id" are sent in the
    POST body to the api/vehicleId endpoint, the expected status code is 403,
    and the message in the response body should be "failed."

      * Set "api/vehicleId" parameters
      * Verifies that the Status Code of the failed connection from the endpoint "api/vehicleId" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"






    Scenario: [TC_03_API_US014] The content of the list in the response body should be validated.


      * Set "api/vehicleId" parameters
      * Prepare request body for admin api vehicleId endpoint and record response
      * The response list verifies its content "id, vehicle_no, vehicle_model, vehicle_photo, manufacture_year, registration_number, chasis_number, max_seating_capacity,driver_name, driver_licence, driver_contact, note, created_at"


