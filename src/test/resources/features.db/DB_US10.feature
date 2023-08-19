@db
Feature: [DB_US_10] A specific entry should be deletable from the visitors_book table


  Scenario: [TC_DB_01] A specific entry should be deletable from the visitors_book table

    * Database connection is established
    * transport_feemaster query is prepared and run and the result is obtained
    * transport_feemaster query result is validated
    * Database connection is closed