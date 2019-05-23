package BelaProject;

import java.util.Random;

public class ProcessorBetOption {

    /**
     * *
     *
     * @return a random BetOption enum
     */
    public static BetOption getRandom_ElementAs_BetOption() {
        return BetOption.values()[new Random().nextInt(BetOption.values().length)];
    }

    /**
     * *
     *
     * @return a random BetOption enum Converted to String
     */
    public static String getRandom_ElementAs_String() {
        return getRandom_ElementAs_BetOption().toString().substring(1);
    }

    /**
     * *
     *
     * @return returns a number from the BetOption as BetOption enum
     */
    public static BetOption getRandom_NumberAs_BetOption() {
        while (true) {
            try {
                BetOption b = getRandom_ElementAs_BetOption();
                String s = getRandom_ElementAs_String();
                Integer.parseInt(s.substring(1));
                return b;
            } catch (NumberFormatException e) {
            }
        }
    }

    /**
     * *
     *
     * @return returns a number from the BetOption converted to integer
     */
    public static int getRandom_NumberAs_Int() {
        while (true) {
            try {
                String s = getRandom_NumberAs_String();
                int i = Integer.parseInt(s);
                return i;
            } catch (NumberFormatException e) {
            }
        }
    }

    /**
     * *
     *
     * @return returns a number from the BetOption converted to String
     */
    public static String getRandom_NumberAs_String() {
        while (true) {
            try {
                String s = getRandom_NumberAs_BetOption().toString().substring(1);
                Integer.parseInt(s);
                return s;
            } catch (NumberFormatException e) {
            }
        }
    }

    /**
     * *
     *
     * @return returns a random Color from the BetOption as BetOption enum
     */
    public static BetOption getRandom_ColorAs_BetOption() {
        return Math.random() >= 0.5 ? BetOption._RED : BetOption._BLACK;
    }

    /**
     * *
     *
     * @return returns a random Color from the BetOption as String
     */
    public static String getRandom_ColorAs_String() {
        return Math.random() >= 0.5 ? "RED" : "BLACK";
    }

    /**
     * *
     *
     * @return returns a random twelve as BetOption enum
     */
//    public static BetOption getRandom_TwelveAs_BetOption() {
//        int i = new Random().nextInt(3);
//        switch (i) {
//            case 0:
//                return BetOption._FIRST_TWELVE;
//            case 1:
//                return BetOption._SECOND_TWELVE;
//            default:
//                return BetOption._THIRD_TWELVE;
//        }
//    }

    /**
     * *
     *
     * @return returns a random twelve converted to String
     */
//    public static String getRandom_TwelveAs_String() {
//        return getRandom_TwelveAs_BetOption().toString();
//    }

    /**
     * *
     *
     * @return returns randomly an odd or even as BetOption enum
     */
    public static BetOption getRandomly_Odd_EvenAs_BetOption() {
        return Math.random() >= 0.5 ? BetOption._ODD : BetOption._EVEN;
    }

    /**
     * *
     *
     * @return returns ranndomly an odd or even as String
     */
    public static String getRandomly_Odd_EvenAs_String() {
        return getRandomly_Odd_EvenAs_BetOption().toString().substring(1);
    }

    /**
     * *
     *
     * @param bet BetOption to convert
     * @return returns a Integer converted from the parameter returns null if
     * cant convert
     */
    public static Integer getBetOptionAs_Integer(BetOption bet) {
        try {
            return Integer.parseInt(bet.toString().substring(1));
        } catch (NumberFormatException e) {
        }
        return null;
    }

    public static boolean numberEquals(Integer i, BetOption bet) {

        Integer j = ProcessorBetOption.getBetOptionAs_Integer(bet);
        if (i == null || j == null) {
            return false;
        }
        return (int) i == (int) j;
    }

    public static boolean numberEquals(BetOption bet1, BetOption bet2) {
        Integer i = ProcessorBetOption.getBetOptionAs_Integer(bet1);
        Integer j = ProcessorBetOption.getBetOptionAs_Integer(bet2);
        if (i == null || j == null) {
            return false;
        }
        return (int) i == (int) j;
    }
    
//    public static boolean isItInTheTwelve(BetOption myBet,int num){
//        switch(myBet){
//            case _FIRST_TWELVE:return num<13;
//            case _SECOND_TWELVE:return num>12 && num<25;
//            case _THIRD_TWELVE:return num>24;
//            default:return false;
//        }
//    }
    
}
