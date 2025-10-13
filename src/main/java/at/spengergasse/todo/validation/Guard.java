package at.spengergasse.todo.validation;

import java.util.Objects;

public final class Guard {
    // not-null, not-empty, value.length <= maxLength
    public static String textLength(String value, int maxLength, String message) {
        Objects.requireNonNull(value);

        String trimmed = value.trim();
        if (trimmed.isEmpty() || trimmed.length() > maxLength) {
            throw new IllegalArgumentException(message);
        }

        return trimmed;
    }

    public static String creditCard(String value, String message) {
        Objects.requireNonNull(value);

        String trimmed = value.trim();
        if (trimmed.isEmpty() || trimmed.length() != 16 ||
                creditCardCheck(GetDigits(trimmed)) == false) {
            throw new IllegalArgumentException(message);
        }

        return trimmed;
    }

    private static int[] GetDigits(String input) {
        if (input == null || input.isEmpty()) {
            return new int[0];
        }

        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                list.add(ch - '0'); // convert '0'..'9' -> 0..9
            }
        }

        // convert to int[]
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    //Lumn Alogrithem
    private static boolean creditCardCheck(int[] digits) {
        int sum = 0;
        int length = digits.length;

        for (int i = 0; i < length; i++) {
            // get digits in reverse order
            int digit = digits[length - i - 1];
            // every 2nd number multiply with 2
            if (i % 2 == 1) {
                digit *= 2;
            }

            sum += digit > 9 ? digit - 9 : digit;
        }

        return sum % 10 == 0;
    }
}
