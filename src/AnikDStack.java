public interface AnikDStack {
    /**
     * method checks if a stack is empty
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * method adds a value to the top of the stack
     * @param d
     */
    public void push(double d);

    /**
     * method removes a value from the top of the stack
     * throws EmptyStackException if empty
     * @return
     */
    public double pop();

    /**
     * method returns top stack value but does not remove
     * throws EmptyStackException if empty
     * @return value at the top of the stack
     */
    public double peek();
}
