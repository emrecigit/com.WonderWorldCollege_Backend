package stepDefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import utilities.API_Utils;
import utilities.ConfigReader;
import java.util.Arrays;
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
import java.util.List;
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
        System.out.println("tempPath = " + tempPath); // tempPath = /{pp0}/{pp1}/{
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
        response = given()
                .spec(HooksAPI.spec)
                .headers("Authorization", "Bearer " + "wrongToken")
                .contentType(ContentType.JSON)
                .when()
                .get(fullPath);
        response.prettyPrint();


    }

    @Then("Verifies that status code is {int}")
    public void verifiesThatStatusCodeIs(int statusCode) {

        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("Verifies that the message information is {string}")
    public void verifiesThatTheMessageInformationIs(String message) {
        JsonPath resJP = response.jsonPath();
        assertEquals(message, resJP.getString("message"));
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





















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































}
