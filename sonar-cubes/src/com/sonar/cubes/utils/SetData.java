package com.sonar.cubes.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetData
{
	public static void toExcel(String fileName, String sName,
			int rIndex, int cIndex, String data)
	{
		try
		{
			File f = new File("./data/"+fileName+".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sName);
			Row r = st.getRow(rIndex);
			Cell c = r.createCell(cIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void toProperties(String fileName,
			String key, String value, String commitMsg)
	{
		try
		{
			File f = new  File("./data/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, commitMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
