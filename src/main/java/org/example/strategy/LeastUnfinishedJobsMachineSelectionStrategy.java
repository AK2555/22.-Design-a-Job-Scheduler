package org.example.strategy;

import org.example.entities.Machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeastUnfinishedJobsMachineSelectionStrategy implements MachineSelectionStrategy{
    @Override
    public Machine findMachines(List<Machine> machines) {
        if(machines.size()==0){
            return null;
        }
        Collections.sort(machines,(a,b)-> {
            if ((a.getJobHistory().getPendingJobs().size()) != (b.getJobHistory().getPendingJobs().size())) {
                return (a.getJobHistory().getPendingJobs().size()) - (b.getJobHistory().getPendingJobs().size());
            } else {
                return a.getMachineId().compareTo(b.getMachineId());
            }
        });
        Machine machine=machines.get(0);
        return machine;
    }
}
