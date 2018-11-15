package qa.com.util;

import com.google.gson.Gson;

public class JSONToJavaUtility {

    private static Gson gson;

    public JSONToJavaUtility() {
        this.gson = new Gson();
    }

    public static String getJSONFromObject(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T getObjectFromJSON(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, clazz);
    }

}

