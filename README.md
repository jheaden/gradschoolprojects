This is the final paper I turned in for the course, complete with APA-style references.


CS627-1601B-01 
Design and Analysis of Algorithms
All Previous Assignments, Feedback Updates, and IP5 Key Assignment with Sudoku Solver
Jill Headen
Colorado Technical University
September 2016


IP1: In-Place Array Reversal Algorithm
Part One: Algorithm Prototype in Java
This is a simple prototype version of an in-place order reversal algorithm implemented in Java. This algorithm will take as an input an array of integers and will reverse the order of the elements in the array, in place (essentially using only the memory in the array). 
/**
* Jill Headen
* Design and Analysis of Algorithms 
* CS627-1601B-01 Design and Analysis of Algorithms
* IP1 - 
**/

package test;
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

 
 

Part Two: Analyze Worst-Case Time Complexity and Space Complexity
Here is my analysis of the time complexity and space complexity of my algorithm in the worst case. 
The algorithm is:
		    int len = jillArray.length;

		    for (int j = 0; j < len / 2; j++)
		    {
		        int temp = jillArray[j];
		        jillArray[j] = jillArray[len - j - 1];
		        jillArray[len - j - 1] = temp;
		    }


Time Complexity: the number of steps for each line of code, and the total lines executed as a mathematical expression where n is the size of the input array. I followed the example of how to calculate this according to the Algorithm Analysis chapter of the textbook: Algorithm Design and Applications. 
Algorithm code	Time complexity calculations for each line
int len = jillArray.length;	The length of the array is calculated 
(Constant = 1)
for (int j = 0; j < len / 2; j++){	FOR loop – runs n times
int temp = jillArray[j];	A temporary integer is created to hold an element of the array. This will happen once for every iteration, making it another Constant (1).
jillArray[j] = jillArray[len - j - 1];	Value is assigned (C = 1)
    jillArray[len - j - 1] = temp;
}	Value is assigned (C = 1)
Total:	(1 + 1 + 1) * (n)
= 3(n)
= O(n)

 
Space complexity: an expression of the number of memory locations and components that are required for the algorithm in the worst case.
Algorithm code	Space complexity calculations for each line
int[] jillArray = {1,2,3,4,5,6,7,8,9,10};	n ints
int len = jillArray.length;	1 int
for (int j = 0; j < len / 2; j++){	1 int 
int temp = jillArray[j];	1 int
jillArray[j] = jillArray[len - j - 1];	0
    jillArray[len - j - 1] = temp;
}	0
Total:	O(n)

Answer: After receiving the feedback from Professor Dave that “the run time is a linear expression that has a time complexity of O(n) and space complexity of O(n),” I redid my calculations and edited my tables above. 
 
Part Three: Find and Plot True Runtime of Various Sizes of n
For the analysis of the runtime of my algorithm, I found an example of a timer in the O’Reilly Java Cookbook on page 776 and modified it quite a bit. The author, Ian Darwin, also got a range of values for his timing tests, so I did not worry too much about getting different values when I ran the program and timed it.
		//Create a variable to hold the different values of n
int n = 1500;
		
		//create an array with n elements
		int [] array_N = new int[n];

		
		for (int i = 0 ; i < array_N.length ; i++){
			array_N[i] = i+1;
		}
		
		//START THE TIMER
		long start3 = System.nanoTime();
		  
		//swap array of 1500 in-place
		    int len3 = array_N.length;
		    for (int k = 0; k < len3 / 2; k++)
		    {
		        int temp3 = array_N[k];
		        array_N[k] = array_N[len3 - k - 1];
		        array_N[len3 - k - 1] = temp3;
		    }
		    
		//STOP THE TIMER
		long stop3 = System.nanoTime();

		//compute run time
		float runTime3 = ((stop3 - start3) / 1000.00f);
		
		System.out.println("Time: " + runTime3);


 
Sizes of n
When I ran the program more than once, I got different timer values for each value of n. So, I ran the program 5 times and calculated and plotted the average time for each value of n.
For n = 500, there was a consistent deviation of 10.868 nanoseconds. For n=1500, the deviation was 33.81 nanoseconds. For n = 2500, the deviation was 52.526 nanoseconds.

