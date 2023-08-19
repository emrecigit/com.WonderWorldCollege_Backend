Feature: [DB_US01] Verify that there are 11 users in the chat_users table with create_staff_id equal to 1.



Scenario: [TC_01_DB_US001] Verify that there are 11 users in the chat_users table
with create_staff_id equal to 1.

  * Database connection is established
  * A querry showing that the number of users with create_staff_id= 1 in the chat_users table in the database is 11 is prepared, run and saved.
  * Verify the query result
  * Database connection is closed