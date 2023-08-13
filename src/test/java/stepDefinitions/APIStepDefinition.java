package stepDefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.PojoAdmin;
import utilities.API_Utils;
import utilities.ConfigReader;

import java.util.*;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;
//import hooks.API_Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class APIStepDefinition {

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
    public static String fullPath;
    JSONObject reqBodyJson;
    Response response;
    int successStatusCode = 200;

    @Given("Set {string} parameters")
    public void set_parameters(String rawPaths) {

        String[] paths = rawPaths.split("/");
        StringBuilder tempPath = new StringBuilder("/{");
        for (int i = 0; i < paths.length; i++) {
            String key = "pp" + i; // pp0 pp1 pp2
            System.out.println("key = " + key); // key = pp0 / key = pp1
            String value = paths[i].trim();
            System.out.println("value = " + value); // value = api / value = visitorsPurposeList
            HooksAPI.spec.pathParam(key, value);
            tempPath.append(key + "}/{");
        }
        // System.out.println("tempPath = " + tempPath); // tempPath = /{pp0}/{pp1}/{
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        System.out.println("tempPath = " + tempPath); // tempPath = /{pp0}/{pp1}
        fullPath = tempPath.toString();
        System.out.println("fullPath = " + fullPath); // fullPath = /{pp0}/{pp1}
    }

    @When("Records response for Admin with valid authorization information")
    public void recordsResponseForAdminWithValidAuthorizationInformation() {
        // Admin icin, gecerli authorization bilgileri ile  response kaydeder
        response = given()
                .spec(HooksAPI.spec)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .contentType(ContentType.JSON)
                .when()
                .get(fullPath);
    }


    @When("Records response for Admin with invalid authorization information")
    public void recordsResponseForAdminWithInvalidAuthorizationInformation() {
        // Admin icin, gecersiz authorization bilgileri ile  response kaydeder
        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .headers("Authorization", "Bearer " + "wrongToken")
                    .contentType(ContentType.JSON)
                    .when()
                    .get(fullPath);
            response.prettyPrint();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Then("Verifies that status code is {int}")
    public void verifiesThatStatusCodeIs(int statusCode) {

        assertEquals(statusCode, response.getStatusCode());

    }

    @Then("Verifies that the message information is {string}")
    public void verifiesThatTheMessageInformationIs(String message) {

        JsonPath resJP = response.jsonPath();
        Assert.assertEquals(message, resJP.getString("message"));


    }


    @When("Records response for Teacher with valid authorization information")
    public void recordsResponseForTeacherWithValidAuthorizationInformation() {
        // Teacher icin, gecerli authorization bilgileri ile  response kaydeder
        response = given()
                .spec(HooksAPI.spec)
                .headers("Authorization", "Bearer " + HooksAPI.tokenTeacher)
                .contentType(ContentType.JSON)
                .when()
                .get(fullPath);
    }

    @When("Records response for Student with valid authorization information")
    public void recordsResponseForStudentWithValidAuthorizationInformation() {
        //  Student icin, gecerli authorization bilgileri ile  response kaydeder
        response = given()
                .spec(HooksAPI.spec)
                .headers("Authorization", "Bearer " + HooksAPI.tokenStudent)
                .contentType(ContentType.JSON)
                .when()
                .get(fullPath);

    }

    @When("The data of the record with {string} is validated")
    public void theDataOfTheRecordWithIsValidated(String class_id) {

        JsonPath resJP = response.jsonPath();
        // System.out.println(resJP.getList("lists"));
        List<Object> list = resJP.getList("lists");
        Object[] arrList = new Object[list.size()];
        arrList = list.toArray(arrList);
        // System.out.println(Arrays.toString(arrList));
        int index = 0;
        for (int a = 0; a < arrList.length; a++) {
            if (arrList[a].toString().contains(class_id)) {
                System.out.println("index no : " + a);
                index = a;
                break;
            }
        }
        System.out.println(arrList[index].toString());
        /*
        {class_id=4, student_session_id=290, id=7, class=Class 4,
         section_id=3, section=C, admission_no=18004, roll_no=109,
         admission_date=2021-03-22, firstname=Laura, middlename=null,
         lastname=Clinton, image=uploads/student_images/7.jpg, mobileno=65656546,
          email=laura@gmail.com, state=null, city=null, pincode=null, religion=, dob=2015-07-01,
          current_address=Lord Street, Suite 9 East Brooklyn, NY 11210-0000Lord Street,
          Suite 9 East Brooklyn, NY 11210-0000, permanent_address=Lord Street, Suite 9 East Brooklyn,
           NY 11210-0000Lord Street, Suite 9 East Brooklyn, NY 11210-0000, category_id=1, category=,
           adhar_no=654564654564, samagra_id=688, bank_account_no=654564, bank_name=UBS Bank, ifsc_code=6545645,
            guardian_name=Michael Clinton, guardian_relation=Father, guardian_email=, guardian_phone=544545454,
            guardian_address=, is_active=yes, created_at=2021-03-22 08:45:05, updated_at=null, father_name=Michael Clinton,
            rte=No, gender=Female, user_tbl_id=13, username=std7, user_tbl_password=password, user_tbl_active=yes}

         */
    }











































































































































































































































































































































    @Given("Patch body containing correct data is prepared.")
    public void patch_body_containing_correct_data_is_prepared() {
        PojoAdmin obj=new PojoAdmin();
        Map<String, Object> adminUpdateReqBody=obj.expectedDataMethod("12","Art Activite","art","13","null","2023-11-14 00:00:00"
                ,"2023-11-24 23:59:00","Paint","Art","0");

        HashMap<String ,Object> expdata=new HashMap<>();
        expdata.put("status",200);
        expdata.put("message","Success");
        expdata.put("updateId","12");

        //response save

        Response response=given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(adminUpdateReqBody)
                .patch(fullPath);

        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
    }

    @Given("Verifies that status code is {int}.")
    public void verifies_that_status_code_is(int statusCode) {
        PojoAdmin obj=new PojoAdmin();
        Map<String, Object> adminUpdateReqBody=obj.expectedDataMethod("12","Art Activite","art","13","null","2023-11-14 00:00:00"
                ,"2023-11-24 23:59:00","Paint","Art","0");
        Response response=given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(adminUpdateReqBody)
                .patch(fullPath);
        assertEquals(statusCode, response.getStatusCode());
    }
    @Given("It should be verified that the updateId information and the id information in the request body are the same.")
    public void ıt_should_be_verified_that_the_update_ıd_information_and_the_id_information_in_the_request_body_are_the_same() {
        PojoAdmin obj=new PojoAdmin();
        Map<String, Object> adminUpdateReqBody=obj.expectedDataMethod("12","Art Activite","art","13","null","2023-11-14 00:00:00"
                ,"2023-11-24 23:59:00","Paint","Art","0");
        Response response=given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(adminUpdateReqBody)
                .patch(fullPath);
        JsonPath respJP=response.jsonPath();
        assertEquals(adminUpdateReqBody.get("id"),respJP.get("updateId"));
    }
    @Given("Verification is done by sending POST body to alumniEventsId endpoint with the updateId returned in the response body.")
    public void verification_is_done_by_sending_post_body_to_api_alumni_events_ıd_endpoint_with_the_update_ıd_returned_in_the_response_body() {
        JSONObject reqBody=new JSONObject();
        reqBody.put("id",12);

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response
                .then()//assert then olmadan  gelmez
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON);

    }









































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    @When("Prepare request body for admin api_alumniId endpoint and record response")
    public void prepareRequestBodyForAdminApi_alumniIdEndpointAndRecordResponse() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", "3");

        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();


        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post(fullPath);


        response.prettyPrint();
    }


    @When("Verifies that record includes {string}")
    public void verifiesThatRecordIncludes(String expectedData) {


        JsonPath resJP = response.jsonPath();

        String actualData = resJP.get("lists").toString();
        System.out.println(actualData);

        String[] expectedArr = expectedData.split(",");

        for (String each : expectedArr) {
            Assert.assertTrue(actualData.contains(each));
        }
    }














































}
