import java.io.*;
import java.util.*;
public class SalaryAnalyzer {
	static final String IN_FILE_NAME = "Salary.txt";
	static final String OUT_FILE_NAME = "OVER250000.txt";
	static final String DELIM = "\t";
	public static void main(String[] args)
	{
		System.out.println("Let's see how many state employees make over $250,000 and work at USC.");
		analyzeEmployeeFile(IN_FILE_NAME);
		System.out.println("Results have been printed to "+OUT_FILE_NAME);
	}
	
	public static void analyzeEmployeeFile(String fileName)
	{
		String result="";
		Scanner fileScanner = new Scanner(new File(fileName));
		String fileLine = fileScanner.nextLine();
		String[] splitLines = fileLine.split(DELIM);
		while(fileScanner.hasNextLine())
		{
			fileLine = fileScanner.nextLine();
			splitLines = fileLine.split(DELIM);
			String Agency = splitLines[0];
			int Total = Integer.parseInt(splitLines[7]);
			if(Agency.equalsIgnoreCase("UNIVERSITY OF SOUTH CAROLINA") && Total >= 250000)
			{
				
				System.out.println(fileLine);
				result = result+fileName+ "\n";
			}
			SalaryAnalyzer.printToSalaryFile(OUT_FILE_NAME, result);
		}
			
	}
	public static void printToSalaryFile(String fileName, String text)
	{
		PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
		fileWriter.println("");
		for(int i=0;i<fileName.length();i++)
		{
			fileWriter.print(fileName[0]);
			fileWriter.print(fileName[7]);
		}
		fileWriter.close();
	}
}