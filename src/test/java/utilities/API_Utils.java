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


    // public static String createfullPath(String rawPaths)                                                  37
    // public static String generateTokenAll(String userType)                                                76
    // public static Response sendEveryRequest(String RequestMethodName, String userType, String endPoint)   73
    // public static Response sendAllRequest(String RequestMethodName, String userType, String endPoint)     135
    // public static Response getRequest(String token, String endpoint)                                      235
    // public static Response deleteRequest(String token, String endpoint)                                   249
    // public static String generateTokenAdmin()                                                             262
    // public static String generateTokenTeacher()                                                           281
    // public static String generateTokenStudent()                                                           298

    public static String createfullPath(String rawPaths) {
        String[] paths = rawPaths.split("/");
        StringBuilder tempPath = new StringBuilder("/{");
        for (int i = 0; i < paths.length; i++) {
            String key = "pp" + i; // pp0 pp1 pp2
            System.out.println("value = " + key);
            String value = paths[i].trim();
            System.out.println("value = " + value);
            HooksAPI.spec.pathParam(key, value);
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
        System.out.println("tempPath = " + tempPath);
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        System.out.println("tempPath = " + tempPath);
        fullPath = tempPath.toString();
        System.out.println("Create fullPath = " + fullPath);
        System.out.println(API_Utils.getPathParams(rawPaths));
        return fullPath;
    }
    public static Map<String,String> getPathParams(String rawPaths) {
        String[] paths = rawPaths.split("/");
        Map<String,String> pathParams = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String key ="\""+ "pp" + i+"\""; // pp0 pp1 pp2
            String value ="\""+ paths[i].trim()+"\"";

            pathParams.put(key, value);
            }
        return pathParams;
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

    public static Response sendEveryRequest(String RequestMethodName, String rawPaths, String userType, String tokenPoints) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        fullPath = createfullPath(rawPaths);
        tokenAll = generateTokenAll(userType);
        RequestSpecification requestSpecification = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON);

        Map<String, Object> requestBody = new HashMap<>();

        switch (RequestMethodName.toUpperCase()) {
            case "POST":
                switch (userType) {
                    case "admin":
                        requestBody.put("email", ConfigReader.getProperty("emailAdmin"));
                        break;
                    case "teacher":
                        requestBody.put("email", ConfigReader.getProperty("emailTeacher"));
                        break;
                    case "student":
                        requestBody.put("email", ConfigReader.getProperty("emailStudent"));
                        break;
                }
                requestBody.put("password", ConfigReader.getProperty("password"));

                requestSpecification.body(requestBody);
                return requestSpecification.when().post(fullPath);

            case "GET":
                return requestSpecification.when().get(fullPath);

            case "DELETE":
                return requestSpecification.when().delete(fullPath);

            case "PATCH":
                switch (userType) {
                    case "admin":
                        requestBody.put("email", ConfigReader.getProperty("emailAdmin"));
                        break;
                    case "teacher":
                        requestBody.put("email", ConfigReader.getProperty("emailTeacher"));
                        break;
                    case "student":
                        requestBody.put("email", ConfigReader.getProperty("emailStudent"));
                        break;
                }
                requestBody.put("password", ConfigReader.getProperty("password"));

                requestSpecification.body(requestBody);
                return requestSpecification.when().patch(fullPath);

            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + RequestMethodName);
        }
    }
    //Response response = sendEveryRequest("POST","admin", "api/getToken");

    public static Response sendAllRequest(String RequestMethodName, String rawPaths, String userType, String tokenPoints ) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        fullPath = createfullPath(rawPaths);
        tokenAll = generateTokenAll(userType);
        Response response;
        Map<String, Object> requestBody = new HashMap<>();

        switch (RequestMethodName.toUpperCase()) {
            case "POST":
                switch (userType) {
                    case "admin":
                        requestBody.put("email", ConfigReader.getProperty("emailAdmin"));
                        break;
                    case "teacher":
                        requestBody.put("email", ConfigReader.getProperty("emailTeacher"));
                        break;
                    case "student":
                        requestBody.put("email", ConfigReader.getProperty("emailStudent"));
                        break;
                }
                requestBody.put("password", ConfigReader.getProperty("password"));

                response = given()
                        .headers(
                                "Authorization",
                                "Bearer " + token,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post(fullPath);
                break;

            case "GET":
                response = given()
                        .headers(
                                "Authorization",
                                "Bearer " + token,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .when()
                        .get(fullPath);
                break;

            case "DELETE":
                response = given()
                        .headers(
                                "Authorization",
                                "Bearer " + token,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .when()
                        .delete(fullPath);
                break;

            case "PATCH":
                switch (userType) {
                    case "admin":
                        requestBody.put("email", ConfigReader.getProperty("emailAdmin"));
                        break;
                    case "teacher":
                        requestBody.put("email", ConfigReader.getProperty("emailTeacher"));
                        break;
                    case "student":
                        requestBody.put("email", ConfigReader.getProperty("emailStudent"));
                        break;
                }
                requestBody.put("password", ConfigReader.getProperty("password"));

                response = given()
                        .headers(
                                "Authorization",
                                "Bearer " + token,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .patch(fullPath);
                break;

            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + RequestMethodName);
        }

        return response;
    }
// Response response = sendAllRequest("POST","admin","api/getToken" );




    public static Response getRequest(String rawPaths, String userType, String tokenPoints) {
        tokenAll = API_Utils.generateTokenAll(userType);
        fullPath = API_Utils.createfullPath(rawPaths);
        Response response = given().headers(
                "Authorization",
                "Bearer " + tokenAll,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(fullPath);
        return response;
    }

    public static Response deleteRequest(String rawPaths, String userType, String tokenPoints){
        tokenAll = API_Utils.generateTokenAll(userType);
        fullPath = API_Utils.createfullPath(rawPaths);
        Response response = given().headers(
                "Authorization",
                "Bearer " + tokenAll,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete(fullPath);
        return  response;
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
//               body(expectedData).when().post();
//       JsonPath json = response.jsonPath();
//       return json.getString("token");
//   }



