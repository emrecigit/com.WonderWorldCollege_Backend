
package pojos;

import java.util.HashMap;
import java.util.Map;

public class pojoBooksUpdate {
    /*

     */
    private int id;
    private String type;
    private String title;

    public Map<String, Object> expectedDataMethod1(String id, String book_title, String book_no,
                                                  String isbn_no, String subject, String rock_no, String publish,
                                                  String author, String qty, String perunitcost, String postdate,
                                                  String description, String available, String is_active) {

        Map<String, Object> expectedDataMap = new HashMap<>();

        if (id != null) {
            expectedDataMap.put("id", id);
        }
        if (book_title != null) {
            expectedDataMap.put("book_title", book_title);
        }
        if (book_no != null) {
            expectedDataMap.put("book_no", book_no);
        }
        if (isbn_no != null) {
            expectedDataMap.put("isbn_no", isbn_no);
        }
        if (subject != null) {
            expectedDataMap.put("subject", subject);
        }
        if (rock_no != null) {
            expectedDataMap.put("rock_no", rock_no);
        }
        if (publish != null) {
            expectedDataMap.put("publish", publish);
        }
        if (author != null) {
            expectedDataMap.put("author", author);
        }
        if (qty != null) {
            expectedDataMap.put("qty", qty);
        }

        if (perunitcost != null) {
            expectedDataMap.put("perunitcost", perunitcost);
        }

        if (postdate != null) {
            expectedDataMap.put("postdate", postdate);
        }

        if (description != null) {
            expectedDataMap.put("description", description);
        }

        if (available != null) {
            expectedDataMap.put("available", available);
        }

        if (is_active != null) {
            expectedDataMap.put("is_active", is_active);
        }

        return expectedDataMap;
    }
}
