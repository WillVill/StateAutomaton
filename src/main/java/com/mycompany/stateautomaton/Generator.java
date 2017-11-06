/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stateautomaton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author williambech
 */
public class Generator {
    String regex;
    ArrayList<String> actions;
    ArrayList<String> possibilities = new ArrayList();
    boolean storeLetters = false;
    
//1. (p|q) is a regular expression denoting the set L(p) union L(q), where  union  denotes the union.
//
//2. (p)(q) is a regular expression denoting the set of all concatenations of m and n, where m in L(p) and n in L(q).
//
//3. (p)^* is a regular expression denoting closure of L(p), that is, the set of zero or more concatenations of strings from L(p)
    
    private String state = "";
    private String startState = "";
    private String lastState = "";
    private final String falseState = "FALSE_STATE";
    private int actionsIndex = 0;
    boolean loop = false;
    boolean clearPossibilites = false;
    private char previousChar;

    public Generator(String regex, ArrayList<String> actions) {
        this.regex = regex;
        this.actions = actions;
    }
    
    public void generate() {
       regexParser();
    }
    
    public void letterHandler(int i, String letter, char focusedChar) {
        if("".equals(startState)) {
           System.out.println("First Letter " + letter);
            possibilities.add(letter);
            if(!storeLetters) {
                tranisitionState();
            }
           startState = letter;
        } else {
            if(i + 1 == regex.length()) {
                lastState = letter;
            }
            possibilities.add(letter);
            
            if(!storeLetters) {
                tranisitionState();
            }
        }
    }

   public void symbolHandler(String letter) {
        switch (letter) {
            case "(":
                System.out.println("is (");
                storeLetters = true;
                break;
            case ")":
                storeLetters = false;
                tranisitionState();
                System.out.println("is *");
                break;
            case "*":
                loop = true;
                tranisitionState();
                loop = false;
                System.out.println("is *");
                possibilities.clear();
                break;
            case "|":
//                storeLetters = true;
                System.out.println("is |");
                break;
        }
   }
   
   public void checkValidState() {
        String isValid;
        
        if(lastState.equals(state)) {
            isValid = "State is valid";
        } else {
            isValid = "State is not valid";
        }
        System.out.println(isValid);
   }
   
   public boolean tranisitionState() {
        String letter = actions.get(actionsIndex);
        boolean match = false;

        for (String possibility : possibilities) {
            if (possibility.equals(letter)) {
                System.out.println("new state" + letter);
                match = true;
                state = letter;
                actionsIndex++;
                break;
            }
        }
        if(match) {
            return true;
        } else if(loop && match) {
            tranisitionState();
            return true;
        } else if(loop && !match) {
            return false;
        }
        System.out.println("transition false");
        state = falseState;
        return false;
   }
         
   public void regexParser() {
       for (int i = 0;i < regex.length(); i++){

           char focusedChar = regex.charAt(i);
           String letter = Character.toString(focusedChar);
           boolean isLetter = Character.isLetter(focusedChar);
           String prevChar = Character.toString(previousChar);
           // hack: When to clear possibilities
           if(!Character.isLetter(previousChar) && isLetter && ")".equals(prevChar)) {
               possibilities.clear();
           }
           System.out.println("focused: " + letter);
           if(isLetter){
               letterHandler(i, letter, focusedChar);
           } else {
               symbolHandler(letter);
           }
       }
   }
   
    public String getState() {
        return state;
    }
    
    public void isStateFinal() {
        String isFinal;
        
        if(lastState.equals(state)) {
            isFinal = "State is final";
        } else {
            isFinal = "State is not final";
        }
        System.out.println(isFinal);
    }
}
