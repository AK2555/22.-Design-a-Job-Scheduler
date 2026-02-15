package org.example.util;

import org.example.entities.Machine;

import java.util.ArrayList;
import java.util.List;

public class CompatibleMachineService {


    public List<Machine> findCompatibleMachine(List<Machine> machines,String[] requiredCapabilities){
        List<Machine> res=new ArrayList<>();
        for(Machine machine: machines){
            if(isCapable(machine,requiredCapabilities)){
                res.add(machine);
            }
        }
        return res;
    }

    private boolean isCapable(Machine machine, String[] requiredCapabilities) {
        String[] capabilities =machine.getCapabilities();
        for(String str: requiredCapabilities){
            boolean found=false;
            for(String str1: capabilities){
                if(str.toLowerCase().trim().equals(str1.toLowerCase().trim())){
                    found=true;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }


}
