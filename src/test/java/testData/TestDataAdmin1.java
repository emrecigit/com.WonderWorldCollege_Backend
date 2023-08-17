package testData;

import org.json.JSONObject;

public class TestDataAdmin1 {
    public JSONObject requestDeleteBody(){
        JSONObject requestDeleteBody = new JSONObject();
        requestDeleteBody.put("id",2);
        return requestDeleteBody;

    }

}
