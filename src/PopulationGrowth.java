/*
 * The PopulationGrowth class displays the population growth for the Marine Life Simulator program via. JFrames.
 * 
 * This class includes a table of values for the predator and prey population between the years 2019 to 2050
 * and as well displays the formula that is used to calculate the new population.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PopulationGrowth extends JFrame implements ActionListener {

	// Instantiation of JPanel for the information panel.
	private static JPanel infoPanel = new JPanel();
	
	// Instantiation of ImageIcons for the table background and the button.
	private static ImageIcon tableInfo = new ImageIcon("media\\tableInfo.png");
	private static ImageIcon bFactors = new ImageIcon("media\\factorsButton.png");
	
	// Instantiation of JLabels for the background, filler, and button.
	private static JLabel info = new JLabel(tableInfo);
	private static JLabel filler = new JLabel();
	private static JButton factors = new JButton(bFactors);
	
	// Finalizing Euler's number, and the growth factors for increasing and decreasing populations.
	private final double e = 2.7182818284590452353602874713527;
	private final double growthIncrease = 0.05;
	private final double growthDecrease = -0.05;
	
	// Initializing the variables for the original and new populations for predator and prey.
	private int predPop = 1000, preyPop = 10000;
	private int newP, updatePred, updatePrey;
	private String newPop;
	
	// Declaration of the custom drawing canvas - the inner class that extends the game's JPanel.
	private static DrawCanvas canvas;
	
	// Instantiation of the background image.
	Image bg = Toolkit.getDefaultToolkit().getImage("media\\tableBG.png");	 
		
	/**
	 * Determines what button the player has pushed.
	 * pre: A button is pushed.
	 * post: The screens' visibilities are adjusted according to the button that was pushed.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == factors) { // If start was selected by the player.
			setVisible(false); // The population growth's screen is no longer visible.
			new Factors(); // The Factors() class is called upon.
		}
	}
		
	/**
	 * Returns the updated population for predator and prey.
	 * pre: The predator and prey's population must be more or equal to zero.
	 * post: The updated population for predator and prey are returned.
	 */
	public String pred2020() { // For the predator population of year 2020.
		newP = (int) (predPop*Math.pow(e, (growthIncrease*1)));
		updatePred = newP;
		newPop = Integer.toString(newP);
		return(newPop);
	}
	public String prey2020() { // For the prey population of year 2020.
		newP = (int) (preyPop*Math.pow(e, (growthIncrease*1)));
		updatePrey = newP;
		newPop = Integer.toString(newP);
		return(newPop);
	}
	public String pred2030() { // For the predator population of year 2030.
		newP = (int) (updatePred*Math.pow(e, (growthDecrease*10)));
		newPop = Integer.toString(newP);
		return(newPop);
	}
	public String prey2030() { // For the prey population of year 2030.
		newP = (int) (updatePrey*Math.pow(e, (growthDecrease*10)));
		newPop = Integer.toString(newP);
		return(newPop);
	}
	
	/**
	 * Constructor.
	 * pre: none
	 * post: The population growth screen is displayed accordingly.
	 */
	public PopulationGrowth() {
		// Setting JFrame settings for the title screen.
		setTitle("Marine Life Simulator");
		setLocation(280, 90);
		setResizable(false);
		setSize(800, 550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		// Configuring the information panel, filler, and button in terms of size and border.
		infoPanel.setPreferredSize(new Dimension(246, 550));
		infoPanel.setBorder(new EmptyBorder(-5, 0, 0, 0));
		filler.setPreferredSize(new Dimension(246, 484));
		factors.setPreferredSize(new Dimension(169, 42));
		
		// Configuring the layout of the information JLabel and adding the filler and button. The JLabel is added onto the JPanel.
		info.setLayout(new FlowLayout(FlowLayout.CENTER));
		info.add(filler);
		info.add(factors);
		infoPanel.add(info);
			
		// The canvas is initialized and set to the size of the screen.
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(554, 550));
		
		// Adding the canvas and information panel onto the JFrame.
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(canvas, BorderLayout.WEST);
		getContentPane().add(infoPanel, BorderLayout.EAST);

		// Setting JFrame settings for the Factors screen.
		pack();
		setVisible(true);
		requestFocus();
		
		// Adding an ActionListener for the button.
		factors.addActionListener(this);
	}
	
	/**
	* Define inner class DrawCanvas, which is a JPanel used for custom drawing.
	*/
	
	class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) { // Configuring paint components and graphics.
			super.paintComponent(g);			
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			
			// Declaring a new font and color and setting the background image.
			Font round = new Font("Arial Rounded MT Bold", Font.PLAIN, 35);
			Color green = new Color(71, 182, 73);
			g.drawImage(bg, 0, 0, this);
			
			// Selecting the font and color that will be used.
			g2.setFont(round);
			g2.setColor(green);
			
			// The numbers that are displayed for the year 2020.
			g2.drawString(pred2020(), 171, 248);
			g2.drawString(prey2020(), 380, 248);
			
			// The numbers that are displayed for the year 2030.
			g2.drawString(pred2030(), 180, 340);
			g2.drawString(prey2030(), 395, 340);
		
			// The numbers that are displayed for the year 2040.
			g2.drawString(pred2020(), 171, 425);
			g2.drawString(prey2020(), 380, 425);
			
			// The numbers that are displayed for the year 2050.
			g2.drawString(pred2030(), 180, 510);
			g2.drawString(prey2030(), 395, 510);
		}
	}
}
