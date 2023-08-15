package stepDefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import org.testng.asserts.SoftAssert;

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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APIStepDefinition {
    String hataMesaji;
    JsonPath jsonPath;

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

    JSONObject jsonObject;

    public static RequestSpecification spec;
    int actData;


    JSONObject reqBodyJson;         // ReqBody Direk yazdirilabilir Put (Update)  Post (Create) Patch (İlave) body gondermek (gonderirken toString ile gonderilir)
    Response response;              // Response Database den body olarak donen cevap direk kullanilmaz JsonPath ile kullanilir.response.prettyPrint veya prettyPeek ile yazdirilabilir.
    JsonPath responseJsonPath;// Kendi Methodlari var Response dan bilgi almak ,kaydetmek ve yazdırmak icin kullanilir.Bu sekilde AssertTrue,Assert Equal testleri yapilabilir.
    String exceptionMessage = "";  // Sorguda ReqBody gonderiyorsak gonderdigimiz Datanın formatını belirtiriz.(PreCondition)
    String responseString;

    // Givenden hemen sonra ContentType(ContentType.JSON) eklenir.Body When den sonra eklenir.
    // Post,Put,Patch methodlari ile body göndereceksek obje olusturup uzerinden reqBodyJson.put("key",value").put("key","value") seklinde data gonderilir
    // Body gönderecekse Given dan sonra precondition yani on hazırlık olarak ContentType(ContentType.JSON) girilmeli
    // Body olarak reqBodyJson objesi gönderirken de body icinde toString ile Stringe cevirmeliyiz
    // Assertion yaparken de response.then().assertThat seklinde assertion oncesi that kullanilir.
    // Assertion da body degilde temel bilgiler sorgulanacaksa asserThat sonrası direk statusCode,contentType,Header degerleri sorgulanabilir
    // JSON Object Cagirirken ; ( Value getirir.)
    // jsonObject(<==obje adı).get("key") ,
    // inner da jsonObject(<==obje adı).getJSONObject("adress").get("city")
    // ReqBody olustururken.Array de Ornegin list.put(0,listElemanObjeAdi)
    // Array de jsonObject(<==obje adı).getJSONArray("adress").getJSONObject(0).get("city") (Index ile put yapilir)
    // JSONPath.com (JSON Object icin yolu gosterir Inner da adress.city / array de phoneNumber[0].type seklinde [.type yazarak tum type valulerini verir basina $.da konulabiliyor)
    // ResponseBody Assert edilirken JsonPath Yolu ile cagrilip Assert edilebilir ;
    // Ornek;response...body("booking.firstname",Matchers.equalTo("Ali")
    // Ornek;response...body("booking.bookingdates.checkin",equalTo("2021-06-21") // Matchers silinebilir de.
    // *Normal Assertionda equalTo,Response List elemanSayısı hasSize,List elemanı Assert edilirken hasItem ,Listin aynı yür elemanlari hasItems ile assert edilir.
    // // response.then().asserThat().body("lists.id",Matchers.hasSize(24), "data.emloyename",hasItem("ashton cox")
    // Temel bilgiler Assert edilirken AssertThat yeterlidir(Response ile gelen genel bilgiler Status Code,Header etc...)
    // Body ıcın ise;
    // 1-Matchers.: Response body deki key ile valuleri test etme (Cok fazla methodu vardır):
    // AssertThat sonrası :response.then().assertThat().body("title",Matchers.equalTo("aaa"),"name",Matchers.equalTo("bbb"),....seklinde sorgulanabilir.
    // Matchers da equalTo(null) test edilebiliyor.
    // 2-Junit Assert methodlari: Key degerleri uzerinden kıyaslar,expected ve actual (Response JsonPath e cevrilir)
    // Assert yaparken JsonObject icin : getJSONObject("booking").get("date"), JsonPath icin : responseJsonPath.get("booking-date") ile equals yapilir
    // 3-TestNG SoftAssert methodlari: Durum raporu icin enson softAssert.assertAll() ile tamamlanır.
    //   Set "api/visitorsPurposeList" parameters. [TC_01_API_US001]_Step1
    @Given("Set {string} parameters")
    public void set_parameters(String rawPaths) {
        fullPath = API_Utils.createfullPath(rawPaths);
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

        System.out.println("Income Message :"+exceptionMessage);

        System.out.println("Income Message :" + exceptionMessage);

        assertTrue(exceptionMessage.contains(statusCode));
        assertTrue(exceptionMessage.contains(message));
    }

    // List element verification test [TC_03_API_US_001]_Step3
    @Given("The data visitors purpose {string} and created at {string} in the list with id number {string} must be validated")
    public void the_data_visitors_purpose_and_created_at_in_the_list_with_id_number_must_be_validated(String visitors_purpose, String created_at, String id) {
        response.prettyPrint();
        responseJsonPath  = response.jsonPath();
        Assert.assertEquals(id, responseJsonPath.get("lists[0].id"));
        Assert.assertEquals(visitors_purpose, responseJsonPath.get("lists[0].visitors_purpose"));
        Assert.assertEquals(created_at, responseJsonPath.get("lists[0].created_at"));
        //   response.then().assertThat().body("lists[0].id", Matchers.hasItem(id),"lists[0].visitors_purpose",Matchers.hasItem(visitors_purpose),"lists[0].created_at",Matchers.hasItem(created_at));
        }

    //   JSONObject reqBodyJson;                   // Put Post Patch işlemlerinde body gondermek icin olusturulur.
    //   response.prettyPrint();                   // Burdan bir mesaj almak için response JsonPath objesine cevrilir
    //   responseJsonPath =response.responseJsonPath();            // Direk yazdirilabilir.
    //   tokenAll  = responseJsonPath.getString("token");  // JsonPath ile Response dan token alınır Bu islemle String haline geldi


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
        String fullPath = API_Utils.createfullPath("api/alumniEventsUpdate");
        PojoAdmin obj = new PojoAdmin();
        Map<String, Object> adminUpdateReqBody = obj.expectedDataMethod("12", "Art Activite", "art", "13", "null", "2023-11-14 00:00:00"
                , "2023-11-24 23:59:00", "Paint", "Art", "0");

        //response save

        Response response = given().spec(HooksAPI.spec).contentType(ContentType.JSON)
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
        PojoAdmin obj = new PojoAdmin();
        Map<String, Object> adminUpdateReqBody = obj.expectedDataMethod("12", "Art Activite", "art", "13", "null", "2023-11-14 00:00:00"
                , "2023-11-24 23:59:00", "Paint", "Art", "0");
        Response response = null;
        try {
            response = given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                    .headers("Authorization", "Bearer " + HooksAPI.tokenStudent)
                    .when()
                    .body(adminUpdateReqBody)
                    .patch(fullPath);
        } catch (Exception e) {
            hataMesaji = e.getMessage();

        }
        System.out.println(hataMesaji);
        assertTrue(hataMesaji.contains("403"));
    }

    @Given("It should be verified that the updateId information and the id information in the request body are the same.")
    public void ıt_should_be_verified_that_the_update_ıd_information_and_the_id_information_in_the_request_body_are_the_same() {
        PojoAdmin obj = new PojoAdmin();
        Map<String, Object> adminUpdateReqBody = obj.expectedDataMethod("12", "Art Activite", "art", "13", "null", "2023-11-14 00:00:00"
                , "2023-11-24 23:59:00", "Paint", "Art", "0");
        Response response = given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(adminUpdateReqBody)
                .patch(fullPath);
        JsonPath respJP = response.jsonPath();
        assertEquals(adminUpdateReqBody.get("id"), respJP.get("updateId"));
    }

    @Given("Verification is done by sending POST body to alumniEventsId endpoint with the updateId returned in the response body.")
    public void verification_is_done_by_sending_post_body_to_api_alumni_events_ıd_endpoint_with_the_update_ıd_returned_in_the_response_body() {

        String fullPath = API_Utils.createfullPath("api/alumniEventsId");
        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 12);

        Response response = given()
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
    @Given("A POST body is sent to the {string} endpoint with valid authorization information and correct data")
    public void a_post_body_is_sent_to_the_endpoint_with_valid_authorization_information_and_correct_data(String string) {
        JSONObject reqBody = new JSONObject();

        reqBody.put("title", "Sports Activite");
        reqBody.put("event_for", "all");
        reqBody.put("session_id", 11);
        reqBody.put("section", "null");
        reqBody.put("from_date", "2023-02-14 00:00:00");
        reqBody.put("to_date", "2023-02-15 23:59:00");
        reqBody.put("note", "Sports");
        reqBody.put("event_notification_message", "Sports");
        reqBody.put("show_onwebsite", "0");


        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        jsonPath = response.jsonPath();
        //    System.out.println("ReqBody "+reqBody);
        //  System.out.println("JsonPath " + jsonPath.toString());

        // Assert.assertEquals(reqBody.get("vehicle_model"),jsonPath.get("vehicle_model"));

    }
    @Given("The successful creation of the new event record via the API must be verified.")
    public void the_successful_creation_of_the_new_event_record_via_the_apı_must_be_verified() {
        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 1184);

        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();

    }


    @Given("Prepare request body for admin api_alumniEventsId endpoint and record response")
    public void prepare_request_body_for_admin_api_alumni_events_ıd_endpoint_and_record_response() {
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


    /*
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
            String fullPath = API_Utils.createfullPath("api/booksUpdate");
            pojoBooksUpdate obj = new pojoBooksUpdate();
            Map<String, Object> adminUpdateReqBody = obj.expectedDataMethod1("122", "Vadideki Zambak1", "7887893", "", "null", "110"
                    , "Dünya Klasikleri", "Balzac", "101", "13.00", "2022-05-04", "Ortaokulda okuduğum en iyi kitap.", "yes", "no");

            //response save

            Response response = given().spec(HooksAPI.spec).contentType(ContentType.JSON)
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
            String fullPath = API_Utils.createfullPath("api/booksId");
            JSONObject reqBody = new JSONObject();
            reqBody.put("id", 122);

            Response response = given()
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
            pojoBooksUpdate obj = new pojoBooksUpdate();
            Map<String, Object> adminUpdateReqBody = obj.expectedDataMethod1("122", "Art Activite", "art", "13", "null", "2023-11-14 00:00:00"
                    , "2023-11-24 23:59:00", "Paint", "Art", "0", "2022-05-04", "Ortaokulda okuduğum en iyi kitap.", "yes", "no");
            Response response = given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                    .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                    .when()
                    .body(adminUpdateReqBody)
                    .patch(fullPath);
            JsonPath respJP = response.jsonPath();
            assertEquals(adminUpdateReqBody.get("id"), respJP.get("updateId"));
        }


        @Given("Response for Admin with invalid authorization information")
        public void response_for_admin_with_invalid_authorization_information() {
            RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://wonderworldcollege.com/").build();

            String token = "12345678901234567";
            spec.pathParams("pp1", "api", "pp2", "getNotice");
            String fullpath = "/{pp1}/{pp2}";
    //Hata olarak 403 kodu verdigi icin excep. firlatiyor.Excep. kaydedip onu  test edecegiz

            String exceptionMsj = "";

            Response response = null;
            try {
                response = given()
                        .contentType(ContentType.JSON)
                        .spec(spec).headers("Authorization", "Bearer " + token,
                                "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                        .when().get(fullpath);
            } catch (Exception e) {
                exceptionMsj = e.getMessage();
            }

            System.out.println(exceptionMsj);
            // Assert.assertTrue(exceptionMsj.contains("status code: 403"));

        }


        // Delete Body
        // @Given("when sending a DELETE body containing the correct data \\(id)")
        // public void when_sending_a_delete_body_containing_the_correct_data_id() {


        // Admin Authorization (Take Token)

        //    Admin Authorization (Take Token)
     */
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


























































































































































































































/*
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
    @Given("Prepare request body for admin api_alumniEventsId endpoint and record response")
    public void prepare_request_body_for_admin_api_alumni_events_ıd_endpoint_and_record_response() {
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

 */
































































































































































































































































































































































//14
@Given("A Post body with valid authorization information and correct data {string} is sent to the {string} endpoint")
public void a_post_body_with_valid_authorization_information_and_correct_data_is_sent_to_the_endpoint(String string, String string2) {

    HooksAPI.spec.pathParams("pp1", "api", "pp2", "vehicleId");
    //Response response = given().when().get(url);
    String fullPath = "/{pp1}/{pp2}";

    JSONObject reqBody = new JSONObject();

    reqBody.put("id", 3);

        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

    response.prettyPrint();
}
    // 15
    @Given("A POST body is sent to the {string} endpoint with valid authorization information and correct data {string}")
    public void a_post_body_is_sent_to_the_endpoint_with_valid_authorization_information_and_correct_data(String string, String string2) {

        JSONObject reqBody = new JSONObject();

        reqBody.put("vehicle_no", "VH4584");
        reqBody.put("vehicle_model", "Ford CAB");
        reqBody.put("vehicle_photo", "1677502339-191558462463fca783b26b0!fd.png");
        reqBody.put("manufacture_year", "2015");
        reqBody.put("registration_number", "FFG-76575676787");
        reqBody.put("chasis_number", "523422");
        reqBody.put("max_seating_capacity", "50");
        reqBody.put("driver_name", "Jasper");
        reqBody.put("driver_licence", "258714545");
        reqBody.put("driver_contact", "8521479630");
        reqBody.put("note", "");

        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        jsonPath = response.jsonPath();
        //    System.out.println("ReqBody "+reqBody);
       //  System.out.println("JsonPath " + jsonPath.toString());

       // Assert.assertEquals(reqBody.get("vehicle_model"),jsonPath.get("vehicle_model"));

    }

        @Given("Verifies that Status Code is {int}.")
        public void verifies_that_status_code_is(Integer int1) {
            JSONObject reqBody = new JSONObject();

            reqBody.put("vehicle_no", "BHC4584");
            reqBody.put("vehicle_model", "Volvo xc90");
            reqBody.put("vehicle_photo", "1577502339-191558462463fca783b26b0!fd.png");
            reqBody.put("manufacture_year", "2023");
            reqBody.put("registration_number", "FFG-76575676787");
            reqBody.put("chasis_number", "523422");
            reqBody.put("max_seating_capacity", "50");
            reqBody.put("driver_name", "Jasper");
            reqBody.put("driver_licence", "258714545");
            reqBody.put("driver_contact", "8521479630");

            Response response= null;
            try {
                response = given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                        .headers("Authorization", "Bearer " + HooksAPI.tokenStudent)
                        .when()
                        .body(reqBody.toString())
                        .patch(fullPath);
            } catch (Exception e) {
                hataMesaji=e.getMessage();

            }

            System.out.println(hataMesaji);
            assertTrue(hataMesaji.contains("403"));

        }


    @Given("The successful creation of the new vehicle record via the API should be validated.")
    public void the_successful_creation_of_the_new_vehicle_record_via_the_apı_should_be_validated() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 288);

        response = given()
                .spec(HooksAPI.spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();

    }














































































































































































































































































































































































































































































































