
Feature:[US_24] As an administrator, I want to access the Alumni information of an alumnus with a given ID through API connection.


  @api
  Scenario: [TC_01_US24] When a valid authorization information and the correct data (id) are sent in a POST body to the api/alumniId endpoint, the expected status code is 200, and the message in the response body should be "Success."

    * Set "api/alumniId" parameters



  @api
  Scenario: [TC_02_US24] When invalid authorization information or incorrect data (id) is sent in a POST body to the api/alumniId endpoint, the expected status code is 403, and the message in the response body should be "failed."
    * Set "api/alumniId" parameters



  @api
  Scenario: [TC_03_US24] The content of the list in the response body should contain the following data:
  id: The identifier of the alumni record.
  student_id: The student identifier associated with the alumni.
  current_email: The current email address of the alumni.
  current_phone: The current phone number of the alumni.
  occupation: The occupation of the alumni (if available).
  address: The address of the alumni (if available).
  photo: The photo of the alumni (if available).
  created_at: The date and time when the alumni record was created.
  These details should be verified to ensure the correct response data.

    * Set "api/alumniId" parameters

