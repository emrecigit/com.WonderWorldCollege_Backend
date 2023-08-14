
Feature: [API_US_001] As an administrator, I want to access the Purpose List through an API connection.


  Scenario: [TC_01_API_US001] To validate that the status code is 200 and the
  response message is "Success" when sending a GET request to the api/visitorsPurposeList
  endpoint with valid authorization credentials, you would typically need to use a programming
  language or a tool to make the API request and perform the validation

 // * Records response for Admin with valid authorization information

    * Set "api/visitorsPurposeList" parameters
    * Record the response of the endpoint "api/visitorsPurposeList" with the current authorization "Admin"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  Scenario:[TC_02_API_US_001] When invalid authorization information is sent with a GET request to the
  api/alumniEventsList endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    // api/visitorsPurposeList endpoint'ine gecersiz authorization bilgileri ile bir GET Request
    // gönderildiginde dönen status code'un 403 oldugu ve response message bilgisinin
    // "failed" oldugu dogrulanmali

    //Path parametrelerini set eder.
    //Admin için, geçersiz authorization bilgileri ile  response kaydeder.
    //Donen status kodunun 403 oldugunu dogrular.
    //Donen response message bilgisinin Failed oldugunu dogrular.

    * Set "api/visitorsPurposeList" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/visitorsPurposeList" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"

  @api
  Scenario: [TC_03_API_US_001] The content of the lists in the response body should be validated
  to contain data with ID "1," where the visitors_purpose is "Marketing," and
  created_at is "2023-01-18 01:07:12."

    //Response body icindeki lists icerigi (id'si = "1", olan veri içeriğindeki
    //visitors_purpose: "Marketing " ve created_at: "2023-01-18 01:07:12") olduğu doğrulanmalı.

  //Path parametrelerini set eder.
  //Admin icin, gecerli authorization bilgileri ile  response kaydeder.

    * Set "api/visitorsPurposeList" parameters
    * Record the response of the endpoint "api/visitorsPurposeList" with the current authorization "Admin"
    * From the data in the list returned from the response body "id: 1", data content "visitors_purpose: Marketing" and "created_at: 2023-01-18 01:07:12", validation test that
