package TestNGFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadriven {
	@DataProvider(name="sending")
	public static Object prodider() {
		return new Object[][] {
	        { "user1", "pass1" },
	        { "user2", "pass2" }
	    };
	}
	@Test(dataProvider="sending")
	public void Taking(String a,String b) {
		System.out.println(a+"   "+b);
	}

}
