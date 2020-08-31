/*
 * The Factors class displays for the Marine Life Simulator program via. JFrames.
 * 
 * This class features animation sequences that show an increase, decrease, or normal level
 * of the 5 environmental factors of predator, prey, pollution, fishing, and invasive species.
 * These 5 factors can be clicked on as JButtons on the side panel while as the animation
 * corresponds to the button that was clicked.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Factors extends JFrame implements ActionListener {

	// Instantiation of JPanel for the Factors screen.
	private static JPanel buttons = new JPanel();
	
	// Instantiation of ImageIcons for the trophic, table, and arrow icons for all five factors.
	private static ImageIcon predator = new ImageIcon("media\\predNORM.png");
	private static ImageIcon prey = new ImageIcon("media\\preyNORM.png");
	private static ImageIcon pollution = new ImageIcon("media\\pollNORM.png");
	private static ImageIcon fishing = new ImageIcon("media\\fishingNORM.png");
	private static ImageIcon invasive = new ImageIcon("media\\invasNORM.png");
	private static ImageIcon buttonsBG = new ImageIcon("media\\buttonsBG.png");
	private static ImageIcon title = new ImageIcon("media\\factorsTitle.png");
	private static ImageIcon bTroph = new ImageIcon("media\\trophicLevels.png");
	private static ImageIcon bTable = new ImageIcon("media\\popTable.png");
	private static ImageIcon up = new ImageIcon("media\\upYellow.png");
	private static ImageIcon up4 = new ImageIcon("media\\up4x.png");
	private static ImageIcon down = new ImageIcon("media\\downYellow.png");
	private static ImageIcon down4 = new ImageIcon("media\\down4x.png");

	// Instantiation of JLabels for the background of the button's JPanel and the filler (empty space).
	private static JLabel bgButtons = new JLabel(buttonsBG);
	private static JLabel filler = new JLabel(title);
	
	// Instantiation of JButtons for the trophic, table, and arrows for all five factors.
	private static JButton trophic = new JButton(bTroph);
	private static JButton table = new JButton(bTable);
	private static JButton predNORM = new JButton(predator);
	private static JButton predUP = new JButton(up);
	private static JButton predDOWN = new JButton(down);
	private static JButton preyNORM = new JButton(prey);
	private static JButton preyUP = new JButton(up);
	private static JButton preyDOWN = new JButton(down);
	private static JButton pollNORM = new JButton(pollution);
	private static JButton pollUP = new JButton(up);
	private static JButton pollDOWN = new JButton(down);
	private static JButton fishNORM = new JButton(fishing);
	private static JButton fishUP = new JButton(up);
	private static JButton fishDOWN = new JButton(down);
	private static JButton invasiveNORM = new JButton(invasive);
	private static JButton invasiveUP = new JButton(up);
	private static JButton invasiveDOWN = new JButton(down);

	// Initializing the multipliers for each environmental factor.
	private static int predMultiplier = 1;
	private static int preyMultiplier = 1;
	private static int pollMultiplier = 1;
	private static int fishMultiplier = 1;
	private static int invasiveMultiplier = 1;

	// Declaration of the custom drawing canvas - the inner class that extends the game's JPanel.
	private static DrawCanvas canvas;
	
	// Initializing the (x, y) positions of the moving object and the update period.
	private static final int UPDATE_PERIOD = 50; // milliseconds
	private static int xPrey = 100;
	private static int xPredS = 50, xPredB = 50;
	private static int yTrash = 300, yTrashUp = 100;
	
	// Initializing the displacement (speed) of the moving object.
	private static int xSpeedPrey = 13;
	private static int xSpeedShark = 9, xSpeedBird = 15;
	private static int ySpeedTrash = 6, ySpeedTrashUp = 6; 

	// Instantiation of all the images that were used in this JFrame.
	Image simBG = Toolkit.getDefaultToolkit().getImage("media\\simBG.png");	 
	Image predNL = Toolkit.getDefaultToolkit().getImage("media\\predNormLeft.png");
	Image predNR = Toolkit.getDefaultToolkit().getImage("media\\predNormRight.png");
	Image predBL = Toolkit.getDefaultToolkit().getImage("media\\predUpLeft.png");
	Image predBR = Toolkit.getDefaultToolkit().getImage("media\\predUpRight.png");
	Image preyNL = Toolkit.getDefaultToolkit().getImage("media\\preyNORMLeft.png");
	Image preyNR = Toolkit.getDefaultToolkit().getImage("media\\preyNORMRight.png");
	Image preyUL = Toolkit.getDefaultToolkit().getImage("media\\preyUpLeft.png");
	Image preyUR = Toolkit.getDefaultToolkit().getImage("media\\preyUpRight.png");
	Image preyDL = Toolkit.getDefaultToolkit().getImage("media\\preyDownLeft.png");
	Image preyDR = Toolkit.getDefaultToolkit().getImage("media\\preyDownRight.png");
	Image fishL = Toolkit.getDefaultToolkit().getImage("media\\fishLeft.png");
	Image fishR = Toolkit.getDefaultToolkit().getImage("media\\fishRight.png");
	Image pollN = Toolkit.getDefaultToolkit().getImage("media\\trashNORM.png");
	Image pollU = Toolkit.getDefaultToolkit().getImage("media\\trashUP.png");
	Image pollD = Toolkit.getDefaultToolkit().getImage("media\\trashDOWN.png");
	Image invas = Toolkit.getDefaultToolkit().getImage("media\\invasiveNORM.png");

	/**
	 * Returns the factor's multiplier.
	 * pre: none
	 * post: The factor's multiplier is returned.
	 */
	public static int getPredMultiplier() {
		return(predMultiplier);
	}
	public static int getPreyMultiplier() {
		return(preyMultiplier);
	}
	public static int getPollMultiplier() {
		return(pollMultiplier);
	}
	public static int getFishMultiplier() {
		return(fishMultiplier);
	}
	public static int getInvasiveMultiplier() {
		return(invasiveMultiplier);
	}
	
	/**
	 * Determines what button the player has pushed.
	 * pre: A button is pushed.
	 * post: The multipliers and arrow icons are changed according to the button that was pushed.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == predNORM) { // If predator was selected by the user.
			// The predator multiplier is changed.
			predMultiplier = 1;
			
			// The arrow icons are changed back to normal and both arrows are enabled.
			predUP.setIcon(up);			
			predDOWN.setIcon(down);
			predUP.setEnabled(true);
			predDOWN.setEnabled(true);
		}
		if (e.getSource() == predUP) { // If the up arrow for predator was selected by the user.
			// The predator multiplier is changed.
			predMultiplier = 2;
			
			// The up arrow icon is changed and the down arrow is disabled.
			predUP.setIcon(up4);
			predDOWN.setEnabled(false);
		}
		if (e.getSource() == predDOWN) { // If the down arrow for predator was selected by the user.
			// The prey multiplier is changed.
			predMultiplier = -2;
			
			// The down arrow icon is changed and the up arrow is disabled.
			predDOWN.setIcon(down4);
			predUP.setEnabled(false);
		}
		if (e.getSource() == preyNORM) { // If prey was selected by the user.
			// The prey multiplier is changed.
			preyMultiplier = 1;
			
			// The arrow icons are changed back to normal and both arrows are enabled.
			preyUP.setIcon(up);			
			preyDOWN.setIcon(down);
			preyUP.setEnabled(true);
			preyDOWN.setEnabled(true);
		}
		if (e.getSource() == preyUP) { // If the up arrow for prey was selected by the user.
			// The prey multiplier is changed.
			preyMultiplier = 2;
			
			// The up arrow icon is changed and the down arrow is disabled.
			preyUP.setIcon(up4);
			preyDOWN.setEnabled(false);
		}
		if (e.getSource() == preyDOWN) { // If the down arrow for prey was selected by the user.
			// The prey multiplier is changed.
			preyMultiplier = -2;
			
			// The down arrow icon is changed and the up arrow is disabled.
			preyDOWN.setIcon(down4);
			preyUP.setEnabled(false);
		}
		if (e.getSource() == pollNORM) { // If pollution was selected by the user.
			// The pollution multiplier is changed.
			pollMultiplier = 1;
			
			// The arrow icons are changed back to normal and both arrows are enabled.
			pollUP.setIcon(up);			
			pollDOWN.setIcon(down);
			pollUP.setEnabled(true);
			pollDOWN.setEnabled(true);
		}
		if (e.getSource() == pollUP) { // If the up arrow for pollution was selected by the user.
			// The pollution multiplier is changed.
			pollMultiplier = 2;
			
			// The up arrow icon is changed and the down arrow is disabled.
			pollUP.setIcon(up4);
			pollDOWN.setEnabled(false);
		}
		if (e.getSource() == pollDOWN) { // If the down arrow for pollution was selected by the user.
			// The pollution multiplier is changed.
			pollMultiplier = -2;
			
			// The down arrow icon is changed and the up arrow is disabled.
			pollDOWN.setIcon(down4);
			pollUP.setEnabled(false);
		}		
		if (e.getSource() == fishNORM) { // If fishing was selected by the user.
			// The fishing multiplier is changed.
			fishMultiplier = 1;
			
			// The arrow icons are changed back to normal and both arrows are enabled.
			fishUP.setIcon(up);			
			fishDOWN.setIcon(down);
			fishUP.setEnabled(true);
			fishDOWN.setEnabled(true);
		}
		if (e.getSource() == fishUP) { // If the up arrow for fishing was selected by the user.
			// The fishing multiplier is changed.
			fishMultiplier = 2;
			
			// The up arrow icon is changed and the down arrow is disabled.
			fishUP.setIcon(up4);
			fishDOWN.setEnabled(false);
		}
		if (e.getSource() == fishDOWN) { // If the down arrow for fishing was selected by the user.
			// The fishing multiplier is changed.
			fishMultiplier = -2;
			
			// The down arrow icon is changed and the up arrow is disabled.
			fishDOWN.setIcon(down4);
			fishUP.setEnabled(false);
		}
		if (e.getSource() == invasiveNORM) { // If invasive species was selected by the user.
			// The invasive species multiplier is changed.
			invasiveMultiplier = 1;
			
			// The arrow icons are changed back to normal and both arrows are enabled.
			invasiveUP.setIcon(up);			
			invasiveDOWN.setIcon(down);
			invasiveUP.setEnabled(true);
			invasiveDOWN.setEnabled(true);
		}
		if (e.getSource() == invasiveUP) { // If the up arrow for invasive species was selected by the user.
			// The invasive species multiplier is changed.
			invasiveMultiplier = 2;
			
			// The up arrow icon is changed and the down arrow is disabled.
			invasiveUP.setIcon(up4);
			invasiveDOWN.setEnabled(false);
		}
		if (e.getSource() == invasiveDOWN) { // If the down arrow for invasive species was selected by the user.
			// The invasive species multiplier is changed.
			invasiveMultiplier = -2;	
			
			// The down arrow icon is changed and the up arrow is disabled.
			invasiveDOWN.setIcon(down4);
			invasiveUP.setEnabled(false);
		}
		if (e.getSource() == trophic) { // If trophic was selected by the user.
			setVisible(false); // The Factors screen is no longer visible.
			new TrophicLevels(); // The TrophicsLevel() constructor is called upon.
		}
		if (e.getSource() == table) { // If table was selected by the user.
			setVisible(false); // The Factors screen is no longer visible.
			new PopulationGrowth(); // The PopulationGrowth() constructor is called upon.
		}
	}
	
	/**
	 * Constructor
	 * pre: none
	 * post: The Factors screen and its contents are displayed accordingly.
	 */
	public Factors() {
		// Initializing the type of border that will be used for the buttons.
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
				
		// Setting JFrame settings for the Factors screen.
		setTitle("Marine Life Simulator");
		setLocation(280, 90);
		setResizable(false);
		setSize(800, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Configuring the buttons panel in terms of size and border.
		buttons.setPreferredSize(new Dimension(246, 550));
		buttons.setBorder(new EmptyBorder(-5, 0, 0, 0));

		// Configuring the JPanels and buttons in terms of size and border.		
		filler.setPreferredSize(new Dimension(246, 96));
		filler.setBorder(new EmptyBorder(-40, 0, 0, 0));
		predUP.setPreferredSize(new Dimension(22, 50));
		predUP.setBorder(raisedbevel);
		predNORM.setPreferredSize(new Dimension(183, 37));
		predDOWN.setPreferredSize(new Dimension(22, 50));
		predDOWN.setBorder(raisedbevel);
		preyUP.setPreferredSize(new Dimension(22, 50));
		preyUP.setBorder(raisedbevel);
		preyNORM.setPreferredSize(new Dimension(183, 37));
		preyDOWN.setPreferredSize(new Dimension(22, 50));
		preyDOWN.setBorder(raisedbevel);
		pollUP.setPreferredSize(new Dimension(22, 50));
		pollUP.setBorder(raisedbevel);
		pollNORM.setPreferredSize(new Dimension(183, 37));
		pollDOWN.setPreferredSize(new Dimension(22, 50));
		pollDOWN.setBorder(raisedbevel);
		fishUP.setPreferredSize(new Dimension(22, 50));
		fishUP.setBorder(raisedbevel);
		fishNORM.setPreferredSize(new Dimension(183, 37));
		fishDOWN.setPreferredSize(new Dimension(22, 50));
		fishDOWN.setBorder(raisedbevel);
		invasiveUP.setPreferredSize(new Dimension(22, 50));
		invasiveUP.setBorder(raisedbevel);
		invasiveNORM.setPreferredSize(new Dimension(183, 37));
		invasiveDOWN.setPreferredSize(new Dimension(22, 50));
		invasiveDOWN.setBorder(raisedbevel);
		trophic.setPreferredSize(new Dimension(114, 28));
		table.setPreferredSize(new Dimension(115, 28));
		
		// Setting the layout of the JLabel and adding the buttons onto it. The JLabel is added onto the buttons JPanel.
		bgButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		bgButtons.add(filler);
		bgButtons.add(predUP);
		bgButtons.add(predNORM);
		bgButtons.add(predDOWN);
		bgButtons.add(preyUP);
		bgButtons.add(preyNORM);
		bgButtons.add(preyDOWN);
		bgButtons.add(pollUP);
		bgButtons.add(pollNORM);
		bgButtons.add(pollDOWN);
		bgButtons.add(fishUP);
		bgButtons.add(fishNORM);
		bgButtons.add(fishDOWN);
		bgButtons.add(invasiveUP);
		bgButtons.add(invasiveNORM);
		bgButtons.add(invasiveDOWN);
		bgButtons.add(trophic);
		bgButtons.add(table);
		buttons.add(bgButtons);
		
		// The canvas is initialized and set to the size of the screen.
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(554, 550));
		
		// Adding the canvas and the buttons JPanel onto the JFrame.
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(canvas, BorderLayout.WEST);
		getContentPane().add(buttons, BorderLayout.EAST);

		// Setting JFrame settings for the Factors screen.
		pack();
		setVisible(true);
		requestFocus();

		// Define an ActionListener to perform update at regular interval
	    ActionListener updateTask = new ActionListener() {
	    	@Override
	        public void actionPerformed(ActionEvent evt) {
	          update();   // update the (x, y) position
	          repaint();  // Refresh the JFrame, callback paintComponent()
	        }
	    };
	    // Allocate a Timer to run updateTask's actionPerformed() after every delay msec
	    new Timer(UPDATE_PERIOD, updateTask).start();

		// Adding ActionListeners for each button.
		trophic.addActionListener(this);
		table.addActionListener(this);
		predNORM.addActionListener(this);
		predUP.addActionListener(this);	
		predDOWN.addActionListener(this);
		preyNORM.addActionListener(this);
		preyUP.addActionListener(this);
		preyDOWN.addActionListener(this);
		pollNORM.addActionListener(this);
		pollUP.addActionListener(this);
		pollDOWN.addActionListener(this);
		fishNORM.addActionListener(this);
		fishUP.addActionListener(this);
		fishDOWN.addActionListener(this);
		invasiveNORM.addActionListener(this);
		invasiveUP.addActionListener(this);
		invasiveDOWN.addActionListener(this);
	}

	/**
	 * Updates the (x, y) position of the moving object.
	 * pre: none
	 * post: The (x, y) position of the moving object is updated.
	 */
	public void update() {	   
		// Declaring (x, y) positions of the objects as their speeds.
		xPrey += xSpeedPrey;
		xPredS += xSpeedShark;
		xPredB += xSpeedBird;
		yTrash += ySpeedTrash;
		yTrashUp += ySpeedTrashUp;
		   
		if (xPrey >= 554 || xPrey <= -246) { // This prevents the prey (fish) image from moving out of the canvas.
			xSpeedPrey = -xSpeedPrey;
		}
		if (xPredS >= 554 || xPredS <= -246) { // This prevents the predator (shark) image from moving out of the canvas.
	    	xSpeedShark = -xSpeedShark;
	 	}
		if (xPredB >= 554 || xPredB <= -246) { // This prevents the predator (bird) image from moving out of the canvas.
	    	xSpeedBird = -xSpeedBird;
		}
	    if (yTrash >= 440) { // This prevents the pollution (trash) image from moving out of the canvas.
	    	ySpeedTrash = 0;
	    }
	    if (yTrashUp >= 462 && getPollMultiplier() == 2) { // This prevents the pollution (trash) image from moving out of the canvas.
	    	ySpeedTrashUp = 0;
		}
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
			
			// Setting the background of the canvas.
			g.drawImage(simBG, 0, 0, this);
		
			// Configuring the images that are drawn for the fishing multiplier.
			if (getFishMultiplier() == 1) { // If the multiplier was 1.
				g.drawImage(fishL, 243, 116, this);
	        	g.drawImage(fishL, 40, 80, this);
	        } else if (getFishMultiplier() == 2) { // If the multiplier was 2.
	        	g.drawImage(fishL, 243, 116, this);
	        	g.drawImage(fishL, 440, 70, this);
	        	g.drawImage(fishL, 40, 80, this);
	        } else if (getFishMultiplier() == -2) { // If the multiplier was -2.
	        	g.drawImage(fishL, 243, 116, this);
	        } 
	        
			// Configuring the images that are drawn for the prey multiplier.
			if (xSpeedPrey > 0 && getPreyMultiplier() == -2) { // If the multiplier was -2.
	        	g.drawImage(preyDR, xPrey, 310, this);
	        } else if (xSpeedPrey < 0 && getPreyMultiplier() == -2) {
	        	g.drawImage(preyDL, xPrey, 310, this);
	        }
			if (xSpeedPrey > 0 && getPreyMultiplier() == 1 || xSpeedPrey > 0 && getPreyMultiplier() == 2) {  // If the multiplier was 1 or 2.
	        	g.drawImage(preyNR, xPrey, 310, this);
	        } else if (xSpeedPrey < 0 && getPreyMultiplier() == 1 || xSpeedPrey < 0 && getPreyMultiplier() == 2) { // If the multiplier was 1 or 2.
	        	g.drawImage(preyNL, xPrey, 310, this);
	        }
	        if (xSpeedPrey > 0 && getPreyMultiplier() == 2) { // If the multiplier was 2.
	        	g.drawImage(preyUR, xPrey + 120, 245, this);
	        	repaint();
	        } else if (xSpeedPrey < 0 && getPreyMultiplier() == 2) { // If the multiplier was 2.
	        	g.drawImage(preyUL, xPrey + 120, 245, this);
	        	repaint();
	        }
	        
	        // Configuring the images that are drawn for the predator multiplier.
	        if (xSpeedShark > 0 && getPredMultiplier() == 1 || xSpeedShark > 0 && getPredMultiplier() == 2) { // If the multiplier was 1 or 2.
	        	g.drawImage(predNR, xPredS, 180, this);
	        } else if (xSpeedShark < 0 && getPredMultiplier() == 1 || xSpeedShark < 0 && getPredMultiplier() == 2) { // If the multiplier was 1 or 2.
	        	g.drawImage(predNL, xPredS, 180, this);
	        }
	        if (xSpeedBird > 0 && getPredMultiplier() == 2) { // If the multiplier was 2.
	        	g.drawImage(predBR, xPredB, 18, this);
	        } else if (xSpeedBird < 0 && getPredMultiplier() == 2) { // If the multiplier was 2.
	        	g.drawImage(predBL, xPredB, 18, this);
	        }
	        
	        // Configuring the images that are drawn for the pollution multiplier.
	        if (ySpeedTrash > 0 && getPollMultiplier() == 1 || ySpeedTrash > 0 && getPollMultiplier() == 2) { // If the multiplier was 1 or 2.
	        	g.drawImage(pollN, 354, yTrash, this);
	        } else if (ySpeedTrash == 0 && getPollMultiplier() == 1 || ySpeedTrash == 0 && getPollMultiplier() == 2) { // If the multiplier was 1 or 2.
	        	g.drawImage(pollN, 354, yTrash, this);
	        }
	        if (ySpeedTrashUp > 0 && getPollMultiplier() == 2) { // If the multiplier was 2.
	        	g.drawImage(pollU, 298, yTrashUp, this);
	        } else if (ySpeedTrashUp == 0 && getPollMultiplier() == 2) { // If the multiplier was 2.
	        	g.drawImage(pollU, 298, yTrashUp, this);
	        }
	        if (getPollMultiplier() == -2) { // If the multiplier was -2.
	        	g.drawImage(pollD, 370, yTrash, this);
	        }
	        
	        // Configuring the images that are drawn for the invasive species multiplier.
	        if (getInvasiveMultiplier() == 1) { // If the multiplier was 1.
				g.drawImage(invas, 250, 467, this);
	        	g.drawImage(invas, 223, 467, this);
	        } else if (getInvasiveMultiplier() == 2) { // If the multiplier was 2.
	        	g.drawImage(invas, 230, 440, this);
	        	g.drawImage(invas, 250, 467, this);
	        	g.drawImage(invas, 223, 467, this);
	        	g.drawImage(invas, 420, 467, this);
	        } else if (getInvasiveMultiplier() == -2) { // If the multiplier was -2.
	        	g.drawImage(invas, 250, 467, this);
	        } 
		}
	}
}
