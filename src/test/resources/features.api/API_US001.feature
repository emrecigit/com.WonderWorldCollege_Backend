
Feature: [API_US_001] As an administrator, I want to access the Purpose List through an API connection.


  Scenario: [TC_01_API_US001] To validate that the status code is 200 and the
  response message is "Success" when sending a GET request to the api/visitorsPurposeList
  endpoint with valid authorization credentials, you would typically need to use a programming
  language or a tool to make the API request and perform the validation

    * Set "api/visitorsPurposeList" parameters
    * Record the response of the endpoint "api/visitorsPurposeList" with the current authorization "Admin"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"





  Scenario:[TC_02_API_US_001] When invalid authorization information is sent with a GET request to the
  api/alumniEventsList endpoint the expected status code is 403,
  and the message in the response body should be "failed."

    * Set "api/visitorsPurposeList" parameters
    * Verifies that the Status Code of the failed connection from the endpoint "api/visitorsPurposeList" with invalid authorization "wrongToken" is "403" and the message is "Forbidden"





 Scenario: [TC_03_API_US_001] The content of the lists in the response body should be validated
  to contain data with ID "1," where the visitors_purpose is "Marketing," and
  created_at is "2023-01-18 01:07:12."

 //  * Data visitors to endpoint "api/visitorsPurposeList" with user type "Admin" for visitors purpose "Parent Teacher Meeting" and created at "2023-01-18 06:07:12" in the list with id number "2" must be verified


    * Set "api/visitorsPurposeList" parameters
    * Record the response of the endpoint "api/visitorsPurposeList" with the current authorization "Admin"
    * The data visitors purpose "Parent Teacher Meeting" and created at "2023-01-18 06:07:12" in the list with id number "2" must be validated



