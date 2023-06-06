package com.ask.utils;

import com.ask.objects.BillingAddress;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static <T> T deserializeJson(String filname, Class<T> T) throws IOException {
        InputStream is= JacksonUtils.class.getClassLoader().getResourceAsStream(filname);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(is, T);
    }
}
