
Feature: [US_32] As an administrator, I want to be able to delete a Books record from the system through API connection.

  @api
  Scenario:  [TC01_US_32] When valid authorization information and correct data (id) are sent with a DELETE body to the
            api/booksDelete endpoint, the expected status code is 200, and the response body's
            message should be "Success."

    * Set "api/deleteBooks" parameters


  @api
  Scenario:  [TC02_US_32] When invalid authorization information or incorrect data (id) is sent with a DELETE body to the
             api/booksDelete endpoint, the expected status code is 403, and the response body's
             message should be "failed."

    * Set "api/deleteBooks" parameters




  @api
  Scenario: [TC03_US_32] By checking that the DeletedId in the response body matches the id sent in the DELETE request
            body to the api/booksDelete endpoint, we can verify that the book record has been successfully
            deleted through the API.

    * Set "api/deleteBooks" parameters



  @api
  Scenario: [TC04_US_32] To further validate that the book record was deleted, we can send a POST body to the api/booksId
            endpoint using the returned DeletedId to check if the record with that ID no longer exists.

    * Set "api/deleteNotice" parameters
