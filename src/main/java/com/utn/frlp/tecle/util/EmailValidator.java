package com.utn.frlp.tecle.util;

import com.utn.frlp.tecle.exception.BadRequestException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
        public static void validEmail(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches())
            throw new BadRequestException("Email Invalido");
    }
}
