/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stateautomaton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author williambech
 */
public class StateAutomaton {

    public static void main(String[] args) {
        ArrayList<String> actions = new ArrayList();
        actions.add("A");
        actions.add("B");
        actions.add("C");
        actions.add("D");

        Generator gen = new Generator("A(B|C)*D", actions);
        
        gen.generate();
        gen.isStateFinal();
        
        ArrayList<String> actions2 = new ArrayList();
        actions2.add("A");
        actions2.add("B");

        Generator gen2 = new Generator("AB", actions2);
        
        gen2.generate();
        gen2.isStateFinal();
        
        // Using the log instances and factory
        
        LogFactory lf = new LogFactory();
        Instance instance = new Instance(1, "A(B|C)*D");
        
        lf.addInstance(instance);
        
        LogEntry log = new LogEntry("level", 1, 1, "A");
        lf.addLog(log);
        LogEntry log1 = new LogEntry("level", 1, 1, "B");
        lf.addLog(log1);
        LogEntry log2 = new LogEntry("level", 1, 1, "C");
        lf.addLog(log2);
        LogEntry log3 = new LogEntry("level", 1, 1, "D");
        lf.addLog(log3);
        
        instance.processLogs();
        instance.isStateFinal();
    }
}
