package il.ac.shenkar;


import java.awt.*;
import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

import javax.swing.*;

import java.awt.event.*;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 


/**
 * 
 * @author Shlomi Yosef ,Rotem Emergi , Yoni Nezer
 * 
 * 
 */

/** This ClientGUI Object Will open the XML file we saved at the last stag( at  the MyXML Object) and put it on MyList Object
* Then it will use this information saved at the MyList Object for display on the GUI layout, and for converts 
* Probable need to use an endless loop in here, for events handler (Button)
*/

public class ClientGUI extends JFrame implements Runnable{
	

	public static Logger logger = Logger.getLogger(Main.class.getName());
/**	
// Event Handlers	
	*/
	HelpHandler eventHelp = new HelpHandler();
	SubmitHandler submitHandler = new SubmitHandler();
/**	
// Buttons
	*/
	JButton bHelp;
	JButton bSubmit;

/**
// Labels	
 * 
 */
	JLabel lFrom, lTo, webDate, amountLable ;
	
/**	
// Different
	*/
	int myListTotal;	
	String listLastWebUpdate;
	JComboBox<?> boxFrom, boxTo;
	ArrayList<ListStruct> myList;
	TextField amount;
	
	
	
	
	ClientGUI(){
		
		
		super("Currency Exchange Rates Application");
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		// Any
		 * 
		 */
		int i = 0;
		myListTotal = 0;
		amount = new TextField("1");
		
		/**
		// buttons
		 * 
		 */
		bHelp = new JButton("Help");
		bSubmit = new JButton("Submit");
		
		/**
		// label
		 * 
		 */
		lFrom = new JLabel("Convert From");
		lTo = new JLabel("Convert To");
		webDate = new JLabel("");
		amountLable = new JLabel("amount");
				
		/**
		// Get Date
		 * 
		 */
		Locale aLocale = new Locale.Builder().setLanguage("iw").setRegion("IL").build();
		DateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy", aLocale);
		timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
		
		/**
//######################## Take Info From File Into MyList Object - Start #######################################################
		*/
		
		try{
		
				/** Will open the file "MyFile.xml" From my computer and read it's data
				 * 
				*/
			
			File xmlFile = new File("myFile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);	
			
			
			doc.getDocumentElement().normalize();
		
			NodeList listALL = doc.getElementsByTagName("CURRENCY");
			
			
			NodeList listNAME = doc.getElementsByTagName("NAME");
			NodeList listUNIT = doc.getElementsByTagName("UNIT");
			NodeList listCURRENCYCODE = doc.getElementsByTagName("CURRENCYCODE");
			NodeList listCOUNTRY = doc.getElementsByTagName("COUNTRY");
			NodeList listRATE = doc.getElementsByTagName("RATE");
			NodeList listCHANGE = doc.getElementsByTagName("CHANGE");
			
			
	
			myListTotal = listALL.getLength();
	
	
			myList = new ArrayList<ListStruct>();
				
			
			
				
				for(i=0 ; i < listALL.getLength() ; i++){
			
					myList.add(new ListStruct());
					
				
					myList.get(i).setlName(listNAME.item(i).getFirstChild().getNodeValue());
					myList.get(i).setlCurrCode(listCURRENCYCODE.item(i).getFirstChild().getNodeValue());
					myList.get(i).setlCountry(listCOUNTRY.item(i).getFirstChild().getNodeValue());
					myList.get(i).setlUnit(Integer.parseInt(listUNIT.item(i).getFirstChild().getNodeValue()));
					myList.get(i).setlChange(Double.parseDouble(listCHANGE.item(i).getFirstChild().getNodeValue()));
					myList.get(i).setlRate(Double.parseDouble(listRATE.item(i).getFirstChild().getNodeValue()));
				
				}
			
			
			
			
		 
			
		}
		
		catch (Exception e) {
			logger.info("GUI Error, Could Not Load The Information Into The JComboBox");
			e.printStackTrace();
		}
		
		
		
		
		
		
/**
//######################## Take Info From File Into MyList Object - End #######################################################
		
		*/
		
		
		String[] Options = new String[myListTotal]; 
		
		/** Creating a list of string which will be used for the JComboBox Later
		*   
		*/
		
		
	
		for(i=0 ; i< myListTotal; i++){
					
			Options[i] = myList.get(i).getlName() +" - "+ myList.get(i).getlCountry();	
		}
			
		
		
		boxFrom = new JComboBox<Object>(Options);
		boxTo = new JComboBox<Object>(Options);
			

		
		/** My GUI definitions */
		
		setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);
		this.setSize(500, 300);
		this.setLocation(400, 190);
		this.setVisible(true);	
		
		
		
		bHelp.setSize(70,32); 
		bHelp.setBorder(null);
		bHelp.setLocation(410, 220);
		bHelp.addActionListener(eventHelp);
		bHelp.setBackground(Color.lightGray);
		bHelp.setFont(new Font("Sans Serif", Font.PLAIN, 20));

		add(bHelp);


		webDate.setText("Today's Date : "+timeFormat.format(new Date()));
		webDate.setSize(200,32); 
		webDate.setLocation(4, 235);
		webDate.setFont(new Font("Sans Serif", Font.PLAIN, 13));
		add(webDate);
		
		bSubmit.setSize(100,32); 
		bSubmit.setLocation(190, 200);
		bSubmit.addActionListener(submitHandler);
		add(bSubmit);
		
		
		
		lFrom.setSize(100,32); 
		lFrom.setLocation(50, 20);
		lFrom.setFont(new Font("Sans Serif", Font.PLAIN, 15));

		add(lFrom);
		
		boxFrom.setSize(160,25); 
		boxFrom.setLocation(40, 60);
		boxFrom.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		boxFrom.setVisible(true);
		add(boxFrom);
		
		
		
		amountLable.setSize(50,25); 
		amountLable.setLocation(120, 110);
		amountLable.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		amountLable.setVisible(true);
		add(amountLable);
		
		amount.setSize(130,25); 
		amount.setLocation(180, 110);
		amount.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		amount.setVisible(true);
		add(amount);
		
		lTo.setSize(100,32); 
		lTo.setLocation(310, 20);
		lTo.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		add(lTo);
		
		
		boxTo.setSize(160,25); 
		boxTo.setLocation(300, 60);
		boxTo.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		boxTo.setVisible(true);
		add(boxTo);

	
		
	}
	
	
	
