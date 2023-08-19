
Feature: [API_US51] As an administrator (teacher), I want to update the registered Questions information in the system through API connection.



  Scenario: [TC_01_API_US051] When valid authorization and correct data (subject_id, question_type, level, class_id, section_id, class_section_id, question, opt_a, opt_b, opt_c, opt_d, opt_e, (opt_x), correct, descriptive_word_limit) are used to send a PATCH body to the "apiteacher/questionUpdate" endpoint, the response status code should be 200, and the response body's message should be "Success."