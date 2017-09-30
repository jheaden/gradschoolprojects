public class searchSongArray {
	
	public static void main(String[] args) {
		
		/* First, I create a sorted array of song names.
		* Some song names were obtained from: http://www.songname.net/
		**/
			
			String[] mySongList = {	
			"Annoyance On A Roll",
			"Bad Confidence",	
			"Carnage From Heaven", 
			"Creativity On A Rope",
			"Dawn Of The Weakness",
			"Death Of The Dynamite",
			"Fate On Ice",
			"Fake Showroom",
			"Gangly Joy",
			"Happy Star",
			"Honour Is Toying With Me",
			"It Sounds Like Courage",
			"Jealous Of My Criminal",
			"Knife Fight At The Gun Show",
			"Liberty Is The Enemy",
			"My Wooden Demon",
			"Nothing But A Revolt Sale",
			"Nuclear Moment",
			"Outrageous Doubt",
			"Progress Is Out To Trick You",
			"Quit Smelling My Hair",
			"Running Rings Around Thunder", 
			"Skill Robot",
			"Stop Messing With Elegance",
			"Trying To Control Leisure",
			"Unfinished Sensitivity",
			"Vintage Riot",
			"Waiting for Bagsy",
			"Xenophobic Landlord",
			"Zoological Desserts And More"
			};
		
		
		/*
		 * Next, I divide the array into thirds by computing the number 
		 * for the element of the array that is 1/3 of the way from zero
		 * and the number of the element that is 2/3 of the way from zero.
		 * This divides the array into the three parts of:
		 *   1. 0 through pivot1
		 *   2. (pivot1 + 1) through (pivot2 - 1)
		 *   3. pivot2 through the end of the array
		 *   
		 *   the compareTo() function compares two strings and returns 0 if they match, 
		 *   a negative number if the variable passed into the function is lower in the alphabet,
		 *   or a positive number if the variable string is higher in the alphabet.
		 *   The number returned corresponds to how far away the variable is from the string calling the function.
		 */
		
		int len = mySongList.length; // the size of my array is (conveniently) 30 elements
		// If len did not yield a multiple of 3, I would use fancy math functions to find the nearest whole numbers, of course

		int pivot1 = ((len / 3) - 1); // one third of the array = element 9. The '-1' is to account for the 0-based index
		int pivot2 = (2 * pivot1); // lazy way of getting the second pivot... element 18
		
	// Now that we have our array division concepts, let's do a comparison of the string to be found with each pivot
		String findme1 = "Skill Robot"; //this is what we are looking for
		
		int comparison1 = -1;
		int comparison2 = -1;
		
		comparison1 = findme1.compareTo(mySongList[pivot1]); 
		comparison2 = findme1.compareTo(mySongList[pivot2]);
		
		//DEBUG: Sanity check to make sure everything is running correctly
		//System.out.println("comp1:" + mySongList[comparison1]);	
		//System.out.println("comp2:" + mySongList[comparison2]);	
		
		
		/* If the song name to be found is the same as a pivot, 
		 * comparison1 or comparison 2 will be set to 0, which means that the
		 * index of the found song will be the item at the array element equal to the 
		 * pivot number. So let's get that out of the way...
		 */
		
		if (comparison1 == 0){
			System.out.println(findme1 + " is at position " + pivot1);
		}else if (comparison2 == 0){
			System.out.println(findme1 + " is at position " + pivot2);
		} else if (comparison2 + comparison1 > 29){
			System.out.println("-1");  // Return -1 if string not found
		}
		
		
		/* logic table
		 * 
		 *    comparison1 and comparison2 will be negative if the song is in partition 0 through pivot1-1
		 *    comparison1 and comparison2 will be positive if the song is in partition pivot2+1 through the end
		 *    comparison1 will be positive and comparison2 will be negative if the song is in the middle partition
		 *      (pivot1 + 1 through pivot2 - 1)
		 *    
		 *    if comparison1 is negative and comparison2 is positive, something has gone horribly wrong
		 *    
		 *    
		 *    comparison1 |    -    |    +    |    +    |
		 *    comparsion2 |    -    |    -    |    +    |
		 *                       pivot1     pivot2               
		 */   
		else if ((comparison1 < 1) && (comparison2 < 1)){ //comparison2 being negative is overkill, 
														  // because if comparison1 is negative, so is comparison2
			for (int i = 0; i < pivot1-1 ; i++){ // loop through the first partition of the array
				// reminder: a zero returned from compareTo() means that strings match
				int comparison3 = 0;
				comparison3 = findme1.compareTo(mySongList[i]); 
				if (comparison3 == 0){
					System.out.println(findme1 + " is at position " + (i + 1)); //another plus one to account for 0-based index
				}//end if
			}//end for
		
			
		}else if ((comparison1 > 1) && (comparison2 > 1)){ //if both are positive...
			for (int j = pivot2+1; j < len ; j++){ // search the third partition
				int comparison4 = 0;
				comparison4 = findme1.compareTo(mySongList[j]); 
				if (comparison4 == 0){    // reminder: a zero returned from compareTo() means that strings match
					System.out.println(findme1 + " is at position " + (j + 1)); //another plus one to account for 0-based index
				}//end if
			}//end for
		
		} else if ((comparison1 > 1) && (comparison2 < 1)){ 
			for (int k = pivot1+1; k < pivot2-1 ; k++){ // search the middle partition
				int comparison5 = 0;
				comparison5 = findme1.compareTo(mySongList[k]); 
				if (comparison5 == 0){  // reminder: a zero returned from compareTo() means that strings match
					System.out.println(findme1 + " is at position " + (k + 1)); //another plus one to account for 0-based index
				}//end if
			}//end for
		} 
	}
}
