Feature: [DB_US_006] Database üzerinden students tablosundaki father_occupation değeri Doctor
  veya Police olan öğrencilerin roll_no bilgilerini büyükten küçüğe listeleyiniz.

  Scenario: [TC_01_DB_US_006] Database üzerinden students tablosundaki father_occupation değeri Doctor
  veya Police olan öğrencilerin roll_no bilgilerini büyükten küçüğe listeleyiniz.

    * Database connection is established
    * List the roll no query is prepared and run and the result is obtained
    * List the roll no query result is validated
    * Database connection is closed