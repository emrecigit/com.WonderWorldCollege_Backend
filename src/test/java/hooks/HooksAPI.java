package hooks;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.Authentication;
import utilities.ConfigReader;
import utilities.API_Utils;


public class HooksAPI {




  public static RequestSpecification spec;
    public static String tokenAll;
   public static String token;
    public static String tokenWrong;
    public static String tokenAdmin;
    public static String tokenTeacher;
    public static String tokenStudent;

    @Before (order = 0)
    public void setUpApi(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
    }

    @Before(order = 1)

    public  void  beforeGenerateTokenAll(String userType, String endPoint){
        tokenAll = API_Utils.generateTokenAll(userType, endPoint);
        System.out.println("Tokenim : " + tokenAll);
    }

    @Before(order = 1)
    public void beforeGenerateTokenAdmin(){
        tokenAdmin = API_Utils.generateTokenAdmin();
        System.out.println("Tokenim : " + tokenAdmin);
    }

    @Before(order = 1)
    public void beforeGenerateTokenTeacher(){
        tokenTeacher = API_Utils.generateTokenTeacher();
        System.out.println("Tokenim : " + tokenTeacher);
    }

    @Before(order = 1)
    public void beforeGenerateTokenStudent(){
        tokenStudent = API_Utils.generateTokenStudent();
        System.out.println("Tokenim : " + tokenStudent);

    }
    @Before (order=1)
    public void beforeGenerateToken(){
    token = Authentication.generateToken();
    }

    @Before (order=1)
    public void beforeGenerateTokenWrong(){
        tokenWrong = Authentication.generateToken();
    }

}
