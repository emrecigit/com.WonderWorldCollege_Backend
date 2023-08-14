Feature:US_24
  Scenario: TC_01

    * Set "api/alumniId" parameters
    * Prepare request body for admin api_alumniId endpoint and record response
    * Verifies that status code is 200
    * Verifies that the message information is "Success"



  Scenario: TC_02
    * Set "api/alumniId" parameters
    * Records response for Admin with invalid authorization information
    * Verifies that status code is 403
    * Verifies that the message information is "failed"




  Scenario: TC_03
    * Set "api/alumniId" parameters
    * Prepare request body for admin api_alumniId endpoint and record response
    * Verifies that record includes "id,student_id,current_email,current_phone,occupation,address,photo,created_at"
