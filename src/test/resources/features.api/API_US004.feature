
Feature: [API_US004] As an administrator, I want to update the registered visitor purpose information in the system through API connection.

  @api
  Scenario: [TC_01_API_US004] When valid authorization information and correct data
  (id, visitors_purpose, description) are sent in the PATCH body to the
  api/visitorsPurposeUpdate endpoint, the expected status code is 200,
  and the message in the response body should be "Success."

    * Set "api/visitorsPurposeUpdate" parameters
    * A Patch body is sent to the endpoint "api/visitorsPurposeUpdate" with valid authorization credentials "Admin" user and correct datas id 4 and visitors_purpose "came for T113" and description "team7 demo presantation"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  @api
Scenario: [TC_02_API_US004] When invalid authorization information or missing/wrong data (id)
is sent in the PATCH body (with visitors_purpose, description) to the api/visitorsPurposeUpdate
endpoint, the expected status code is 403, and the message in the response body should be "failed."

    * Set "api/visitorsPurposeUpdate" parameters





  @api
Scenario: [TC03_API_US004] The updateId information in the response body should be
validated to be the same as the id information in the PATCH request body sent to the
api/visitorsPurposeUpdate endpoint.

    * Set "api/visitorsPurposeUpdate" parameters
    * Comparison test with updateId in the response when submitting a Patch body to the endpoint "api/visitorsPurposeUpdate" with valid authorization credentials "Admin" user and correct data ID 4 and visitors_purpose "Team7 is the best team among T113 batch teams" and description "Team7 Demo Presantation_Sprint:2"





  @api
Scenario: [TC04_API_US004] The successful update of the visitor purpose record via the API should be validated.
This can be confirmed by using the updateId returned in the response body to send a POST body
to the api/visitorsPurposeId endpoint and verify the record is updated.

    * Set "api/visitorsPurposeUpdate" parameters
    * Comparison test with updateId in the response when submitting a Patch body to the endpoint "api/visitorsPurposeUpdate" with valid authorization credentials "Admin" user and correct data ID 4 and visitors_purpose "Team7 is the best team among T113 batch teams" and description "Team7 Demo Presantation_Sprint:2"