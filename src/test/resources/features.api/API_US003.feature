Feature :[API_US003] As an administrator, I want to create a new visitor purpose record through API connection.



  Scenario: [TC_01_API_US003] When valid authorization information and correct data
  (visitors_purpose, description) are sent in the POST body to the api/visitorsPurposeAdd
  endpoint, the expected status code is 200, and the message in the response body should be "Success."


    * b
    * b
    * b
    * b


  Scenario: [TC_02_API_US003] When invalid authorization information or missing data
  (visitors_purpose, description) is sent in the POST body to the api/visitorsPurposeAdd endpoint,
  the expected status code is 403, and the message in the response body should be "failed."


    * b
    * b
    * b
    * b



  Scenario: [TC03_API_US003] The successful creation of a new visitor purpose record via the API
  should be validated. (This can be confirmed by using the addId returned in the response body to
  send a POST body to the api/visitorsPurposeId endpoint and verify the record is created.)


    * b
    * b
    * b
    * b
