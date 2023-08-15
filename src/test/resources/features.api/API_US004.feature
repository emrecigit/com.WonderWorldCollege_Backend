Feature :[API_US004] As an administrator, I want to update the registered visitor purpose information in the system through API connection.


  Scenario: [TC_01_API_US004] When invalid authorization information or missing/wrong data (id) is
  sent in the PATCH body (with visitors_purpose, description) to the api/visitorsPurposeUpdate
  endpoint, the expected status code is 403, and the message in the response body should be "failed."

  api/visitorsPurposeUpdate endpoint'ine gecerli authorization bilgileri ve dogru datalar
  (id, visitors_purpose, description) iceren bir PATCH body gönderildiginde dönen status code'in 200
  oldugu ve response body'deki message bilgisinin "Success" oldugu dogrulanmali

    * b
    * b
    * b
    * b


  Scenario: [TC_02_API_US004] When invalid authorization information or missing/wrong data (id)
  is sent in the PATCH body (with visitors_purpose, description) to the api/visitorsPurposeUpdate
  endpoint, the expected status code is 403, and the message in the response body should be "failed."

    * b
    * b
    * b
    * b



  Scenario: [TC03_API_US004] The updateId information in the response body should be
  validated to be the same as the id information in the PATCH request body sent to the
  api/visitorsPurposeUpdate endpoint.

    * b
    * b
    * b
    * b




  Scenario: [TC04_API_US004] The successful update of the visitor purpose record via the API should be validated.
  (This can be confirmed by using the updateId returned in the response body to send a POST body
  to the api/visitorsPurposeId endpoint and verify the record is updated.)

    * b
    * b
    * b
    * b