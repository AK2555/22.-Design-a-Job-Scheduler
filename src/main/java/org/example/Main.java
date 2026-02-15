package org.example;


public class Main {

    private static void printResult(String testName, String expected, String actual) {
        System.out.println(
                testName +
                        " | Expected: " + expected +
                        " | Actual: " + actual +
                        " | " + (expected.equals(actual) ? "PASS ✅" : "FAIL ❌")
        );
    }

    public static void main(String[] args) {

        System.out.println("===== TEST BLOCK 1 =====");

        JobScheduler scheduler = new JobScheduler();

        // Add Machines
        scheduler.addMachine("M1", new String[]{"Image compression","Audio Extraction"});
        scheduler.addMachine("M2", new String[]{"image compression","video THUMBNAIL generation"});
        scheduler.addMachine("M3", new String[]{"image compression","audio extraction","video thumbnail generation"});

        // job1
        printResult("job1",
                "M1",
                scheduler.assignMachineToJob("job1", new String[]{"image compression"}, 0)
        );

        // job2
        printResult("job2",
                "M3",
                scheduler.assignMachineToJob("job2", new String[]{"audio extraction"}, 0)
        );

        // job3
        printResult("job3",
                "M2",
                scheduler.assignMachineToJob("job3", new String[]{"video thumbnail generation"}, 0)
        );

        // job4
        printResult("job4",
                "M1",
                scheduler.assignMachineToJob("job4",
                        new String[]{"image compression","audio extraction"}, 0)
        );

        // Complete job1
        scheduler.jobCompleted("job1");

        // job5 (criteria = 1)
        printResult("job5",
                "M1",
                scheduler.assignMachineToJob("job5", new String[]{"image compression"}, 1)
        );

        // Complete job2 & job3
        scheduler.jobCompleted("job2");
        scheduler.jobCompleted("job3");

        // job6 (criteria = 1)
        printResult("job6",
                "M1",
                scheduler.assignMachineToJob("job6", new String[]{"image compression"}, 1)
        );

        // job7 (criteria = 0)
        printResult("job7",
                "M3",
                scheduler.assignMachineToJob("job7", new String[]{"audio extraction"}, 0)
        );

        // Complete job4 & job5
        scheduler.jobCompleted("job4");
        scheduler.jobCompleted("job5");

        // job8 (criteria = 1)
        printResult("job8",
                "M1",
                scheduler.assignMachineToJob("job8", new String[]{"audio extraction"}, 1)
        );

        // job9 (no machine matches)
        printResult("job9",
                "",
                scheduler.assignMachineToJob("job9", new String[]{"speech to text conversion"}, 0)
        );

        // Add A-machine (test trimming & case-insensitive)
        scheduler.addMachine("A-machine",
                new String[]{" Speech To Text Conversion ","Image Compression"});

        // job10
        printResult("job10",
                "A-machine",
                scheduler.assignMachineToJob("job10", new String[]{"speech to text conversion"}, 0)
        );

        System.out.println("===== TEST END =====");
    }
}

