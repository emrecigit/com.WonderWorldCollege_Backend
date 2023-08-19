
Feature: [API_US037] As an administrator, I want to be able to delete a Visitors' record from the system through API connection.


  @api
  Scenario: [TC_01_API_US_037] When a DELETE body with valid authorization information and correct data (id) is sent to the api/visitorsDelete endpoint,
            it should be verified that the status code returned is 200 and "Success".



  @api
  Scenario: [TC_02_API_US_037] When a DELETE body with invalid authorization information or incorrect data (id) is sent to the api/visitorsDelete endpoint,
            it should be verified that the returned status code is 403 and the message information is "failed".



  @api
  Scenario: [TC_03_API_US_037] Verify that the DeletedId in the response body is the same as
            the id in the DELETE request body sent to the api/visitorsDelete endpoint


  @api
  Scenario: [TC_04_API_US_037] It is necessary to verify from the API that the visitor
            record requested to be deleted from the API has been deleted.