	/**
	
	//################################# Events Handler - START ###########################################
	
	

	//####################### Help #################################
		*/
		private class HelpHandler implements ActionListener{ 	
																
			public void actionPerformed(ActionEvent myEvent){ /** Handling a click on the Help menu*/	

				new Help();
			}

		}	
		
		
		/**

	//####################### Submit #################################	
		*/
		private class SubmitHandler implements ActionListener{ 	/** inner class, it auto inheriting */
																/** all of the outer class methods */
			public void actionPerformed(ActionEvent myEvent){ 	/** coming when you call the class */

				
				/**
				 * p get the input from the  user and take with the regular expiration 
				 * ([0-9]+) just the number
				 */
			    Pattern p = Pattern.compile("([0-9]+)");
			    Matcher m = p.matcher(amount.getText());
			    if (m.find()) {
			    	
			      
			      int num =  Integer.parseInt(m.group(1));

					if(num == 0)
						num=1;
					
			      JOptionPane.showMessageDialog(null, num +" "+myList.get(boxFrom.getSelectedIndex()).getlName()+"-"+myList.get(boxFrom.getSelectedIndex()).getlCountry()+" Is : "+        Double.parseDouble(new DecimalFormat("##.###").format(            (num* myList.get(boxFrom.getSelectedIndex()).getlRate()) / myList.get(boxTo.getSelectedIndex()).getlRate()              ))              +" " +myList.get(boxTo.getSelectedIndex()).getlName()+"-"+myList.get(boxTo.getSelectedIndex()).getlCountry()             );
				
					
			    } else {
			    	

			    	logger.info("This \"Amount\" Input Is Not Allowed"); /** we have created an input check above so i am not */
			    														/** sure how can you get here.. maybe if you did not inserted anything */
			    	System.out.println("No match.");
			      
			    }
			    
			    
		
				
				
				
			}

		}

/**
 * Its a Thread for Gui 
 */


	public void run() {
		while (true) {
            try
            {
                Thread.sleep(300000);
            } catch (InterruptedException e)
            {
            	logger.info("The Gui Thread doesn't work");
                e.printStackTrace();
            }
            logger.info("Update Gui Thread ");
		}
		
	}	
		
		

/**
	//################################# Events Handler - END ###########################################
	
	*/
	
	
	
	
	
	
}
