import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
class GiveAttendence {
	LoginPage tr = new LoginPage();
	Scanner sw = new Scanner(System.in);


	boolean tf = false;

	static String roll;

	static int var35;
	boolean tf23 = true;

	static String g1;
	static String g2;
	private static int var2;
	private  int var;
	private int var11;


	Queue q1 = new ArrayDeque();


	private void AttendenceByRollNo() throws IOException {


		

		DataFormatter dfFormatter = new DataFormatter();
		FileInputStream  n = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t = new XSSFWorkbook(n);
		XSSFSheet sheet = t.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		for(int r=1;r<=rows;r++) {
			XSSFRow bgg = sheet.getRow(r);
			XSSFCell hjr = bgg.getCell(0);

			Object vvalueObject = dfFormatter.formatCellValue(hjr);
			if(vvalueObject.equals(roll)) {
			var2 = r;
			tf23 = false;
			break;
			}
		}

		if(tf23) {
			System.out.println("                                        !!! Please Enter Correct Rollno !!!");
		}
		else {
			while(true) {
				System.out.println("1.Mat");
				System.out.println("2.Dsa");
				System.out.println("3.Eng");
				System.out.println("4.Exit");
				System.out.println("                        ^^^^  Enter The Option  ^^^^");
				String subject1 = sw.nextLine();
				if(subject1.equals("1")) {
					g1 = "MatAttended";
					g2 = "MatTotalclasses";
					attendnce();
					System.out.println("                               -- Successfully Updated --");
				}
				else if(subject1.equals("2")) {
					g1 = "DsaAttended";
					g2 = "DsaTotalclasses";
					attendnce();
					System.out.println("                               -- Successfully Updated --");
				}
				else if(subject1.equals("3")) {
					g1 = "EngAttended";
					g2 = "EngTotalclasses";
					attendnce();
					System.out.println("                               -- Successfully Updated --");
}
				else if(subject1.equals("4")) {
					break;
				}
				else {
					System.out.println("                                                  $$$ Please Enter The Correct Option $$$");
				}
			}
			
				
			
		}
		
	}
	private void attendnce() throws IOException {
		FileInputStream  n1 = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t = new XSSFWorkbook(n1);
		XSSFSheet sheet = t.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		XSSFRow bg = sheet.getRow(0);
		for(int c =0;c<cols;c++) {
			XSSFCell hj = bg.getCell(c);
			DataFormatter dFormatter = new DataFormatter();
			Object valueObject = dFormatter.formatCellValue(hj);
			if(valueObject.equals(g1)) {
				var = c;
			}
			if(valueObject.equals(g2)) {
				var11 = c;
			}	
		}
		
		
		XSSFRow bgg111 = sheet.getRow(var2);
		
		XSSFCell hjr11 = bgg111.getCell(var);
		XSSFCell hjrr211 = bgg111.getCell(var11);
		
		DataFormatter d = new DataFormatter();
		Object ob1 = d.formatCellValue(hjr11);
		Object ob2 = d.formatCellValue(hjrr211);
	String v34 = ob1.toString();

	String v342 = ob2.toString();

		System.out.println(v34);
		System.out.println(v342);
		System.out.println("---------------------------------------------------");
		System.out.println("1.Present");
		System.out.println("2.Absent");
		System.out.println("---------------------------------------------------");
		System.out.println("                  !!! Enter The Option !!!");
		String att = sw.nextLine();

		XSSFCell hjr2= sheet.getRow(var2).createCell(var);
		XSSFCell hjrr23 = sheet.getRow(var2).createCell(var11);


		if(att.equals("1")) {



			if(v34.equals("") && v342.equals("")) {
				hjr2.setCellValue(1);
				hjrr23.setCellValue(1);
			}
			else if(v34.equals("")) {
				int i12 =(Integer.valueOf(v342))+1;

				hjr2.setCellValue(1);
				hjrr23.setCellValue(i12);
			}
			else if(v342.equals("")) {
				int i1 = (Integer.valueOf(v34))+ 1;
				hjr2.setCellValue(i1);
				hjrr23.setCellValue(i1);
			}
			else {
				int i12 =(Integer.valueOf(v342))+1;
				int i1 = (Integer.valueOf(v34))+ 1;


				hjr2.setCellValue(i1);
				hjrr23.setCellValue(i12);
			}
		}
		else if(att.equals("2")) {


			if(v34.equals("") && v342.equals("")) {
				hjr2.setCellValue(0);
				hjrr23.setCellValue(1);
			}
			else if(v34.equals("")) {
				int i121 = (Integer.valueOf(v342))+1;
				hjr2.setCellValue(0);
				hjrr23.setCellValue(i121);
			}
			else if(v342.equals("")) {
				int i11 =(Integer.valueOf(v34));
				hjr2.setCellValue(i11);
				hjrr23.setCellValue(i11);
			}
			else{
				int i11 =(Integer.valueOf(v34));
				int i121 = (Integer.valueOf(v342))+1;

				hjr2.setCellValue(i11);
				hjrr23.setCellValue(i121);
			}

		}
		else {
			System.out.println("                          %%%  Enter The Correct Option  %%%");
		}

		FileOutputStream er = new FileOutputStream("Book1.xlsx");
		t.write(er);
		er.close();

	}
	public void ClassAttendence() throws IOException {
		FileInputStream  n1 = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t = new XSSFWorkbook(n1);
		XSSFSheet sheet = t.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		System.out.println(rows);
		for(int r=1;r<=rows;r++){
			XSSFCell bg = sheet.getRow(r).getCell(0);
			DataFormatter d3 = new DataFormatter();
			Object ob4 = d3.formatCellValue(bg);
			String w = (String) ob4;
			q1.add(w);
			System.out.println(q1);
		}
		n1.close();
		while(!q1.isEmpty()){
			String r1 = (String) q1.poll();
			System.out.println(r1);
			System.out.println(q1);
			roll = r1 ;
			System.out.println("              "+roll);
			AttendenceByRollNo();
			percentageAttendence();
		}

	}

