package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //1-Properties objesi olusturacagiz
    private static Properties properties; //Diğer configreaderda static Properties properties;

    //2-Bu classin amaci configration.propertiesdosyasini okumak.
    // ve aradaki key ikililerini kullanarak istegimiz key e ait value bize getirmek
    static {

        String path = "configuration.properties";
        try {

            FileInputStream file = new FileInputStream(path);

            properties= new Properties();
            properties.load(file);

            file.close();  // Diğer configreaderda yoktu
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //3-test classlarindan configReader classina
    // ulasip yukaridaki islemleri yapmamizi saglayacak bir method
    // This method accepts the key and returns the value
    public static String getProperty(String key){
        //String value=properties.getProperty(key); Diğer Configreaderda
        return properties.getProperty(key); // return value;
    }


    /*
     "status": 200,
    "message": "Success",
    "Token_remaining_time": 13,
    "lists": [
        {
            "id": "1",
            "visitors_purpose": "Marketing ",
            "description": "",
            "created_at": "2023-01-18 01:07:12"
        },
        {
            "id": "2",
            "visitors_purpose": "Parent Teacher Meeting",
            "description": "",
            "created_at": "2023-01-18 01:07:12"
        },
        {
            "id": "3",
            "visitors_purpose": "Student Meeting",
            "description": "",
            "created_at": "2023-01-18 01:07:12"
        },
        {
            "id": "4",
            "visitors_purpose": "Staff Meeting",
            "description": "",
            "created_at": "2023-01-18 01:07:12"
        },
        {
            "id": "5",
            "visitors_purpose": "Principal Meeting",
            "description": "",
            "created_at": "2023-01-18 01:07:12"
        },
        {
            "id": "9",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-07-06 15:32:19"
        },
        {
            "id": "10",
            "visitors_purpose": "purpose update",
            "description": "came for student visit",
            "created_at": "2023-07-10 04:34:23"
        },
        {
            "id": "11",
            "visitors_purpose": "purpoxsne updanteR",
            "description": "came for gstudent visiter",
            "created_at": "2023-07-10 04:34:49"
        },
        {
            "id": "12",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-06 10:18:34"
        },
        {
            "id": "14",
            "visitors_purpose": "Disiplin",
            "description": "Disiplin Kurulu Toplandi",
            "created_at": "2023-08-06 10:55:45"
        },
        {
            "id": "15",
            "visitors_purpose": "ddddd",
            "description": "ddddd",
            "created_at": "2023-08-06 11:10:10"
        },
        {
            "id": "16",
            "visitors_purpose": "purpose update",
            "description": "came for student visit",
            "created_at": "2023-08-07 11:30:08"
        },
        {
            "id": "18",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti Icin Gelindi",
            "created_at": "2023-08-07 15:40:37"
        },
        {
            "id": "19",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-07 15:42:13"
        },
        {
            "id": "20",
            "visitors_purpose": "purpose update",
            "description": "came for student visit",
            "created_at": "2023-08-08 13:21:54"
        },
        {
            "id": "21",
            "visitors_purpose": "Toren Ziyareti",
            "description": "29 Ekim Kutlamasi",
            "created_at": "2023-08-08 15:00:54"
        },
        {
            "id": "22",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-09 12:42:16"
        },
        {
            "id": "23",
            "visitors_purpose": "Toren Ziyareti",
            "description": "29 Ekim Kutlamasi",
            "created_at": "2023-08-09 12:52:19"
        },
        {
            "id": "43",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 03:33:18"
        },
        {
            "id": "45",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 03:45:45"
        },
        {
            "id": "46",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 03:47:30"
        },
        {
            "id": "47",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 03:49:36"
        },
        {
            "id": "50",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 04:44:38"
        },
        {
            "id": "51",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 04:55:12"
        },
        {
            "id": "52",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 04:57:46"
        },
        {
            "id": "55",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 05:17:33"
        },
        {
            "id": "56",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 05:26:57"
        },
        {
            "id": "57",
            "visitors_purpose": "purpose update",
            "description": "Team112",
            "created_at": "2023-08-10 05:29:43"
        },
        {
            "id": "60",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-10 05:53:02"
        },
        {
            "id": "65",
            "visitors_purpose": "purpose update",
            "description": "came for student visit",
            "created_at": "2023-08-10 06:17:46"
        },
        {
            "id": "66",
            "visitors_purpose": "QA Tester Bilgilendirme Toplantısı (Team-3)",
            "description": "QA Tester Bilgilendirme Toplantısı İçin Gelindi",
            "created_at": "2023-08-10 06:19:45"
        },
        {
            "id": "67",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 06:57:24"
        },
        {
            "id": "68",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 06:57:49"
        },
        {
            "id": "76",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-10 08:10:10"
        },
        {
            "id": "78",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-10 08:24:37"
        },
        {
            "id": "81",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-10 08:37:07"
        },
        {
            "id": "82",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-10 08:38:59"
        },
        {
            "id": "83",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-10 08:41:54"
        },
        {
            "id": "85",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-10 08:42:29"
        },
        {
            "id": "86",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-10 08:42:32"
        },
        {
            "id": "89",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 11:38:33"
        },
        {
            "id": "90",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 11:54:07"
        },
        {
            "id": "91",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 12:15:39"
        },
        {
            "id": "92",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 13:19:34"
        },
        {
            "id": "93",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 13:20:25"
        },
        {
            "id": "94",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 13:46:21"
        },
        {
            "id": "99",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 17:51:07"
        },
        {
            "id": "102",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 20:17:39"
        },
        {
            "id": "103",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-10 20:28:45"
        },
        {
            "id": "104",
            "visitors_purpose": "Veli Ziyareti",
            "description": "ne",
            "created_at": "2023-08-10 20:51:20"
        },
        {
            "id": "108",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 07:01:03"
        },
        {
            "id": "109",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 07:30:06"
        },
        {
            "id": "110",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 07:45:58"
        },
        {
            "id": "111",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 09:18:58"
        },
        {
            "id": "112",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 10:11:19"
        },
        {
            "id": "113",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 10:21:44"
        },
        {
            "id": "114",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 11:08:56"
        },
        {
            "id": "115",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 11:58:58"
        },
        {
            "id": "118",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-11 12:03:27"
        },
        {
            "id": "119",
            "visitors_purpose": "Test",
            "description": "This Record Created For Testing",
            "created_at": "2023-08-11 12:03:30"
        },
        {
            "id": "120",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 14:45:43"
        },
        {
            "id": "121",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 14:48:53"
        },
        {
            "id": "122",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 14:49:34"
        },
        {
            "id": "123",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-11 15:09:24"
        },
        {
            "id": "124",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 10:38:43"
        },
        {
            "id": "125",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 10:55:51"
        },
        {
            "id": "126",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 10:56:19"
        },
        {
            "id": "128",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 14:34:15"
        },
        {
            "id": "129",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 14:35:02"
        },
        {
            "id": "130",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 14:44:10"
        },
        {
            "id": "131",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 14:53:01"
        },
        {
            "id": "132",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 14:56:14"
        },
        {
            "id": "133",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 14:57:05"
        },
        {
            "id": "134",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:03:29"
        },
        {
            "id": "135",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:06:35"
        },
        {
            "id": "136",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:08:08"
        },
        {
            "id": "137",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:08:39"
        },
        {
            "id": "138",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:09:36"
        },
        {
            "id": "139",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:13:43"
        },
        {
            "id": "140",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:17:19"
        },
        {
            "id": "141",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:19:00"
        },
        {
            "id": "142",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:21:01"
        },
        {
            "id": "143",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:25:23"
        },
        {
            "id": "144",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-12 15:27:22"
        },
        {
            "id": "145",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:27:22"
        },
        {
            "id": "146",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:27:25"
        },
        {
            "id": "147",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:28:05"
        },
        {
            "id": "148",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:28:08"
        },
        {
            "id": "149",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:29:02"
        },
        {
            "id": "150",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:29:05"
        },
        {
            "id": "151",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:30:45"
        },
        {
            "id": "152",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:30:47"
        },
        {
            "id": "153",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:31:12"
        },
        {
            "id": "154",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:31:14"
        },
        {
            "id": "155",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:31:41"
        },
        {
            "id": "156",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:31:44"
        },
        {
            "id": "157",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:33:09"
        },
        {
            "id": "158",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:33:12"
        },
        {
            "id": "159",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:38:17"
        },
        {
            "id": "160",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:38:19"
        },
        {
            "id": "161",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:39:39"
        },
        {
            "id": "162",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:39:41"
        },
        {
            "id": "163",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:42:43"
        },
        {
            "id": "164",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:42:45"
        },
        {
            "id": "165",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:56:48"
        },
        {
            "id": "166",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:56:50"
        },
        {
            "id": "167",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:57:19"
        },
        {
            "id": "168",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:57:22"
        },
        {
            "id": "169",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 15:59:23"
        },
        {
            "id": "170",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 15:59:26"
        },
        {
            "id": "171",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 16:00:35"
        },
        {
            "id": "172",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 16:00:38"
        },
        {
            "id": "173",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 16:01:05"
        },
        {
            "id": "174",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 16:01:08"
        },
        {
            "id": "175",
            "visitors_purpose": "Test Purpose",
            "description": "Positive Test",
            "created_at": "2023-08-12 16:02:08"
        },
        {
            "id": "176",
            "visitors_purpose": "Test",
            "description": "Validate",
            "created_at": "2023-08-12 16:02:10"
        },
        {
            "id": "194",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-13 05:29:33"
        },
        {
            "id": "196",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-13 06:39:18"
        },
        {
            "id": "200",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-13 07:16:16"
        },
        {
            "id": "201",
            "visitors_purpose": "Veli Ziyareti",
            "description": "Veli Ziyareti İçin Gelindi",
            "created_at": "2023-08-13 07:38:46"
        }
    ]
}




     */



}


