package com.tsystems.railwayservice.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {

    public static String readToString(InputStream stream) throws IOException {
        StringBuilder finalString = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        while (reader.readLine() != null) {
            finalString.append(reader.readLine());
        }
        return finalString.toString();
    }
}