Values of n	Range of time in nanoseconds	Average
500	14.489
15.094
15.697
23.456
25.357	18.8186
1500	42.866
43.469
44.074
67.62
76.676	54.941
2500	70.035
71.242
87.544
115.92
122.561	93.4604

 

Cartesian plotting for values of n

 
 
IP2: Divide (in Thirds) and Conquer
Part One: Ternary Search
This is a ternary search algorithm that searches a sorted list of strings for a particular song. If the song is found, the index of the song is returned. Otherwise, -1 is returned. 
This is the beginning of the Java code.
______________________________________________________________________
public class searchSongArray {
	
	public static void main(String[] args) {
		
		/* First, I create sorted array of song names.
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
		String findme1 = "aaa";
		
		int comparison1 = -1;
		int comparison2 = -1;
		
		comparison1 = findme1.compareTo(mySongList[pivot1]); 
		comparison2 = findme1.compareTo(mySongList[pivot2]);
		
//		System.out.println("comp1:" + comparison1);	
//		System.out.println("comp2:" + comparison2);	
		
		
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
			System.out.println("-1");  // This is the KLUGE to make the system return -1 if string not found
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
____________________________________________________________________________
That is the end of the Java code. 

Part 2
•	What is the time complexity (in Big-O notation) of your algorithm with respect to the size of the playlist?  
The simplest answer I found is in the title of an article on www.quora.com: Why don't we use ternary search even though the algorithm complexity (O(logn/log3)) is better than binary search complexity (O(logn/log2))? 
For another opinion, page 398 of the Goodrich text states: 
“We can represent any algorithm for searching a sorted array by three-way comparisons with a ternary decision tree …. For an array of n elements, all such decision trees will have 2n + 1 leaves (n for successful searches and n + 1 for unsuccessful ones). Since the minimum height h of a ternary tree with l leaves is ⌈log3 l⌉, we get the following lower bound on the number of worst-case comparisons: Cworst(n) ≥ ⌈log3(2n + 1)⌉       (Goodrich 2015).”
Therefore, the final answer is: O(logn/log3)
•	How does this time complexity compare to the time complexity of binary search (in terms of Big-O)? 
Mark Gordon’s answer to the question I mentioned before on www.quora.com is: 
“While everyone is correct in saying that constant factors do not matter in big Oh notation and that n-ary searches require more comparisons, ternary searches in fact require log1.5(n) (or log(n)/log(1.5)) iterations.  Each iteration your search space shrinks by a factor of 23 so it should be obvious it will take more iterations than a binary search which reduces the search space by 12.”
 
IP3 Greedy Disk Drive Utilization

Part 1
This is a greedy algorithm that efficiently transfers media to storage devices and results in a minimum of unused disk space.
Inputs: 
Variables	Values	Considerations
n files	f1 through fn	Sorted LARGEST to SMALLEST
f1 > fn
file sizes (in MBs) 	s1 through sn	
m disks, 	d1 through dm	Sorted LARGEST to SMALLEST
d1 > dm
disk storage amounts	t1 through tm	
•	The algorithm should return an array map[i] which contains the disk index of which the ith media file should be stored.
When I do a project, first I make sure it’s worth my efforts by doing a sanity check:
I would start by taking stock of the file sizes to see if all of the media files can be stored on one disk – and not just the largest disk. Is the sum of all of the file sizes (s1 through sn) smaller than any of the disk storage amounts (t1 through tm)?
//begin pseudocode
variable x = sum(s1,… sn)
	for (loop through array of disk sizes starting with the smallest disk size) {
		compare x to the disk size
		if x < disk size then hooray! We can put all files on that one disk and go home
} 
else
	go on to the next part where we actually use the algorithm
} //end pseudocode
If so, then transfer all of the files onto the smallest disk that can contain them and return the remaining disks. 
If all files will not fit on one disk, then make sure that the sum of all file sizes is not larger than the sum of all of the disk files. Because if we need more than the number of disks we have, then it’s pointless to do this.
For the purpose of the assignment, let’s say that the total size of all of the files is greater than the largest disk size, but smaller than the total amount of disk spaces all added together.
This is a refresher of the terms…
Variable	Values	Considerations
n files	f1 through fn	Sorted LARGEST to SMALLEST
f1 > fn
file sizes (in MBs) 	s1 through sn	
m disks, 	d1 through dm	Sorted LARGEST to SMALLEST
d1 > dm
disk storage amounts	t1 through tm	


Start by putting the largest file on the largest disk.
//map[0] says that d1 holds f1
map[0]: d1 => f1;
//Compute remaining file size of d1 => d1’s original size minus the size of f1: 
d1_remaining_size =  (t1 – s1);
//if d1_remaining_size is larger than the next largest file (f2) then put that file on d1
if (d1_remaining_size > f2){
map[1] = d1 =>f2;
//and then calculate the remaining size on d1
d1_remaining_size = (t1 – s2)
//then loop back up and do it all again on the next largest file
} else if {
// if f2 is too large to fit on d1, then put it on d2 
//compute the remaining size on d2
calculate the remaining file size on d1…
The algorithm continues, trying to fit each file into the remaining disk space of the largest disk until it fits somewhere. When there are no more files left, the program ends.

Pseudocode Summary
//Create hashmap that relates disk numbers [numbered 0 through m] to the array of songs each will contain
Initialize map[i] of integers
//Array of songs is sorted according to size, in non-increasing order
// Initialize loop to go through song array
//Loop structure starts at 0, which is the largest song in the array.
 For (i=0 ; i <filearray.length ; i++)
//compare size of song[i] with size of disk[i]
If song[i].size > disk[i].remainingsize
Then
Push song[i] onto array corresponding to map[i]
Else
	Push song[i] onto array corresponding to map[i+1]

Part 2
•	Discuss the optimality of your algorithm. Is it guaranteed to return an optimal result?
No. The algorithm takes the next smallest file and moves it wherever it fits starting with the largest disk. There is a possibility that the next file size to be processed could fill the remaining space exactly, but that would require extra loops of time to calculate and compare that instead of just greedily shoving the current file into the best spot for it.
•	What is the Big-O time complexity of this algorithm in terms of m and n? Justify your answer. 
The Big-O of the solution is O(nm + nlogn) (Dave, 2016)
The first few loops through the process, files have plenty of room available and the algorithm does not have to look at every disk, but later on, as the disks get full, files might have to be compared to every remaining disk size until a large enough spot is found. Because most of the n files are being compared with the remaining space on m disks, the first part of the runtime is O(n times m). Also, because the n files are sorted and presented in an optimized way, the second part of the runtime is O(nlogn) – yielding a final runtime of O(nm + nlogn). I only reached this conclusion after reviewing the feedback from Professor Amit Dave and redoing my calculations. 
Part 3
•	If you were to solve this problem using a brute force or exhaustive search method, what would be the time complexity? Justify your response. 
After reading Justin Abrahms’s Web page about calculating Big-Oh notation I know that to test every file size combination with every other file size on every disk size would take O(nm) runtime. By the time it was done, disk space would be pennies per Terabyte and it would cost more in electricity to run the processor than to just shove all the files onto a cloud server somewhere and let them be someone else’s problem, to paraphrase Ken Grohe (2013). 
IP4: Binary 2-D Array Image comparison
This algorithm compares two 2-D int arrays that are assumed to be 2 black-and-white images. The algorithm will compare x to the y, row-by-row, as defined below. My algorithm will employ a dynamic programming scheme to compare X to Y identifying the minimal difference between each row. 
Begin pseudocode
function imageCompare(array x, array y, int thresh){
      define array D[0][0]; //distance matrix that will be returned
//compare array X to array Y
	for (each row of elements in x and y){
//subtract the values of the corresponding elements of the two arrays, because if both values are the same, then diff == 0
	diff = x[current_element] – y[current_element];
	//push diff onto the distance matrix D…
D.push(diff);
//after reaching the end of the row, call the function to check whether it’s worth it to look at the next row
Function keepGoingOrNot{
	//Sum all of the elements of D
For (all elements of D) {
Current_sum += D[current element].value;

	//Compare the sum to “thresh”
	If (current_sum > thresh){ //if thresh is exceeded…
		End function, return message to user “images are different”
	} Else {
		Call the next row of X and the next row of Y and try again
	}
	
End pseudocode
Discuss the optimality of the dynamic programming solution. Discuss the time complexity of this algorithm in terms of the size of the inputs X and Y.
If the images are similar, then the algorithm will compare every element of every row of X and Y. Otherwise, it quits as soon as Thresh is exceeded.
 
IP 5 Key Assignment – AI Sudoku Solver
This project is the conceptual design of an artificial intelligence agent that will complete a Sudoku game, given any starting state of the game. 
Given the rules for the game as given on the www.sudoku.com website, these are the terms I will use:
Square: one of the 81 solved or unsolved units of the 9 by 9 Sudoku board that can contain one digit. Each unsolved square has the potential of containing digits 1 through 9. 
Row: a horizontal collection of squares that can contain only one of each digit ranging from 1 through 9.
								
								
								
								
								
								
								
								
								

Column: a vertical collection of squares
								
								
								
								
								
								
								
								
								

 
Box: one of the 3 X 3 collections of squares
								
								
								
								
								
								
								
								
								

State Space
•	Describe how you plan to search for the Sudoku solution given a starting state.
An easy-level Sudoku game has about 50% of the 81 squares on the board “solved” – meaning that the squares of the board contain only one integer that is not present in the row, column, or box that contains that solved square. 
The unsolved squares each have the potential of containing any of the numbers that are not present in the rows, columns, or boxes that contain them. As more squares are solved, this reduces the potential of the other squares until only one logical solution for each square of the board exists. Therefore, I consider each of the unsolved squares to contain an array of potential answers.
•	Clearly define your state space here: What does a vertex in your state traversal tree represent? 
A vertex represents a square in the board, either solved or unsolved. As each vertex is visited, the values of the solved vertices must be remembered and compared to the unsolved vertices, so that the values of the solved ones can be removed from the “potential solution” pool of the unsolved vertices. The edges of the state traversal tree represent the shapes that must be searched according to the rules of Sudoku: row, column, and box. The algorithm must start from each unsolved vertex and traverse the three shapes (row, column, and box) and compare each of the vertices along the path to what is contained in the original vertex. If a match is found, that potential integer is removed from the array of potential answers. When only one element of the array of potential remains, the original vertex changes from an unsolved to solved state.

Part 2b: Traversal Time Complexity
•	Assuming you were to naively traverse your state space, what is the upperbound time complexity (in terms of Big-O) of a brute force searching algorithm?
An algorithm working on a Sudoku game with 40 of the 81 squares solved would need to compare each of the 41 unsolved squares to each of the squares in each of the structures that contain the values that must be compared to the original square. Each of the three structures has 8 squares that contain either a solved square or another array of potential values because each structure contains 9 digits, because the algorithm should be smart enough not to compare the starting square to itself. In the worst case, if the value that causes the original square to change to a solved state is not found until the last square of the last structure, then the algorithm is making 41 x ( 3 x 8 ) comparisons.

•	Present this result in terms of n and p where nxn is the size of the Sudoku board and p is the number of possible numbers (1–9) permitted in a square. 
Given that nxn is the size of the board, and that 50% of the squares will start in a solved and will not need to be a starting point of the algorithm, nxn/2 is the size of the board.
Therefore the number of possible entries (p) being compared to about half of the squares in the board given in terms of p and n would be: p[(n-1) x (n-1)] / 2
Part 2c: Heuristic Search
•	What type of heuristic search would you employ to search this state space in hopes to reduce the search time?
According to Dave Marshall: “A heuristic is a method that 
•	might not always find the best solution 
•	but is guaranteed to find a good solution in reasonable time.” (Marshall 1997)
According to the Mathematics department at Cornell University: “A well-formed Sudoku puzzle is one that has a unique solution.” (Cornell, n.d.) 
Therefore, I could argue (but I know I should not) that applying heuristic techniques to a problem that requires one unique solution might not be the best practice, unless I am doing so in an attempt to better understand heuristic techniques. Which, given that this is an algorithm class, I am.
I could apply the Greedy Algorithm and simply insert a value into the unsolved square and then backtrack later if the value is proved to be an inaccurate possibility. 

•	Think about the problem and how you might search this state-space tree. 
I would apply my original “brute force” solution, rather than a heuristic one, but I would add another part to the algorithm that searches each of the columns, rows, and boxes to find structures that have 8 of their 9 squares solved. This is how I approach Sudoku games when I have the luxury of being a human who can scan the contents of the board as a whole. I look for the “easy ones” and solve those first. 
Part 2d: Pseudocode
•	Create pseudocode that finds the solution to a Sudoku game using a brute force search or using your heuristic discussed above. To simplify this task, assume that you have standard data structures available to you, such as stacks and queues. 
I am pseudocoding the solution that is closest to how I approach a Sudoku game, and I am assuming that it would be considered a “brute force” approach.
 
Pseudoku
// Initialize 9 x 9 array of arrays. This is the “Grid of Potential.” 

//outer loop defines the rows
	for (i = 0 ; i < 9 ; i++){

		//inner loop defines the columns
		for (j = 0 ; j < 9 ; j++){
			Grid[j] = [1, 2, 3, 4, 5, 6, 7, 8, 9]; //put an array in each square
		}
	}

//Load game 
// Grid of Potential is subjected to a loop
// that replaces arrays of potential  integers with solved values

for (elements of Grid){
	if (Grid[elements] == Sudoku_Game[solved_value]){
		Grid[elements]== solved;
	} else {
		go to next Grid element ;
	}
}

//Define search pattern shapes
// row

function search_row(Grid[element]){
	//seach the rest of the elements in the row	

}

// column

function search_column(Grid[element]){
	//seach the rest of the elements in the column	

}

// box

function search_box(Grid[element]){
	//seach the rest of the elements in the box	
	//the direct way is to define a box with a Case statement
	case (Grid[element]){
	//look for which one of the 9 boxes on the board 
	//contains the coordinates of the Grid element being searched

	}
}

//Loop through the Grid until you find an unsolved square
//pass the coordinated of the unsolved square to each of the search pattern shapes
//when a match is found, remove that element from the unsolved element's array and check to //see how many elements the array contains
//When the array contains only 1 element, then the square is considered "solved"

for (elements of Grid){
	if (current element != solved){
	   search_row(element);
	   search_column(element);
	   search_box(element);
	}
}
}//end Pseudoku

 

References

Abrahms J. (n.d.). Big-O notation explained by a self-taught programmer. Retrieved from: https://justin.abrah.ms/computer-science/big-o-notation-explained.html

Cornell University. (n.d.) The Math Behind Sudoku: Some More Interesting Facts. Retrieved from: http://www.math.cornell.edu/~mec/Summer2009/Mahmood/More.html

Darwin, I.F. (2014) Java cookbook: third edition. Sebastopol, CA: O’Reilly Media.

Dave, A. (2016). Instructor feedback. Colorado Technical University. Online classroom grade and feedback page. Retrieved from: https://studentlogin.coloradotech.edu/portal/6/pages/mainframe.aspx?contentframe=/portal/6/pages/Home.aspx

Goodrich M.T. and Tamassia R. (2015). Algorithm design and applications. Hoboken, NJ: Wiley.

Gordon, M. (2013). Why don't we use ternary search even though the algorithm complexity (O(logn/log3)) is better than binary search complexity (O(logn/log2))?. Retrieved from: https://www.quora.com/Why-dont-we-use-ternary-search-even-though-the-algorithm-complexity-O-logn-log3-is-better-than-binary-search-complexity-O-logn-log2

Grohe, K. (2013). Moore’s law forcing the next evolution of storage. Wired Magazine. Retrieved from: http://www.wired.com/insights/2013/06/moores-law-forcing-the-next-evolution-of-storage/ 

Marshall, D. (1997). Heuristic search. Retrieved from: http://www.cs.cf.ac.uk/Dave/AI2/ node23.html

Sudoku. (n.d.). How to play Sudoku. Retrieved from: www.sudoku.com.

