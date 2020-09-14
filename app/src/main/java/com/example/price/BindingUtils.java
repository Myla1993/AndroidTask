package com.example.price;

import java.text.DecimalFormat;

public class BindingUtils {

    public static String convertToSuffix(Double count) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return String.valueOf(("$" + twoDForm.format(count)));

    }
    public static String convertTochangedPrice(Double count) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return String.valueOf(( twoDForm.format(count))+"%");

    }
}
