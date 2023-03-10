import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) {
        Mortgage mortgage = new Mortgage();

        mortgage.setYearInterest(3.3);
        mortgage.setHomeValue(400000);
        mortgage.setLoanTerm(25);
        mortgage.setDownPayment(50000);

        System.out.println(round(mortgage.calculateMonthlyPaymentAnual()) );
    }
}