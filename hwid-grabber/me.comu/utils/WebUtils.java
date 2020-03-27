package me.comu.utils;

import java.net.*;
import java.util.*;
import java.util.function.*;
import java.io.*;

public class WebUtils
{
    public static String get(final String url) throws IOException {
        final HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        final StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine).append("\n");
        }
        in.close();
        return response.toString();
    }
    
    public static String post(final String url, final Map<String, String> requestMap, final String body) throws IOException {
        final HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        if (requestMap != null) {
            requestMap.forEach(con::setRequestProperty);
        }
        con.setDoOutput(true);
        con.setDoInput(true);
        final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(body);
        wr.flush();
        wr.close();
        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        final StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine).append("\n");
        }
        in.close();
        return response.toString();
    }
}
