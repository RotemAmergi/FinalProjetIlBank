package il.ac.shenkar;

import javax.swing.JOptionPane;


/**
 * 
 * @author Shlomi Yosef ,Rotem Emergi , Yoni Nezer
 * 
 * 
 */


public class MyList {

	String listName;
	int listUnit;
	String listCurrCode;
	String listCountry;
	double listRate;
	double listChange;

/** Contain all of the information from the bank web-site and we will use it at the ClientGUI Object

	
	
//############################## Generated Getters+Setters - START ##################################################################




//########################################  Name
 * @return  Name
	*/
	
	public String getListName() {
		
		return listName;
	}
	
	
	public void setListName(String listName) {
		
		this.listName = listName;
	}
	
	
/**
//########################################  Unit
 * 
 * @return Unit
 */
 

	
	public int getListUnit() {
		
		return listUnit;
	}
	
	
	public void setListUnit(int listUnit) {
		
		this.listUnit = listUnit;
	}

	
/**
//######################################## Currency Code
 * 
 * @return Currency Code
 */
 
	
	
	
	public String getListCurrCode() {
		
		return listCurrCode;
	}
	
	
	public void setListCurrCode(String listCurrCode) {
		
		this.listCurrCode = listCurrCode;
	}
	

/**
//########################################  Country
 * 
 * @return Country
 */

	
	public String getListCountry() {
		
		return listCountry;
	}
	

	public void setListCountry(String listCountry) {
		
		this.listCountry = listCountry;
	}

/**
//########################################  Rate
 * 
 * @return Rate
 */
	
	
	
	public double getListRate() {
		
		return listRate;
	}
	
	public void setListRate(double listRate) {
	

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
 * @return Change
 */
	

	public double getListChange() {
		
		return listChange;
	}
	
	
	public void setListChange(double listChange) {
		
		this.listChange = listChange;
	}


	
	
	/**
//############################## Generated Getters+Setters - END ##################################################################	
 * 
 */
	
}
