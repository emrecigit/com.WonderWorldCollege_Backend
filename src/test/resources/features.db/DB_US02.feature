@db
Feature: [DB_US02] Verify that there are 11 users in the chat_users table with create_staff_id equal to 1.



  Scenario: [TC_01_DB_US002] List the IDs of contents from the class_sections table
  where the class_id and section_id values are equal


    * Database connection is established
    * A query that lists the ids of the contents with equal class_id and section data is prepared, run and saved from the data in the class_sections table in the database.
    * List and verify the query result
    * Database connection is closed