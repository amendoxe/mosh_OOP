import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageTry {
    private int principal;
    private float annualInterest;
    private byte years;
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public MortgageTry() {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
        printTMortgage(getPrincipal(), getAnnualInterest(), getYears());
        printPaymentSchedule(principal, annualInterest, years);
        //balance no usa el resultado de calculateMortgage
        //hace su propio cálculo y escribimos la suma que llevaría mes con mes

    }

    private void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    private void printTMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private double calculateMortgage(int principal, float annualInterest, byte years) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    private int getPrincipal() {
        return principal;
    }

    private void setPrincipal(int principal) {
        this.principal = (int) readNumber("Principal: ", 1000, 1_000_000);
    }

    private float getAnnualInterest() {
        return annualInterest;
    }

    private void setAnnualInterest(float annualInterest) {
        this.annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
    }

    private byte getYears() {
        return years;
    }

    private void setYears(byte years) {
        this.years = (byte) readNumber("Period (Years): ", 1, 30);
    }

    public double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
}