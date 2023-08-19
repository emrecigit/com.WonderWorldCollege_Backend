
Feature: [API_US46] As an administrator (teacher), I want to update the registered Homework information in the system through API connection.



  @api
  Scenario: [TC_01_API_US046] When valid authorization and correct data (id, class_id, section_id, session_id, subject_group_subject_id, subject_id, homework_date, submit_date, marks, description, create_date, evaluation_date, document, created_by, evaluated_by) are sent in a PATCH body to the "api/alumniEventsUpdate" endpoint, the response status code should be 200, and the response body's message should be "Success."