package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static String loadUrl(String url) {
		driver.get("https://www.facebook.com/");
		return url;

	}

	public static void fill(WebElement ele,String text) {
		ele.sendKeys(text);

	}
	
	public static String excelRead(String path,String sheetName,int rowNo,int cellNo) throws IOException {
		File file=new File(path);
		FileInputStream fin=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(fin);
		Sheet s=w.getSheet("Input");
		Row r=s.getRow(rowNo);
		Cell c=r.getCell(cellNo);
		int cellType = c.getCellType();
		String value="";
		if (cellType==1) {
			value=c.getStringCellValue();
			
		} else if(DateUtil.isCellDateFormatted(c)) {
			Date d=c.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			value=sim.format(d);
        }
		else {
			double d = c.getNumericCellValue();
			long l=(long)d;
			value=String.valueOf(l);
		}
		return value;

	}
	
	public static void click(WebElement ele) {
		ele.click();

	}
	
}
