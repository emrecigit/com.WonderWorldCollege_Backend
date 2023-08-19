
Feature: [API_US_013] As an administrator, I want to access the Vehicle List through API connection.


  @api
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



  @api
    Scenario: [TC_03_API_013] The content of the list in the response body should be validated. Specifically,
    the content of the data with ID "1" in the lists should have the following attributes: vehicle_no as "VH1001",
    vehicle_model as "Volvo Bus", vehicle_photo as "1677502387-149436744063fca7b3a1796!fd.png",
    manufacture_year as "2017", registration_number as "FVFF-08797865",chasis_number as "45453," max_seating_capacity as "50" ,
    driver_name as "Michel",driver_licence as "R534534" , driver_contact as "8667777869" ,
    note as empty, and created_at as "2023-02-27 07:53:07".

      * Set "api/vehicleList" parameters
      * Record the response of the endpoint "api/vehicleList" with the current authorization "Admin"
      * Validates list content with user "1" ,"VH1001","Volvo Bus","1677502387-149436744063fca7b3a1796!fd.png","2017","FVFF-08797865","45453","50","Michel","R534534","8667777869","","2023-02-27 07:53:07"
