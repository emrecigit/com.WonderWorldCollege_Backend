Feature: As an administrator, I want to access the Books List through API connection.


  Scenario:  When a valid authorization information is sent with a GET request to the api/booksList endpoint,
            the expected status code is 200, and the response message should be "Success."


    * Set "api/BooksList" parameters
    * Records response for Admin with valid authorization information
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  Scenario:  When invalid authorization information is sent with a GET request to the api/booksList endpoint,
             the expected status code is 403, and the response message should be "failed."


    * Set "api/BooksList" parameters
    * Records response for Admin with invalid authorization information
    * Verifies that status code is 403
    * Verifies that the message information is "failed"


  Scenario: Response body must be confirmed.


    * Set "api/BooksList" parameters
    * Records response for Admin with valid authorization information
    * The data of the record with "" is validated