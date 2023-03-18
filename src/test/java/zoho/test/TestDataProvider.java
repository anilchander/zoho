package zoho.test;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import zoho.utils.ExcelReader;

public class TestDataProvider {

	@DataProvider(name = "userdata", parallel = true)
	public Object[][] getData(ITestContext context) throws Exception {
		String dataFile = context.getCurrentXmlTest().getParameter("dataFile");
		String sheet = context.getCurrentXmlTest().getParameter("sheet");
		return new ExcelReader(dataFile).getData(sheet);
	}

}
