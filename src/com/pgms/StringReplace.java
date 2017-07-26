package com.pgms;

public class StringReplace {

    public static void main(String[] args) {

        System.out.println(replace("aaaaaaaa".toCharArray(), "a".toCharArray(), "b".toCharArray()));
    }

    public static String replace(char[] arr, char[] oldchar, char[] newchar) {

        char[] newarr = null;
        int occurence = 0;
        int[] positions = new int[arr.length / oldchar.length];

        for (int i = 0; i <=arr.length - oldchar.length; i++) {
            int j;
            for (j = 0; j < oldchar.length; j++) {
                if (arr[i + j] != oldchar[j]) {
                    break;
                }
            }
            if (j == oldchar.length) {
                positions[occurence] = i;
                occurence++;
            }
        }

        if (occurence > 0) {
            newarr = new char[arr.length - (occurence * (oldchar.length - newchar.length))];

            int posIndex = 0;
            int newarrIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != positions[posIndex]) {
                    newarr[newarrIndex++] = arr[i];
                } else if(posIndex<(occurence)){
                    for (int k = 0; k < newchar.length; k++) {
                        newarr[newarrIndex++] = newchar[k];
                    }
                    posIndex++;
                    i=i+oldchar.length-1;
                }
            }

            return new String(newarr);
        } else {
            return new String(arr);
        }

    }

}
