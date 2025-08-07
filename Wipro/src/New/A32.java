package New;

import java.util.ArrayList;
import java.util.List;

public class A32 {

    public static void main(String[] args) {

        System.out.println("---- NegativeArraySizeException ----");
        try {
            int[] arr1 = new int[-5];
        } catch (NegativeArraySizeException e) {
            e.printStackTrace();
        }

        System.out.println("---- ArrayIndexOutOfBoundsException ----");
        try {
            int[] arr2 = new int[3];
            int x = arr2[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("---- StringIndexOutOfBoundsException ----");
        try {
            String str = "hello";
            char ch = str.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("---- IndexOutOfBoundsException (List) ----");
        try {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int y = list.get(5);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("---- NullPointerException ----");
        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("---- ArithmeticException ----");
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
