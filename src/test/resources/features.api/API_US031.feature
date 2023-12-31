
Feature: [US_31] As an administrator, I want to update the registered Books information
         in the system through API connection.


  @api
  Scenario: [TC01_US_31] When valid authorization information and correct data are sent with a PATCH
            body to the api/booksUpdate endpoint, the expected status code is 200, and the response
            body's message should be "Success."

    * Set "api/booksUpdate" parameters



  @api
  Scenario: [TC02_US_31] When invalid authorization information or incomplete/incorrect data (id) is sent with a PATCH
            body  to the api/booksUpdate endpoint, the expected status code is 403, and the response
            body's message should be "failed."

    * Set "api/booksUpdate" parameters
    * Booksupdate patch body containing correct data is prepared.



  @api
  Scenario: [TC03_US_31] By checking that the updateId in the response body matches the id sent in the PATCH request body
           to the api/booksUpdate endpoint, we can verify that the book record has been successfully
           updated throughthe API.

    * Set "api/booksUpdate" parameters
    * Booksupdate patch body containing correct data is prepared.


  @api
  Scenario: [TC04_US_31] To further validate that the book record was updated, we can send a POST body to the api/booksId
            endpoint using the returned updateId to check the updated details of the book.

    * Set "api/booksId" parameters
    * Verification is done by sending POST body to booksId endpoint with the updateId returned in the response body.
