Feature: As an administrator, I want to access the book information
         of a book with a given ID through API connection.


  Scenario: When a valid authorization information and correct data (id) are sent
           with a POST body to the api/booksId endpoint,the expected status code is 200,
           and the response body's message should be "Success."





  Scenario: When invalid authorization information is sent with a GET request to the api/booksList
            endpoint, the expected status code is 403, and the response message should be "failed."




  Scenario: The content of the list in the response body should contain data with the following attributes.