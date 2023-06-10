package Test;

import java.util.*;
import java.util.regex.Pattern;

public class KonsolenRechnerV1 {

    public static void main(String[] args) {

        String aufgabe = getKonsolInput();
        int loesung = 0;
        List<Integer> numbers = new ArrayList<>();

        if (aufgabe.contains("+")) {
            numbers = getNumbers(aufgabe, "+");
            loesung = numbers.get(0) + numbers.get(1);
        } else if (aufgabe.contains("-")) {
            numbers = getNumbers(aufgabe, "-");
            loesung = numbers.get(0) - numbers.get(1);
        } else if (aufgabe.contains("*")) {
            numbers = getNumbers(aufgabe, "*");
            loesung = numbers.get(0) * numbers.get(1);
        } else if (aufgabe.contains("/")) {
            numbers = getNumbers(aufgabe, "/");
            loesung = numbers.get(0) / numbers.get(1);
        } else {
            System.out.println("Ungültige Eingabe");
            return; // Exit the program if the input is invalid
        }
        System.out.print("Lösung: ");
        System.out.println(loesung);
    }

    public static String getKonsolInput() {
    	System.out.print("Geben Sie eine Rechenaufgabe ein: ");
        Scanner scanner = new Scanner(System.in);
        String konsolInput = scanner.nextLine();
        scanner.close();
        konsolInput.replace(" ", "");
        return konsolInput;
    }

    public static List<Integer> getNumbers(String aufgabe, String operator) {
        String[] einzelneZahlen = aufgabe.split(Pattern.quote(operator));
        List<Integer> returnValue = new ArrayList<>();
        returnValue.add(Integer.parseInt(einzelneZahlen[0]));
        returnValue.add(Integer.parseInt(einzelneZahlen[1]));
        return returnValue;
    }

}
