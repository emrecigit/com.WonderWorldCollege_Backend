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

//rumeysa
//id, student_id, current_email, current_phone, occupation, address, photo

    public Map<String, Object> expectedRMMethod(String id, String student_id, String current_email,
                                                String current_phone, String occupation, String address, String photo) {

        Map<String, Object> expectedDataMap = new HashMap<>();

        if (id != null) {
            expectedDataMap.put("id", id);
        }
        if (student_id != null) {
            expectedDataMap.put("student_id", student_id);
        }
        if (current_email != null) {
            expectedDataMap.put("current_email", current_email);
        }
        if (current_phone != null) {
            expectedDataMap.put("current_phone", current_phone);
        }
        if (occupation != null) {
            expectedDataMap.put("occupation", occupation);
        }
        if (address != null) {
            expectedDataMap.put("address", address);
        }
        if (photo != null) {
            expectedDataMap.put("photo", photo);
        }

        return expectedDataMap;
    }

    public Map<String, Object> expDataMethod(String id, String vehicle_no, String vehicle_model,
                                             String vehicle_photo, String manufacture_year, String registration_number,String chasis_number, String max_seating_capacity,
                                             String driver_name, String driver_licence, String driver_contact, String note) {

        Map<String, Object> expectedDataMap = new HashMap<>();

        if (id != null) {
            expectedDataMap.put("id", id);
        }
        if (vehicle_no != null) {
            expectedDataMap.put("vehicle_no", vehicle_no);
        }

        if (vehicle_model != null) {
            expectedDataMap.put("vehicle_model", vehicle_model);
        }
        if (vehicle_photo != null) {
            expectedDataMap.put("vehicle_photo", vehicle_photo);
        }
        if (manufacture_year != null) {
            expectedDataMap.put("manufacture_year", manufacture_year);
        }
        if (registration_number != null) {
            expectedDataMap.put("registration_number", registration_number);
        }
        if (chasis_number != null) {
            expectedDataMap.put("chasis_number", chasis_number);
        }
        if (max_seating_capacity != null) {
            expectedDataMap.put("max_seating_capacity", max_seating_capacity);
        }
        if (driver_name != null) {
            expectedDataMap.put("driver_name", driver_name);
        }
        if (driver_licence != null) {
            expectedDataMap.put("driver_licence", driver_licence);
        }
        if (driver_contact != null) {
            expectedDataMap.put("driver_contact", driver_contact);
        }
        if (note != null) {
            expectedDataMap.put("note", note);
        }
        return expectedDataMap;
    }
}
