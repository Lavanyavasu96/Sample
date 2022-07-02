package flipkart.com;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetrySample implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int fcount=0;
		int limit =4;
		if(fcount<limit) {
			fcount++;
		return true;}

	return false;
}

}
