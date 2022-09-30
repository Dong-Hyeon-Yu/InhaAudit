package org.inha.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public abstract class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static byte[] serialize(Object object) {
        return new JSONObject(object).toString().getBytes(StandardCharsets.UTF_8);
    }

    public static <T> T deserialize(byte[] rawString, Class<T> clazz) throws IOException {
        return (T) objectMapper.readValue(rawString, clazz);
    }
}
