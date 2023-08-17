Feature: [DB_US_11] Update the fine_amount value to '200.00' for the record in the transport_feemaster table where the month value is 'October'.


  Scenario: [TC_DB_01]

    * Database connection is established
    * Book-title query is prepared and run and the result is obtained
    * Book-title query result is validated
    * Database connection is closed