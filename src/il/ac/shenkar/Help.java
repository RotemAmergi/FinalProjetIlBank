package il.ac.shenkar;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * 
 * @author Shlomi Yosef ,Rotem Emergi , Yoni Nezer
 * 
 * 
 */


/**
//########################################## Help Menu - START ###########################################
 * In here it's provide for the user a information 
*/
class Help extends JFrame{

	
	JLabel Title;
	JLabel Line1, Line2, Line2ex1, Line2ex2, Line3, Line4, Line5, Line6, Line7;
	
	Help(){

		super("Help Menu");

		
		
		Title = new JLabel("Help Menu");
		
		Line1 = new JLabel("* This Is A Currency Exchange Converter");
		Line2 = new JLabel("* This App Create A File Named MyXML");
		Line2ex1 = new JLabel("  Which Is Getting Information From The Web :");
		Line2ex2 = new JLabel("  http://www.boi.org.il/currency.xml");
		Line3 = new JLabel("* Have Fun ~!");
		Line4 = new JLabel("* Made By :");
		Line5 = new JLabel("* Shlomi Yosef - 201119864");
		Line6 = new JLabel("* Yoni Nezer - 201319142");
		Line7 = new JLabel("* Rotem Emergi - 302677174");
		
		setLayout(null);
		
		this.getContentPane().setBackground(Color.lightGray);
		this.setSize(400, 500);
		this.setLocation(400, 50);
		this.setVisible(true);	


		Title.setSize(150,32); 
		Title.setLocation(125, 30);
		Title.setForeground(Color.CYAN);
		Title.setFont(new Font("Sans Serif", Font.PLAIN, 25));
		add(Title);
		
		
		Line1.setSize(350,32); 
		Line1.setLocation(40, 100);
		Line1.setForeground(Color.white);
		Line1.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line1);
		
		
		Line2.setSize(350,32); 
		Line2.setLocation(40, 150);
		Line2.setForeground(Color.white);
		Line2.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line2);
		Line2ex1.setSize(350,32); 
		Line2ex1.setLocation(40, 165);
		Line2ex1.setForeground(Color.white);
		Line2ex1.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line2ex1);
		Line2ex2.setSize(350,32); 
		Line2ex2.setLocation(40, 180);
		Line2ex2.setForeground(Color.white);
		Line2ex2.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line2ex2);
		

		Line3.setSize(350,32); 
		Line3.setLocation(40, 230);
		Line3.setForeground(Color.green);
		Line3.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line3);

		
		Line4.setSize(350,32); 
		Line4.setLocation(40, 280);
		Line4.setForeground(Color.magenta);
		Line4.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line4);

		
		Line5.setSize(350,32); 
		Line5.setLocation(40, 310);
		Line5.setForeground(Color.blue);
		Line5.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line5);
		

		Line6.setSize(350,32); 
		Line6.setLocation(40, 340);
		Line6.setForeground(Color.black);
		Line6.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line6);



		Line7.setSize(350,32); 
		Line7.setLocation(40, 370);
		Line7.setForeground(Color.red);
		Line7.setFont(new Font("Sans Serif", Font.BOLD, 15));
		add(Line7);

		
		
	}

}
/**
//########################################## Help Menu - END ###########################################
*/

