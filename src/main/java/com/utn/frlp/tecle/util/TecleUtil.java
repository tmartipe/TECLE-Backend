package com.utn.frlp.tecle.util;

import com.utn.frlp.tecle.entity.ConfirmationToken;
import com.utn.frlp.tecle.entity.User;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

public class TecleUtil {

    private static char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public static String generateRandomAlphanumericToken(){
        return randomString(CHARSET_AZ_09, 6);
    }

    public static String randomString(char[] characterSet, int length) {
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            // picks a random index out of character set > random character
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return new String(result);
    }

    public static ConfirmationToken generateTokenForUser(User user) {
        String token = generateRandomAlphanumericToken();
        return new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15L),
                user);
    }
}
