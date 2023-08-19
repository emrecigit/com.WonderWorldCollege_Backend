
Feature: [US_30] As an administrator, I want to create a new Books record through API connection.


  @api
  Scenario: [TC01_US_30] When valid authorization information and correct data are sent with a POST
            body to the api/booksAdd endpoint, the expected status code is 200, and the response
            body's message should be "Success."

    * Set "api/booksAdd" parameters
    * A books post body is sent to the "api/booksAdd" endpoint with valid authorization information and correct data "(book_title, book_no, isbn_no, subject, rack_no, publish, author, qty, perunitcost, postdate, description)"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"



  Scenario: [TC02_US_30] When invalid authorization information or incomplete data is sent with a POST
            body to the api/booksAdd endpoint, the expected status code is 403, and the response
            body's message should be "failed."

    * Set "api/booksList" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/booksList" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"


  @api
  Scenario: [TC03_US_30] By using the returned addId in the response body, we can verify that a new book record has
            been successfully created through the API by sending a POST body to the api/booksId endpoint.

    * Set "api/booksId" parameters
    * The successful books post creation of the new vehicle record via the API should be validated.