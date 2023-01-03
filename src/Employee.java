public class Employee {
    private int baseSalary;
    private int hourlySalary;
    
    public int calculateWage(int extraHours) {
        return baseSalary + (hourlySalary * extraHours);
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        if (hourlySalary <= 0) throw new IllegalArgumentException("Hourly Salary can't be 0 or less than 0");
        this.hourlySalary = hourlySalary;
    }
}
