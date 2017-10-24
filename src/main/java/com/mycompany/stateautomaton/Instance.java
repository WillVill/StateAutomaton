/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stateautomaton;

import com.mycompany.stateautomaton.DynamicAnalyser.State;
import java.util.ArrayList;

/**
 *
 * @author williambech
 */
public class Instance {
    
    int instance;
    ArrayList<LogEntry> logs;
    DynamicAnalyser da;

    public Instance(int instance) {
        this.instance = instance;
        this.da = new DynamicAnalyser();
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
    
    public DynamicAnalyser getDynamicAnalyser() {
        return this.da;
    }
    
    public State getState() {
        return da.getState();
    }
    
    public boolean isStateFinal() {
        return da.isStateFinal();
    }
}
