package cwone;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class cwone {
	final static int LIMIT= 100;//Static limit for arrays
	static int faCount = 1; // fillArray count
	public static void main(String[] args) {
		//Empty arrays initialised with LIMIT of 100 
		int arrayOne[] = new int[LIMIT];
		int arrayTwo[] = new int[LIMIT];
		fillArray(arrayOne);
		fillArray(arrayTwo);	
		int data1[] = userData(arrayOne);
		int data2[] = userData(arrayTwo);
		if (data1.length>0 || data2.length>0) {//only runs rest of the code if array is not empty
		int similar[] = displayElements(arrayOne,arrayTwo);
		System.out.println("Values for array 1 is: " + Arrays.toString(data1));
		System.out.println("Values for array 2 is: " + Arrays.toString(data2));
		System.out.println("Common data is: " + Arrays.toString(similar));
		System.out.println("Number of Common data is: " + similar.length);
		int uni1[]= uniElements(data2, data1);
		int uni2[] = uniElements(data1, data2);
	    System.out.println("Number of unique data for array one is: " + Arrays.toString(uni1));
	    System.out.println("Number of unique data for array two is: " + Arrays.toString(uni2));
		}
		else{
			System.out.println("both arrays are empty");
		}
	}
	//method for data entry
	public static void fillArray(int[] arr){
		Scanner reader = new Scanner(System.in);
		int n;
		for(int i =0; i < arr.length; i++){
			boolean dup = false;
			System.out.println("Enter data for array" + faCount +" (0 to finish): ");
			n = reader.nextInt();
			if (n == 0){
				break; //exits if 0 is entered
			}
			for(int c = 0; c < arr.length; c++){
				if (arr[c]==n){
					System.out.println(n + " already exists");
					dup = true;
					i--;//if duplicate goes back to previous element with valid number
				}
			}
			if(dup != true){
				arr[i] = n;//enters data only if data is unique
			}
		}
		faCount++;
	}
	//method for common numbers, could merge with method for unique numbers.
	public static int[] displayElements (int [] arr1, int[] arr2){
		List<Integer> simi = new ArrayList<Integer>();
		for(int i : arr1){
			for(int c = 0; c < arr2.length; c++){
				if (arr2[c] != 0){
					if( i==arr2[c]){
					simi.add(i);
					}
				}
			}
		
		}
		//converts list to int Array
		int[] ret = new int[simi.size()];
	    int i = 0 ;
	    for (Integer e : simi) { 
	        ret[i] = e.intValue();
	        i++;
	    }
	    return ret;
	}
	//method to remove unused 0 from user input. can be merged with method for data entry.
	public static int[] userData (int []arr1){
		List<Integer> ud = new ArrayList<Integer>();
		for(int d = 0; d < arr1.length; d++){
				if (arr1[d] != 0){
					ud.add(arr1[d]);
					}
				}
		//converts list to int Array
		int[] ret = new int[ud.size()];
	    int i = 0;
	    for (Integer e : ud) { 
	        ret[i] = e.intValue();
	        i++;
	    }
		return ret;
	}
	//method for unique numbers between both arrays
	public static int[] uniElements (int [] arr1, int[] arr2){
		
			List<Integer> simi = new ArrayList<Integer>();
			for(int i : arr2){//int i = 0; i < arr1.length; i++
				boolean unique = true;
				for (int c : arr1){
					if( i == c){
						unique = false;//only true if data is unique
						}	
				}
				if(unique == true){
					simi.add(i);
				}
				
			}
			//converts list to int Array
			int[] ret = new int[simi.size()];
		    int i = 0 ;
		    for (Integer e : simi) { 
		        ret[i] = e.intValue();
		        i++;
		    }
		    return ret;
		}
	}		
