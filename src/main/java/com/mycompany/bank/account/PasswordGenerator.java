/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank.account;

/**
 *
 * @author gasimovv21
 */
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordGenerator {
    static CustomersRepository cr = new CustomersRepository();
    private static final String UPPER_CASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "$@$!%*?&";
    private static final String PASSWORD_ALLOWED_CHARS = UPPER_CASE_CHARS + LOWER_CASE_CHARS + NUMBER_CHARS + SPECIAL_CHARS;
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 16;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,16}$");

    public static String generate() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean specialCharFlag = false;

        int passwordLength = random.nextInt((PASSWORD_MAX_LENGTH - PASSWORD_MIN_LENGTH) + 1) + PASSWORD_MIN_LENGTH;

        while (password.length() < passwordLength) {
            int randomIndex = random.nextInt(PASSWORD_ALLOWED_CHARS.length());
            char randomChar = PASSWORD_ALLOWED_CHARS.charAt(randomIndex);

            if (Character.isUpperCase(randomChar) && !upperCaseFlag) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(randomChar) && !lowerCaseFlag) {
                lowerCaseFlag = true;
            } else if (Character.isDigit(randomChar) && !numberFlag) {
                numberFlag = true;
            } else if (SPECIAL_CHARS.indexOf(randomChar) != -1 && !specialCharFlag) {
                specialCharFlag = true;
            }

            if (upperCaseFlag && lowerCaseFlag && numberFlag && specialCharFlag) {
                password.append(randomChar);
            }
        }
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if(matcher.matches()) {
            cr.customer_data.set(7, password.toString());
            System.out.println("Your new password: " + password.toString());
            Utils.sleeping(1500);
            System.out.println("You can Log in with this password. \nAfter change password in Account settings -> Change data -> Password.");
            return password.toString();
        } else {
            return generate();
        }
    }
}

