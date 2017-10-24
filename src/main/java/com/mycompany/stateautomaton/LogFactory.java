/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stateautomaton;

import java.util.ArrayList;

/**
 *
 * @author williambech
 */
public class LogFactory {
    private static ArrayList<Instance> logInstances;

    public ArrayList<Instance> getInstances() {
        return logInstances;
    }
    
    public void addLog(LogEntry log) {
        if (logInstances.size() < 1) {
            Instance logInstance = new Instance(log.getInstance());
            logInstance.addLog(log);
            logInstances.add(logInstance);
        } else {
            for (int i = 0; i < logInstances.size(); i++) {
                try {
                    if (logInstances.get(i).getInstance() == log.getInstance()) {
                        logInstances.get(i).addLog(log);
                        break;
                    } else {
                        Instance newInstance = new Instance(log.getInstance());
                        newInstance.addLog(log);
                        logInstances.add(newInstance);
                        break;
                    }
                } catch (Exception exception) {
                    System.out.println("Factory: Something went wrong when adding log");
                    System.out.println(exception);
                }
            }
        
        }
    }
      
    
}
