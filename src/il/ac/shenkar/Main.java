package il.ac.shenkar;



import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;



/**
 * 
 * @author Shlomi Yosef ,Rotem Emergi , Yoni Nezer
 * This is the main  
 * 
 */

public class Main {
	
	public static Logger logger = Logger.getLogger(Main.class.getName());
	
	
	public static void main(String arg[]){
		
		/**
		 * Create the logs.txt file for the logs 
		 */
		BasicConfigurator.configure();
		try
		{
			logger.addAppender(new FileAppender(new SimpleLayout(), "logs.txt"));
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
		/**
		 * Create for the first time the MakeMyXML class 
		 */
			MakeMyXML xmlHandler = new MakeMyXML(); 
		/**
		 * Create for the first time the ClientGUI class 
		 */
			ClientGUI GUI = new ClientGUI();
		/**
		 * The thread for the program 
		 */
			Thread t1 = new Thread(xmlHandler);
			Thread t2 = new Thread(GUI);
			t1.start();
			t2.start();
			
		
	}
	
	
}
