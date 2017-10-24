/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stateautomaton;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author williambech
 */
public class Generator {
    Pattern p;
    ArrayList actions;
    
    
    protected enum State {
        IDLE, FALSE_STATE, LOGGED_IN, LISTING_ITEM, EDITING_ITEM, LOGGED_OUT
    }
    
    protected enum Symbol {
        A, B, C, D;
    }
    
    private State state = State.IDLE;
    private State startNode = State.LOGGED_IN;
    private State endNode = State.LOGGED_OUT;
    
    public void transitionState(Symbol nextState) {
        boolean allowTransition = verifyTransition(nextState);
        if(allowTransition == true) {
            state = symbolToState(nextState);
        } else {
            state = State.FALSE_STATE; 
       }
    }
    
    public boolean isStateFinal() {
        return endNode == state;
    }
//    A Login, 100
//    B List items, 50
//    C Edit item, 500
//    D Logout, 200
    
    public State getState() {
        return state;
    }
    
    public State symbolToState(Symbol sym) {
        switch (sym) {
            case A:
                return State.LOGGED_IN;
            case B:
                return State.LISTING_ITEM;
            case C:
                return State.EDITING_ITEM;
            case D:
                return State.LOGGED_OUT;
            default:
                System.out.println("What kinda symbol is that");;
                return State.FALSE_STATE;
        }
    }
    
//    Example: A(B|C)*D

    private boolean verifyTransition(Symbol symbol) {
        boolean result;
        switch (state) {
            case IDLE:
                result = (symbol == Symbol.A);
                return result;
            case LOGGED_IN:
                result = (symbol == Symbol.B || symbol == Symbol.C || symbol == Symbol.D);
                return result;
            case LISTING_ITEM:
                result = (symbol == Symbol.B || symbol == Symbol.C || symbol == Symbol.D);
                return result;
            case EDITING_ITEM:
                result = (symbol == Symbol.B || symbol == Symbol.C || symbol == Symbol.D);
                return result;
            case LOGGED_OUT:
                result = (symbol == Symbol.A);
                return result;
            default:
                return false;
        }
    }
}
