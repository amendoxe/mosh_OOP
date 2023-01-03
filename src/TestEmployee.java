public class TestEmployee {
    public static void main(String[] args) {
        var employee1 = new Employee();
        employee1.setBaseSalary(200);
        employee1.setHourlySalary(10);
        int wage = employee1.calculateWage(2);
        System.out.println(wage);
    }
}
