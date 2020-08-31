/*
 * The Title class displays the title, introduction, and definition screens for the Marine Life Simulator
 * program via. JFrames. This features a very basic introduction to the simulation and key definitions
 * that the user should know before continuing to use the program.
 */

import java.awt.Frame;
import java.awt.event.*;
import javax.swing.*;

public class Title implements ActionListener {
	
	// Instantiation of JFrames for the title, introduction, and definition screens.
	private static JFrame title = new JFrame();
	private static JFrame intro = new JFrame();
	private static JFrame definitions = new JFrame();
	
	// Instantiation of ImageIcons for the title, introduction, and definition screens.
	private static ImageIcon bgTitle = new ImageIcon("media\\title.png");
	private static ImageIcon bgIntro = new ImageIcon("media\\introBG.png");
	private static ImageIcon bgDef = new ImageIcon("media\\definitionsBG.png");
	
	// Instantiation of ImageIcons for the start, next, and back buttons.
	private static ImageIcon bStart = new ImageIcon("media\\start.png");
	private static ImageIcon bNext = new ImageIcon("media\\nextButton.png");
	private static ImageIcon bBack = new ImageIcon("media\\backButton.png");
	
	// Instantiation of JLabels for the title, introduction, and definition screens.
	private static JLabel t = new JLabel(Title.bgTitle);
	private static JLabel introScreen = new JLabel(Title.bgIntro);
	private static JLabel defScreen = new JLabel(Title.bgDef);
	
	// Instantiation of JButtons for the play, back, two next, two previous, and start buttons.
	private static JButton start = new JButton(Title.bStart);
	private static JButton next1 = new JButton(Title.bNext);
	private static JButton back1 = new JButton(Title.bBack);
	private static JButton next2 = new JButton(Title.bNext);
	private static JButton back2 = new JButton(Title.bBack);
	
	/**
	 * Determines what button the player has pushed.
	 * pre: A button is pushed.
	 * post: The screens' visibilities are adjusted according to the button that was pushed.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) { // If start was selected by the player.
			// The title screen is no longer visible as the introduction screen becomes visible.
			title.setVisible(false);
			intro.getContentPane();
			intro.setVisible(true);
		}
		if (e.getSource() == back1) { // If back was selected by the player.
			// The introduction screen is no longer visible as the title screen becomes visible.
			intro.setVisible(false);
			title.getContentPane();
			title.setVisible(true);
		}
		if (e.getSource() == next1) { // If next on the first tutorial screen was selected by the player.
			// The introduction screen is no longer visible as the definitions screen becomes visible.
			intro.setVisible(false);
			definitions.getContentPane();
			definitions.setVisible(true);
		}
		if (e.getSource() == back2) { // If back was selected by the player.
			// The definitions screen is no longer visible as the introduction screen becomes visible.
			definitions.setVisible(false);
			intro.getContentPane();
			intro.setVisible(true);
		}
		if (e.getSource() == next2) { // If next on the first tutorial screen was selected by the player.
			definitions.setVisible(false); // The definitions screen is no longer visible.
			new TrophicLevels(); // The TrophicsLevel() constructor is called upon.
		}
	}
	
	/**
	 * Returns the Definitions JFrame in terms of content and visibility.
	 * pre: none
	 * post: The Definitions JFrame is returned.
	 */
	public static Frame getDefinitions() {
		definitions.getContentPane();
		definitions.setVisible(true);
		return(definitions);
	}
	
	/**
	 * Constructor
	 * pre: none
	 * post: The title, introduction, and definitions screens are displayed accordingly.
	 */
	public Title() {
		// Setting JFrame settings for the title screen.
		title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.setLayout(null);
		
		// Configuring the title screen's image location, border, visibility, and play button.
		t.setBounds(0, 0, 800, 550);
		t.setBorder(null);
		t.setVisible(true);
		start.setBounds(305, 400, 188, 53);

		// Adding the start button and title screen image onto the JFrame.
		title.getContentPane().add(t);
		title.getContentPane().add(start);
		
		// Setting JFrame settings for the title screen.
		title.setTitle("Marine Life Simulator");
		title.setLocation(280, 90);
		title.setResizable(false);
		title.setSize(800, 550);
		title.setVisible(true);
		
		// Configuring the introduction screen's image location, border, visibility, and next and back buttons.
		introScreen.setBounds(0, 0, 800, 550);
		introScreen.setLayout(null);
		introScreen.setVisible(true);
		next1.setBounds(55, 450, 152, 53);
		back1.setBounds(225, 450, 152, 53);
		
		// Adding the next button, back button and introduction screen image onto the JFrame.
		intro.getContentPane().add(introScreen);
		intro.getContentPane().add(next1);
		intro.getContentPane().add(back1);
		
		// Setting JFrame settings for the introduction screen.
		intro.setLayout(null);
		intro.setTitle("Marine Life Simulator");
		intro.setLocation(280, 90);
		intro.setResizable(false);
		intro.setSize(800, 550);
		
		// Configuring the definitions screen's image location, border, visibility, and next and back buttons.
		defScreen.setBounds(0, 0, 800, 550);
		defScreen.setLayout(null);
		defScreen.setVisible(true);
		next2.setBounds(55, 450, 152, 53);
		back2.setBounds(225, 450, 152, 53);
		
		// Adding the next button, back button and definitions screen image onto the JFrame.
		definitions.getContentPane().add(defScreen);
		definitions.getContentPane().add(next2);
		definitions.getContentPane().add(back2);
		
		// Setting JFrame settings for the definitions screen.
		definitions.setLayout(null);
		definitions.setTitle("Marine Life Simulator");
		definitions.setLocation(280, 90);
		definitions.setResizable(false);
		definitions.setSize(800, 550);

		// Adding ActionListeners for each button.
		start.addActionListener(this);
		next1.addActionListener(this);
		back1.addActionListener(this);
		next2.addActionListener(this);
		back2.addActionListener(this);
	}
}
