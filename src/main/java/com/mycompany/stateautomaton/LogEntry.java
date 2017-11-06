/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stateautomaton;

import java.util.Date;

public class LogEntry {
    String level;
    int system;
    int instance;
    String action;
    Date timestamp;

    public LogEntry(String level, int system, int instance, String action) {
        this.level = level;
        this.system = system;
        this.instance = instance;
        this.action = action;
        this.timestamp = new Date();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public int getInstance() {
        return instance;
    }

    public void setInstance(int instance) {
        this.instance = instance;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
