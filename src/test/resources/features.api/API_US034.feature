Feature: [API_US034] As an administrator, I want to access the Visitor information of a visitor with a given ID through API connection.


  Scenario: [TC_01_API_US_034] When a POST body with valid authorization information and correct data (id) is sent to the api/visitorsId endpoint,
            it should be verified that the status code returned is 200 and "Success".


    * Set "api/visitorsId" parameters
    * Prepare request body for admin api_alumniId endpoint and record response
    * Verifies that status code is 200
    * Verifies that the message information is "Success"




  Scenario: [TC_02_API_US_034] When a POST body containing invalid authorization information or invalid data (id) is sent to the api/visitorsId endpoint,
            it should be verified that the status code returned is 403 and "failed".

    * Set "api/visitorsId" parameters
    * Records response for Admin with invalid authorization information
    * Verifies that status code is 403
    * Verifies that the message information is "failed"



  Scenario: [TC_03_API_US_034] The contents of the list data in the response body must be validated.
            The values of these contents must match the id in the POST body sent.

    * Set "api/visitorsId" parameters
    * Prepare request body for admin api_alumniId endpoint and record response
    * Verifies that record includes "id, staff_id, student_session_id, source, purpose, name, email, contact, id_proof, no_of_people, date, in_time, out_time, note, image, meeting_with, created_at, class, section, staff_name, staff_surname, staff_employee_id, class_id, section_id, students_id, admission_no, student_firstname, student_middlename, student_lastname, role_id"