package testData;

import org.json.JSONObject;
import org.junit.Test;

public class TestDataAdmin {

    public JSONObject requestDeleteBody(){
        JSONObject requestDeleteBody = new JSONObject();
        requestDeleteBody.put("id",293);
        return requestDeleteBody;

    }
    public JSONObject alumniEventsRequestDeleteBody(){
        JSONObject requestDeleteBody = new JSONObject();
        requestDeleteBody.put("id",1196);
        return requestDeleteBody;

    }

    public JSONObject vehicleDeleteReqDeleteResponseBody(){
        JSONObject requestDeleteBody = new JSONObject();
        requestDeleteBody.put("id",3); // en son olusturdugum liste id
        return requestDeleteBody;

    }

}
