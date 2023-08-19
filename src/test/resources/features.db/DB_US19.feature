@db
Feature: [DB_US_19] List the 5 longest (text) values from the email column in the students table.


  Scenario: [TC_01_DB_US_19] List the 5 longest (text) values from the email column in the students table.

    * Database connection is established.
    * List the five longest (text) data in the email column of the students table.
    * Database connection is closed