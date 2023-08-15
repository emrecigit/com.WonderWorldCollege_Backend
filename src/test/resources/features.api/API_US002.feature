Feature :[API_US002] As an administrator, I want to access the Visitor Purpose information of a user with a given ID through API connection.


  Scenario: [TC_01_API_US002] When a valid authorization information and correct data (ID) are
  sent in the POST body to the api/visitorsPurposeId endpoint, the expected status code is 200,
  and the message in the response body should be "Success."


    * b
    * b
    * b
    * b


  Scenario: [TC_02_API_US002] When invalid authorization information or invalid data (ID)
  is sent in the POST body to the api/visitorsPurposeId endpoint, the expected status code is 403,
  and the message in the response body should be "failed."

    * b
    * b
    * b
    * b



  Scenario: [TC03_API_US004] The content of the list data (ID, visitors_purpose, description,
  created_at) in the response body should be validated.

    * b
    * b
    * b
    * b




