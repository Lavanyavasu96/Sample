package flipkart.com;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice {

	@Test (retryAnalyzer=RetrySample.class)

	public void test1() {
		Assert.assertTrue(false);

		System.out.println("test1");
	}

	

}
