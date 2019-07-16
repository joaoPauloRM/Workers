package com.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.entities.Department;
import com.entities.HourContract;
import com.entities.Worker;
import com.entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Entr department's name: ");
		String department = sc.next();
		System.out.println("Enter worker data: ");
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Level: ");
		String level = sc.next();
		System.out.println("Base salary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));

		System.out.println("Enter the amount of contracts: ");
		int numberOfContracts = sc.nextInt();

		for (int i = 0; i < numberOfContracts; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.println("Data (dd/mm/yyyy): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duration (Hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);

		}
		System.out.println("-----------------------------");
		System.out.println("Calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println(worker);
		System.out.println("Income for: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

	}

}
