Feature:[API_US_O15] As an administrator, I want to create a new Vehicle record through API connection.

  Scenario: [TC_01_API_US015] When valid authorization information and correct data (vehicle_no, vehicle_model,
  vehicle_photo, manufacture_year, registration_number, chasis_number, max_seating_capacity, driver_name,
  driver_licence, driver_contact, note) are sent in the POST body to the api/vehicleAdd endpoint,
  the expected status code is 200, and the message in the response body should be "Success."

    * Set "api/vehicleAdd" parameters
    * Ilk a post body is sent to the "api/vehicleAdd" endpoint with valid authorization information and correct data "(vehicle_no, vehicle_model, vehicle_photo, manufacture_year, registration_number,chasis_number, max_seating_capacity, driver_name, driver_licence, driver_contact, note)"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"

   Scenario: [TC_02_API_015] When invalid authorization information or missing data are sent in the POST body to the
  api/vehicleAdd endpoint,the expected status code is 403, and the message in the response body should be "failed."

  * Set "api/vehicleAdd" parameters
  * Verifies that Status Code is 403.


  Scenario: [TC_03_API_015] The successful creation of the new vehicle record via the API should be validated.


    * Set "api/vehicleId" parameters
    * Ilk the successful creation of the new vehicle record via the API should be validated



