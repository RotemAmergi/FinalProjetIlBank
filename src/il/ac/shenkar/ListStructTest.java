package il.ac.shenkar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 * @author Shlomi Yosef ,Rotem Emergi , Yoni Nezer
 * 
 * 
 */

public class ListStructTest extends ListStruct {

	private ListStruct ob;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}
	
	@AfterClass
	
	public static  void tearDownAfterClass() throws Exception  { }
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		ob = new ListStruct();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		ob =null;
	}

	/**
	 * Test method for ListStruct
	 */
	@Test
	public void testListStruct() { }
	

	/**
	 * Test method for getlName(
	 */
	@Test
	public void testgetlName()
	{

	}

	/**
	 * Test method for getlUnit()
	 */
	@Test
	public void testgetlUnit()
	{
		
	}

	/**
	 * Test method for getlCurrCode()
	 */
	@Test
	public void testgetlCurrCode()
	{

	}

	/**
	 * Test method for getlCountry()
	 */
	@Test
	public void testgetlCountry() 
	{
	
	}

	/**
	 * Test method for getlRate()
	 */
	@Test
	public void testgetlRate()
	{

	}

	/**
	 * Test method for getlChange()
	 */
	@Test
	public void testgetlChange() { }
	
	/**
	 * Test method for setlName(String lName)
	 */
	@Test
	public void testsetlName()
	{ 
		ob.setlName("Shekeltest");  
	    assertTrue(ob.getlName().equals("")); 
	}

	
	/**
	 * Test method for setlUnit(int lUnit)
	 */
	@Test
	public void testSetUnit() 
	{
	    ob.setlUnit(0);  
	    assertTrue(ob.getlUnit() < 0); 
	   
	}

	/**
	 * Test method for setlCurrCode(String lCurrCode) 
	 */
	@Test
	public void testsetlCurrCode()
	{
		  ob.setlCurrCode("codetest");  
		  assertTrue(ob.getlCurrCode().equals("")); 
	}

	/**
	 * Test method for setlCurrCode(String lCurrCode)
	 */
	@Test
	public void testsetlCurrCode(String lCurrCode) 
	{
	    ob.setlCurrCode("Countrytest");  
	    assertTrue(ob.getlCurrCode().equals("")); 
	}

	/**
	 * Test method for setlRate(double lRate)
	 */
	@Test
	public void testSetRate() 
	{
	    ob.setlRate(0);  
	    assertTrue(ob.getlRate() < 0);
	    fail("Rate of coin is negetive");
	}

	/**
	 * Test method for setlChange(double lChange)
	 */
	@Test
	public void testsetlChange() { }
	
		

}
