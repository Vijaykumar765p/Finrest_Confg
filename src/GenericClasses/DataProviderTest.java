package GenericClasses;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

import Other.Xls_Reader;

public class DataProviderTest extends TestBase {
	@DataProvider(name = "DP")
	public static Object[][] getData(Method m)
	{
				if(m.getName().equals("addcaste"))
				{
					Xls_Reader xls = new Xls_Reader(prop.getProperty("Customer100"));
					int rows = xls.getRowCount("caste");
					int cols = xls.getColumnCount("caste");

					Object data[][] = new Object[rows-1][cols];

					for(int rNum=2;rNum<=rows;rNum++){
						for(int cNum=0;cNum<cols;cNum++){
							System.out.println(xls.getCellData("caste", cNum, rNum));
							data[rNum-2][cNum] = xls.getCellData("caste", cNum, rNum);
						}
					}
					return data;
				}
				return null;
		}
	}