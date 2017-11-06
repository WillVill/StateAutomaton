/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stateautomaton;

import com.mycompany.stateautomaton.DynamicAnalyser.State;
import java.util.ArrayList;

public class Instance {
    
    int instance;
    ArrayList<LogEntry> logs = new ArrayList();
    Generator gen;
    String regex;

    public Instance(int instance, String regex) {
        this.instance = instance;
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
    
    public ArrayList<LogEntry> getLogList() {
        return logs;
    }

    public void setLogList(ArrayList<LogEntry> logs) {
        this.logs = logs;
    }

    public int getInstance() {
        return instance;
    }

    public void setInstance(int instance) {
        this.instance = instance;
    }
    
    public void addLog(LogEntry log) {
        logs.add(log);
    }
    
    public void processLogs() {
        ArrayList<String> actions = new ArrayList();

        for (LogEntry log : logs) {
            actions.add(log.getAction());
        }
        
        this.gen = new Generator(regex, actions);
        gen.generate();
    }
    
    public Generator getGenerator() {
        return this.gen;
    }
    
    public String getState() {
        return gen.getState();
    }
    
    public void isStateFinal() {
        gen.isStateFinal();
    }
}
