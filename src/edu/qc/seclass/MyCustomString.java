package edu.qc.seclass;

import edu.qc.seclass.MyCustomStringInterface;

import java.util.Arrays;

public class MyCustomString implements MyCustomStringInterface {
    private String customString;
    @Override
    public String getString() {
        return this.customString;
    }

    @Override
    public void setString(String string) {
        this.customString = string;
    }

    @Override
    public int countNumbers() throws NullPointerException{
        int counter = 0;
        char c;

        if(customString == null){
            throw new NullPointerException();
        }

        if(customString.isEmpty()){
            return 0;
        }
        else {
            String word = customString.replaceAll("\\D", " ");
            String[] nums = word.split(" ");
            for (String num : nums) {
                if (!num.isEmpty()) {
                    c = num.charAt(0);
                    if (Character.isDigit(c)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) throws IllegalArgumentException, NullPointerException {
        StringBuilder string = new StringBuilder();

        if(n <= 0){
            throw new IllegalArgumentException();
        }

        if(this.customString == null && n > 0){
            throw new NullPointerException();
        }
        if (n > this.customString.length()) {
            return "";
        }
        if (startFromEnd) {
            for (int i = this.customString.length() - n; i >= 0; i -= n) {
                string.insert(0, this.customString.charAt(i));
            }
            return string.toString();
        }
        else {
            for (int i = n - 1; i < this.customString.length(); i += n) {
                string.append(this.customString.charAt(i));
            }
            return string.toString();
        }
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) throws IllegalArgumentException, MyIndexOutOfBoundsException, NullPointerException {
        if (startPosition > endPosition){
            throw new IllegalArgumentException();
        }
        if (startPosition < 1 || endPosition > this.customString.length()) {
            throw new MyIndexOutOfBoundsException();
        }
        if(startPosition > 0 && endPosition > 0 && this.customString == null){
            throw new NullPointerException();
        }

        String newString = customString.substring(startPosition-1, endPosition);

        newString = newString.replaceAll("0", "Zero");
        newString = newString.replaceAll("1", "One");
        newString = newString.replaceAll("2", "Two");
        newString = newString.replaceAll("3", "Three");
        newString = newString.replaceAll("4", "Four");
        newString = newString.replaceAll("5", "Five");
        newString = newString.replaceAll("6", "Six");
        newString = newString.replaceAll("7", "Seven");
        newString = newString.replaceAll("8", "Eight");
        newString = newString.replaceAll("9", "Nine");


        this.customString = customString.substring(0, startPosition-1) + newString
                + customString.substring(endPosition);
    }
}
