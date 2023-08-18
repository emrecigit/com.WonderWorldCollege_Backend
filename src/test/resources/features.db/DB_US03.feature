Feature: [DB_US03] Verify that there are 11 users in the chat_users table with create_staff_id equal to 1.



  Scenario: [TC_01_DB_US003] Verify that the email of the student in the students table with
  firstname Brian and lastname Kohlar is brain@gmail.com.


    * Database connection is established
    * The query confirming that the email information of the student with firstname= Brian and lastname= Kohlar in the wonderworld_qa.students table over the database is prepared, run and saved.
    * Verify the query result
    * Database connection is closed