/**
 * Determine smallest value within a stack, move that to top of the code
 * Create a method moveSmallestToTop to do so
 */

import java.util.EmptyStackException;
import java.util.Scanner;

public class AnikListNode implements AnikDStack{
    int val, size;
    Node next;

    /**
     * inner class to create nodes
     */
    private static class Node {
        double nodeData;
        Node nextNode;
    }

    //constructors

    /**
     * Empty constructor
     */
    public AnikListNode() {

    }

    /**
     * sets the value of this object to the input value
     * @param val
     */
    public AnikListNode(int val) {
        this.val = val;
    }

    /**
     * sets both the val and next node of this object to input parameters
     * @param val
     * @param next
     */
    public AnikListNode(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    /**
     * method will find the smallest value within the stack and move it to the top of the stack
     * rest of the stack should remain in the order it was in beforehand
     */
    private void moveSmallestToTop(AnikDStack newStack) {
        Node current = next, prev = null;
        double min = current.nodeData;

        if (!isEmpty()) { //if not empty, AND while next node not null, iterate through nodes to find min value
            //if min bigger than next node, set min to that smaller value and move current to next node + repeat
            while (current.nextNode != null) {
                if (min > current.nodeData) {
                    min = current.nodeData;
                }
                current = current.nextNode;
            }
            //pushes min value to the front of the stack
            push(min);
        } else {
            System.out.println("There is no data within the list");
        }
        System.out.println("Current minimum value is: " + min);
    }

    /**
     * method checks if a stack is empty
     *
     * @return true if stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return next == null;
    }

    /**
     * method adds a value to the top of the stack
     * @param d
     */
    @Override
    public void push(double d) {
        Node temp = new Node();

        temp.nodeData = d;
        temp.nextNode = next;
        next = temp;
        size++;
    }

    /**
     * method removes a value from the top of the stack
     * throws EmptyStackException if empty
     *
     * @return
     */
    @Override
    public double pop() {
        Node temp = new Node();

        if(isEmpty()) {
            System.out.println("No data within the list");
            throw new EmptyStackException();
        }
        temp.nodeData = next.nodeData;
        next = next.nextNode;
        size--;
        return temp.nodeData;
    }

    /**
     * method returns top stack value but does not remove
     * throws EmptyStackException if empty
     *
     * @return value at the top of the stack
     */
    @Override
    public double peek() {
        if (isEmpty()) {
            System.out.println("No data within the list");
            throw new EmptyStackException();
        }
        return next.nodeData;
    }

//Writing a main method to allow a user to push, peek, and pop values into a linked list
//After each input, the list will be sorted and move the smallest value to the top of the stack
    public static void main(String[] args) {
        AnikListNode LinkedListStack = new AnikListNode();
        double input = 0, minVal;

        Scanner menu = new Scanner(System.in), userDouble = new Scanner(System.in);

        while(input != 4) {
            System.out.println("1) Enter new value\n2) View value at top of stack\n3) Remove value at top of stack\n4) Exit");
            input = menu.nextDouble();

            switch((int) input) {
                case 1:
                    System.out.println("Enter double value");
                    input = userDouble.nextDouble();
                    LinkedListStack.push(input);
                    System.out.println("Input value: " + LinkedListStack.peek());
                    if(LinkedListStack.size > 1) {
                        LinkedListStack.moveSmallestToTop(LinkedListStack);
                    }
                    break;
                case 2:

                    System.out.println(LinkedListStack.peek());
                    break;
                case 3:

                    System.out.println("Double Removed: " + LinkedListStack.pop());
                    System.out.println("Value at head: " + LinkedListStack.peek());
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }
}
