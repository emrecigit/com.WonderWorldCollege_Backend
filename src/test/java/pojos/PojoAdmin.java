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
            expectedDataMap.put("Status", id);
        }
        if (title != null) {
            expectedDataMap.put("Message", title);
        }

        if (event_for != null) {
            expectedDataMap.put("Update id", event_for);
        }
        if (session_id != null) {
            expectedDataMap.put("Session id", session_id);
        }
        if (section != null) {
            expectedDataMap.put("Section", section);
        }
        if (from_date != null) {
            expectedDataMap.put("From date", from_date);
        }
        if (to_date != null) {
            expectedDataMap.put("To date", to_date);
        }
        if (note != null) {
            expectedDataMap.put("Note", note);
        }
        if (event_notification_message != null) {
            expectedDataMap.put("Event notification message", event_notification_message);
        }
        if (show_onwebsite != null) {
            expectedDataMap.put("Show onwebsite", show_onwebsite);
        }


        return expectedDataMap;
    }
}
