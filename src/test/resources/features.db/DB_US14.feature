@db
Feature: JDBS_US_14


  Scenario: List the book titles of books in the books table where the author data is 'Rubina Malik'
  or 'MRV'

    * Database connection is established
    * Book-title query is prepared and run and the result is obtained
    * Book-title query result is validated
    * Database connection is closed
