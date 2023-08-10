package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_Utils {

    public static RequestSpecification spec;
    public static String generateTokenAdmin(){



        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("pp1","api","pp2","getToken");
        Map<String,Object> dataCredential = new HashMap<>();
        dataCredential.put("email", ConfigReader.getProperty("emailAdmin"));
        dataCredential.put("password", ConfigReader.getProperty("password"));
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .when()
                .body(dataCredential)
                .post("/{pp1}/{pp2}");
        JsonPath respJP = response.jsonPath();
        String token = respJP.getString("token");
        return token;
    }
    public static String generateTokenTeacher(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("pp1","api","pp2","getToken");
        Map<String,Object> dataCredential = new HashMap<>();
        dataCredential.put("email", ConfigReader.getProperty("emailTeacher"));
        dataCredential.put("password", ConfigReader.getProperty("password"));
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .when()
                .body(dataCredential)
                .post("/{pp1}/{pp2}");
        JsonPath respJP = response.jsonPath();
        String token = respJP.getString("token");
        return token;
    }
    public static String generateTokenStudent(){


        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        spec.pathParams("pp1","apistudent","pp2","getToken");

        Map<String,Object> dataCredential = new HashMap<>();

        dataCredential.put("email", ConfigReader.getProperty("emailStudent"));
        dataCredential.put("password", ConfigReader.getProperty("password"));

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .when()
                .body(dataCredential)
                .post("/{pp1}/{pp2}");

        JsonPath respJP = response.jsonPath();

        String token = respJP.getString("token");

        return token;
    }



//   public static RequestSpecification spec;
//   public static String generateToken() {

//       spec = new RequestSpecBuilder().setBaseUri(URI.create("https://xyz.com/api/login")).build();
//       RequestSpecification requestSpec = spec;

//       Map<String, Object> expectedData = new HashMap<>();
//       expectedData.put("email", "test@test.com");
//       expectedData.put("password", "123123123");

//       Response response = given().spec(requestSpec).contentType(ContentType.JSON).
//               body(expectedData).when().post();

//       JsonPath json = response.jsonPath();

//       return json.getString("token");

//   }


//   public static Response getRequest(String token, String endpoint) {

//       Response response = given().headers(
//               "Authorization",
//               "Bearer " + token,
//               "Content-Type",
//               ContentType.JSON,
//               "Accept",
//               ContentType.JSON).when().get(endpoint);


//       return response;


//   }

//   public static Response deleteRequest(String token, String endpoint){
//       Response response = given().headers(
//               "Authorization",
//               "Bearer " + token,
//               "Content-Type",
//               ContentType.JSON,
//               "Accept",
//               ContentType.JSON).when().delete(endpoint);
//       return  response;
//   }

}
