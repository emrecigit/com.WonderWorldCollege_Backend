Feature: [API_US033] As an administrator, I want to access the Visitor List through API connection.


  @LM1_033
  Scenario: [TC_01_API_US_033] ,When a valid authorization information is used to send a GET request to the api/visitorsList endpoint,
  the expected status code is 200, and the response message should be "Success."


    * Set "api/visitorsList" parameters
    * Records response for Admin with valid authorization information
    * Verifies that status code is 200
    * Verifies that the message information is "Success"

 @LM2_033
  Scenario: [TC_02_API_US_033] When invalid authorization information is used to send a GET request to the api/visitorsList endpoint,
  the expected status code is 403, and the response message should be "failed."


    * Set "api/visitorsList" parameters
    * Records response for Admin with invalid authorization information
    * Verifies that status code is 403
    * Verifies that the message information is "failed"

  Scenario: [TC_03_API_US_033] To validate the response body, we should check that the lists
  content contains the data with id equal to "250" and the following information: