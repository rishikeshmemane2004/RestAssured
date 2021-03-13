package com.rough.datadriven;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DataDrivenTestJUnit4 {

	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{1,2},{3,4},{5,6},{7,8},{9,10}
		});
	}
	private int fInput;
	private int fExpected;
	
	public DataDrivenTestJUnit4(int input, int expected)
	{
		this.fInput    = input;
		this.fExpected = expected;
	}
	
	@Test
	public void test()
	{
		System.out.println(fInput + " " + fExpected);
	}
	
	
	
	
	
}
