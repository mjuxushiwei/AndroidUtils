package utils.xsw.com.utillibrary;

import com.google.gson.Gson;

public class JsonUtils {

    private static Gson gson = new Gson();

    public static String GetJSon(Object object) {
        return gson.toJson(object);

    }

    public static <T> T Json2Object(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return gson.fromJson(json, clazz);

    }

//    public static List<?> JsonToListObject(String listStr, final Object clazz) {
//      final Class t=  clazz.getClass();
//        return gson.fromJson(listStr, new TypeToken<List<t>>() {
//        }.getType());
//
//
//    }

}
