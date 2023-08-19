
Feature: [US_28] As an administrator, I want to access the Books List through API connection.

  @api
  Scenario:  [TC01_US_28] When a valid authorization information is sent with a GET request to the api/booksList endpoint,
            the expected status code is 200, and the response message should be "Success."


    * Set "api/booksList" parameters
    * Record the response of the endpoint "api/booksList" with the current authorization "Admin"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  @api
  Scenario:  [TC02_US_28] When invalid authorization information is sent with a GET request to the api/booksList endpoint,
             the expected status code is 403, and the response message should be "failed."

    * Set "api/booksList" parameters



  @api
  Scenario: [TC03_US_28] Response body must be confirmed.

    * Set "api/booksList" parameters
    * Record the response of the endpoint "api/booksList" with the current authorization "Admin"


