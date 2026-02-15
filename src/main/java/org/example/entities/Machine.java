package org.example.entities;

public class Machine {
    private final String machineId;
    private final String[] capabilities;
    private JobHistory jobHistory;

    public Machine(String machineId,String[] capabilities){
        this.machineId=machineId;
        this.capabilities=capabilities;
        this.jobHistory=new JobHistory();
    }

    public String getMachineId() {
        return machineId;
    }

    public String[] getCapabilities() {
        return capabilities;
    }

    public JobHistory getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(JobHistory jobHistory) {
        this.jobHistory = jobHistory;
    }
}
