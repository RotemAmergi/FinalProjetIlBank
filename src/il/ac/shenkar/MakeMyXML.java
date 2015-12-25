package il.ac.shenkar;


import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.w3c.dom.*;

import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;



/**
 * 
 * @author Shlomi Yosef ,Rotem Emergi , Yoni Nezer
 * 
 * 
 */


public class MakeMyXML implements Runnable {
	

	public static Logger logger = Logger.getLogger(Main.class.getName());
	
	

	ArrayList<MyList> myList;
	
	Scanner in = new Scanner(System.in);
	int ans;
	
	
	boolean networkChecker; /** in case i have any exception i don't want to keep going on without updating the GUI
							* so in this case i will let the user decide if he want to re-try update it's file or keep going on
							* in case that this is the first time the program is running and i got exception and the user will not
							* chooce's the re-try option, the GUI will go on empty, since he won't have any information yet
							*/
	
	
	/**Loop Start
	*
	* this XML Object will receive information from the "http://www.boi.org.il/currency.xml" web-site 
	*
	* IF we have a connection it will do that thing above and save it into XML file
	*
	* Else, we are going to try and read it from the computer(older file)
	*
	*IF those things above does not work it will send a msgBox to the screen and end the program since we have no data
	*
	*/
	
	
	


	
	public void run() {
		 while (true) {
	            
	            	

				
				
				try{
						
					int i;
				    InputStream iStream = null;
				    HttpURLConnection con = null;
			    	networkChecker = false;
			    	URL A = new URL("http://www.boi.org.il/currency.xml");
					   
				    
				    	
				    	
					    try{
					 	
		/** I am going to read the XML File from the Internet and then insert all of it's information into
		 *  MyFile.txt which will be stored in my computer
		 */
					    	
					    	con = (HttpURLConnection)A.openConnection();
							con.setRequestMethod("GET");
							con.connect();
							iStream = con.getInputStream();
							DocumentBuilderFactory bFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder builder = bFactory.newDocumentBuilder();
							Document doc = builder.parse(iStream);

							
							NodeList listALL = doc.getElementsByTagName("CURRENCY");
							NodeList listNAME = doc.getElementsByTagName("NAME");
							NodeList listUNIT = doc.getElementsByTagName("UNIT");
							NodeList listCURRENCYCODE = doc.getElementsByTagName("CURRENCYCODE");
							NodeList listCOUNTRY = doc.getElementsByTagName("COUNTRY");
							NodeList listRATE = doc.getElementsByTagName("RATE");
							NodeList listCHANGE = doc.getElementsByTagName("CHANGE");
							
							
							myList = new ArrayList<MyList>();
							
							
								
								for(i=0 ; i < listALL.getLength() ; i++){
							
									myList.add(new MyList());
									
									myList.get(i).setListName(listNAME.item(i).getFirstChild().getNodeValue());
									myList.get(i).setListCurrCode(listCURRENCYCODE.item(i).getFirstChild().getNodeValue());
									myList.get(i).setListCountry(listCOUNTRY.item(i).getFirstChild().getNodeValue());
									myList.get(i).setListUnit(Integer.parseInt(listUNIT.item(i).getFirstChild().getNodeValue()));
									myList.get(i).setListChange(Double.parseDouble(listCHANGE.item(i).getFirstChild().getNodeValue()));
									myList.get(i).setListRate(Double.parseDouble(listRATE.item(i).getFirstChild().getNodeValue()));
								
								}
							


								myList.add(new MyList());
								myList.get(i).setListName("Shekel");
								myList.get(i).setListCurrCode("NIS");
								myList.get(i).setListCountry("Israel");
								myList.get(i).setListUnit(1);
								myList.get(i).setListChange(0);
								myList.get(i).setListRate(1);
								
			/**					
		//####################################### Create And Update The XML File - START #######################################
				*/			
							
							
						
							DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
							/**					 
							// root- CURRENCIES element
							 * 
							 */
							doc = docBuilder.newDocument();
							Element rootElement = doc.createElement("CURRENCIES");
							doc.appendChild(rootElement);
					 
							
							Element[] stuff = new Element[listALL.getLength()+1];
							
							
							for(i=0 ; i < listALL.getLength()+1; i++){
									
								/**
								// CURRENCY elements
								 * 
								 */
								stuff[i] = doc.createElement("CURRENCY");
								rootElement.appendChild(stuff[i]);
						 	 
								/**
								// NAME elements
								 * 
								 */
								Element NAME = doc.createElement("NAME");
								NAME.appendChild(doc.createTextNode(myList.get(i).getListName()));
								stuff[i].appendChild(NAME);
						 
								/**
								// UNIT elements
								 * 
								 */
								Element UNIT = doc.createElement("UNIT");
								UNIT.appendChild(doc.createTextNode(Integer.toString(myList.get(i).getListUnit())));
								stuff[i].appendChild(UNIT);

								/**
								// CURRENCYCODE elements
								 * 
								 */
								Element CURRENCYCODE = doc.createElement("CURRENCYCODE");
								CURRENCYCODE.appendChild(doc.createTextNode(myList.get(i).getListCurrCode()));
								stuff[i].appendChild(CURRENCYCODE);

								/**
								// COUNTRY elements
								 * 
								 */
								Element COUNTRY = doc.createElement("COUNTRY");
								COUNTRY.appendChild(doc.createTextNode(myList.get(i).getListCountry()));
								stuff[i].appendChild(COUNTRY);

								/**
								// RATE elements
								 * 
								 */
								Element RATE = doc.createElement("RATE");
								RATE.appendChild(doc.createTextNode(Double.toString(myList.get(i).getListRate())));
								stuff[i].appendChild(RATE);

								/**
								// CHANGE elements
								 * 
								 */
								Element CHANGE = doc.createElement("CHANGE");
								CHANGE.appendChild(doc.createTextNode(Double.toString(myList.get(i).getListChange())));
								stuff[i].appendChild(CHANGE);
								
							
							}
							
							
							
							
							/** write the content into MyFile.xml  */
							
							TransformerFactory transformerFactory = TransformerFactory.newInstance();
							Transformer transformer = transformerFactory.newTransformer();
							DOMSource source = new DOMSource(doc);
							StreamResult result = new StreamResult(new File("myFile.xml"));
					 
					 
							transformer.transform(source, result);
					 
							logger.info("File Successfully Updated From Network");
							System.out.println("File Successfully Updated From Network");
							networkChecker = true;
						
		/**					
		//####################################### Create And Update The XML File - END #######################################
				*/			

					    	
					    	
					    }
					    
						catch(Exception e){
					    	
							logger.info("Input Output / Connection Exception");
					        networkChecker = false;
							
					    }
						
						finally{
					    
							if(iStream!=null){
								
								
						           try{
						        	   
						        	   iStream.close();
						           }
						           
						           
						           catch(IOException e){

										logger.info("Input Output Exception");
						           }
						           
				   
					         }
					           
							
			/**				
		//##################################################################################################################
		//################################# NO NETWORK ############################################################################
		//##################################################################################################################					
				*/			
					           
					           if(!networkChecker){ /** if i am in this IF statement that means i did not had a connection OR
					        	   					// i had an exception, which means i want to read from the file
					        	   					 * 
					        	   					 */
					        	   
					      	   
					        	   
					        	   /** In case there is no Internet connection i will just open the file(MyFile.xml) from
					        	    *  my computer and read it
					        	   */

					        	   
					        	   JOptionPane.showMessageDialog(null, "The program did not updated the 'myFile.xml' File \ndue to failed to connect the internet");
					        	   
					        	   
					        	   
					        	   try{
					        		   

					        			File XmlFile = new File("myFile.xml");
					        			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					        			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					        			Document doc = dBuilder.parse(XmlFile);
					        		 
					        			doc.getDocumentElement().normalize();
					        		 
					    				NodeList listALL = doc.getElementsByTagName("CURRENCY");
										NodeList listNAME = doc.getElementsByTagName("NAME"); 
										NodeList listUNIT = doc.getElementsByTagName("UNIT");
										NodeList listCURRENCYCODE = doc.getElementsByTagName("CURRENCYCODE");
										NodeList listCOUNTRY = doc.getElementsByTagName("COUNTRY");
										NodeList listRATE = doc.getElementsByTagName("RATE");
										NodeList listCHANGE = doc.getElementsByTagName("CHANGE");
										
										
										myList = new ArrayList<MyList>();
										
										
											
											for(i=0 ; i < listALL.getLength() ; i++){
										
												myList.add(new MyList());
												
											
												myList.get(i).setListName(listNAME.item(i).getFirstChild().getNodeValue());
												myList.get(i).setListCurrCode(listCURRENCYCODE.item(i).getFirstChild().getNodeValue());
												myList.get(i).setListCountry(listCOUNTRY.item(i).getFirstChild().getNodeValue());
												myList.get(i).setListUnit(Integer.parseInt(listUNIT.item(i).getFirstChild().getNodeValue()));
												myList.get(i).setListChange(Double.parseDouble(listCHANGE.item(i).getFirstChild().getNodeValue()));
												myList.get(i).setListRate(Double.parseDouble(listRATE.item(i).getFirstChild().getNodeValue()));
											
											}
											
											
						/**				
					//####################################### Create And Update The XML File - START #######################################
						*/				
										
										
									
										DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
										DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
								 
										/**
										// root- CURRENCIES element
										 * 
										 */
										doc = docBuilder.newDocument();
										Element rootElement = doc.createElement("CURRENCIES");
										doc.appendChild(rootElement);
								 
										
										Element[] staff = new Element[listALL.getLength()];
										
										
										for(i=0 ; i < listALL.getLength(); i++){
												
											/**
											// CURRENCY elements
											 * 
											 */
											staff[i] = doc.createElement("CURRENCY");
											rootElement.appendChild(staff[i]);
									 
											/**
											// NAME elements
											 * 
											 */
											Element NAME = doc.createElement("NAME");
											NAME.appendChild(doc.createTextNode(myList.get(i).getListName()));
											staff[i].appendChild(NAME);
									  
											/**
											// UNIT elements
											 * 
											 */
											Element UNIT = doc.createElement("UNIT");
											UNIT.appendChild(doc.createTextNode(Integer.toString(myList.get(i).getListUnit())));
											staff[i].appendChild(UNIT);

											/**
											// CURRENCYCODE elements
											 * 
											 */
											Element CURRENCYCODE = doc.createElement("CURRENCYCODE");
											CURRENCYCODE.appendChild(doc.createTextNode(myList.get(i).getListCurrCode()));
											staff[i].appendChild(CURRENCYCODE);

											/**
											// COUNTRY elements
											 * 
											 */
											Element COUNTRY = doc.createElement("COUNTRY");
											COUNTRY.appendChild(doc.createTextNode(myList.get(i).getListCountry()));
											staff[i].appendChild(COUNTRY);

											/**
											// RATE elements
											 * 
											 */
											Element RATE = doc.createElement("RATE");
											RATE.appendChild(doc.createTextNode(Double.toString(myList.get(i).getListRate())));
											staff[i].appendChild(RATE);

											/**
											// CHANGE elements
											 * 
											 */
											Element CHANGE = doc.createElement("CHANGE");
											CHANGE.appendChild(doc.createTextNode(Double.toString(myList.get(i).getListChange())));
											staff[i].appendChild(CHANGE);
											
										
										}
										
										logger.info("File Successfully Updated From Computer");
										System.out.println("File Successfully Updated From Computer");
										networkChecker = true;
									
					/**					
					//####################################### Create And Update The XML File - END #######################################
						*/				

					        	
					        		   
					        		   
					        		   
					        		   
					        	   }
					        	   catch(Exception e){

					        		   /** There is no connection to the Internet AND there is no File on my computer, which means
					        		    *  i can't get any information, the program will end 
					        		    */
					        		   
										logger.info("Input/Output Exception"+" - The Program Failed Duo To :\n1. No Internet Connection\n2. The File \"MyFile.xml\" Does Not Exists");
					        	   	   JOptionPane.showMessageDialog(null, "The Program Failed Duo To :\n1. No Internet Connection\n2. The File \"MyFile.xml\" Does Not Exists");
					        	   	   System.exit(-1);
					 			      
					        	   }
					        	   
					           
					       }
					           
			/**		           
		//##################################################################################################################
		//################################# NO NETWORK ############################################################################
		//##################################################################################################################					
				*/	           
					           
					        
					           
					           
					           
					           
							
					       if(con!=null){
					    	   
					           con.disconnect();   
					       }
					     
						}
						
					
					
					    Thread.sleep(600000);
			            	
				}
				
				catch(Exception e){
					logger.info("Unknowen Error");
					e.printStackTrace();
				}
				
					
	            	
	            logger.info("Update MakeMyXML Thread ");
		 }
		
	}
	
}
