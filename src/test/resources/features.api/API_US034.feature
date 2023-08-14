Feature: [API_US034] As an administrator, I want to access the Visitor information of a visitor with a given ID through API connection.


  Scenario: [TC_01_API_US_034] When a POST body with valid authorization information and correct data (id) is sent to the api/visitorsId endpoint,
            it should be verified that the status code returned is 200 and "Success".




  Scenario: [TC_02_API_US_034] When a POST body containing invalid authorization information or invalid data (id) is sent to the api/visitorsId endpoint,
            it should be verified that the status code returned is 403 and "failed".



  Scenario: [TC_03_API_US_034] The contents of the list data in the response body must be validated.
            The values of these contents must match the id in the POST body sent.