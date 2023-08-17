Feature:As an Teacher, I want to be able to delete a Homework record from the system through API connection.

  Scenario: TC_01 When valid authorization and correct data (id) are sent in a DELETE body to the "apiteacher/homeworkDelete" endpoint,
  the response status code should be 200,
  and the response body's message should be "Success."

    * Set "apiteacher/homeworkDelete" parameters
    * Delete body containing correct data is prepared.
    * Verifies that status code is 200
    * Verifies that the message information is "Success"



  Scenario: TC_02 When invalid authorization or incorrect data (id) are sent in a DELETE body to the "apiteacher/homeworkDelete" endpoint,
  the response status code should be 403, and the response body's message should be "failed."

    * Set "apiteacher/homeworkDelete" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "apiteacher/homeworkDelete" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"

  Scenario: TC_03 The "DeletedId" field in the response body should match
  the "id" field sent in the DELETE request body to the "apiteacher/homeworkDelete" endpoint.

    * Set "apiteacher/homeworkDelete" parameters
    * Delete body containing correct data is prepared.
    * It is verified that the DeletedId in the response body is the same as the id in the request body.


  Scenario:  TC_04 TThe successful deletion of the alumni homework record can be verified through the API.
  The response body should contain a "DeletedId" field, and this ID can be used to verify that the record was deleted
  by sending a POST body to the "apiteacher/homeworkbyId" endpoint.

    * Set "apiteacher/homeworkDelete" parameters
    * Delete body containing correct data is prepared.
    * The deletion of the desired notice record through the API should be validated.