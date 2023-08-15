Feature: [DB_US_005] Database üzerinden students tablosundaki lastname bilgisi 'T' ile başlayan
  öğrencinin mother_name ve mother:occupation degrlerini listeleyiniz.

  Scenario: [TC_01_DB_US_005] Database üzerinden students tablosundaki lastname bilgisi 'T' ile başlayan
  öğrencinin mother_name ve mother:occupation degrlerini listeleyiniz.

    * Database connection is established
    * List the mother name and mother occupation query is prepared and run and the result is obtained
    * List the mother name and mother occupation query result is validated
    * Database connection is closed