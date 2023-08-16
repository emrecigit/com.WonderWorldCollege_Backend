Feature :[API_US005] As an administrator, I want to be able to delete a visitor purpose record from the system through API connection.


  Scenario: [TC_01_API_US005] When valid authorization information and correct data (id) are sent
  in the DELETE body to the api/visitorsPurposeDelete endpoint,
  the expected status code is 200, and the message in the response body should be "Success."




  Scenario: [TC_02_API_US005] When invalid authorization information or wrong data (id) is sent
  in the DELETE body to the api/visitorsPurposeDelete endpoint, the expected status code is 403,
  and the message in the response body should be "failed."




  Scenario: [TC03_API_US005] The DeletedId information in the response body should be validated
  to be the same as the id information in the DELETE request body sent to the
  api/visitorsPurposeDelete endpoint.






  Scenario: [TC04_API_US005] The successful deletion of the visitor purpose record via the API
  should be validated. (This can be confirmed by using the DeletedId returned in the response body
  to send a POST body to the api/visitorsPurposeId endpoint and verify the record is deleted.)
