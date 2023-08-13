
Feature: JDBS US_13
  @Mina
  Scenario:List the email addresses of records in the online_admissions table where the firstname contains the word 'al'

    * Database connection is established
    * E-mail query is prepared and run and the result is obtained
    * Email query result is validated
    * Database connection is closed