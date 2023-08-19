
Feature:[API_US_O12] As an administrator, I want to be able to delete an Alumni Events record from the system
  through API connection.


  @api
  Scenario: [TC_01_API_US012] When valid authorization information and correct data (id) are sent in the
  DELETE body to the api/alumniEventsDelete endpoint, the expected status code is 200, and the message in the
  response body should be "Success."

    * Set "api/alumniEventsDelete" parameters


  @api
  Scenario: [TC_02_API_012] When invalid authorization information or wrong data (id) are sent in the
  DELETE body to the api/alumniEventsDelete endpoint, the expected status code is 403, and the message in the
  response body should be "failed."

    * Set "api/alumniEventsDelete" parameters



  @api
  Scenario: [TC_03_API_012] TThe DeletedId information in the response body should be validated to be the
  same as the id information in the DELETE request body sent to the api/alumniEventsDelete endpoint.

    * Set "api/alumniEventsDelete" parameters



  @api
  Scenario: [TC_04_API_012] The successful deletion of the alumni events record via the API should be validated.

    * Set "api/alumniEventsDelete" parameters

