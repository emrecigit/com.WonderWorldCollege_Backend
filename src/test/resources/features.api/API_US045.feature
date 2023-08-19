
Feature: [API_US45] As an administrator (teacher), I want to create a new Homework record through API connection.


  @api
  Scenario: [TC_01_API_US045] When valid authorization and correct data (class_id, section_id, session_id, subject_group_subject_id, subject_id, homework_date, submit_date, marks, description, create_date, evaluation_date, document, created_by, evaluated_by) are sent in a POST body to the "apiteacher/homeworkAdd" endpoint, the response status code should be 200, and the response body's message should be "Success."