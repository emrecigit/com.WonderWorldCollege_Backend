
Feature: [API_US_025] As an administrator, I want to create a new Alumni record through API connection


  @api
  Scenario: [TC_01_API_US_025] When valid authorization information and the correct data (student_id, current_email, current_phone, occupation, address, photo) are sent in a POST body to the api/alumniAdd endpoint, the expected status code is 200, and the message in the response body should be "Success."
