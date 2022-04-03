import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AnikJobScheduler{
    /* Implementing a queue using an array because it is First in First out, new job added below existing ones so that the oldest remains at the top
    * and is taken out first */
    private static int front, rear, capacity, size;
    ArrayList<Job> jobSchedule;

    /**
     * Constructor creating a new arraylist
     * @param
     */
    public AnikJobScheduler() {
        jobSchedule = new ArrayList<>();
    }

    /**
     * Adds new job process to the system
     * @param inputJob
     */
    public void addProcess(Job inputJob) {
        jobSchedule.add(inputJob);
        System.out.println(inputJob + " was added to the schedule.");
        System.out.println("Current Task: " + jobSchedule.get(front));
    }

    /**
     * Gets the next job and adds this job back to the system If no other jobs exist, this job is sent back
     * @return job that was added in place of the original
     */
    public Job switchProcess() {
        if(jobSchedule.size() > 1) {
            Job replacedJob = jobSchedule.get(0);
            jobSchedule.remove(replacedJob);
            jobSchedule.add(replacedJob);

            System.out.println(replacedJob + " was replaced with " + jobSchedule.get(front) + " and was sent to the back");
            System.out.println(jobSchedule);
            return jobSchedule.get(front);
        } else {
            throw new NoSuchElementException("There is no other job to switch to");
        }
    }

    /**
     * Previous job finished, this method is used to get next process if no other process then returns null
     * @return
     */
    public Job getNextProcess() {
        if(jobSchedule.size() > 1) {
            System.out.println(jobSchedule.get(front) + " has been completed, moving to next task.");
            jobSchedule.remove(front);
            System.out.println("Current new job is: " + jobSchedule.get(front));
        }
        System.out.println("No next job is available");
        return null;
    }


    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     */
    public Iterator iterator() {
        return null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        AnikJobScheduler testJobScheduler = new AnikJobScheduler();

        testJobScheduler.addProcess(new Job("Buy Milk"));
        testJobScheduler.addProcess(new Job("Buy Vegetables"));
        testJobScheduler.addProcess(new Job("Wash Car"));

        testJobScheduler.getNextProcess();

        testJobScheduler.switchProcess();
    }
}
