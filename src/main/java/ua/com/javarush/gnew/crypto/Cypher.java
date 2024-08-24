package ua.com.javarush.gnew.crypto;

import ua.com.javarush.gnew.language.LanguageDetector;
import java.util.ArrayList;
import java.util.Collections;

public class Cypher {


    public String encrypt(String input, int key) {
        key = Math.negateExact(key);
        char[] chars = input.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (char currentChar : chars) {
            builder.append(processSymbol(currentChar, key));
        }
        return builder.toString();
    }


    private Character processSymbol(char currentChar, int key) {
        ArrayList<Character> originalAlphabet = LanguageDetector.detector(currentChar);
        if (originalAlphabet == null){
            return currentChar;
        }
        ArrayList<Character> rotatedAlphabet = new ArrayList<>(originalAlphabet);
        Collections.rotate(rotatedAlphabet, key);
        int index =  originalAlphabet.indexOf(currentChar);
        return rotatedAlphabet.get(index);
    }
}




// if (!originalAlphabet.contains(currentChar)) {
//            return currentChar;
//        }



//    public String encrypt(String input, int key) {
//        key = Math.negateExact(key);
//
//        originalAlphabet = LanguageDetector.detector(input);
//        ArrayList<Character> rotatedAlphabet = new ArrayList<>(originalAlphabet);
//        Collections.rotate(rotatedAlphabet, key);
//
//        char[] charArray = input.toCharArray();
//
//        StringBuilder builder = new StringBuilder();
//        for (char symbol : charArray) {
//            builder.append(processSymbol(symbol, rotatedAlphabet));
//        }
//        return builder.toString();
//    }
//
//    private Character processSymbol(char symbol, ArrayList<Character> rotatedAlphabet) {
//        if (!originalAlphabet.contains(symbol)) {
//            return symbol;
//        }
//        int index = originalAlphabet.indexOf(symbol);
//
//        return rotatedAlphabet.get(index);
//    }