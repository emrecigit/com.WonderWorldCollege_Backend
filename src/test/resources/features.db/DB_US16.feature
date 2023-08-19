@db
Feature: [DB_US16] List the last 10 records from the online_admissions table.


    //Database üzerinden online_admissions tablosuna en son  kaydolan 10 datayı lısteleyınız.

   // * Database baglantisi kurulur.
   // * Query hazirlanir.
   // * Query calistirilir ve sonuclari alinir.
   // * Query sonuclari dogrulanir.
   // * Database baglantisi kapatilir.

  Scenario: [TC_01_DB_US_016] List the last 10 records from the online_admissions table.

    * Database connection is established
    * Database connection is closed
