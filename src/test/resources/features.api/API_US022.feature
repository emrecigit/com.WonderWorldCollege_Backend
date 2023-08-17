Feature: [US_022] As an administrator, I want to access the Alumni List through API connection.

  @Test
  Scenario: [TC_01_US022]When a valid authorization information is sent in a GET request to the api/alumniList endpoint,
  the expected status code is 200, and the message in the response body should be "Success."

  //Path parametrelerini set eder.
  //Admin icin, gecerli authorization bilgileri ile  response kaydeder
  //Donen status kodunun 200 oldugunu dogrular
  //Donen response message bilgisinin Success oldugunu dogrular


    * Set "api/alumniList" parameters
    * Records response for Admin with valid authorization information
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  Scenario: [TC_02_API_US_007] When invalid authorization information is sent with a GET request to the
  api/alumniList endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/alumniList" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/alumniList" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"


  Scenario: [TC_03_API_US_022] Response body icindeki lists icerigi (id'si = "2", olan veri içeriğindeki student_id: "41", current_email: "rohan@gmail.com", current_phone: "0808080707", occupation:"",address: "",  photo:null, created_at: "2023-03-11 03:04:50") olduğu doğrulanmalı.

    * Set "api/alumniList" parameters
    * Record the response of the endpoint "api/alumniList" with the current authorization "Admin"
    * rumeysa The data visitors purpose  created at "2" "41" "deneme@gmail.com"  in the list with id number must be validated

