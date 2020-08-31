/*
 * Isabella Cheng
 * Marine Life Simulator Program
 * 
 * January 7th, 2018
 * PROF: Mr. Kordbacheh
 * COURSE: ICS 4U1
 *
 * The Main class starts the Marine Life Simulator program by calling upon the other classes' constructors.
 */

import javax.swing.SwingUtilities;

public class Main{

public static void main(String[] args) {
      // Run GUI codes on the Event-Dispatcher Thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
        	// Call upon the constructors.
        	new Title();
        	new MusicPlayer();
         }
      }); 
   }
}