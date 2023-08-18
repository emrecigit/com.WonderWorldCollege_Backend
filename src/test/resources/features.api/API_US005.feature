Feature: [API_US005] As an administrator, I want to be able to delete a visitor purpose record from the system through API connection.


  Scenario: [TC_01_API_US005] When valid authorization information and correct data (id) are sent
  in the DELETE body to the api/visitorsPurposeDelete endpoint,
  the expected status code is 200, and the message in the response body should be Success.

    * Set "api/visitorsPurposeDelete" parameters
    * A Post body is sent to the endpoint "api/visitorsPurposeAdd" with valid authorization credentials "Admin" user and correct datas visitors_purpose "Veli Ziyareti" and description "Veli Ziyareti İçin Gelindi"
    * A Delete body is sent to the endpoint "api/visitorsPurposeDelete" with valid authorization credentials "Admin" user and correct id 3
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


    * Set "api/visitorsPurposeUpdate" parameters
    * The DeletetetetetId number returned in the response of the Post request sent to the "api/visitorsPurposeDelete" endpoint with the userType "Admin" and the body containing "Rising the Team7" and "Team7's Demo Presantation" is compared with the id number returned from the "api/visitorsPurposeId" post query to verify that the registration was successful.


  Scenario: [TC04_API_US005] The successful deletion of the visitor purpose record via the API
  should be validated. (This can be confirmed by using the DeletedId returned in the response body
  to send a POST body to the api/visitorsPurposeId endpoint and verify the record is deleted.)

    * Set "api/visitorsPurposeUpdate" parameters
    * Comparison test with DeleteeeeId in the response when submitting a Delete body to the endpoint "api/visitorsPurposeDelete" with valid authorization credentials "Admin" user and correct data ID 4 and visitors_purpose "Team7 is the best team among T113 batch teams" and description "Team7 Demo Presantation_Sprint:2"