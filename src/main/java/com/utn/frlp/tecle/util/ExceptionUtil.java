package com.utn.frlp.tecle.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.utn.frlp.tecle.constants.RegistrationConstants.TOKEN_CANNOT_BE_VALIDATED;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class ExceptionUtil {
    public static void handleTokenException(Exception exception, HttpServletResponse response) throws IOException {
        response.setHeader("Error", exception.getMessage());
        response.setStatus(FORBIDDEN.value());
        Map<String, String> error = new HashMap<>();
        error.put("error_message", TOKEN_CANNOT_BE_VALIDATED);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), error);
    }
}
