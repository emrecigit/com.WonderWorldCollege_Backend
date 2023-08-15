Feature: [DB_US_004] List the firstname and lastname of students in the students table with admission
  numbers between 18001 and 18010.

  Scenario: [TC_01_DB_US_004] List the firstname and lastname of students in the students table with admission
  numbers between 18001 and 18010.

    * Database connection is established
    * List the students query is prepared and run and the result is obtained
    * List the students query result is validated
    * Database connection is closed