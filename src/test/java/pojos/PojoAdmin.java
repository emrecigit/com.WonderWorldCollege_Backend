package pojos;

import java.util.HashMap;
import java.util.Map;

public class PojoAdmin {
    /*

     */
    private int id;
    private String type;
    private String title;

    public Map<String, Object> expectedDataMethod(String id, String title, String event_for,
    String session_id, String section, String from_date, String to_date,
    String note, String event_notification_message, String show_onwebsite) {

        Map<String, Object> expectedDataMap = new HashMap<>();

        if (id != null) {
            expectedDataMap.put("id", id);
        }
        if (title != null) {
            expectedDataMap.put("title", title);
        }

        if (event_for != null) {
            expectedDataMap.put("event_for", event_for);
        }
        if (session_id != null) {
            expectedDataMap.put("session_id", session_id);
        }
        if (section != null) {
            expectedDataMap.put("section", section);
        }
        if (from_date != null) {
            expectedDataMap.put("from_date", from_date);
        }
        if (to_date != null) {
            expectedDataMap.put("to_date", to_date);
        }
        if (note != null) {
            expectedDataMap.put("note", note);
        }
        if (event_notification_message != null) {
            expectedDataMap.put("event_notification_message", event_notification_message);
        }
        if (show_onwebsite != null) {
            expectedDataMap.put("show_onwebsite", show_onwebsite);
        }
        return expectedDataMap;
    }
}
