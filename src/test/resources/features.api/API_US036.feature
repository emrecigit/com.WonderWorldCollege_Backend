Feature: [API_US036] As an administrator, I want to update the registered Visitors' information in the system through API connection.


  Scenario: [TC_01_API_US_036] When a PATCH body with valid authorization information and correct data is sent to the api/visitorsUpdate endpoint,
            it should be verified that the status code returned is 200 and "Success".


  Scenario: [TC_02_API_US_036] Verify that the status code returned when a PATCH body with invalid authorization information or missing/incorrect
            data (id) is sent to the api/visitorsUpdate endpoint is 403 and "failed".


  Scenario: [TC_03_API_US_036] It should be verified that the updateId in the response body is the same
            as the id in the PATCH request body sent to the api/visitorsUpdate endpoint.



  Scenario: [TC_04_API_US_036] It should be verified from the API that the visitor record
            that is requested to be updated via the API has been updated.