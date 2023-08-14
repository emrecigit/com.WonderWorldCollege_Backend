Feature: As an administrator, I want to be able to delete a Notice record from the system through API connection.

    Scenario: [TC_01_US_42] When a valid authorization and correct data (id) are sent with a DELETE body to the api/deleteNotice endpoint,
             the response status code should be 200, and the response body's message should be "Success" to be verified.

      * Set "api/deleteNotice" parameters
      * Records response for Admin with valid authorization information
      * when sending a DELETE body containing the correct data (id)
      * Verifies that status code is 200
      * Verifies that the message information is "Success"
