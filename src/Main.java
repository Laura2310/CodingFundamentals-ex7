import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti parola:");
        String password = input.nextLine();
        boolean valid = true;
        if (password.length() < 6) {
            System.out.println("Lungimea trebuie sa fie de minim 6 caractere");
            valid = false;
        }
        boolean hasLowerCase = isValid(".*[a-z].*", password, "minim o litera mica");
        boolean hasUpperCase = isValid(".*[A-Z].*", password, "minim o litera mare");
        boolean hasDigit = isValid(".*\\d.*", password, "minim un digit");

        valid = valid && hasDigit && hasLowerCase && hasUpperCase;
        System.out.println(valid ? "Parola corecta" : "Parola incorecta");
    }
    private static boolean isValid(String regex,String password, String message){
        if(Pattern.matches(regex,password))
            return true;
        System.out.println(message);
        return false;
    }
}
