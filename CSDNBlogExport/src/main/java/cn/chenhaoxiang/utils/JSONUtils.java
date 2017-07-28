package cn.chenhaoxiang.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/3/16.
 * Time: 下午 7:55.
 * Explain:JSON数据操作类，例如JSON和JavaBean之间的互相转换等
 */
public class JSONUtils extends ObjectMapper {
    private static SerializeConfig mapping = new SerializeConfig();
    static{
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    private static JSONUtils mapper;

    /**
     * Object可以是POJO，也可以是Collection或数组。
     * 如果对象为Null, 返回"null".
     * 如果集合为空集合, 返回"[]".
     */
    public String toJson(Object object) {
        try {
            return this.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 反序列化POJO或简单Collection如List<String>.
     *
     * 如果JSON字符串为Null或"null"字符串, 返回Null.
     * 如果JSON字符串为"[]", 返回空集合.
     * 如需反序列化复杂Collection如List<MyBean>, 请使用fromJson(String,JavaType)
     */
    public <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return this.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 反序列化复杂Collection如List<Bean>, 先使用函數createCollectionType构造类型,然后调用本函数.
     * @see #createCollectionType(Class, Class...)
     */
    public <T> T fromJson(String jsonString, JavaType javaType) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return (T) this.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 構造泛型的Collection Type如:
     * ArrayList<MyBean>, 则调用constructCollectionType(ArrayList.class,MyBean.class)
     * HashMap<String,MyBean>, 则调用(HashMap.class,String.class, MyBean.class)
     */
    public JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return this.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 當JSON裡只含有Bean的部分屬性時，更新一個已存在Bean，只覆蓋該部分的屬性.
     */
    public <T> T update(String jsonString, T object) {

        try {
            return (T) this.readerForUpdating(object).readValue(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 輸出JSONP格式數據.
     */
    public String toJsonP(String functionName, Object object) {
        return toJson(new JSONPObject(functionName, object));
    }


    /**
     * 取出Mapper做进一步的设置或使用其他序列化API.
     */
    public ObjectMapper getMapper() {
        return this;
    }

    /**
     * 将obj对象转换成 class类型的对象
     * @param obj
     * @param clazz
     * @return
     */
    public static <T> T parseObject(Object obj, Class<T> clazz){
        return JSON.parseObject(JSON.toJSONString(obj), clazz);
    }

    /**
     * 对象转换为JSON字符串
     * @param obj JavaBean对象
     * @return 返回JSON字符串
     */
    public static String obj2json(Object obj){
//      return JSON.toJSONString(obj,SerializerFeature.UseSingleQuotes);//使用单引号
//      return JSON.toJSONString(obj,true);//格式化数据，方便阅读
        return JSON.toJSONString(obj,mapping);
    }

    /**
     * JSON字符串转换成JavaBean、Map
     * @param jsonStr JSON字符串
     * @param clazz JavaBean.class
     * @param <T>
     * @return
     */
    public static <T> T json2obj(String jsonStr,Class<T> clazz){
        return JSON.parseObject(jsonStr,clazz);
    }

    /**
     * JSON字符串转换成List<JavaBean> ,List<Map>
     * @param jsonArrayStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz){
        return JSON.parseArray(jsonArrayStr, clazz);
    }

    /**
     * JSON字符串转换为Map<String,Object>对象
     * @param jsonStr
     * @param <T>
     * @return
     */
    public static <T> Map<String,Object> json2map(String jsonStr){
        return json2obj(jsonStr, Map.class);
    }

    /**
     *JSON字符串转换为Map<String,JavaBean.class>
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Map<String,T> json2map(String jsonStr,Class<T> clazz){
        Map<String,T> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, T>>() {});
        for (Map.Entry<String, T> entry : map.entrySet()) {
            JSONObject obj = (JSONObject) entry.getValue();
            map.put(entry.getKey(), JSONObject.toJavaObject(obj, clazz));
        }
        return map;
    }

}
