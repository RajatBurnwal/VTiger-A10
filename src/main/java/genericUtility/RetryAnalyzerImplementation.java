package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count = 1;
	int maxCount = 4;		//identified manually
	
	@Override
	public boolean retry(ITestResult result) {
//		1<=4-->true-->re-run, 2<=4-->true-->re-run,...4<=4-->true-->re-run,
//		5<=4-->false-->stop re-run
		while(count<=maxCount)
		{
			count++;
			return true;
		}
		return false;
	}

	
}
