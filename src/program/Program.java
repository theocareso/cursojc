package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		System.out.println("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.print("Enter work data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int quantitie = sc.nextInt();
		
		for (int i = 0; i < quantitie; i++) {
			System.out.print("Enter contract #"+ (i+1)+ " data: ");
			System.out.print("Date: (DD/MM/YYYY) ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration hours: ");
			Integer durationHours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, durationHours);
			worker.addContract(contract);
		}
		
		System.out.print("Enter month and yer to calculate income: (MM/yyyy)");
		String monthYear = sc.nextLine();
		int month = Integer.parseInt(monthYear.substring(0, 2));		
		int year = Integer.parseInt(monthYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("");
		
		sc.close();
	}

}
