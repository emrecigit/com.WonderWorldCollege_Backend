package utilities;

import hooks.HooksAPI;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;

public class API_Utils {

    private static String token;
    private static String fullPath;
    private static RequestSpecification spec;


    // public static String createfullPath(String rawPaths)                                                  23
    // public static String generateTokenAll(String userType, String rawPaths)                               44
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
            String value = paths[i].trim();
            System.out.println("value = " + value);
            HooksAPI.spec.pathParam(key, value);
            tempPath.append(key + "}/{");
        }
        // System.out.println("tempPath = " + tempPath);
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        System.out.println("tempPath = " + tempPath);
        fullPath = tempPath.toString();
        System.out.println("fullPath = " + fullPath);
        return fullPath;
    }

    public static String generateTokenAll(String userType, String rawPaths) { //  "/ olmadan başla"
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        fullPath = createfullPath(rawPaths);

        Map<String, Object> dataCredential = new HashMap<>();

        if ("admin".equals(userType)) {
            dataCredential.put("email", ConfigReader.getProperty("emailAdmin"));
        } else if ("teacher".equals(userType)) {
            dataCredential.put("email", ConfigReader.getProperty("emailTeacher"));
        } else if ("student".equals(userType)) {
            //fullPath = createfullPath(rawPaths);
            dataCredential.put("email", ConfigReader.getProperty("emailStudent"));
        }
        dataCredential.put("password", ConfigReader.getProperty("password"));
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(dataCredential)
                .post(fullPath);
        JsonPath respJP = response.jsonPath();
        token = respJP.getString("token");
        return token;
    }

    public static Response sendEveryRequest(String RequestMethodName, String userType, String endPoint) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        String fullPath = createfullPath(endPoint);
        token = generateTokenAll(userType, endPoint);
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

    public static Response sendAllRequest(String RequestMethodName, String userType, String endPoint) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        String fullPath = createfullPath(endPoint);
        token = generateTokenAll(userType, endPoint);
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




    public static Response getRequest(String token, String endpoint) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(endpoint);
        return response;
    }

    public static Response deleteRequest(String token, String endpoint){
        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete(endpoint);
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



