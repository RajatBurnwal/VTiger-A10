package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationPractice {

	@Test
	public void test()
	{
		System.out.println("Test method executed");
	}
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("Before suite executed");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("After suite executed");
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("Before class executed");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("After class executed");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("Before method executed");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("After method executed");
	}
}
