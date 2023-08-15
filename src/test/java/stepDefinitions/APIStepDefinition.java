package stepDefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.pojoBooksUpdate;
import testData.TestDataAdmin;
import utilities.API_Utils;

import static io.restassured.RestAssured.given;
//import hooks.API_Hooks;


import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import pojos.PojoAdmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APIStepDefinition {
    String hataMesaji;

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
    public static String tokenAll;
    JSONObject reqBodyJson;         // ReqBody Direk yazdirilabilir Put (Update)  Post (Create) Patch (İlave) body gondermek (gonderirken toString ile gonderilir)
    Response response;              // Response Database den body olarak donen cevap
    JsonPath jsonPath;              // Response dan bilgi almak ,kaydetmek ve yazdırmak icin kullanilir.
    String exceptionMessage = "";  // Sorguda ReqBody gonderiyorsak gonderdigimiz Datanın formatını belirtiriz.(PreCondition)
    // Givenden hemen sonra ContentType(ContentType.JSON) eklenir.Body When den sonra eklenir.


    String responseString;



    //   Set "api/visitorsPurposeList" parameters. [TC_01_API_US001]_Step1
    @Given("Set {string} parameters")
    public void set_parameters(String rawPaths) {

        fullPath = API_Utils.createfullPath(rawPaths);
        //   String[] paths = rawPaths.split("/");
        //   StringBuilder tempPath = new StringBuilder("/{");
        //   for (int i = 0; i < paths.length; i++) {
        //       String key = "pp" + i; // pp0 pp1 pp2
        //       //System.out.println("key = " + key); // key = pp0 / key = pp1
        //       String value = paths[i].trim();
        //       //System.out.println("value = " + value); // value = api / value = visitorsPurposeList
        //       HooksAPI.spec.pathParam(key, value);
        //       tempPath.append(key + "}/{");
        //   }
        //   //System.out.println("tempPath = " + tempPath); // tempPath = /{pp0}/{pp1}/{
        //   tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        //   tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        //   //System.out.println("tempPath = " + tempPath); // tempPath = /{pp0}/{pp1}
        //   fullPath = tempPath.toString();
        //   System.out.println("Definition fullPath = " + fullPath); // fullPath = /{pp0}/{pp1}


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


// Admin Authorization (Take Token)
    // @When("Records response for Admin with valid authorization information")
    // public void recordsResponseForAdminWithValidAuthorizationInformation() {
    //     // Admin icin, gecerli authorization bilgileri ile  response kaydeder
    //     response = given()
    //             .spec(HooksAPI.spec)
    //             .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
    //             .contentType(ContentType.JSON)
    //             .when()
    //             .get(fullPath);
    // }

    // Success record the response body (Status Code 200) [TC_01_API_US001]_Step2
    @Given("Record the response of the endpoint {string} with the current authorization {string}")
    public void record_the_response_of_the_endpoint_with_the_current_authorization(String rawPaths, String UserType) {
        tokenAll = API_Utils.generateTokenAll(UserType);
        fullPath = API_Utils.createfullPath(rawPaths);
        System.out.println("TokenAll " + tokenAll);
        response = given()
                .spec(HooksAPI.spec)
                .headers("Authorization", "Bearer " + tokenAll)
                .contentType(ContentType.JSON)
                .when()
                .get(fullPath);
        // response.prettyPrint();
    }



// Admin Authorization (Take Token)
    // @When("Records response for Admin with valid authorization information")
    // public void recordsResponseForAdminWithValidAuthorizationInformation() {
    //     // Admin icin, gecerli authorization bilgileri ile  response kaydeder
    //     response = given()
    //             .spec(HooksAPI.spec)
    //             .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
    //             .contentType(ContentType.JSON)
    //             .when()
    //             .get(fullPath);
    // }



    // Satus Code Assertion (Status Code 200) [TC_01_API_US001]_Step3
    @Then("Verifies that status code is {int}")
    public void verifiesThatStatusCodeIs(int statusCode) {
        System.out.println("Status Code :" + response.getStatusCode());
        assertEquals(statusCode, response.getStatusCode());

        response                            // Assert olarak bu da kullanılabilir.
                .then()
                .assertThat()
                .statusCode(statusCode);

    }


    // Message Verification (Success Message) [TC_01_API_US001]_Step4
    @Then("Verifies that the message information is {string}")
    public void verifiesThatTheMessageInformationIs(String message) {
        JsonPath resJP = response.jsonPath();

        System.out.println("Message = " + resJP.getString("message"));
        Assert.assertEquals(message, resJP.getString("message"));
        // response                            // Assert olarak bu da kullanılabilir.
        //         .then()
        //         .assertThat()
        //         .statusCode(200)
        //         .body("message", Matchers.equalTo("Success"));
    }


    // Invalid Authorization Test [TC_02_API_US_001]_Step2
    @Given("Verifies that the Status Code of the failed connection from the endpoint {string} with invalid authorization {string} is {string} and the message is {string}")
    public void verifies_that_the_status_code_of_the_failed_connection_from_the_endpoint_with_invalid_authorization_is_and_the_message_is(String rawPaths, String wrongToken, String statusCode, String message) {
        fullPath = API_Utils.createfullPath(rawPaths);
        try {
            response = given()
                    .spec(HooksAPI.spec)
                    .headers("Authorization", "Bearer " + wrongToken)
                    .contentType(ContentType.JSON)
                    .when()
                    .get(fullPath);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
        System.out.println("Income Message :" + exceptionMessage);
        assertTrue(exceptionMessage.contains(statusCode));
        assertTrue(exceptionMessage.contains(message));
    }

    // List element verification test [TC_03_API_US_001]_Step3
    @Given("From the data in the list returned from the response body {string}, data content {string} and {string}, validation test that")
    public void from_the_data_in_the_list_returned_from_the_response_body_data_content_and_validation_test_that(String string, String string2, String string3) {

        reqBodyJson = new JSONObject();  //put post patch body içeriği için reqBodyJson.put("email","emre.cigit@admin.wonderworldcollege.com"); gibi
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBodyJson.toString())
                .post(fullPath);
        //   JSONObject reqBodyJson;                   // Put Post Patch işlemlerinde body gondermek icin olusturulur.
        //   response.prettyPrint();                   // Burdan bir mesaj almak için response JsonPath objesine cevrilir
        //   jsonPath =response.jsonPath();            // Direk yazdirilabilir.
        //   tokenAll  = jsonPath.getString("token");  // JsonPath ile Response dan token alınır Bu islemle String haline geldi
    }


    // Teacher Authorization (Take Token)

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

    // Student Authorization (Take Token)
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

    // Gecerli Token Listesi
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


    //      response = given()
    //              .contentType(ContentType.JSON)
    //              .when()
    //              .body(reqBody.toString())
    //              .post(fullPath);


    //       response
    //               .then()//assert then olmadan  gelmez
    //               .assertThat()
    //               .statusCode(201)
    //               .contentType(ContentType.JSON);
//
//
    //   }






















































































































































































































































































    @Given("Patch body containing correct data is prepared.")
    public void patch_body_containing_correct_data_is_prepared() {
        String fullPath=API_Utils.createfullPath("api/alumniEventsUpdate");
        PojoAdmin obj=new PojoAdmin();
        Map<String, Object> adminUpdateReqBody=obj.expectedDataMethod("12","Art Activite","art","13","null","2023-11-14 00:00:00"
                ,"2023-11-24 23:59:00","Paint","Art","0");

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
        Response response= null;
        try {
            response = given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                    .headers("Authorization", "Bearer " + HooksAPI.tokenStudent)
                    .when()
                    .body(adminUpdateReqBody)
                    .patch(fullPath);
        } catch (Exception e) {
            hataMesaji=e.getMessage();

        }
        System.out.println(hataMesaji);
        assertTrue(hataMesaji.contains("403"));
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

        String fullPath=API_Utils.createfullPath("api/alumniEventsId");
        JSONObject reqBody=new JSONObject();
        reqBody.put("id",12);

        Response response=given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post("https://qa.wonderworldcollege.com/api/alumniEventsId");
        response.prettyPrint();

        response
                .then()//assert then olmadan  gelmez
                .assertThat()
                .statusCode(200)
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


    }


    @When("Verifies that record includes {string}")
    public void verifiesThatRecordIncludes(String expectedData) {


        JsonPath resJP = response.jsonPath();

        String actualData = resJP.get("lists").toString();
        System.out.println(actualData);

        String[] expectedArr = expectedData.split(",");


    }
































































































































































































































































































































    @Given("Prepare request body for admin api_booksId endpoint and record response")
    public void prepare_request_body_for_admin_api_books_ıd_endpoint_and_record_response() {
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

    }

    @Given("Booksupdate patch body containing correct data is prepared.")
    public void booksupdate_patch_body_containing_correct_data_is_prepared() {
        String fullPath=API_Utils.createfullPath("api/booksUpdate");
        pojoBooksUpdate obj=new pojoBooksUpdate();
        Map<String, Object> adminUpdateReqBody=obj.expectedDataMethod1("122","Vadideki Zambak1","7887893","","null","110"
                ,"Dünya Klasikleri","Balzac","101","13.00", "2022-05-04","Ortaokulda okuduğum en iyi kitap.","yes","no");

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

    @Given("Verification is done by sending POST body to booksId endpoint with the updateId returned in the response body.")
    public void verification_is_done_by_sending_post_body_to_books_ıd_endpoint_with_the_update_ıd_returned_in_the_response_body() {
        String fullPath=API_Utils.createfullPath("api/booksId");
        JSONObject reqBody=new JSONObject();
        reqBody.put("id",122);

        Response response=given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post("https://qa.wonderworldcollege.com/api/booksId");
        response.prettyPrint();

        response
                .then()//assert then olmadan  gelmez
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }

    @Given("It should be verified that the  books updateId information and the id information in the request body are the same.")
    public void ıt_should_be_verified_that_the_books_update_ıd_information_and_the_id_information_in_the_request_body_are_the_same() {
        pojoBooksUpdate obj=new pojoBooksUpdate();
        Map<String, Object> adminUpdateReqBody=obj.expectedDataMethod1("122","Art Activite","art","13","null","2023-11-14 00:00:00"
                ,"2023-11-24 23:59:00","Paint","Art","0", "2022-05-04","Ortaokulda okuduğum en iyi kitap.","yes","no");
        Response response=given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(adminUpdateReqBody)
                .patch(fullPath);
        JsonPath respJP=response.jsonPath();
        assertEquals(adminUpdateReqBody.get("id"),respJP.get("updateId"));
    }


































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    @Given("It is verified that the DeletedId in the response body is the same as the id in the request body.")
    public void ıt_is_verified_that_the_deleted_ıd_in_the_response_body_is_the_same_as_the_id_in_the_request_body() {
     JsonPath responseJP = response.jsonPath();
     TestDataAdmin testDataAdmin = new TestDataAdmin();
     JSONObject reqDeleteResponseBody = testDataAdmin.requestDeleteBody();
     Assert.assertEquals(reqDeleteResponseBody.get("id"),responseJP.get("deleteId"));

    }



    @Given("Delete body containing correct data is prepared.")
    public void delete_body_containing_correct_data_is_prepared() {
        TestDataAdmin testDataAdmin = new TestDataAdmin();
        JSONObject reqDeleteResponseBody = testDataAdmin.requestDeleteBody();
        response= given()
                .spec(HooksAPI.spec)
                .headers("Authorization","Bearer"+HooksAPI.tokenAdmin)
                .contentType(ContentType.JSON)
                .when()
                .body(reqDeleteResponseBody.toString())
                .delete("https://qa.wonderworldcollege.com/api/deleteNotice");

        System.out.println("Request Delete Response Body : " + reqDeleteResponseBody);
        response.prettyPrint();

    }


    @Given("The deletion of the desired notice record through the API should be validated.")
    public void the_deletion_of_the_desired_notice_record_through_the_apı_should_be_validated() {

        TestDataAdmin testDataAdmin = new TestDataAdmin();
        JSONObject deleteByIdBody = testDataAdmin.requestDeleteBody();
        deleteByIdBody.put("id",292);
        response= given()
                .spec(HooksAPI.spec)
                .headers("Authorization","Bearer"+HooksAPI.tokenAdmin)
                .contentType(ContentType.JSON)
                .when()
                .body(deleteByIdBody.toString())
                .post("https://qa.wonderworldcollege.com/api/getNoticeById");

        System.out.println("Delete By Id Body : " + deleteByIdBody);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),403);

    }


    @Given("Response for Admin with invalid authorization information")
   public void response_for_admin_with_invalid_authorization_information() {
        RequestSpecification spec= new RequestSpecBuilder().setBaseUri("https://wonderworldcollege.com/").build();

        String token= "12345678901234567";
        spec.pathParams("pp1","api","pp2","getNotice");
        String fullpath="/{pp1}/{pp2}";
//Hata olarak 403 kodu verdigi icin excep. firlatiyor.Excep. kaydedip onu  test edecegiz

        String exceptionMsj="";

        Response response= null;
        try {
            response = given()
                    .contentType(ContentType.JSON)
                    .spec(spec).headers("Authorization","Bearer " + token,
                            "Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
                    .when().get(fullpath);
        } catch (Exception e) {
            exceptionMsj=e.getMessage();
        }

        System.out.println(exceptionMsj);
        // Assert.assertTrue(exceptionMsj.contains("status code: 403"));

    }

 }









































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        //for (String each : expectedArr) {
        //    Assert.assertTrue(actualData.contains(each));



















































