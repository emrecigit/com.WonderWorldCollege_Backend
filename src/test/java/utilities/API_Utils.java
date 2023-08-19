package utilities;

import hooks.HooksAPI;
import io.cucumber.gherkin.internal.com.eclipsesource.json.PrettyPrint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API_Utils {

    private static String token;
    private static String tokenAll;
    private static String fullPath;
    private static RequestSpecification spec;

    public static Response response;
    public static JSONObject reqBody;


    public static String createfullPath(String rawPaths) {
        String[] paths = rawPaths.split("/");
        StringBuilder tempPath = new StringBuilder("/{");
        for (int i = 0; i < paths.length; i++) {
            String key = "pp" + i; // pp0 pp1 pp2
            String value = paths[i].trim();
            HooksAPI.spec.pathParam(key, value);
         //   System.out.println(HooksAPI.spec.pathParam(key, value).toString());
            tempPath.append(key + "}/{");
            /*
            tempPath.append(key);            temPath den alta doğru bu şekilde de devam edebilir.
            if (i < paths.length - 1) {
                tempPath.append("}/{");
            }
         }
        tempPath.append("}");
        return tempPath.toString();
             */
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        fullPath = tempPath.toString();
      //  System.out.println("Create fullPath = " + fullPath);
        return fullPath;
    }


       public static String generateTokenAll(String userType) { //  "/ olmadan başla"
           if (userType.toLowerCase().equals("admin")) {
               tokenAll = API_Utils.generateTokenAdmin();
           }
           if (userType.toLowerCase().equals("teacher")) {
               tokenAll = API_Utils.generateTokenTeacher();
           }
           if (userType.toLowerCase().equals("student")) {
               tokenAll = API_Utils.generateTokenStudent();
           }
           return tokenAll;
       }

    public static String generateTokenAdmin() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("pp1", "api", "pp2", "getToken");
        Map<String, Object> dataCredential = new HashMap<>();
        dataCredential.put("email", ConfigReader.getProperty("emailAdmin"));
        dataCredential.put("password", ConfigReader.getProperty("password"));
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(dataCredential)
                .post("/{pp1}/{pp2}");
        JsonPath respJP = response.jsonPath();
        String token = respJP.getString("token");
        return token;
    }
    public static String generateTokenTeacher() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("pp1", "api", "pp2", "getToken");
        Map<String, Object> dataCredential = new HashMap<>();
        dataCredential.put("email", ConfigReader.getProperty("emailTeacher"));
        dataCredential.put("password", ConfigReader.getProperty("password"));
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(dataCredential)
                .post("/{pp1}/{pp2}");
        JsonPath respJP = response.jsonPath();
        String token = respJP.getString("token");
        return token;
    }
    public static String generateTokenStudent() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("pp1", "apistudent", "pp2", "getToken");
        Map<String, Object> dataCredential = new HashMap<>();
        dataCredential.put("username", ConfigReader.getProperty("emailStudent"));// email yerine username ile değişti
        dataCredential.put("password", ConfigReader.getProperty("password"));
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(dataCredential)
                .post("/{pp1}/{pp2}");
        JsonPath respJP = response.jsonPath();
        String token = respJP.getString("token");
        return token;
    }
    public static String generateToken(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("pp1","api","pp2","getToken");
        JSONObject reqBody = new JSONObject();

        reqBody.put("email", ConfigReader.getProperty("email"));
        reqBody.put("password", ConfigReader.getProperty("password"));

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .when()
                .body(reqBody.toString())
                .post("/{pp1}/{pp2}");

        JsonPath resJP = response.jsonPath();

        String token=resJP.getString("token");

        return token;
    }


}


//   public static RequestSpecification spec;
//   public static String generateToken() {
//       spec = new RequestSpecBuilder().setBaseUri(URI.create("https://xyz.com/api/login")).build();
//       RequestSpecification requestSpec = spec;
//       Map<String, Object> expectedData = new HashMap<>();
//       expectedData.put("email", "test@test.com");
//       expectedData.put("password", "123123123");
//       Response response = given().spec(requestSpec).contentType(ContentType.JSON).
//       body(expectedData).when().post();
//       JsonPath json = response.jsonPath();
//       return json.getString("token");
//   }




