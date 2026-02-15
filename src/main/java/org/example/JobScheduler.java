package org.example;

import org.example.entities.Job;
import org.example.entities.Machine;
import org.example.factory.StrategyFactory;
import org.example.strategy.MachineSelectionStrategy;
import org.example.util.CompatibleMachineService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobScheduler {

    private List<Machine> machines;
    private Map<String,Machine> jobMachineMap;
    private CompatibleMachineService compatibleMachineService;

    public JobScheduler() {
       machines=new ArrayList<>();
       jobMachineMap=new HashMap<>();
       compatibleMachineService=new CompatibleMachineService();
    }

    public void addMachine(String machineId, String[] capabilities) {
        for(int i=0;i<capabilities.length;i++){
            capabilities[i]=capabilities[i].toLowerCase();
        }
         Machine machine=new Machine(machineId,capabilities);
        machines.add(machine);
    }

    public String assignMachineToJob(String jobId, String[] capabilitiesRequired, int criteria) {
       MachineSelectionStrategy strategy= StrategyFactory.getStrategy(criteria);
       if(strategy==null){
           return "";
       }
       List<Machine> list=compatibleMachineService.findCompatibleMachine(machines,capabilitiesRequired);
        Machine machine=strategy.findMachines(list);
        if(machine==null){
            return "";
        }
        Job job=new Job(jobId,capabilitiesRequired);
        machine.getJobHistory().addToPendingJobs(job);
        jobMachineMap.put(jobId,machine);
        return machine.getMachineId();

    }

    public void jobCompleted(String jobId) {
        Machine machine=jobMachineMap.get(jobId);
        machine.getJobHistory().moveJobFromPendingToCompleted(jobId);
    }
}
