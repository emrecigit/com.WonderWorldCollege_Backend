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
  api/alumniEventsList endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/alumniList" parameters
    * Records response for Admin with invalid authorization information
    * Verifies that status code is 403
    * Verifies that the message information is "Failed"