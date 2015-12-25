package il.ac.shenkar;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.swing.JOptionPane;

import org.junit.Test;


/**
 * 
 * @author Shlomi Yosef ,Rotem Emergi , Yoni Nezer
 * 
 * 
 */


public class MyListTest extends MyList{

	String listName;
	int listUnit;
	String listCurrCode;
	String listCountry;
	double listRate;
	double listChange;

/** Contain all of the information from the bank web-site and we will use it at the ClientGUI Object
*/
	
	/**
//############################## Generated Getters+Setters - START ##################################################################



/**
//########################################  Name
 * 
 */
 



	
	@Test
	public void setListNameTest(String listName) {
		

	}
	
	
/**
//########################################  Unit
 * 
 * @param listUnit
 */


	@Test
	public void setListUnitTest(int listUnit) {


	}

	
/**
//######################################## Currency Code
 * 
 * @param listCurrCode
 */


	@Test
	public void setListCurrCodeTest(String listCurrCode) {


	}
	

/**
//########################################  Country
 * 
 * @param listCountry
 */


	
	@Test
	public void setListCountryTest(String listCountry) {


	}

/**
//########################################  Rate
 * 
 * @param listRate
 */
	

	@Test
	public void setListRateTest(double listRate) {
	

		if(listRate <= 0){
			JOptionPane.showMessageDialog(null, "The Rate Cannot Be Lower/Equal 0");
			System.exit(-1);
			
		}else{
			
			this.listRate = listRate;
		}

		
	}

/**
//########################################	Change
 * 
 * @param listChange
 */


	
	@Test
	public void setListChangeTest(double listChange) {
		
		this.listChange = listChange;
	}


	
	
	/**
//############################## Generated Getters+Setters - END ##################################################################	
	*/
}
