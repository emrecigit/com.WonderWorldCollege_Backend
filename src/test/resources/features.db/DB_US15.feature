@db
Feature: JDBS_US_15

  Scenario: List the books from the books table where the quantity (qty) value is between 100 and 500.

    * Database connection is established
    * List the books query is prepared and run and the result is obtained
    * List the books query result is validated
    * Database connection is closed


