Feature: As an administrator, I want to access the book information
         of a book with a given ID through API connection.


  Scenario: When a valid authorization information and correct data (id) are sent
           with a POST body to the api/booksId endpoint,the expected status code is 200,
           and the response body's message should be "Success."

    * Set "api/booksId" parameters
    * Prepare request body for admin api_alumniId endpoint and record response
    * Verifies that status code is 200
    * Verifies that the message information is "Success"



  Scenario: When invalid authorization information is sent with a GET request to the api/booksList
            endpoint, the expected status code is 403, and the response message should be "failed."

    * Set "api/booksId" parameters
    * Records response for Admin with invalid authorization information
    * Verifies that status code is 403
    * Verifies that the message information is "failed"



  Scenario: The content of the list in the response body should contain data with the following attributes.

    * Set "api/booksId" parameters
    * Prepare request body for admin api_alumniId endpoint and record response
    * Verifies that record includes "id,book_title,book_no,isbn_no,subject,rock_no,publish,author"
