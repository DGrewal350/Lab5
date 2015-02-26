package salarydemo;

public class StudentEmployee extends Employee {

	private double studentCredit;

	/**
	 * 
	 * @param name the name of this employee
	 * @param credit the amount of credits student gets
	 */
	public StudentEmployee(String name, double credit) {
		setName(name);
		studentCredit = credit;
	}

	/**
	 * 
	 * @param hoursWorked amount of hours this employee worked
	 */
	public double weeklyPay(int hoursWorked) {
		double pay = hoursWorked * studentCredit;
		if (studentCredit > 40)
		{
			// Add overtime
			pay = pay + ((hoursWorked - 40) * 0.5) * studentCredit;
		}
		return pay;
	}

}