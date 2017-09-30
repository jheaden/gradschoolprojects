// **
//* Jill Headen
//* Design and Analysis of Algorithms 
//* CS627-1601B-01 Design and Analysis of Algorithms
//* Sept 2016
//**/

package swapArray;

public class swapArray {
	public static void main(String[] args) {
		/*Overview: Part One
		* Create arrays, fill them with ints by using a loop
		* Display the original array
		* Reverse the array
		* Display the reversed array
		 */
		//create an array with 10 elements
		int[] jillArray = {1,2,3,4,5,6,7,8,9,10}; 
		//tell the user what's up
		System.out.print("\n\nHere is the original array: ");
		
		// Display that array today... yay!
		for (int i=0; i < jillArray.length; i++){
			System.out.print(jillArray[i] + " ");
		}// end for()	
		
		//swap the array in-place
		// HERE IS THE ALGORITHM!
		    int len = jillArray.length;

		    for (int j = 0; j < len / 2; j++)
		    {
		        int temp = jillArray[j];
		        jillArray[j] = jillArray[len - j - 1];
		        jillArray[len - j - 1] = temp;
		    }
		   
			//tell the user what’s happening
			System.out.print("\n\nHere is the reversed array: ");
			// Display the reversed  array... 
			for (int i=0; i < jillArray.length; i++){
				System.out.print(jillArray[i] + " ");
			}// end for()
	} // end main()
}// end class
