
Feature: [US_32] As an administrator, I want to be able to delete a Books record from the system through API connection.


  Scenario:  [TC01_US_32] When valid authorization information and correct data (id) are sent with a DELETE body to the
            api/booksDelete endpoint, the expected status code is 200, and the response body's
            message should be "Success."

    * Set "api/deleteBooks" parameters
    * Delete books body containing correct data is prepared.
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  Scenario:  [TC02_US_32] When invalid authorization information or incorrect data (id) is sent with a DELETE body to the
             api/booksDelete endpoint, the expected status code is 403, and the response body's
             message should be "failed."

    * Set "api/deleteBooks" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/deleteNotice" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"




  Scenario: [TC03_US_32] By checking that the DeletedId in the response body matches the id sent in the DELETE request
            body to the api/booksDelete endpoint, we can verify that the book record has been successfully
            deleted through the API.

    * Set "api/deleteBooks" parameters
    * Delete books body containing correct data is prepared.
    * It is verified that the DeletedBooksId in the response body is the same as the id in the request body.




  Scenario: [TC04_US_32] To further validate that the book record was deleted, we can send a POST body to the api/booksId
            endpoint using the returned DeletedId to check if the record with that ID no longer exists.

    * Set "api/deleteNotice" parameters
    * Delete books body containing correct data is prepared.
    * The books deletion of the desired notice record through the API should be validated.