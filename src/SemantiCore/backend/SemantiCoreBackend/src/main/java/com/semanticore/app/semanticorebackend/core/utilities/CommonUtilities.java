package com.semanticore.app.semanticorebackend.core.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommonUtilities {

    // Method to generate a random UUID
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    // Method to format the current date as a string
    public static String getCurrentDate(String format) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        return dateFormatter.format(new Date());
    }

    // Method to check if a string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Method to convert a string to title case
    public static String toTitleCase(String input) {
        if (isNullOrEmpty(input)) {
            return input;
        }

        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }
}

