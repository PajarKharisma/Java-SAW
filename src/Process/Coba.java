package Process;

public class Coba {

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        String value = "Muhammad Pajar Kharisma Putra";
        System.out.println("Nilai : " + isNumeric(value));
    }
}
