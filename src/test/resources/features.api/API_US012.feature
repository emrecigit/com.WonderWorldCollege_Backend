
Feature:[API_US_O12] As an administrator, I want to be able to delete an Alumni Events record from the system
  through API connection.



  Scenario: [TC_01_API_US012] When valid authorization information and correct data (id) are sent in the
  DELETE body to the api/alumniEventsDelete endpoint, the expected status code is 200, and the message in the
  response body should be "Success."

    * Set "api/alumniEventsDelete" parameters
    * Events prepares the deletion body containing the deletion data.
    * Verifies that status code is 200
    * Verifies that the message information is "Success"



  Scenario: [TC_02_API_012] When invalid authorization information or wrong data (id) are sent in the
  DELETE body to the api/alumniEventsDelete endpoint, the expected status code is 403, and the message in the
  response body should be "failed."

    * Set "api/alumniEventsDelete" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/deleteNotice" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"



  Scenario: [TC_03_API_012] TThe DeletedId information in the response body should be validated to be the
  same as the id information in the DELETE request body sent to the api/alumniEventsDelete endpoint.

    * Set "api/alumniEventsDelete" parameters
    * Events prepares the deletion body containing the deletion data.
    * Response body DeletedId should be verified that it is the same as the DELETE request body id information.


  @api
  Scenario: [TC_04_API_012] The successful deletion of the alumni events record via the API should be validated.

    * Set "api/alumniEventsDelete" parameters
    * Events prepares the deletion body containing the deletion data.
    * The deletion of the alumni events record requested via the API must be verified.
