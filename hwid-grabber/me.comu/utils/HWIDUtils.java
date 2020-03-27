package me.comu.utils;

import java.security.*;
import java.io.*;

public class HWIDUtils
{
    public static String getHWID() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final StringBuilder s = new StringBuilder();
        final String main = String.valueOf(System.getenv("PROCESSOR_IDENTIFIER")) + System.getenv("COMPUTERNAME") + System.getProperty("user.name").trim();
        final byte[] bytes = main.getBytes("UTF-8");
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        final byte[] md5 = messageDigest.digest(bytes);
        int i = 0;
        byte[] array;
        for (int length = (array = md5).length, j = 0; j < length; ++j) {
            final byte b = array[j];
            s.append(Integer.toHexString((b & 0xFF) | 0x300), 0, 3);
            if (i != md5.length - 1) {
                s.append("-");
            }
            ++i;
        }
        return s.toString();
    }
}
