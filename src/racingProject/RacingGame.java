package racingProject;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.awt.*;

public class RacingGame extends JFrame implements ActionListener {

	Player player1 = new Player("Player 1");
	Player player2 = new Player("Player 2");
	private JPanel panel1;
	private JPanel panel2;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel totalPanelWest;
	private JPanel totalPanelEast;
	private JPanel totalPanelSouth;
	private JLabel emptyWest;
	//private JLabel emptyEast;
	private JLabel chooseCar1;
	private JLabel chooseCar2;
	private JLabel wagerWord1;
	private JTextField wagerBox1;
	private JLabel totalWord1;
	private JLabel totalWord2;
	private JTextField totalBox1;
	private JTextField totalBox2;

	private JButton betButton1;
	// private JButton runButton;

	private JRadioButton car1;
	private JRadioButton car12;
	private JRadioButton car13;
	private ButtonGroup radioButtonGroup1;

	private JRadioButton car2;
	private JRadioButton car22;
	private JRadioButton car23;
	private ButtonGroup radioButtonGroup2;
	private JSlider wagerSlider;
	
	private JLabel gif;
	private JPanel centerPanel;;
	private URL url;
	
	public RacingGame() throws MalformedURLException {
		// Create text for the title bar
		setTitle("Racing Game");
		setSize(1000,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// create label for panel1
		chooseCar1 = new JLabel("Choose your car: ");
		car1 = new JRadioButton("Hennessey Venom GT");
		car12 = new JRadioButton("Bugatti Veyron Super Sport");
		car13 = new JRadioButton("SSC Ultimate Aero");
		car1.addActionListener(new CarImage());
		car12.addActionListener(new CarImage());
		car13.addActionListener(new CarImage());
		wagerWord1 = new JLabel("WAGER");
		wagerBox1 = new JTextField(10);
		wagerBox1.setEnabled(false);
		wagerSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
		wagerSlider.addChangeListener(new SlideListener());
	    wagerSlider.setMajorTickSpacing(20);
	    wagerSlider.setMinorTickSpacing(5);
	    wagerSlider.setPaintTicks(true);
	    wagerSlider.setPaintLabels(true);
		totalWord1 = new JLabel("Cash Total:");
		totalBox1 = new JTextField(10);
		totalBox1.setText(""+String.format("%,.2f", player1.getCash()));
		totalBox1.setEnabled(false);
		emptyWest = new JLabel(" ");
		//emptyEast = new JLabel(" ");
	
		

		// Group the radio buttons panel1
		radioButtonGroup1 = new ButtonGroup();
		radioButtonGroup1.add(car1);
		radioButtonGroup1.add(car12);
		radioButtonGroup1.add(car13);
	

		betButton1 = new JButton("PLACE BET");
		betButton1.addActionListener(this);

		// add panel1 - panel with Radio Buttons
		panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel1.setBorder(BorderFactory.createTitledBorder("PLAYER 1"));
		panel1.setLayout(new GridLayout(4, 1));
		                
		// panel1.add(playerWord1);
		panel1.add(chooseCar1);
		panel1.add(car1);
		panel1.add(car12);
		panel1.add(car13);
		

		// add panel with total cash
		totalPanelWest = new JPanel();
		totalPanelWest.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		totalPanelWest.setLayout(new GridLayout(3, 2));
		totalPanelWest.add(totalWord1);
		totalPanelWest.add(totalBox1);

		// create label for panel2
		chooseCar2 = new JLabel("Choose your car:");
		car2 = new JRadioButton("Hennessey Venom GT");
		car22 = new JRadioButton("Bugatti Veyron Super Sport");
		car23 = new JRadioButton("SSC Ultimate Aero");
		car2.addActionListener(new CarImage());
		car22.addActionListener(new CarImage());
		car23.addActionListener(new CarImage());
		totalWord2 = new JLabel("Cash Total:");
		totalBox2 = new JTextField(10);
		totalBox2.setText(""+String.format("%,.2f", player1.getCash()));
		totalBox2.setEnabled(false);

		// Group the radio buttons panel2
		radioButtonGroup2 = new ButtonGroup();
		radioButtonGroup2.add(car2);
		radioButtonGroup2.add(car22);
		radioButtonGroup2.add(car23);

		 
		// add panel2
		panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel2.setBorder(BorderFactory.createTitledBorder("PLAYER 2"));
		panel2.setLayout(new GridLayout(4, 1));
		// panel1.add(playerWord1);
		panel2.add(chooseCar2);
		panel2.add(car2);
		panel2.add(car22);
		panel2.add(car23);
		

		// add panel with total cash
		totalPanelEast = new JPanel();
		totalPanelEast.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		totalPanelEast.setLayout(new GridLayout(3, 2));
		totalPanelEast.add(totalWord2);
		totalPanelEast.add(totalBox2);
		
		//add South panel with bet and wager
		totalPanelSouth = new JPanel();
		totalPanelSouth.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		totalPanelSouth.setLayout(new GridLayout(2, 2));
		totalPanelSouth.add(wagerWord1);
		totalPanelSouth.add(wagerBox1);
		totalPanelSouth.add(wagerSlider);
		totalPanelSouth.add(betButton1);
		totalPanelSouth.add(emptyWest);
		

		eastPanel = new JPanel(new GridLayout(2,1));
		westPanel = new JPanel(new GridLayout(2,1));

		eastPanel.add(panel2);
		eastPanel.add(totalPanelEast);
		westPanel.add(panel1);
		westPanel.add(totalPanelWest);
		
		
	
		url = new URL("https://slack-imgs.com/?c=1&url=https%3A%2F%2Fmedia1.giphy.com%2Fme"
				+ "dia%2Fl0HlVROZapDLw6E0M%2Fgiphy.gif");
	    Icon icon = new ImageIcon(url);
	    gif = new JLabel(icon);
	    centerPanel = new JPanel();
	    centerPanel.add(gif);

		
		add(eastPanel, BorderLayout.EAST);
		add(westPanel, BorderLayout.WEST);
		add(totalPanelSouth, BorderLayout.SOUTH);
		add(centerPanel,BorderLayout.CENTER);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
	
		
	
		Car car1 = new Car();  // Create car object for player one
		car1.setMake(selectCar(radioButtonGroup1)); //set the make from the ratio button
		player1.setVehicle(car1); //send car object to player
		
		Car car2 = new Car();
		car2.setMake(selectCar(radioButtonGroup2));
		player2.setVehicle(car2);
		
		
		//allows bet to occur as long as a bet is placed and the players both have a balance greater than 0
		if((!wagerBox1.getText().isEmpty())&&player1.getCash()>0&&player2.getCash()>0){  	
			double bet = Double.parseDouble(wagerBox1.getText());  //collects bet input by users
			if(player1.getCash()>=bet&&player2.getCash()>=bet){
			Bet b = new Bet(player1,player2,bet); 					// bet object
			b.Race();
			//Winner message
	
			JOptionPane.showMessageDialog(null, b.getWinner());
			// updates players account balance
			totalBox1.setText("$"+""+String.format("%,.2f", player1.getCash()));
			totalBox2.setText("$"+""+String.format("%,.2f", player2.getCash()));
			}
			else
				JOptionPane.showMessageDialog(null,"Bet is larger than player balance");
		} 
		
		wagerBox1.setText("");	//returns wager box back to being empty
	
		
		String video = getVideo();
		try {
			url = new URL(video);
		} catch (MalformedURLException e1) {
		
			e1.printStackTrace();
		}
	    Icon icon = new ImageIcon(url);
	    gif.setIcon(icon);
	    centerPanel.add(gif);
	}
	
	
	public String selectCar(ButtonGroup radio){   // Picks up  car radio selction to create car object
		String selected = "";
		Enumeration<AbstractButton> buttons = radio.getElements();
		while(buttons.hasMoreElements()){
				AbstractButton button = buttons.nextElement();
			if(button.isSelected())
				selected= button.getText();
			
		}
		return selected;
	}
	
	//Randomize gif in center panel
	public String getVideo(){
		String [] gifArr ={"https://slack-imgs.com/?c=1&url="
				+ "http%3A%2F%2Fmedia2.giphy."
				+ "com%2Fmedia%2FulZwxYQVqUWhW%2Fgiphy.gif", "http://i.giphy.com/8k6EJT"
				+ "TxzvIVG.gif","http://i.giphy.com/B1CrvUCoMxhy8.gif",
				"http://i.giphy.com/ROKcEzcG0wqqc.gif","http://i.giphy.com/xJUYqIVL45Cow.gif",
				"http://i.giphy.com/8wEzlZgZx5vjy.gif","https://slack-imgs.com/?c=1&url=https%3A%2F%2Fmedi"
				+ "a3.giphy.com%2Fmedia%2FAHOm9Xxo9gQqk%2Fgiphy.gif","https://slack-imgs.com/?c=1&url=https%"
				+ "3A%2F%2Fmedia1.giphy.com%2Fmedia%2F3o6ZsUwxolYZQ4WhiM%2Fgiphy.gif",
				"https://slack-imgs.com/?c=1&url=https%3A%2F%2Fmedia3.gi"
				+ "phy.com%2Fmedia%2FmfkBSPCioUixW%2Fgiphy.gif","https://slack-imgs.com/?c=1&url"
				+ "=http%3A%2F%2Fmedia.giphy.com%2Fmedia%2F13hBHuu2xQ0lxe%2Fgiphy-tumblr.gif",
				"https://slack-imgs.com/?c=1&url=https%3A%2F%2Fmedia1.giphy.com%2Fme"
				+ "dia%2F3o6Zt3qG8S2e4uQXo4%2Fgiphy.gif", "https://media4.giphy.com/media/3oEjIa1Bj4w8l5EfXa/200w.gif#0","https://media0.giphy.com/media/110ZMh8vWqs1rO/200.gif#20", "https://media3.giphy.com/media/wOl2FMxiLxMuk/200.gif#23", "https://media.giphy.com/media/11fucLQCTOdvBS/giphy.gif", "https://slack-imgs.com/?c=1&url=http%3A%2F%2Fmedia.giphy.com%2Fmedia%2Fhqh8NpKgBMRTa%2Fgiphy-tumblr.gif", "https://slack-imgs.com/?c=1&url=http%3A%2F%2Fmedia.giphy.com%2Fmedia%2FWCVpYUialUY9i%2Fgiphy-tumblr.gif", "https://media3.giphy.com/media/wOl2FMxiLxMuk/200.gif#23" };
		
		int vidSelection = (int)(Math.random() * gifArr.length);
		
		return gifArr[vidSelection];
	
	}
	
	
	//set's icon image base on car selection
	private class CarImage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ImageIcon imageIcon;
			if(e.getSource()==car1||e.getSource()==car2){
				imageIcon = new ImageIcon("HenVenGT.jpeg");
				
			}
			else if (e.getSource()==car12||e.getSource()==car22)
				imageIcon = new ImageIcon("BugVeySup.jpeg");
			else
				imageIcon = new ImageIcon("SscUltAero.jpeg");
				Image image = imageIcon.getImage();
				Image newImage = image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
				ImageIcon resizeImage = new ImageIcon(newImage);
				
				if(e.getSource()==car1|e.getSource()==car12||e.getSource()==car13)
					chooseCar1.setIcon(resizeImage);
				else
					chooseCar2.setIcon(resizeImage);
			
			
		}
	}
	
	//Sets bet based on slide bar
	private class SlideListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            double betValue = wagerSlider.getValue();
            wagerBox1.setText(""+String.format("%,.2f", betValue));
        }
    }
	
	

	public static void main(String[] args) throws MalformedURLException {
		RacingGame myFrame = new RacingGame();
		
		
	}
	


}