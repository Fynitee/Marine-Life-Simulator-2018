/*
 * The TrophicLevel class displays the trophic levels for the Marine Life Simulator program via. JFrames.
 * 
 * This class includes the trophic pyramid that displays the marine ecosystem divided into 5 
 * categories and includes the usage of tooltip text to explain the purpose of the pyramid
 * and why it is ordered the way it is.
 */
import java.awt.event.*;
import javax.swing.*;

public class TrophicLevels implements ActionListener {
	
	// Instantiation of JFrames for the title screen and tutorial screens.
	private static JFrame tLevel = new JFrame();
	
	// Instantiation of ImageIcons for the background and trophic levels.
	private static ImageIcon bgImg = new ImageIcon("media\\trophicsBG.png");
	private static ImageIcon pyramidImg = new ImageIcon("media\\pyramid.png");
	private static ImageIcon carnTopImg = new ImageIcon("media\\carnTop.png");
	private static ImageIcon carn2Img = new ImageIcon("media\\carn2.png");
	private static ImageIcon carn1Img = new ImageIcon("media\\carn1.png");
	private static ImageIcon herbImg = new ImageIcon("media\\herbivores.png");
	private static ImageIcon primImg = new ImageIcon("media\\primaryProducer.png");
	
	// Instantiation of ImageIcons for the next and back buttons.
	private static ImageIcon bNext = new ImageIcon("media\\next2Button.png");
	private static ImageIcon bBack = new ImageIcon("media\\back2Button.png");
	
	// Instantiation of JLabels for the background and trophic level labels.
	private static JLabel bg = new JLabel(TrophicLevels.bgImg);
	private static JLabel pyramid = new JLabel(TrophicLevels.pyramidImg);
	private static JLabel carnTop = new JLabel(TrophicLevels.carnTopImg);
	private static JLabel carn2 = new JLabel(TrophicLevels.carn2Img);
	private static JLabel carn1 = new JLabel(TrophicLevels.carn1Img);
	private static JLabel herbivore = new JLabel(TrophicLevels.herbImg);
	private static JLabel primary = new JLabel(TrophicLevels.primImg);
	
	// Instantiation of JButtons for the play, back, two next, two previous, and start buttons.
	private static JButton next = new JButton(TrophicLevels.bNext);
	private static JButton back = new JButton(TrophicLevels.bBack);
	
	/**
	 * Determines what button the player has pushed.
	 * pre: A button is pushed.
	 * post: The screens' visibilities are adjusted according to the button that was pushed.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next) { // If next on the first tutorial screen was selected by the player.
			tLevel.setVisible(false); // The trophics level screen is no longer visible.
			new Factors(); // The Factors() class is called upon.
		}
		if (e.getSource() == back) { // If back was selected by the player.
			tLevel.setVisible(false); // The trophics level screen is no longer visible.
			Title.getDefinitions(); // The Title() class is called upon with the getDefinitions() method.
		}
	}
	
	/**
	 * Constructor
	 * pre: none
	 * post: The title screen and tutorial screens are displayed accordingly.
	 */
	public TrophicLevels() {
		// Setting JFrame settings for the title screen.
		tLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tLevel.setLayout(null);
		
		// Configuring the title screen's image location, border, visibility, next, and back buttons.
		bg.setBounds(-6, 0, 800, 550);
		bg.setBorder(null);
		bg.setVisible(true);
		next.setBounds(5, 483, 104, 33);
		back.setBounds(685, 483, 104, 33);
		
		// Configuring the pyramid's label in terms of location, border, visibility, and tooltip text.
		pyramid.setBounds(175, 484, 439, 36);
		pyramid.setBorder(null);
		pyramid.setVisible(true);
		pyramid.setToolTipText("This pyramid demonstrates the 5 trophic levels of a marine ecosystem. " 
		+ "The consumers in the layer above gain their energy from feeding upon the layer below.");	
		
		// Configuring the top carnivores' label in terms of location, border, visibility, and tooltip text.
		carnTop.setBounds(22, 43, 305, 29);
		carnTop.setBorder(null);
		carnTop.setVisible(true);
		carnTop.setToolTipText("As the 5th trophic level, top carnivores feed off quaternary consumers!");
		
		// Configuring the second level of carnivores' label in terms of location, border, visibility, and tooltip text.
		carn2.setBounds(22, 102, 200, 69);
		carn2.setBorder(null);
		carn2.setVisible(true);
		carn2.setToolTipText("As the 4th trophic level, the second level of carnivores and quaternary consumers feed off tertiary consumers!");
		
		// Configuring the first level of carnivores' label in terms of location, border, visibility, and tooltip text.
		carn1.setBounds(22, 201, 184, 66);
		carn1.setBorder(null);
		carn1.setVisible(true);
		carn1.setToolTipText("As the 3rd trophic level, the first level of carnivores and tertiary consumers feed off secondary consumers!");
		
		// Configuring the herbivores' label in terms of location, border, visibility, and tooltip text.
		herbivore.setBounds(22, 319, 183, 22);
		herbivore.setBorder(null);
		herbivore.setVisible(true);
		herbivore.setToolTipText("As the 2nd trophic level, herbivores (otherwise known as secondary consumers) feed off primary producers!");
		
		// Configuring the primary consumers' label in terms of location, border, visibility, and tooltip text.
		primary.setBounds(22, 393, 126, 49);
		primary.setBorder(null);
		primary.setVisible(true);
		primary.setToolTipText("As the 1st trophic level, primary producers make their own food by converting energy from the sun through photosynthesis!");
		
		// Adding the JLabels, background image, and next and back buttons onto the JFrame.
		tLevel.getContentPane().add(pyramid);
		tLevel.getContentPane().add(carnTop);
		tLevel.getContentPane().add(carn2);
		tLevel.getContentPane().add(carn1);
		tLevel.getContentPane().add(herbivore);
		tLevel.getContentPane().add(primary);
		tLevel.getContentPane().add(bg);
		tLevel.getContentPane().add(next);
		tLevel.getContentPane().add(back);
		
		// Setting JFrame settings for the title screen.
		tLevel.setTitle("Marine Life Simulator");
		tLevel.setLocation(280, 90);
		tLevel.setResizable(false);
		tLevel.setSize(800, 550);
		tLevel.setVisible(true);

		// Adding ActionListeners for each button.
		next.addActionListener(this);
		back.addActionListener(this);
	}
}
