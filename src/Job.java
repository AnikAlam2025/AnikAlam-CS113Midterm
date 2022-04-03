//Job object class for job scheduler
//Making each job object a string about chores
public class Job {
    private String chore;

    /**
     * Constructor for Job, takes in a chore and creates a new Job object
     * @param chore
     */
    public Job(String chore) {
        this.chore = chore;
    }

    /**
     * Copy constructor for chore, checks if original data is valid and creates a copy
     * @param original
     */
    public Job(Job original) {
        if(original == null) {
            System.out.println("Null data given to job constructor");
        } else {
            this.setAll(original.chore);
        }
    }

    //Setters and getter for chore
    public void setChore(String chore) {
        this.chore = chore;
    }

    public void setAll(String chore) {
        this.setChore(chore);
    }

    public String getChore() {
        return chore;
    }

    public String toString() {
        return chore;
    }
}
