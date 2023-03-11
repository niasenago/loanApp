import static java.lang.Math.floor;

public class Main {
    public static void main(String[] args) {
        Mortgage mortgage = new Mortgage();

        double interest = 5;
        double homeVal = 300000;
        int loanTerm = 30;
        mortgage.setYearInterest(interest);
        mortgage.setHomeValue(homeVal);
        mortgage.setLoanTerm(loanTerm);
        mortgage.setDownPayment(20000);

        System.out.println("Interest rate : "+  interest + " |home value : "+ homeVal + "|Loan term : "+ loanTerm);

        mortgage.printMonthlyPaymentsAnnuity();
        mortgage.printMonthlyPaymentsLinear();

    }

}