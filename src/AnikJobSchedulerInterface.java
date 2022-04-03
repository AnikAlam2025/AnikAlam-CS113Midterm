public interface AnikJobSchedulerInterface {
    /**
     * Method inserts a Process at the rear end of the queue and will return true/false
     * @param newJob
     * @return true if the Process was added successfully, null if queue is empty
     */
    public boolean offer(Job newJob);

    /**
     * method removes a Process from the front of the queue and returns it if queue is not empty
     * throws a NoSuchElementException if empty
     * @return
     */
    public String remove();

    /**
     * method removes entry at front of queue and returns it
     * @return returns front entry, null if queue empty
     */
    public Job poll();

    /**
     * method returns Process at front of queue but does not remove it
     * @return Process at front of queue, null if queue is empty
     */
    public Job peek();


}
