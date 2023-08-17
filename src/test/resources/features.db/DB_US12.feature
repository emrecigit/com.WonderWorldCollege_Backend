Feature: [DB_US_12] List the first 5 employees in the staff table sorted by work experience from the oldest to the newest.


  Scenario: [TC_DB_01]

    * Database connection is established
    * work_exp query is prepared and run and the result is obtained
    * work_exp query result is validated
    * Database connection is closed