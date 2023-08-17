Feature: [API_US003] As an administrator, I want to create a new visitor purpose record through API connection.



  Scenario: [TC_01_API_US003] When valid authorization information and correct data
  (visitors_purpose, description) are sent in the POST body to the api/visitorsPurposeAdd
  endpoint, the expected status code is 200, and the message in the response body should be "Success."

    * Set "api/visitorsPurposeAdd" parameters
    * A Post body is sent to the endpoint "api/visitorsPurposeAdd" with valid authorization credentials "Admin" user and correct datas visitors_purpose "Veli Ziyareti" and description "Veli Ziyareti İçin Gelindi"
    * Verifies that status code is 200
    * Verifies that the message information is "Success"

    Scenario: [TC_02_API_US003] When invalid authorization information or missing data
    (visitors_purpose, description) is sent in the POST body to the api/visitorsPurposeAdd endpoint,
    the expected status code is 403, and the message in the response body should be "failed."

      * Set "api/visitorsPurposeAdd" parameters
      * Validates that when sending correct or incorrect data with datas visitors_purpose "Veli Ziyareti" and description "Veli Ziyareti İçin Gelindi" to the "api/visitorsPurposeAdd" endpoint with invalid authorization "wrongToken", the status Code of the failed connection is 403 and the message is "Forbidden"

      Scenario: [TC03_API_US003] The successful creation of a new visitor purpose record via the API
      should be validated. (This can be confirmed by using the addId returned in the response body to
      send a POST body to the api/visitorsPurposeId endpoint and verify the record is created.)

        * Set "api/visitorsPurposeAdd" parameters
        * The AddId number returned in the response of the Post request sent to the "api/visitorsPurposeAdd" endpoint with the userType "Admin" and the body containing "Rising the Team7" and "Team7's Demo Presantation" is compared with the id number returned from the "api/visitorsPurposeId" post query to verify that the registration was successful.

