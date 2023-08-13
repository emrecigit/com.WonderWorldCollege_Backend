Feature: [US_001] As an administrator, I want to access the Purpose List through an API connection.


Scenario: [TC_02_API_US_007] When invalid authorization information is sent with a GET request to the
api/alumniEventsList endpoint the expected status code is 403,
and the message in the response body should be "failed."

* Set "api/alumniEventsList" parameters
* Records response for Admin with invalid authorization information
* Verifies that status code is 403
* Verifies that the message information is "Failed"