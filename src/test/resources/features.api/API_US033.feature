
Feature: [API_US033] As an administrator, I want to access the Visitor List through API connection.


  Scenario: [TC_01_API_US_033] ,When a valid authorization information is used to send a GET request to the api/visitorsList endpoint,
  the expected status code is 200, and the response message should be "Success."

    * Set "api/visitorsList" parameters
    * Record the response of the endpoint "api/visitorsList" with the current authorization "Admin"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"




  Scenario: [TC_02_API_US_033] When invalid authorization information is used to send a GET request to the api/visitorsList endpoint,
  the expected status code is 403, and the response message should be "failed."

   * Set "api/visitorsList" parameters
   * Verifies that the Status Code of the failed connection from the endpoint "api/visitorsList" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"



  @api
  Scenario: [TC_03_API_US_033] To validate the response body, we should check that the lists
  content contains the data with id equal to "250" and the following information:

    * Set "api/visitorsList" parameters
    * Record the response of the endpoint "api/visitorsList" with the current authorization "Admin"





