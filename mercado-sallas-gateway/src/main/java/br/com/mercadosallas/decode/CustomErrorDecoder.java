package br.com.mercadosallas.decode;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

@Component
public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        String message = null;
        String path = null;
        Reader reader = null;
        ExceptionMessage exceptionMessage = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            reader = response.body().asReader();
            String result = CharStreams.toString(reader);
            exceptionMessage = mapper.readValue(result,
                    ExceptionMessage.class);
            message = exceptionMessage.message;
            System.out.println("resultado body = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exceptionMessage;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ExceptionMessage extends Exception{
        private int status;
        private String error;
        private String message;
        private String path;
    }
}