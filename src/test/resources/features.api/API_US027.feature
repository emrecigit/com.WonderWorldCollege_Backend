
Feature: As an administrator, I want to be able to delete a Notice record from the system through API connection.

  @api
  Scenario: [TC_01_US_27] When a valid authorization and correct data (id) are sent with a DELETE body to the api/deleteNotice endpoint,
  the response status code should be 200, and the response body's message should be "Success" to be verified.

    * Set "api/alumniDelete" parameters


  @api
  Scenario: [TC_02_API_US_27] When invalid authorization information is sent with a GET request to the api/booksList endpoint,
  the expected status code is 403, and the response message should be "failed."

    * Set "api/alumniDelete" parameters




  @api
  Scenario: [TC_03_API_US_27] The DeletedId in the response body
  should be the same as the id sent in the DELETE request body to the api/deleteNotice endpoint to be verified.

    * Set "api/alumniDelete" parameters




  @api
  Scenario:  [TC_04_API_US_27] The deletion of the desired notice record through the API should be validated rumeysa.
  This can be confirmed by using the DeletedId returned in the response body
  to make a POST request to the api/getNoticeById endpoint and verify that the record has been deleted.

    * Set "api/alumniDelete" parameters
