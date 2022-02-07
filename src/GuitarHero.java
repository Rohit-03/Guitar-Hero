/** 
* CS312 Assignment 12.
 * 
 * On my honor, <Rohit Shetty>, this programming assignment is my own work and I
 * have not shared my solution with any other student in the class.
 *
 * email address: rohit.shetty@utexas.edu 
 * UTEID: Unique 5 digit course ID:rrs3229 
 * Number of slip days used on this assignment: 0
 */
public class GuitarHero {
	
	
	 public static void main(String[] args) {

		 String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
			

	        final double TEXT_POS_X = .2;
	        final double TEXT_POS_Y = .5;
	        
	        StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Please type one of the given notes to play a "
	        		+ "note: q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ");
	        
	        play(keyboard);
	    }
	
	
	 private static void play(String keyboard) {        // the main input loop
		
		 GuitarString [] arrayOfStrings = new GuitarString [keyboard.length()]; 
		
		 for (int i = 0; i < keyboard.length(); i++) {
	    	   double frequency = 440* Math.pow(1.05956,(i - 24));
	    	   GuitarString stringX = new GuitarString(frequency);
	    	   arrayOfStrings[i] = stringX;
	       }
		 
		 
		 while (true) {
	            
	            // check if the user has typed a key, and, if so, process it
	            if (StdDraw.hasNextKeyTyped()) {
	 
	                // the user types this character
	                char key = StdDraw.nextKeyTyped();

	                int stringNum = keyboard.indexOf(key);
	                if (stringNum != -1) {
	                GuitarString currString = arrayOfStrings[stringNum];
	                	
	                currString.pluck();
	                }
	      
	            }

	            // compute the superposition of the samples
	            double sample  = 0.0;
	            
	            for(int n = 0; n < arrayOfStrings.length; n++) {
	            	sample+= arrayOfStrings[n].sample();
	            }

	            // send the result to standard audio
	            StdAudio.play(sample);

	            
	            // advance the simulation of each guitar string by one step
	            for(int n = 0; n < arrayOfStrings.length; n++) {
	            	arrayOfStrings[n].tic();
	            }
	        }
	 }
	

}