//"id": 3,
//        "student_id": "29",
//        "current_email": "deneme@deneme.com",
//        "current_phone": "9809967867",
//        "occupation": "",
//        "address": "",
//        "photo": ""
    @Given("Verifies that status code {int}")
    public void verifies_that_status_code(Integer int1) {
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
    @Given("Patch body containing correct data is prepared rumeysa.")
    public void patch_body_containing_correct_data_is_prepared_rumeysa() {
        String fullPath=API_Utils.createfullPath("api/alumniUpdate");
        PojoAdmin obj=new PojoAdmin();

        Map<String, Object> adminUpdateReqBody=obj.expectedRMMethod("3","29","deneme@deneme.com","9809967867","",""
                ,"");
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

    @Given("Verifies that status code is {int} rumeysa.")
    public void verifies_that_status_code_is_rumeysa(int statusCode) {
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
    @Given("It should be verified that the updateId information and the id information in the request body are the same rumeysa.")
    public void ıt_should_be_verified_that_the_update_ıd_information_and_the_id_information_in_the_request_body_are_the_same_rumeysa() {
        PojoAdmin obj=new PojoAdmin();
        Map<String, Object> adminUpdateReqBody=obj.expectedRMMethod("3","29","deneme@deneme.com","9809967867","",""
                ,"");

        Response response=given().spec(HooksAPI.spec).contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.tokenAdmin)
                .when()
                .body(adminUpdateReqBody)
                .patch(fullPath);
        JsonPath respJP=response.jsonPath();
        assertEquals(adminUpdateReqBody.get("id"),respJP.get("updateId"));
    }
    @Given("Verification is done by sending POST body to alumniEventsId endpoint with the updateId returned in the response body rumeysa.")
    public void verification_is_done_by_sending_post_body_to_api_alumni_events_ıd_endpoint_with_the_update_ıd_returned_in_the_response_body_rumeysa() {

        String fullPath=API_Utils.createfullPath("api/alumniId");
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
    @Given("Prepare request body for admin api_alumniEventsId endpoint and record response r.")
    public void prepare_request_body_for_admin_api_alumni_events_ıd_endpoint_and_record_response_r() {
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

        for (String each : expectedArr) {
            assertTrue(actualData.contains(each));
        }

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



    // Delete Body
    // @Given("when sending a DELETE body containing the correct data \\(id)")
    // public void when_sending_a_delete_body_containing_the_correct_data_id() {

}










































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































//for (String each : expectedArr) {
//    Assert.assertTrue(actualData.contains(each));





















































