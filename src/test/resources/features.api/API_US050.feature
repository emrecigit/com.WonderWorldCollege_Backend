
Feature: [API_US50] As an administrator (teacher), I want to create a new Questions record through API connection.


  @api
  Scenario: [TC_01_API_US050] When valid authorization and correct data (subject_id, question_type, level, class_id, section_id, class_section_id, question, opt_a, opt_b, opt_c, opt_d, opt_e, (opt_x), correct, descriptive_word_limit) are used to send a POST body to the "apiteacher/questionAdd" endpoint, the response status code should be 200, and the response body's message should be "Success."