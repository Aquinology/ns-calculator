package poui.nscalculator;

import java.util.HashMap;
import java.util.Map;

public class Methods {

    public static void main(String[] args) {

        System.out.println(convert(4837457, 16));
    }

    public static String convert(int decimalNumber, int numeralSystem){

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        map.put(10, "a");
        map.put(11, "b");
        map.put(12, "c");
        map.put(13, "d");
        map.put(14, "e");
        map.put(15, "f");
        map.put(16, "g");
        map.put(17, "h");
        map.put(18, "i");
        map.put(19, "j");
        map.put(20, "k");
        map.put(21, "l");
        map.put(22, "m");
        map.put(23, "n");
        map.put(24, "o");
        map.put(25, "p");
        map.put(26, "q");
        map.put(27, "r");
        map.put(28, "s");
        map.put(29, "t");
        map.put(30, "u");
        map.put(31, "v");
        map.put(32, "w");
        map.put(33, "x");
        map.put(34, "y");
        map.put(35, "z");

        String newValue = "";
        int i;

        for (i = decimalNumber; i >= numeralSystem; i = i/numeralSystem){
            newValue = newValue + (map.get(i % numeralSystem));
        }
        newValue = newValue + map.get(i);
        newValue = reverseString(newValue);
        return newValue;
    }

    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }
}
