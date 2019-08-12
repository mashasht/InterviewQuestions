package leetcode;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int minLength = Math.min(num1.length(), num2.length());
        if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            int sum = num1.charAt(num1.length() - 1 - i) + num2.charAt(num2.length() - 1 - i) - 96 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        for (int i = minLength; i < num2.length(); i++) {
            int sum = (num2.charAt(num2.length() - 1 - i) - 48) + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            result.append(carry);
        }
        result = result.reverse();
        return result.toString();
    }
    public static void main(String[] args) {
        AddStrings as = new AddStrings();
       System.out.println(as.addStrings("6913259244", "71103343"));
    }
}

