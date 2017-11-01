/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingsearchingruntime;

/**
 *
 * @author ratid6445
 */
public class SortingSearchingRuntime {

    public void swap(int[] array, int p1, int p2) {
        // swap positions of values
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;

    }

    public void selectionSort(int[] array) {
        // keep track of which position we are sorting
        for (int position = 0; position < array.length; position++) {
            // create an integer that stores the position of the smallest number
            int smallerNumber = position;
            // go through looking for a smaller number
            for (int i = position + 1; i < array.length; i++) {
                // if a smaller number is found
                if (array[i] < array[smallerNumber]) {
                    smallerNumber = i;
                }
            }
            // swap numbers and make sure it is the smallest number
            swap(array, smallerNumber, position);
        }
    }

    public int smallestMissingNumber(int[] array) {
        // create a for loop to go through the numbers of the array in certain positions
        for (int i = 0; i < array.length; i++) {
            // look to see if the number next to the certain value is one bigger
            // do this by seeing if the numbers are the same when adding one to the first position
            if (array[i] + 1 != array[i + 1]) {
                // if it's not the same return the missing number
                return array[i] + 1;
            }
        }
        return -1;
    }

    public int countOnes(int[] array, int position) {
        // if the array length is equal to the position length
        if (array.length == position) {
            return 0;
        }
        // see if the number in the array is 1
        if (array[position] == 1) {
            // add 1 each time you find 1
            return 1 + countOnes(array, position + 1);
        } // if the number is not one
        else {
            // go to the next position and add nothing
            return 0 + countOnes(array, position + 1);
        }
    }

    public void countingSort(int[] trackerArray) {
        // keep track of how many times a number appears in the array
        int frequency = 0;
        // make an array of 101 numbers to keep track of the position
        int[] position = new int[101];
        // sort through array
        for (int i = 0; i < trackerArray.length; i++) {
            frequency = trackerArray[i];
            // increase counter each time
            position[frequency] = position[frequency] + 1;
        }
        // make two values to swap and keep track of positions
        int value1 = 0;
        int value2 = 0;
        // sort through array 
        while (value1 < trackerArray.length) {
            // make sure the value is greater than 0
            if (position[value2] > 0) {
                // set the array position to value position
                trackerArray[value1] = value2;
                // subtract one from array value
                position[value2]--;
                // move to next position
                value1++;
            } else {
                // if the value is 0 go to the next value
                value2++;
            }
        }
    }

    public void insertionSort(String[] word) {
        // start going through the array
        for (int i = 0; i < word.length - 1; i++) {
            // store position
            int position = i;
            // check values beside each other
            while (position >= 0 && word[position].compareTo(word[position + 1]) > 0) {
                // if out of place start swapping downwards
                // until correct position is reached
                swapWord(word, position, position + 1);
                // move downwards and keep checking
                position--;
            }
        }
    }

    public void swapWord(String[] array, int p1, int p2) {
        // swap positions of words
        String temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;

    }

    private void print(String[] wordScramble) {
        // print out the words in alphabetical order
        for (int i = 0; i < wordScramble.length; i++) {
            System.out.println(wordScramble[i] + ", ");
        }
        System.out.println(" ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortingSearchingRuntime test = new SortingSearchingRuntime();

        // making a random array of ints
        int[] numbers = new int[101];
        for (int i = 0; i < 101; i++) {
            // make a random number
            numbers[i] = (int) (Math.random() * 101);
        }
        System.out.println("BEFORE:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        //SORT HERE
        // test counting sort
        test.countingSort(numbers);
        // test selection sort
        test.selectionSort(numbers);


        //AFTER
        System.out.println("AFTER:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // test smallestMissingNumber
        int[] array1 = {0, 1, 2, 4, 5, 7, 10};
        int p = test.smallestMissingNumber(array1);
        System.out.println(p);

        // test countOnes
        int[] array2 = {0, 1, 1, 1, 1, 1, 0, 0, 1};
        int n = test.countOnes(array2, 0);
        System.out.println(n);

        // test insertaion sort
        String[] array = {"coop", "dog", "chicken", "eat"};
        System.out.println("BEFORE: ");
        test.print(array);
        System.out.println("AFTER: ");
        test.insertionSort(array);
        test.print(array);
    }
}
