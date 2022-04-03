import java.util.Scanner;

public class AnikRecursion {

    /**
     * method takes an input integer and checks to see how many times 7 is within that integer
     * @param input
     * @return occurence of number 7 within the input value
     */
    public static int sevenOccurance(int input) { //takes input
        if(input == 0) { // base case where if 0 is entered as next int, 0 is returned
            return 0;
        /* recursive case where mod 10 will see if the rightmost digit is 7
        * returns that occurence and will see if that trend continues if value is divided by 10 */
        } else if(7 == (input % 10)) {
            return (1 + sevenOccurance(input/10));
        /* else case will divide the input by 10 and repeat the loop to see if mod 10 will produce a seven/cycle until end is reached */
        } else {
            return (sevenOccurance(input/10));
        }
    }

    /**
     * method performs subtraction by decrementing by 1
     * @param i
     * @param j
     * @return value of subtraction
     */
    public static int recursiveSubtract(int i, int j) {
        //base case where if second value is 0, will return the first value(i)
        if(j == 0) {
            System.out.println(i);
            return i;
        //otherwise will decrement each value by one until the second value reaches 0 and will return the first value
        } else {
            return recursiveSubtract((i - 1), (j -1));
        }
    }

    public static void main(String[] args) {
        //TESTING SEVEN OCCURENCE
        int input;
        Scanner inputNumbers = new Scanner(System.in);

        System.out.println("Enter a positive integer value: ");
        input = inputNumbers.nextInt();

        System.out.println("The number 7 appears " + sevenOccurance(input) + " times");

        //TESTING RECURSIVE SUBTRACTION
//        int num1, num2;
//        Scanner inputNumbers = new Scanner(System.in);
//
//        System.out.println("Enter a number greater than 0");
//        num1 = inputNumbers.nextInt();//j
//
//        System.out.println("Enter another number greater than the first");
//        num2 = inputNumbers.nextInt();//i
//
//        recursiveSubtract(num2, num1);

    }
}
