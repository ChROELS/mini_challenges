package be.intecbrussel.katas;

public class HowToKnowCentury {
    public static int century(int number) {
        String date = String.valueOf(number);
        String centuries;
        String decades;
        int result;
        switch (date.length()){
            case 4:
                centuries = date.substring(0, 2);
                decades = date.substring(2, 4);
                result = Integer.parseInt(centuries);
                if (decades.equals("00")) {
                    return result;
                }
                return result + 1;
            case 3:
                centuries = date.substring(0, 1);
                decades = date.substring(1, 3);
                result = Integer.parseInt(centuries);
                if (decades.equals("00")) {
                    return result;
                }
                return result + 1;
            default:
                return 1;
        }
    }

    public static void main(String[] args) {
        //century determination
        //19
        System.out.println(century(1854));
        //20
        System.out.println(century(2000));
        //2
        System.out.println(century(122));
    }
}
