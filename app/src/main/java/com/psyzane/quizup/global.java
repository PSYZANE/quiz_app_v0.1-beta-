package com.psyzane.quizup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class global {
    //USERNAME VALIDATION
    public static int validUsername(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 1;
        }
        if (str.length() < 3) {
            return 2;
        }
        if (str.length() > 20) {
            return 3;
        }
        return 0;
    }

    //Check whether the password contain a alphabet, number and special character
    public static boolean validPassword(String str) {
        //Check for empty password
        if (str == null || str.trim().isEmpty()) {
            return false; // Or throw an exception, depending on your requirements
        }

        //Check for minimum length
        if (str.length() < 8) {
            return false;
        }

        // Define patterns for each type of character
        Pattern alphabetPattern = Pattern.compile("[a-zA-Z]"); // Letters (a-z, A-Z)
        Pattern numberPattern = Pattern.compile("[0-9]");       // Numbers (0-9)
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]"); // Anything not a letter or number

        // Check for matches
        Matcher alphabetMatcher = alphabetPattern.matcher(str);
        Matcher numberMatcher = numberPattern.matcher(str);
        Matcher specialCharMatcher = specialCharPattern.matcher(str);

        // Return true only if all patterns match at least once
        return alphabetMatcher.find() && numberMatcher.find() && specialCharMatcher.find();
    }
}
