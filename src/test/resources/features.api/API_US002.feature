Feature: [API_US002] As an administrator, I want to access the Visitor Purpose information of a user
  with a given ID through API connection.



  Scenario: [TC_01_API_US002] When a valid authorization information and correct data (ID)
  are sent in the POST body to the api/visitorsPurposeId endpoint, the expected status code is 200,
  and the message in the response body should be Success.


    * Set "api/visitorsPurposeId" parameters
    * A Post body is sent to the endpoint "api/visitorsPurposeId" with valid authorization credentials "Admin" user and correct id 3
    * Verifies that status code is 200
    * Verifies that the message information is "Success"

  Scenario: [TC_02_API_US002] When invalid authorization information or invalid data (ID) is sent in the Post body
  to the api/visitorsPurposeId endpoint, the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/visitorsPurposeId" parameters
    * Validates that when sending correct or incorrect data with id 2 to the "api/visitorsPurposeId" endpoint with invalid authorization "wrongToken", the status Code of the failed connection is 403 and the message is "Forbidden"


  Scenario: [TC_03_API_US002] The content of the list data (ID, visitors_purpose, description, created_at)
  in the response body should be validated.

    * Set "api/visitorsPurposeId" parameters
    * A Post body is sent to the endpoint "api/visitorsPurposeId" with valid authorization credentials "Admin" user and correct id 3
    * The content of the list data "3" and "Student Meeting" and "" and "2023-01-18 06:07:12" in the response body should be validated.

