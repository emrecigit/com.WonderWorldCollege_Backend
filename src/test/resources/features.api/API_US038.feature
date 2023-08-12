<<<<<<< HEAD
Feature: [API_US_38]As an administrator, I want to access the Notice List through API connection.

=======

Feature: [API_US_38]As an administrator, I want to access the Notice List through API connection.


>>>>>>> main
  @TC_01
  Scenario: [TC_01_API_US_38]when a valid authorization is sent with a GET request to the api/getNotice endpoint,
  the response status code should be 200, and the response message should be "Success" to be verified.

    * Set "api/getNotice" parameters
    * Records response for Admin with valid authorization information
    * Verifies that status code is 200
<<<<<<< HEAD
    * Verifies that the message information is "Success"

    @TC_02
    Scenario: [TC_01_API_US_38]
=======
    * Verifies that the message information is "Success"
>>>>>>> main
