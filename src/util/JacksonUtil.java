/*
package util;

*/
/**
 * Created by Administrator on 2017/11/14.
 *//*


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * Created by yancyyang on 2016/11/29.
 *//*

public class JacksonUtil {

    private static ObjectMapper mapperWithNull = new ObjectMapper();
    private static ObjectMapper mapperWithoutNull = new ObjectMapper();

    static {
        mapperWithoutNull.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapperWithoutNull.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapperWithNull.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        mapperWithNull.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, true);
    }



    public static Map jsonString2Map(String jsonString){
        Map map = null;
        try {
            map = mapperWithNull.readValue(jsonString, Map.class);
        }catch(IOException e){
            logger.error("occur wrong when the json string is parsing to map");
            e.printStackTrace();
        }
        return map;
    }

    public static List jsonString2List(String jsonString){
        List list = null;
        try {
            list = mapperWithNull.readValue(jsonString, List.class);
        }catch(IOException e){
            logger.error("occur wrong when the json string is parsing to map");
            e.printStackTrace();
        }
        return list;
    }

    public static Object jsonString2Object(String jsonString, Class ObjectClass){
        Object object = null;
        try {
            object  = mapperWithNull.readValue(jsonString, ObjectClass);
        }catch(IOException e){
            logger.error("occur wrong when the json string is parsing to map");
            e.printStackTrace();
        }
        return object;
    }

    public static String object2JsonStringWithoutNull(Object object){
        String res = null;
        try {
            res = mapperWithoutNull.writeValueAsString(object);
        }catch(JsonProcessingException e){
            logger.error("occur wrong when the object is parsing to json string");
            e.printStackTrace();
        }
        return res;
    }

    public static String object2JsonStringWithNull(Object object){
        String res = null;
        try {
            res = mapperWithNull.writeValueAsString(object);
        }catch(JsonProcessingException e){
            logger.error("occur wrong when the object is parsing to json string");
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String args []){
        Map map = new HashMap();
        map.put("valueTest",1);
        map.put("nullTest", null);
        map.put("dateTest", new Date());
        map.put("beanTest", new AdDemander());
        map.put("byteTest", (byte) 10);
        map.put("longTest", Long.MAX_VALUE);
        map.put("longTest1", (long)2);
        String jsonStringWithoutNull = object2JsonStringWithoutNull(map);
        String jsonStringWithNull = object2JsonStringWithNull(map);
        System.out.println(jsonStringWithoutNull);
        System.out.println(jsonStringWithNull);

        Map map1 = jsonString2Map(jsonStringWithoutNull );
        int a=0;
        a++;
    }
}
*/
