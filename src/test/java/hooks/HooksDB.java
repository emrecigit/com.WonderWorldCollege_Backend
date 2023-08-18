package hooks;


import org.junit.After; //import io.cucumber.java.After;
import org.junit.Before; // import io.cucumber.java.Before;
import utilities.ConfigReader;

import java.sql.*;

public class HooksDB {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String dbURL;
    private static String dbUsername;
    private static String dbPassword;


    @Before
    public void setUpDatabaseConnection() throws SQLException {
        // Load database credentials from Configuration.properties file
        dbURL = ConfigReader.getProperty("db_credentials_url");
        dbUsername = ConfigReader.getProperty("db_username");
        dbPassword = ConfigReader.getProperty("db_password");

        // Establish database connection
        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // statement = connection.createStatement();
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*
        public static ResultSet getResultset() {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultSet;
    }
         */
    }

    @After
    public void closeDatabaseConnection() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    /*
       try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     */
}

/*
  @Given("a database connection is established")
    public void aDatabaseConnectionIsEstablished() {
        // No need to explicitly establish connection, HooksDB will handle it
    }

    @When("I execute a database query")
    public void iExecuteADatabaseQuery() {
        // Execute your database query using the 'statement' object
    }

    @Then("I verify the database query result")
    public void iVerifyTheDatabaseQueryResult() {
        // Verify your database query result
    }
Bu örnekler, Cucumber senaryolarınızda MySQL veritabanı ile çalışmak için temel bir çerçeve sağlar. Gerçek senaryolarınıza uyacak şekilde bu temel örneği özelleştirebilirsiniz.

 */