import java.util.Objects;
/**
 * The Money class stores the amount as 2 separate dollar and cent variables has various methods including a toString, getter methods, setter methods, and an
 * equals method.
 *
 * @author Vishak Srikanth
 * @version 2/3/21
 */
public class Money {
    /**
     * Define amount variables as private
     */
    private int dollars;
    private int cents;


    /**
     *
     *  No args Constructor for objects of class Money initializes dollars and cents to both zero
     *
     */
    public Money(){
        this.dollars = 0;
        this.cents = 0;
    }

    /**
     * Constructor with only full dollar amounts
     * @param dollars
     */
    public Money(int dollars) {
        this.dollars = dollars;
        this.cents = 0;
    }


    /**
     * Constructor with both dollar and cent amounts
     * @param dollars
     * @param cents
     */
    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    /**
     * getDollars(): a getter method for Dollar portion of Money amount
     * @param: none
     * @return: dollars (int): dollar portion of amount of Money object
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * setDollars(): a setter method for dollars portion of Money amount
     * @param: dollars( int )
     * @return: none
     */
    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    /**
     * getCents(): a getter method for cents portion of Money amount
     * @param: none
     * @return: cents (int): cents portion of amount of Money object
     */
    public int getCents() {
        return cents;
    }

    /**
     * setCents(): a setter method for cents portion of Money amount
     * @param: cents( int )
     * @return: none
     */
    public void setCents(int cents) {
        this.cents = cents;
    }

    /**
     * add(): static method to add 2 amounts and return Money object that has this amount in dollars and cents variables
     * @param amt_A : first amount(Money object)
     * @param amt_B : second amount(Money object)
     * @return (Money): Money object that represents the sum or addition of the 2 amounts
     */
    static Money add(Money amt_A, Money amt_B){
        //Add dollar and cent portions separately
        int dol = amt_A.getDollars() + amt_B.getDollars();
        int cents = amt_A.getCents() + amt_B.getCents();
        // if cents sum goes over 100, take the residue after subtracting 100 and add 1 to dollar amount (carry)
        if(cents >= 100){
            cents = cents - 100;
            dol += 1;
        }
        //Create a new Money object to hold sum and return it
        Money sum = new Money(dol, cents);
        return sum;
    }

    /**
     * isInvalidAmount(): instance method to check if Money object is valid (i.e. it has non-negative dollars and cents values)
     * @param: none
     * @return boolean: true if the Money object has negative values for either dollars or cents or false otherwise
     */
    public boolean isInvalidAmount(){
        return getDollars() < 0 || getCents() < 0;
    }

    /**
     * minus(): static method to subtract second amount from 1st amounts and return Money object that has this difference amount in dollars and cents variables
     * @param amt_A : first amount(Money object)
     * @param amt_B : second amount(Money object)
     * @return (Money): Money object that represents the difference of the 2 amounts
     */
    static Money minus(Money amt_A, Money amt_B){
        //Convert all amounts to cents first for both current object and second moey object to subtract
        int from = (amt_A.getCents()==0?amt_A.getDollars()*100: (amt_A.getDollars()*100 + amt_A.getCents()));
        int sub = (amt_B.getCents()==0?amt_B.getDollars()*100: (amt_B.getDollars()*100 + amt_B.getCents()));
        //Initialize diff and resulting dollar and cents values to negative in case user attempts to perform invalid minus operation
        int diff = -1;
        int dol = -1;
        int cents = -1;
        //Calculate difference
        diff = from - sub;
        //Create dollar variable for difference by taking integer division
        dol = diff/100;
        //Create cents value by taking modulo 100
        cents = diff%100;
        //Create new Money object for the difference and return it
        Money diff_money = new Money(dol, cents);
        return diff_money;
    }

    /**
     * add(): instance method to add 2 amounts and return Money object that has the sum amount in dollars and cents variables
     * @param amt_B : second amount(Money object)
     * @return (Money): Money object that represents the sum or addition of the current Money object and amt_B
     */
    public Money add(Money amt_B){
        //Add dollar and cent portions of both objects separately
        int dol = this.getDollars() + amt_B.getDollars();
        int cents = this.getCents() + amt_B.getCents();
        // if cents sum goes over 100, take the residue after subtracting 100 and add 1 to dollar amount (carry)
        if(cents >= 100){
            cents = cents - 100;
            dol += 1;
        }
        //Create a new Money object to hold sum and return it
        Money sum = new Money(dol, cents);
        return sum;
    }


    /**
     * minus(): static method to subtract second amount from current instance and return Money object that has this difference amount in dollars and cents variables
     * @param amt_B : second amount(Money object)
     * @return (Money): Money object that represents the difference of the 2 amounts
     */
    public Money minus(Money amt_B) {
        //Convert all amounts to cents first
        int from = (this.getCents()==0?this.getDollars()*100: (this.getDollars()*100 + this.getCents()));
        int sub = (amt_B.getCents()==0?amt_B.getDollars()*100: (amt_B.getDollars()*100 + amt_B.getCents()));;
        //Initialize diff and resulting dollar and cents values to negative in case user attempts to perform invalid minus operation
        int diff = -1;
        int dol = -1;
        int cents = -1;
        //Calculate difference
        diff = from - sub;
        //Create dollar variable for difference by taking integer division
        dol = diff/100;
        //Create cents value by taking modulo 100
        cents = diff%100;
        //Create new Money object for the difference and return it
        Money diff_money = new Money(dol, cents);
        return diff_money;

    }

    @Override
    /**
     * toString(): a toString method for class Money
     * @param: none
     * @return: a string representation of objects of class Money
     */
    public String toString() {
        //Creating a nice user friendly method for $ amount presentation and also showing the dollar and cent internal fields also for object
        float amt = (float) (dollars + cents/100.0);
        return "Money object has value: $" + String.format("%.2f", amt) + " [" +
                "Dollars=" + dollars +
                ", Cents=" + cents +
                ']';
    }

    @Override
    /**
     * equals(): an equals method comparing objects of class Money to another Money object
     * @param o (another Money object)
     * @return
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        //an object will only have a same instance variables dollars and cents if the object is an object of class Money or the
        //object contains or is derived from an object of class Money ( two objects must be from the same class to be equal)
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return getDollars() == money.getDollars() && getCents() == money.getCents();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDollars(), getCents());
    }
}
