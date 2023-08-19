
Feature: [US_42] As an administrator, I want to be able to delete a Notice record from the system through API connection.



    Scenario: [TC_01_US_42] When a valid authorization and correct data (id) are sent with a DELETE body to the api/deleteNotice endpoint,
             the response status code should be 200, and the response body's message should be "Success" to be verified.

      * Set "api/deleteNotice" parameters
      * Verifies that status code is 200
      * Verifies that the message information is "Success"




  Scenario: [TC_02_API_US_42] When invalid authorization information is sent with a GET request to the api/booksList endpoint,
  the expected status code is 403, and the response message should be "failed."

    * Set "api/deleteNotice" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/deleteNotice" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"


  @api
    Scenario: [TC_03_API_US_42] The DeletedId in the response body
    should be the same as the id sent in the DELETE request body to the api/deleteNotice endpoint to be verified.

      * Set "api/deleteNotice" parameters




  Scenario:  [TC_04_API_US_42] The deletion of the desired notice record through the API should be validated.
      This can be confirmed by using the DeletedId returned in the response body
      to make a POST request to the api/getNoticeById endpoint and verify that the record has been deleted.

    * Set "api/deleteNotice" parameters
    * The deletion of the desired notice record through the API should be validated.