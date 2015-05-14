package com.rf.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class StringUtil {
    public static String getHash(String password, String salt) {
        String salted = salt + password;
        String hashed = salted;

        try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(salted.getBytes());
                hashed = encodeHex(md.digest(), 64);
        }
        catch (Exception ex) {
                hashed = null;
        }

        return hashed;
    }
    public static String encodeHex(byte[] bytes, int length) {
        BigInteger bigint = new BigInteger(1, bytes);
        String hex = String.format("%0" + length + "X", bigint);

        assert hex.length() == length;
        return hex;
    }
    public static byte[] randomBytes(int size) {
        byte[] saltBytes = new byte[size];
        new Random().nextBytes(saltBytes);
        return saltBytes;
    }
    public static boolean checkString(String text) {
        return (text == null) || text.trim().isEmpty();
    }
    public static String getDate(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(Calendar.getInstance().getTime());
    }

}
