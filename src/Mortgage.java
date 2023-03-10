import static java.lang.Math.pow;
/*
    Pageidaujama paskolos suma (galimas skaičius ir su kalbeliu). +
    Paskolos terminas (metai ir mėnesiai). +
    Paskolos grąžinimo grafikas (pasirenkame vieną): Anuiteto arba Linijinis
    Metinis procentas +
 */
public class Mortgage {
    boolean isAnual = true;
    private double homeValue;
    private double downPayment;

    private double loan;
    private double yearInterestRate;
    private int loanTerm; // in years; devided by 100

    final int months = 12;

    Mortgage( ){

    }
    public void setYearInterest(double yearInterestRateIn){
        this.yearInterestRate = yearInterestRateIn / 100;
    }

    public void setDownPayment(double downPaymentIn){ this.downPayment = downPaymentIn; }
    public void setHomeValue(double homeValueIn){ this.homeValue = homeValueIn; }
    public void setLoanTerm(int loanTermIn){ this.loanTerm = loanTermIn; }

    public double getDownPayment(){ return this.downPayment; }
    public double getHomeValue(){ return this.homeValue; }

    public double getLoanTerm(){ return this.loanTerm; }

    public double getYearInterestRate(){ return this.yearInterestRate; }

    public double calculateMonthlyPaymentAnual(){
        this.loan = this.homeValue - this.downPayment; // Principal (starting balance) of the loan

        double monthlyInterestRate = this.yearInterestRate / months;
        int numOfPayments = this.loanTerm * months;
        double temp = pow((1 + monthlyInterestRate), numOfPayments);

        double payment = ((monthlyInterestRate * temp ) / (temp - 1)) * this.loan;

        return payment;
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