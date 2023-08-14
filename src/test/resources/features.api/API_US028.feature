Feature: As an administrator, I want to access the Books List through API connection.


  Scenario:  When a valid authorization information is sent with a GET request to the api/booksList endpoint,
            the expected status code is 200, and the response message should be "Success."


    * Set "api/booksList" parameters
    * Record the response of the endpoint "api/booksList" with the current authorization "Admin"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  Scenario:  When invalid authorization information is sent with a GET request to the api/booksList endpoint,
             the expected status code is 403, and the response message should be "failed."

    * Set "api/booksList" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/booksList" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"


  Scenario: Response body must be confirmed.

    * Set "api/booksList" parameters
    * Record the response of the endpoint "api/booksList" with the current authorization "Admin"
    * From the data in the list returned from the response body "id: 1", data content "book_title: nnnnnnnnnnnnnnnnn" and "created_at: 2023-08-14 13:02:31", validation test that

