/****************************************************************************
 * Created by: Wendi Yu
 * Created on: Mar 23 2019
 * Created for: ICS4U
 * This program generates a list of 250 random values and sorts them. It then
 * 		allows the user to input a number and searches for that number in the
 * 		list
 ****************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class BinarySearch2 {
	public static void main(String[] args) { 
		
		Scanner userInput = new Scanner(System.in);
		Random range = new Random();
		//create array
		int[] values = new int[250]; 
		
		System.out.print("Generated values:\n");
		
		int randomNumber;
		
		//print random values
		for(int counter = 0; counter < values.length; counter++) {
			randomNumber = range.nextInt(550) + 1;
			values[counter] = randomNumber;
			System.out.println(randomNumber);
			
		}
		
		//print sorted values
		System.out.println("\nSorted values:");
		NumberSort(values);
		
		do {
			//get number to search for from user
			System.out.println("Enter a number from 1 to 550 to search in values(Enter -1 to exit the program): ");
			int userNumber = userInput.nextInt();
			
			//if the input is negative or greater than 550 
			if(userNumber < -1 || userNumber > 550) {
				System.out.print("\n Invalid.");
			}
			else if(userNumber == -1) {
				System.out.print("Thank You For Using!");
				System.exit(0);
			} 
			else {
				//searches for number
				String search = NumSearch(values, userNumber);
				System.out.print("\n" + search);
				break;
				
			}
			
		} while(true);
		
		//lets user add a number into sorted values list
		System.out.println("\nEnter a number you would like to add to the list: ");
		int userAdd = userInput.nextInt();
		
		//create new array with news numbers
		int[] newArray = new int[values.length + 1];
		
		int valuesArrayInd = 0;
		int newArrayInd = 0;
		
		//if the values in the old sorted array are less than the user input. Then, put them in the new array
		while(newArrayInd<newArray.length) {
			if(values[valuesArrayInd]<userAdd) {
				newArray[newArrayInd] = values[valuesArrayInd];
				newArrayInd ++;
				valuesArrayInd ++;
			}
			else {
				//user input in array
				newArray[newArrayInd] = userAdd;
				newArrayInd++;
				break;
			}
	
		}
		//put other values into new array after value of user input had put it in.
		
		while(newArrayInd<newArray.length) {
		newArray[newArrayInd] = values[valuesArrayInd];
		newArrayInd++;
		valuesArrayInd++;
		}
		
		//print new array with user input
		for(int counter = 0; counter < newArray.length; counter++) {
			System.out.println(newArray[counter]);
		}
	}
	
	public static void NumberSort(int array[]) {
		
		// sorts elements in array in numerical order 
		int arrLen = array.length;
		
		for(int nextNum = 0; nextNum < arrLen; nextNum ++) {
			for(int prevNum = 0; prevNum < arrLen; prevNum++) {
				if(array[nextNum] < array[prevNum]) {
					int sub = array[nextNum];
					array[nextNum] = array[prevNum];
					array[prevNum] = sub;
				}
			}
		}
		
		//prints out array
		for(int counter = 0; counter < arrLen; counter++) {
			System.out.println(array[counter]);
		}
	} 
	
	public static String NumSearch(int array[], int srchNum) {
		
		// searches for user number in array and returns whether or not number is found
		
		int lowInd = 0;
		int highInd = array.length - 1;
		int midInd;
		
		while(lowInd <= highInd) {
			
			//finds the middle value
			midInd = (lowInd + highInd)/2;
			
			//if number equal to the middle value
			if(srchNum == array[midInd]) {
				return "Found at " + (midInd+1) + "\n";
			} 
			//Changing lowIndex, if number is greater than the middle value then shorten the range
			else if(srchNum > array[midInd]) {
				lowInd = midInd + 1;
			} 
			//Changing highIndex, if number is less than the middle value then shorten the range
			else if(srchNum < array[midInd]) {
				highInd = midInd - 1;
			}
			// if number is not found
			else if(lowInd > highInd) {
				return "Not found.";
			}
			// Just in case something is not right, the program will crash
			else {
			}
		}
		return "Not found.";
	}
}
