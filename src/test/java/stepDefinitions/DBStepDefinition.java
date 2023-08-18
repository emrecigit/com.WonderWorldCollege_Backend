package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DB_Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.DB_Utils.*;

public class DBStepDefinition {
    /*
Scope
Emre ÇİĞİT : 1-500
Nur YURTSEVEN : 501-1000
İlknur DOĞANALP : 1001-1500
Rümeysa ARAS : 1501-2000
Merve DEMİRDÜZEN : 2001-2500
Latife MERT : 2501-3000
Mustafa ÖRS : 3001-3500
Mehmet Şah OKUMUŞ :3501-4000
 */
    List<Object> UserEmailList= new ArrayList<>();
    @Given("Database connection established")
    public void database_connection_established() {
        createConnection();
    }
    @Given("From the Users table,{string} data of the user whose {string} and {string} information is entered are retrieved")
    public void from_the_users_table_data_of_the_user_whose_and_information_is_entered_are_retrieved(String email, String firstName, String lastName) {
        String query= "SELECT email FROM u480337000_tlb_training.users where first_name='"+firstName+"' and last_name= '"+lastName+"';";
        UserEmailList=getColumnData(query,email);
    }

    @Then("User's {string} data is verified")
    public void user_s_data_is_verified(String email) {
        assertTrue(UserEmailList.get(0).equals(email));

    }
    @Then("Database connection is closed")
    public void database_connection_is_closed() {

        closeConnection();
    }


    String query;
    String searchSyllable;
    String query1;
    String query2;
    ResultSet rs;
    ResultSet rs1;
    ResultSet rs2;
    PreparedStatement ps;
    String query4;
    ResultSet rs4;
    String query5;
    ResultSet rs5;
    String query6;
    ResultSet rs6;

    @Given("Database connection is established")
    public void database_connection_is_established() {

        DB_Utils.createConnection();
    }

    @Given("E-mail query is prepared and run and the result is obtained")
    public void e_mail_query_is_prepared_and_run_and_the_result_is_obtained() throws SQLException {

        query = "SELECT email FROM u168183796_qawonderuser.online_admissions WHERE firstname LIKE '%al%';";
        rs = getStatement().executeQuery(query);
    }
    @Given("Email query result is validated")
    public void email_query_result_is_validated() throws SQLException {

        String expected="al";
        String actual= DB_Utils.getColumnData(query,"email").toString();
        Assert.assertTrue(actual.contains(expected));


    }

    @Given("Book-title query is prepared and run and the result is obtained")
    public void book_title_query_is_prepared_and_run_and_the_result_is_obtained() throws SQLException {

        query1 = "SELECT book_title FROM u168183796_qawonderuser.books WHERE author IN ('Rubina malik', 'MRV');";
        rs1 = getStatement().executeQuery(query1);
        System.out.println(getQueryResultList(query1));
    }
    @Given("Book-title query result is validated")
    public void book_title_query_result_is_validated() throws SQLException {

        int expectedData = 4;
        int flag=0;
        while(rs1.next()){
            flag++;
        }
        assertEquals(expectedData,flag);
    }

    @Given("List the books query is prepared and run and the result is obtained")
    public void list_the_books_query_is_prepared_and_run_and_the_result_is_obtained() throws SQLException {

        query2 = "SELECT qty FROM u168183796_qawonderuser.books WHERE qty BETWEEN 100 AND 500;";
        rs2 = getStatement().executeQuery(query2);
    }

    @Given("List the books query result is validated")
    public void list_the_books_query_result_is_validated() {

        System.out.println(getColumnData(query2, "qty"));
    }



































































































































































































































































































































































































