package com.metacube.get2019;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * It is a class with main method and input output operations
 * of excel file.
 * @author Kritika
 *
 */
public class StudentProgramAllocator { 

	/**
	 * It is a main method.
	 * @param args unused.
	 * @throws BiffException
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void main(String args[]) throws BiffException, IOException,
			RowsExceededException, WriteException {

		Queue<Student> students = new LinkedList<>();
		String[] preferenceList = null;
		String studentName = "";
		
		String FilePath = "C:\\GET2019\\GET2019\\DSAssignment2\\Students.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sheet = wb.getSheet(0);
		
		int totalNoOfRows = sheet.getRows();
		int totalNoOfCols = sheet.getColumns();
		
		for (int row = 0; row < totalNoOfRows; row++) {
			preferenceList = new String[6];
			for (int col = 0; col < totalNoOfCols; col++) {
				if (col == 0) {
					studentName = sheet.getCell(col, row).getContents();

				} else {
					preferenceList[col] = sheet.getCell(col, row).getContents();
				}
			}
			Student s1 = new Student(studentName, preferenceList);
			students.add(s1);
		} 
		
		String FilePath1 = "C:\\GET2019\\GET2019\\DSAssignment2\\Programs.xls";
		FileInputStream fs1 = new FileInputStream(FilePath1);
		Workbook wb1 = Workbook.getWorkbook(fs1);
		Sheet programSheet = wb1.getSheet(0);
		
		int totalNoOfRows1 = programSheet.getRows();
		int capacityArr[] = new int[totalNoOfRows1];
		String programsArr[] = new String[totalNoOfRows1];
		
		for (int row = 0; row < totalNoOfRows1; row++) {
				programsArr[row] = programSheet.getCell(0, row).getContents();
				capacityArr[row] = Integer.parseInt(programSheet.getCell(1, row).getContents());
		}
		
		String FilePath2 = "C:\\GET2019\\GET2019\\DSAssignment2\\StudentAllocation.xls";
		File fs2 = new File(FilePath2);
		WritableWorkbook wb2 = Workbook.createWorkbook(fs2);
		WritableSheet allocationSheet = wb2.createSheet("Sheet 0", 0);
		
		int row = 0;
		String[] stuPrefList;
		int size = students.size();
		
		for (int i = 0; i < size; i++) {
			stuPrefList = new String[5];
			stuPrefList = students.peek().getProgramsList();
			String stuName = students.peek().getStudentName();
			for (int j = 1; j <= 5; j++) {
				int k = 0;
				while (k < capacityArr.length && !programsArr[k].equals( stuPrefList[j] )) {
					k++;
				}
				if (capacityArr[k] != 0) {
					Label label = new Label(0, row, stuName);
					allocationSheet.addCell(label);
					Label label1 = new Label(1, row, programsArr[k]);
					allocationSheet.addCell(label1);
					row++;
					capacityArr[k]--;
					students.remove(); 
					break;
				}
			}
		}
		wb2.write();
		wb2.close();
	}
}
