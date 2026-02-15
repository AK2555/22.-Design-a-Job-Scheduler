package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JobHistory {
    private final String id;
    private List<Job> completedJobs;
    private List<Job> pendingJobs;

    public JobHistory(){
        this.id= UUID.randomUUID().toString();
        completedJobs=new ArrayList<>();
        pendingJobs=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Job> getCompletedJobs() {
        return completedJobs;
    }

    public void setCompletedJobs(List<Job> completedJobs) {
        this.completedJobs = completedJobs;
    }

    public List<Job> getPendingJobs() {
        return pendingJobs;
    }

    public void setPendingJobs(List<Job> pendingJobs) {
        this.pendingJobs = pendingJobs;
    }

    public void addToCompletedJobs(Job job){
        completedJobs.add(job);
    }

    public void addToPendingJobs(Job job){
        pendingJobs.add(job);
    }

    public boolean moveJobFromPendingToCompleted(String jobId){
        Job job=null;
        for(Job job1: pendingJobs){
            if(jobId.equals(job1.getJobId())){
                pendingJobs.remove(job1);
                job=job1;
                break;
            }
        }
        if(job==null){
            return false;
        }
        addToCompletedJobs(job);
        return true;
    }

}
