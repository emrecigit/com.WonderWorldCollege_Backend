Feature: As an administrator, I want to create a new Books record through API connection.


  Scenario: When valid authorization information and correct data are sent with a POST
            body to the api/booksAdd endpoint, the expected status code is 200, and the response
            body's message should be "Success."




  Scenario: When invalid authorization information or incomplete data is sent with a POST
            body to the api/booksAdd endpoint, the expected status code is 403, and the response
            body's message should be "failed."



  Scenario: By using the returned addId in the response body, we can verify that a new book record has
            been successfully created through the API by sending a POST body to the api/booksId endpoint.