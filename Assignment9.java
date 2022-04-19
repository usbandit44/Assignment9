// Assignment: Assignment9.java
// Name: Arvin Edouard
// StudentID: 1222200512
// Lecture: Tuesday Thursday 1:30 to 2:45
// Description: program that allows user to input something and find and change differnet things to that input

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.lang.model.element.Element;

public class Assignment9 {

    public static void main(String[] args) {
		
        int[] nums;// variable for array
        String input;// variables for filer reader
        int option;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);// reader file
            BufferedReader stdin = new BufferedReader(isr);
            do{
                printMenu();
                input = stdin.readLine().trim();// reads line and makes line a string
                option = Integer.parseInt(input);// makes line a int of switch

                switch (option){

                    case 1:// option one of finding largest
                        nums = parseInts(stdin);
                        int largestNum = largest(nums, 0, nums.length - 1);
                        System.out.print("The largest number in the array is: " + largestNum + "\n");
                        break;

                    case 2: // option 2 for product of all prime
                        nums = parseInts(stdin);
                        int prime = primeProducts(nums, 0, nums.length - 1);
                        System.out.print("The product of all prime numbers in the array is: " + prime + "\n");
                        break;

                    case 3: // option 3 for element with the largest sum of digits
                        nums = parseInts(stdin);
                        int biggestSum = largestSum(nums, 0, nums.length - 1);
                        System.out.print("The largest sum of digits in the array is: " + biggestSum + "\n");
                        break;
                    case 4: // option 4 remove adjacent dublicate in a string string
                        String userInput;
                        System.out.print("Please enter String:\n");
                        userInput = stdin.readLine().trim();
                        String anwser = remove(userInput, 0, userInput.length() - 1);
                        System.out.print("String after adjacent duplicate characters were removed: " + anwser + "\n");
                        break;

                    case 5:
                        break;
                    
                    default:
                        System.out.println("Please choose a number between 1 and 5.");
                        break;

                }
            } while (option != 5); // leave loop when 5 is inputed
        } catch (Exception e) {
            //TODO: handle exception
        }
	
    }


    // Utility method for printing the menu 
    public static void printMenu() {
        System.out.print("\nWhat would you like to do?\n\n");
        System.out.print("1: Find the largest number in an array of integers\n");
        System.out.print("2: Calculate the product of all prime numbers in an array of integers\n");
        System.out.print("3: Find the element with the largest sum of digits in an array of integers\n");
        System.out.print("4: Remove adjacent duplicate characters in a String\n");
        System.out.print("5: Quit\n\n");
    }

    // utility method for parsing integers from standard input
    public static int[] parseInts(BufferedReader reader) {
        String line = "";
        ArrayList<Integer> container = new ArrayList<>();
        try {
            System.out.print("Please enter integers:\n");
            line = reader.readLine();
            int num = Integer.parseInt(line);

            while (num > 0) {
                container.add(num);
                line = reader.readLine();
                num = Integer.parseInt(line);
            }

        } catch (IOException ex) {
            System.out.println("IO Exception");
        }

        int[] result = new int[container.size()];
         for(int i = 0; i < container.size(); i++){
             result[i] = container.get(i);
         }
        return result;
    }

    public static int largest(int[] list, int lowerIndex, int upperIndex){
        int max;
        if(lowerIndex == upperIndex){
            return lowerIndex;
        }else{
            max = largest(list, lowerIndex + 1, upperIndex);
            if(list[lowerIndex] >= max){
                return list[lowerIndex];
            }else{
                return max;
            }
        }

    }

    public static int primeProducts(int[] list, int lowerIndex, int upperIndex){
        int product = 1;
        if(lowerIndex == upperIndex && prime(list[lowerIndex])){
           return product * list[lowerIndex];
        }else if(lowerIndex == upperIndex && !prime(list[lowerIndex])){
            return product;
        }else{
            if(prime(list[lowerIndex])){
                return list[lowerIndex] * primeProducts(list, lowerIndex + 1, upperIndex);
            }else{
                return product * primeProducts(list, lowerIndex + 1, upperIndex);
            }
        } 

    }

    private static boolean prime(int num) {// helper method
        if(num < 1){
            return false;
        }
        if(num == 1 || num == 2){
            return true;
        }else{
            for(int i = 2; i < num; i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
        
    }

    public static String remove(String a, int lowerIndex, int upperIndex){
        String removed = a;
        if(lowerIndex == upperIndex){
            return removed;
        }else{
            if(removed.charAt(lowerIndex) == removed.charAt(lowerIndex + 1)){
                removed = removed.substring(0, lowerIndex) + removed.substring(lowerIndex + 1);
                upperIndex = upperIndex - 1;
                return remove(removed, lowerIndex, upperIndex);
            }else{
                return remove(removed, lowerIndex + 1, upperIndex);
            }
        }
    }

    public static int largestSum(int[] list, int lowerIndex, int upperIndex){
        int max;
        if(lowerIndex == upperIndex){
            return sumHelper(list[lowerIndex]);
        }else{
            max = largestSum(list, lowerIndex +1, upperIndex);
            if(sumHelper(list[lowerIndex]) >= max){
                return sumHelper(list[lowerIndex]);
            }else{
                return max;
            }
        }
    }

    private static int sumHelper(int a){// helpe
        int sum = 0;
        int num;
        if(a == 0){
            return sum;
        }else{
            sum = sum + a % 10;
            num = a / 10;
            return sum + sumHelper(num);
        }
    }
                                                                                                                               
}

