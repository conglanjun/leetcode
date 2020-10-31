package offer;

public class Offer20 {

    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }

        s = s.trim();
        try{
            double a = Double.parseDouble(s);
        }catch (Exception e){
            return false;
        }

        char c = s.charAt(s.length()-1);
        return (c >= '0' && c <= '9') || c == '.';
    }

    public static void main(String[] args) {
        Offer20 o = new Offer20();
        boolean number = o.isNumber("46.e3");
        System.out.println(number);
    }

}