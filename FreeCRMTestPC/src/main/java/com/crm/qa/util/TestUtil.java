package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{

	public static long PAGE_LOAD_TIMEOUT=50;
	public static long IMPLICIT_WAIT = 50;
	
	public void awitchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	
}
