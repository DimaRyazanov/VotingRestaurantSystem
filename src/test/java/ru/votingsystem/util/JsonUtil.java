package ru.votingsystem.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {

    }

    public static <T> String writeValueToJson(T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T readFromJsonResultAction(ResultActions action, Class<T> clazz) throws IOException {
        return mapper.readValue(getContent(action.andReturn()), clazz);
    }

    private static String getContent(MvcResult result) throws UnsupportedEncodingException {
        return result.getResponse().getContentAsString();
    }

}
