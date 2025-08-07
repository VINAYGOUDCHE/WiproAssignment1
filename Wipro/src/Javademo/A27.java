package Javademo;
public class A27 {

    enum Currency {
        TEN, TWENTY, FIFTY, HUNDRED, TWO_HUNDRED, FIVE_HUNDRED
    }

    public static void main(String[] args) {

        for (Currency c : Currency.values()) {
            System.out.println("Currency: " + c);

            switch (c) {
                case TEN:
                    System.out.println("₹10 note");
                    break;
                case TWENTY:
                    System.out.println("₹20 note");
                    break;
                case FIFTY:
                    System.out.println("₹50 note");
                    break;
                case HUNDRED:
                    System.out.println("₹100 note");
                    break;
                case TWO_HUNDRED:
                    System.out.println("₹200 note");
                    break;
                case FIVE_HUNDRED:
                    System.out.println("₹500 note");
                    break;
            }

            System.out.println();
        }
    }
}
/*
Currency: TEN
₹10 note

Currency: TWENTY
₹20 note

Currency: FIFTY
₹50 note

Currency: HUNDRED
₹100 note

Currency: TWO_HUNDRED
₹200 note

Currency: FIVE_HUNDRED
₹500 note
*/