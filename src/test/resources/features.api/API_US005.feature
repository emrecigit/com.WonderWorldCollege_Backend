Feature: [API_US005] As an administrator, I want to be able to delete a visitor purpose record from the system through API connection.


  Scenario: [TC_01_API_US005] When valid authorization information and correct data (id) are sent
  in the DELETE body to the api/visitorsPurposeDelete endpoint,
  the expected status code is 200, and the message in the response body should be Success.

    * Set "api/visitorsPurposeDelete" parameters
    * For the record created in a Post query sent to the "api/visitorsPurposeAdd" endpoint with visitors_purpose "Team7 is the best team among T113 batch teams" and description "Team7 Demo Presantation_Sprint:2", a Delete body is sent to the "api/visitorsPurposeDelete" endpoint with the valid authorization credentials "Admin" user and the id returned from the record response
    * Verifies that status code is 200
    * Verifies that the message information is "Success"


  Scenario: [TC_02_API_US005] When invalid authorization information or wrong data (id) is sent
  in the DELETE body to the api/visitorsPurposeDelete endpoint, the expected status code is 403,
  and the message in the response body should be  failed.


    * Set "api/visitorsPurposeDelete" parameters
    * Validates that when sending correct or incorrect data with id 2 to the "api/visitorsPurposeDelete" endpoint with invalid authorization "wrongToken", the status Code of the failed connection is 403 and the message is "Forbidden"


  Scenario: [TC03_API_US005] The DeletedId information in the response body should be validated
  to be the same as the id information in the DELETE request body sent to the
  api/visitorsPurposeDelete endpoint.


    * Set "api/visitorsPurposeDelete" parameters
    * For the record created in a Post query sent to the "api/visitorsPurposeAdd" endpoint with visitors_purpose "Team7 is the best team among T113 batch teams" and description "Team7 Demo Presantation_Sprint:2", a Delete body is sent to the "api/visitorsPurposeDelete" endpoint with the current authorization credentials "Admin" user and the id returned from the record response, and a comparison test with the DeleteId in the response returned from it


  Scenario: [TC04_API_US005] The successful deletion of the visitor purpose record via the API
  should be validated. (This can be confirmed by using the DeletedId returned in the response body
  to send a POST body to the api/visitorsPurposeId endpoint and verify the record is deleted.)

    * Set "api/visitorsPurposeUpdate" parameters
    * For the record created in a Post query sent to the "api/visitorsPurposeAdd" endpoint with visitors_purpose "Team7 is the best team among T113 batch teams" and description "Team7 Demo Presantation_Sprint:2", a Delete body is sent to the "api/visitorsPurposeDelete" endpoint with the current authorization credentials "Admin" user and the id returned from the record response, and a comparison test with the DeleteId in the response returned from it