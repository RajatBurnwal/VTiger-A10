package practice;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(genericUtility.ListenersImplementation.class)
public class TestNGPractice {

	@Test(priority = 1)
	public void createUser()
	{
//		Assert.fail();
		System.out.println("User created");
	}
	
	@Test(priority = 2, dependsOnMethods = {"createUser"})
	public void modifyUser()
	{
		System.out.println("User modified");
	}
	
//	@Ignore
	@Test(priority = 3)
	public void deleteUser()
	{
		System.out.println("User deleted");
	}
}
