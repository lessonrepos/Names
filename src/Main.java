
public class Main {

	//PSEUDOCODE
//		//Create array STARS of length names
//		//Create array SAME_NUMBER_OF_STARS of length names
//		//Randomly assign stars to each index of STARS
//		
//		//FIRST RUN THROUGH: find largest num of stars
//		//SECOND RUN THROUGH: for each name that has the same number of stars as MAX, 
//			//add them to your SAME NUMBER OF STARS array
//		
//		//loop through samenumberofstars, find out if there is more than one value
//		//IF MORE THAN ONE VALUE: Recursive: assignStars(samenumberofstar[])
//		//IF EQUAL TO ONE VALUE: end, return the samenumberofstars array

	public static void main(String[] args) {
		//TESTER
		String[] names = {"Mary", "Jane", "Bob", "Joe", "Carl", "Leo", "Emma", "Polly", "Sam", "Steve"};
		assignStars(names);
	}

	
	public static void assignStars(String[] names) {
		int starsCount[] = new int[names.length];
		
		//IF THERE ISN'T ONE WINNER
		if(names.length > 1) {
			//STEP 1: ASSIGN STARS
			for(int i= 0; i<250; i++) {
				starsCount[(int)(Math.random() * names.length)]++;
			}
			
			//STEP 2: FIND THE MAX NUM OF STARS
			int maxStars = 0;
			for(int count: starsCount) {
				if(count > maxStars) {
					maxStars = count;
				}
			}
			
			//********************************
			//CHECK POINT: CHECK THE MAXIMUM NUMBER OF STARS SOMEONE HAS
				//System.out.println(maxStars);
			//********************************
			
			//AESTHETIC STEP: CREATE A MEASURE SO YOU CAN
			//LINE UP ALL THE NAMES AND THEIR STARS TO VISUALLY COMPARE
			int longestNameLength= 0;
			for(String name: names) {
				if(name.length() > longestNameLength) {
					longestNameLength = name.length();
				}
			}
			
			//STEP 3: PRINT OUT ALL NAMES AND THEIR STARCOUNT
			String stars = "";
			String spacesNeeded = "";
			
			for(int i=0; i<names.length; i++) {
				for(int j=0; j<starsCount[i]; j++) {
					stars+="*";
				}
				for(int k=0; k<longestNameLength - names[i].length(); k++) {
					spacesNeeded += " ";
				}
				System.out.println(names[i] + " " + spacesNeeded + stars);
				
				//RESET STARS STRING AND SPACES STRING
				stars = "";
				spacesNeeded = "";
			}

			//STEP 4: FIND ALL NAMES WITH THAT NUM OF STARS AND COUNT THEM
			int tieCount = 0;
			for(int count: starsCount) {
				if(count == maxStars) {
					tieCount++;
				}
			}
			
			//STEP 5: CREATE A NEW ARRAY THAT IS THE RIGHT SIZE TO HOLD EVERYONE THAT TIED
			//AND ADD THOSE NAMES TO A NEW ARRAY
			String tiedNames[];
			int indexOfTiedNames = 0;
			tiedNames = new String[tieCount];
			for(int i=0; i<starsCount.length; i++) {
				if(starsCount[i] == maxStars) {
					tiedNames[indexOfTiedNames] = names[i];
					indexOfTiedNames++;
				}
			}
			
			//ALTERNATIVE: REPLACEMENT FOR STEP 5		
			//SPLIT THE TIE STRING INTO AN ARRAY
			//String[] tiedPeople = tie.split(",");
			
			
			//********************************
			//CHECKPOINT: CHECK THE NAMES IN TIED NAMES
				//for(String name: tiedNames) {
				//	System.out.print(name + " ");
				//}
			//********************************
			
			//STEP 6: PRINT OUT ANY TIES
			System.out.println(); //SPACING
			
			String finalTies = "";
			if(tiedNames.length > 1) {
				for(int i=0; i<tiedNames.length -1; i++) {
					finalTies += tiedNames[i] + " and ";
				}
				finalTies += tiedNames[tiedNames.length-1];
				System.out.println("People who Tied: " + finalTies);
			}
			
			System.out.println(); //SPACING
			
			//STEP 7: RECURSIVE, KEEP RUNNING THE PROGRAM UNTIL YOU GET ONLY ONE PERSON IN THE TIED ARRAY
			//THIS IS THE WINNER
			assignStars(tiedNames);
		}	
		//IF THERE IS ONE WINNER
		else if(names.length == 1) {
			System.out.println("Winner is: " + names[0]);
		}

	}
	
	
}
