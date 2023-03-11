import static java.lang.Math.*;

/*
    Pageidaujama paskolos suma (galimas skaičius ir su kalbeliu). +
    Paskolos terminas (metai ir mėnesiai). +
    Paskolos grąžinimo grafikas (pasirenkame vieną): Anuiteto arba Linijinis
    Metinis procentas +
 */
public class Mortgage {
    private double homeValue;
    private double downPayment;

    private double loan;
    private double yearInterestRate; // devided by 100
    private int loanTerm; // in years;

    private double monthlyInterestRate;
    final int months = 12;  //constant value

    Mortgage( ){

    }
    public void setYearInterest(double yearInterestRateIn){
        this.yearInterestRate = yearInterestRateIn / 100;
        this.monthlyInterestRate = this.yearInterestRate / months;
    }

    public void setDownPayment(double downPaymentIn){ this.downPayment = downPaymentIn; }
    public void setHomeValue(double homeValueIn){ this.homeValue = homeValueIn; }
    public void setLoanTerm(int loanTermIn){ this.loanTerm = loanTermIn; }

    public double getDownPayment(){ return this.downPayment; }
    public double getHomeValue(){ return this.homeValue; }

    public double getLoanTerm(){ return this.loanTerm; }

    public double getYearInterestRate(){ return this.yearInterestRate; }

    private double calculateMonthlyPaymentAnnuity(){
        this.loan = this.homeValue - this.downPayment; // Principal (starting balance) of the loan

        //double monthlyInterestRate = this.yearInterestRate / months;
        int numOfPayments = this.loanTerm * months;
        double temp = pow((1 + this.monthlyInterestRate), numOfPayments);

        double payment = ((this.monthlyInterestRate * temp ) / (temp - 1)) * this.loan;

        return payment;
    }

    public void printMonthlyPaymentsAnnuity(){
        double mokejimoSuma = calculateMonthlyPaymentAnnuity();
        float annuityPirce = 0;
        double paskolosLikutis = this.loan;
        double palukanuDalis;
        double paskolosDalis;
       // System.out.printf("Mėnuo | Paskolos likutis | Mokėjimo suma | Paskolos dalis | Palūkanų dalis %n");
        for(int i = 0; i < this.loanTerm * months; ++i){
            palukanuDalis = myRoundToCents(paskolosLikutis * this.monthlyInterestRate);
            paskolosDalis = myRoundToCents(mokejimoSuma - palukanuDalis);
            paskolosLikutis = myRoundToCents(paskolosLikutis);
           // System.out.printf("%-5d | %-16.2f | %-13.2f | %-14.2f | %-14.2f %n", i + 1,paskolosLikutis,mokejimoSuma,paskolosDalis,palukanuDalis);

            paskolosLikutis -= paskolosDalis;
            annuityPirce += mokejimoSuma;

        }
        System.out.println("Kaina anuiteto " + annuityPirce);

    }

    public void printMonthlyPaymentsLinear(){
        float linearprice = 0;
        double loanBalance = this.loan; // paskolos likutis
        double monthlyPayment = myRoundToCents(this.loan / (this.loanTerm * months)) ;

        //System.out.printf("Mėnuo | Paskolos likutis | Mokėjimo suma | Paskolos dalis | Palūkanų dalis %n");

        for(int i = 0 ; i < this.loanTerm * months; ++i){
            double interest = myRoundToCents(loanBalance * this.monthlyInterestRate) ;
           // System.out.printf("%-5d | %-16.2f | %-13.2f | %-14.2f | %-14.2f %n", i + 1,loanBalance,monthlyPayment + interest,monthlyPayment,interest);
            loanBalance -= monthlyPayment;

            linearprice += monthlyPayment + interest;
        }
        System.out.println("Kaina linijinio " + linearprice);

    }
    private static double myRoundToCents(double number){
        return floor(number * 100) / 100;
    }

}

/*
* 1)Kiek kiekvieną mėnesį turime mokėti už būstą (bendrą menesio sumą, išskaidoma į suma+procentai) ir kiek dar liko nesumokėta
*   (atvaizduoti galima kaip lentelę).
* 2)Turi būti filtras, kuriame galime matyti, tik tam tikro laiko intervalo mokėtinas sumas.
* 3)Turime turėti galimybę gauti ataiskaitą faile.
* 4)Turi būti galimybė matyti grafinį atvaizdavimą (line chart) ,
*   kuriuose matosi anuiteto ir linijinio mokėjimo kitimai.
* 5)Turi būti galimybė įtraukti atidėjimą (atidėjimas galimas  nuo bet kurios datos
*   (ir nurodant kiek laiko bus atidėjimas). Pasirenkant atidėjimą, turime galimybę nustatyti kokie atidėjimo procentai.
*   Atidėjimo metu skaičiuojame tik nuo nurodyto "atidėjimo procento"
*/