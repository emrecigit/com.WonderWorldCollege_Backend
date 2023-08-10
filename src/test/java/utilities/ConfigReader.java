package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //1-Properties objesi olusturacagiz
    private static Properties properties; //Diğer configreaderda static Properties properties;

    //2-Bu classin amaci configration.propertiesdosyasini okumak
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

}
