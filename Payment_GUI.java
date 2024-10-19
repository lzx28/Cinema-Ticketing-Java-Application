import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static javax.swing.JOptionPane.*;

public class Payment_GUI extends JFrame implements ActionListener, ItemListener {

	public JTextField jtfTotal;
	public JRadioButton jrbCash, jrbCards, jrbOnlineBanking;
	public JButton bProceed, bBack;
	public ButtonGroup bg = new ButtonGroup();
	public String method =" ";
	
	//Data
	public String movieName = "", date = "", time = "", hall = ""; //MovieList Class
	public int ticketType[] = new int[3]; //Ticketing Class
	public int ticketNumber = 0; //Ticketing Class
	public String seating[] = new String[10]; //Hall Class
	public int comboNumber[] = new int[3]; //AddOn Class

	public Payment_GUI() {
		
		setTitle("Payment Method");
		Container canvas1 = getContentPane();
		canvas1.setLayout(new BorderLayout());
		
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout());
		title.add(new Label("Payment Method"));
		
		JPanel line = new JPanel();
		line.setLayout(new FlowLayout());
		line.add(new Label("-----------------------------------------------------"));
		
		JPanel total = new JPanel();
		total.setLayout(new FlowLayout());
		total.add(new JLabel("Total : RM"));
		total.add(jtfTotal = new JTextField(6));
		jtfTotal.setEditable(false);
		
		JPanel memo = new JPanel();
		memo.setLayout(new FlowLayout());
		memo.add(new Label("Please select your payment method :)"));
		
		JPanel cash = new JPanel();
		cash.setLayout(new FlowLayout());
		cash.add(jrbCash = new JRadioButton("Cash"));
		bg.add(jrbCash);
		
		JPanel cards = new JPanel();
		cards.setLayout(new FlowLayout());
		cards.add(jrbCards = new JRadioButton("Credit/Debit Cards"));
		bg.add(jrbCards);
		
		JPanel Online = new JPanel();
		Online.setLayout(new FlowLayout());
		Online.add(jrbOnlineBanking = new JRadioButton("Online Banking"));
		bg.add(jrbOnlineBanking);
		
		JPanel line1 = new JPanel();
		line1.setLayout(new FlowLayout());
		line1.add(new Label("-----------------------------------------------------"));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(bBack = new JButton("Back"));
		buttons.add(bProceed = new JButton("Proceed"));
		bProceed.setEnabled(false);
		
		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		north.add(title, BorderLayout.NORTH);
		north.add(line, BorderLayout.CENTER);
		north.add(memo, BorderLayout.SOUTH);
		
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(cash, BorderLayout.NORTH);
		center.add(cards, BorderLayout.CENTER);
		center.add(Online, BorderLayout.SOUTH);
		
		JPanel south = new JPanel();
		south.setLayout(new BorderLayout());
		south.add(line1, BorderLayout.NORTH);
		south.add(total, BorderLayout.CENTER);
		south.add(buttons, BorderLayout.SOUTH);
		
		canvas1.add(north, BorderLayout.NORTH);
		canvas1.add(center, BorderLayout.CENTER);
		canvas1.add(south, BorderLayout.SOUTH);
		
		bBack.addActionListener(this);
		bProceed.addActionListener(this);
		jrbCash.addItemListener(this);
		jrbCards.addItemListener(this);
		jrbOnlineBanking.addItemListener(this);
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() instanceof JRadioButton) {
			if(jrbCash.isSelected()) {
				this.method="Cash";
			}
			else if(jrbCards.isSelected()) {
				this.method = "Credit/Debit Cards";
			}
			else if (jrbOnlineBanking.isSelected()) {
				this.method = "Online Banking";
			}
		}
		boolean bool = false;
		
		if(e.getSource() instanceof JRadioButton) 
		{
			if(jrbCash.isSelected() || jrbCards.isSelected() || jrbOnlineBanking.isSelected()) 
			{
				bool = true;
			}
			else
			{
				bool = false;
			}
		}

		if (bool == true) 
		{
			bProceed.setEnabled(true);
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		//Go to Completed
		if(e.getSource() == bProceed)
		{
			PaymentData next = new PaymentData
			(this.movieName, this.hall, this.date, this.time, this.ticketType, this.seating, this.comboNumber);
			next.PaymentToCompleted();
			this.dispose();
		}
			
		//Back to Payment
		if(e.getSource() == bBack) 
		{
			PaymentData next = new PaymentData
			(this.movieName, this.hall, this.date, this.time, this.ticketType, this.seating, this.comboNumber);
			next.ReviewSummaryToPayment();
			this.dispose();
		}
	}
	
	
//end
}


	

