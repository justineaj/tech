package com.pgms;

public class PhoneNumberText {

    /**
     * @param args
     */
    public static String numTexts = "ABCDEFGHIJKLMNOPRSTUVWXY";
    public static String telNum = "478";

    public static void main(String[] args) {

        printWord("", 0, 0);

    }

    private static void printWord(String previousText, int position, int index) {
        if (position == telNum.length() ) {
            System.out.println(previousText);
            return;
        } else {
            if (getChar(digitAtPosition(position), 0).equals("" + digitAtPosition(position))) {
                printWord(previousText + getChar(digitAtPosition(position), 0), position + 1, 0);
            } else {
                for (int i = 0; i < 3; i++) {
                    printWord(previousText + getChar(digitAtPosition(position), i), position + 1, i);

                }
            }
        }
    }

    private static int digitAtPosition(int position) {
        return Integer.parseInt(telNum.substring(position, position + 1));

    }

    static String getChar(int num, int index) {
        if (num == 1 || num == 0) {
            return "" + num;
        } else {
            int pos = (num - 2) * 3 + index;
            return numTexts.substring(pos, pos + 1);
        }
    }
}
