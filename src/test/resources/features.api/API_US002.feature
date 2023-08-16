Feature: [API_US002] As an administrator, I want to access the Visitor Purpose information of a user
  with a given ID through API connection.



@api
  Scenario: [TC_01_API_US002] When a valid authorization information and correct data (ID)
  are sent in the POST body to the api/visitorsPurposeId endpoint, the expected status code is 200,
  and the message in the response body should be Success.


    * Set "api/visitorsPurposeId" parameters
    * A Post body is sent to the endpoint "api/visitorsPurposeId" with valid authorization credentials "Admin" user and correct id 3
    * Verifies that status code is 200
    * Verifies that the message information is "Success"
