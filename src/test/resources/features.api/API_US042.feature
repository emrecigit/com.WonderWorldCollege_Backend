Feature: As an administrator, I want to be able to delete a Notice record from the system through API connection.

    Scenario: [TC_01_US_42] When a valid authorization and correct data (id) are sent with a DELETE body to the api/deleteNotice endpoint,
             the response status code should be 200, and the response body's message should be "Success" to be verified.

      * Set "api/deleteNotice" parameters
      * Record the response of the endpoint "api/deleteNotice" with the current authorization "Admin"
      * Create expected data and save delete response for "responseString" id deleteNotice
      * Verifies that status code is 200
      * Verifies that the message information is "Success"


  Scenario: [TC_01_API_US_38] When invalid authorization information is sent with a GET request to the api/booksList endpoint,
  the expected status code is 403, and the response message should be "failed."

    * Set "api/deleteNotice" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/deleteNotice" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"
