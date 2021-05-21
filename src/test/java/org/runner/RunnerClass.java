package org.runner;

import java.io.IOException;

import org.base.BaseClass;
import org.login.LoginPojo;
import org.testng.annotations.Test;

public class RunnerClass extends BaseClass {
	
@Test
private void tc1() throws IOException {
	launchBrowser();
	loadUrl("https://www.facebook.com/");
	LoginPojo l=new LoginPojo();
	fill(l.getTxtUsername(), excelRead("D:\\eclipse-workspace\\FrameworkSample\\ExcelSheets\\Facebook.xlsx", "Input", 1, 0));
	fill(l.getTxtPassword(), excelRead("D:\\eclipse-workspace\\FrameworkSample\\ExcelSheets\\Facebook.xlsx", "Input", 1, 1));
	click(l.getBtnLogin());

}
	
	
}
	




