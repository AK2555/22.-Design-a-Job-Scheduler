package org.example.entities;

public class Job {
    private final String jobId;
    private String[] requiredCapabilities;

    public Job(String jobId, String[] requiredCapabilities) {
        this.jobId = jobId;
        this.requiredCapabilities = requiredCapabilities;
    }

    public String[] getRequiredCapabilities() {
        return requiredCapabilities;
    }

    public void setRequiredCapabilities(String[] requiredCapabilities) {
        this.requiredCapabilities = requiredCapabilities;
    }

    public String getJobId() {
        return jobId;
    }
}
