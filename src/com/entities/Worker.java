package com.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.entities.enums.WorkerLevel;

public class Worker {

	private String workerName;
	private WorkerLevel workerLevel;
	private double baseSalary;

	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {

	}

	public Worker(String workerName, WorkerLevel workerLevel, double baseSalary, Department department) {
		this.workerName = workerName;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract hourContract) {
		contracts.add(hourContract);

	}

	public void removeContract(HourContract hourContract) {
		contracts.remove(hourContract);

	}

	public double income(int year, int month) {
		Calendar cal = Calendar.getInstance();
		double sum = baseSalary;
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int cYear = cal.get(Calendar.YEAR);
			int cMonth = 1 + cal.get(Calendar.MONTH);
			if (year == cYear || month == cMonth) {
				sum += c.totalValue();
			}
		}
		return sum;

	}

	@Override
	public String toString() {
		return "Worker [workerName=" + workerName + ", department=" + department.getName() + "]";
	}

}