	public void giveAttendenceByRollNo() throws IOException {
		System.out.println("                        ^^^^  Enter The Rollno  ^^^^");
		roll = sw.nextLine();
		AttendenceByRollNo();
		percentageAttendence();

	}
	private void percentageAttendence() throws IOException {
		FileInputStream  n12 = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t2 = new XSSFWorkbook(n12);
		XSSFSheet sheet = t2.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		String attendence = "ATTENDENCE";
		String[] array1 = new String[]{"MatTotalclasses","EngTotalclasses","DsaTotalclasses"};
		String[] array2 = new String[]{"MatAttended","EngAttended","DsaAttended"};
		List q2 = new ArrayList();
		List q25 = new ArrayList();

		for(int i =0;i<array1.length;i++){
		for(int c =0;c<cols;c++){

			XSSFCell c43 = sheet.getRow(0).getCell(c);
			DataFormatter d3 = new DataFormatter();
			Object ob45 = d3.formatCellValue(c43);
			String answer = (String) ob45;

			if(answer.equals(array1[i]))
			{
			q2.add(c);
			}
			else if(answer.equals(array2[i]))
			{
				q25.add(c);
			}
			if(answer.equals(attendence)){
				var35 = c;
			}
		}}
		 int i3 =0;
		 int i34 =0;
		for(int i =0;i<array1.length;i++){
			XSSFCell bg = sheet.getRow(var2).getCell((int)q2.get(i));
			DataFormatter d3 = new DataFormatter();
			Object ob4 = d3.formatCellValue(bg);
			String answer3 = (String) ob4;
			XSSFCell bg1 = sheet.getRow(var2).getCell((int) q25.get(i));

			Object ob41 = d3.formatCellValue(bg1);
			String answer31 = (String) ob41;
			i3 = i3+Integer.valueOf(answer3);
			i34=i34+Integer.valueOf(answer31);

		}

		double percentage = (Double.valueOf(i34)/Double.valueOf(i3))*100;

		XSSFCell cell7 = sheet.getRow(var2).createCell(var35);

		cell7.setCellValue(percentage);

		FileOutputStream file5 = new FileOutputStream("Book1.xlsx");
		t2.write(file5);
		file5.close();
	}
}
