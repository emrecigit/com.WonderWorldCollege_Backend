Feature: As an administrator, I want to be able to delete a Notice record from the system through API connection.

  Scenario: [TC_01_US_27] When a valid authorization and correct data (id) are sent with a DELETE body to the api/deleteNotice endpoint,
  the response status code should be 200, and the response body's message should be "Success" to be verified.

    * Set "api/alumniDelete" parameters
    * Delete body containing correct data is prepared rumeysa.
    * Verifies that status code is 200
    * Verifies that the message information is "Success"

  Scenario: [TC_02_API_US_27] When invalid authorization information is sent with a GET request to the api/booksList endpoint,
  the expected status code is 403, and the response message should be "failed."

    * Set "api/alumniDelete" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/alumniDelete" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"

  Scenario: [TC_03_API_US_27] The DeletedId in the response body
  should be the same as the id sent in the DELETE request body to the api/deleteNotice endpoint to be verified.

    * Set "api/alumniDelete" parameters
    * Delete body containing correct data is prepared rumeysa.
    * It is verified that the DeletedId in the response body is the same as the id in the request body rumeysa.


  Scenario:  [TC_04_API_US_27] The deletion of the desired notice record through the API should be validated rumeysa.
  This can be confirmed by using the DeletedId returned in the response body
  to make a POST request to the api/getNoticeById endpoint and verify that the record has been deleted.

    * Set "api/alumniDelete" parameters
    * Delete body containing correct data is prepared.
    * The deletion of the desired notice record through the API should be validated.