    @Given("List the students query is prepared and run and the result is obtained")
    public void list_the_students_query_is_prepared_and_run_and_the_result_is_obtained() throws SQLException {

        query4 = "SELECT lastname,firstname from u168183796_qawonder.students WHERE admission_no<18011 AND  admission_no>18000;";
        rs4 = getStatement().executeQuery(query4);
    }
    @Given("List the students query result is validated")
    public void list_the_students_query_result_is_validated() {
        System.out.println(getColumnData(query4, "firstname, lastname"));
    }
    @Given("List the mother name and mother occupation query is prepared and run and the result is obtained")
    public void list_the_mother_name_and_mother_occupation_query_is_prepared_and_run_and_the_result_is_obtained() throws SQLException {
        query5 = "SELECT mother_occupation,mother_name from u168183796_qawonderuser.students WHERE lastname LIKE 'T%';";
        rs5 = getStatement().executeQuery(query5);
    }
    @Given("List the mother name and mother occupation query result is validated")
    public void list_the_mother_name_and_mother_occupation_query_result_is_validated() {
        System.out.println(getColumnData(query5, " mother_occupation,mother_name"));
    }
    @Given("List the roll no query is prepared and run and the result is obtained")
    public void list_the_roll_no_query_is_prepared_and_run_and_the_result_is_obtained() throws SQLException {
        query6 = "SELECT roll_no FROM u168183796_qawonderuser.students WHERE father_occupation IN ('Doctor', 'Police') ORDER BY roll_no DESC;";
        rs6 = getStatement().executeQuery(query6);
    }
    @Given("List the roll no query result is validated")
    public void list_the_roll_no_query_result_is_validated() {
        System.out.println(getColumnData(query6, "roll_no"));
    }
























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































//-------------rumeysa
    String query10;
    ResultSet rs10;
    @Given("visitors_book query is prepared and run and the result is obtained")
    public void visitors_book_query_is_prepared_and_run_and_the_result_is_obtained() throws SQLException {
        /*public static void deleteRecord(String  visitors_book, String columnName, int recordId) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = getConnection();
                String deleteQuery = "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";
                preparedStatement = connection.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, recordId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Kayıt silindi.");
                } else {
                    System.out.println("Silme işlemi başarısız oldu veya hiçbir kayıt etkilenmedi.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

         */
        Statement st = DB_Utils.createStatement(DB_Utils.getConnection());

        String query = "DELETE FROM visitors_book WHERE id = kimlik_numarası";

        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {
            System.out.println(rs.getString("username") +" - - "+ rs.getString("password"));
        }

        rs.close();
        st.close();
       /* query10 = "DELETE FROM visitors_book WHERE id = kimlik_numarası";
        rs10 = getStatement().executeQuery(query);
        System.out.println(query10);

        */

    }

    @Given("visitors_book query result is validated")
    public void visitors_book_query_result_is_validated() throws SQLException {

    }


    //11
    String updateQuery10;
    @Given("transport_feemaster query is prepared and run and the result is obtained")
    public void transport_feemaster_query_is_prepared_and_run_and_the_result_is_obtained() throws SQLException {

       /* String updateQuery10= ConfigReader.getProperty();
        String updatename10=ConfigReader.getProperty();
        String updateId10=ConfigReader.getProperty();

        DB_Utils.update();

        */
        Statement st= DB_Utils.createStatement(DB_Utils.getConnection());

        String query= "UPDATE transport_feemaster SET fine_amount = '200.00' WHERE month = 'October';";

        ResultSet rs = st.executeQuery(query);

        //UPDATE transport_feemaster SET fine_amount = '200.00' WHERE month = 'October';
    }

    @Given("transport_feemaster query result is validated")
    public void transport_feemaster_query_result_is_validated() {

    }


    //12
    @Given("work_exp query is prepared and run and the result is obtained")
    public void work_exp_query_is_prepared_and_run_and_the_result_is_obtained() {

        //SELECT * FROM staff ORDER BY work_exp ASC LIMIT 5;
    }

    @Given("work_exp query result is validated")
    public void work_exp_query_result_is_validated() {

    }








































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































}
