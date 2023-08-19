
Feature: [API_US_38]As an administrator, I want to access the Notice List through API connection.


  @api
  Scenario: [TC_01_API_US_38] When a valid authorization is sent with a GET request to the api/getNotice endpoint,
  the response status code should be 200, and the response message should be "Success" to be verified.

    * Set "api/getNotice" parameters




  @api
    Scenario: [TC_02_API_US_38] When invalid authorization information is sent with a GET request to the api/booksList endpoint,
    the expected status code is 403, and the response message should be "failed."

      * Set "api/getNotice" parameters





