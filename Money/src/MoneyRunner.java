/**
 * The MoneyRunner class tests all methods, constructors, and edge conditions from the Money class
 *
 * @author Vishak Srikanth
 * @version 2/3/21
 */
public class MoneyRunner {
    public static void main(String[] args) {
        Money first_amt = new Money();
        System.out.println("Testing 1st Money object with default constructor : " + first_amt.toString());
        System.out.println("Using setters on 1st Money object");
        first_amt.setDollars(11);
        first_amt.setCents(24);
        System.out.println("Testing getters on 1st Money object to verify both setters and getters work:");
        System.out.println("First Money object now has its dollars feild set to: " + first_amt.getDollars() +  " and its cents field set to: " + first_amt.getCents());
        System.out.println("First Money object testing the toString method: " +  first_amt.toString());
        first_amt = new Money(23, 59);
        System.out.println("Creating new 1st Money object with 2 parameter constructor, amount now is: " + first_amt.toString());
        Money second_amt = new Money();
        second_amt = new Money(9);
        System.out.println("Testing 2nd amount with constructor with dolalrs only, no cents: " + second_amt.toString());
        System.out.println("Checking addition and subtraction on Money class using static methods:");
        Money sumStaticMethod = Money.add(first_amt, second_amt);
        Money diffStaticMethod = Money.minus(first_amt, second_amt);
        System.out.println("Sum of first amount & second amount using static method : " + sumStaticMethod.toString());
        if(!diffStaticMethod.isInvalidAmount()){
            System.out.println("Difference of first amount & second amount using static method : " + diffStaticMethod.toString());
        }
        else{
            System.out.println("Difference of first amount & second amount using static method : INVALID: Money Amt to be subtracted FROM needs to be larger than amount being subtracted!");
        }
        System.out.println("Check if first amount & second amount are equal: " + (first_amt.equals(second_amt) ? "Equal" : "Not Equal"));
        System.out.println("Checking addition and subtraction on Money class using instance method:");
        Money sumInstanceMethod = first_amt.add(second_amt);
        Money diffInstanceMethod = first_amt.minus(second_amt);
        System.out.println("Sum of first amount & second amount using instance method : " + sumInstanceMethod.toString());
        if(!diffInstanceMethod.isInvalidAmount()){
            System.out.println("Difference of first amount & second amount using instance method : " + diffInstanceMethod.toString());
        }
        else{
            System.out.println("Difference of first amount & second amount using instance method : INVALID: Money Amt to be subtracted FROM needs to be larger than amount being subtracted!");
        }

        System.out.println("Checking borrow logic when cents value on first amount is lower than cents value on second amount:");
        first_amt = new Money(25, 4);
        System.out.println("New First amount now : " + first_amt.toString());
        second_amt = new Money(9, 89);
        System.out.println("New 2nd amount : " + second_amt.toString());
        System.out.println("Checking addition and subtraction on Money class using static method:");
        sumStaticMethod = Money.add(first_amt, second_amt);
        diffStaticMethod = Money.minus(first_amt, second_amt);
        System.out.println("New Sum of first amount & second amount using static method : " + sumStaticMethod.toString());
        if(!diffStaticMethod.isInvalidAmount()){
            System.out.println("New Difference of first amount & second amount using static method : " + diffStaticMethod.toString());
        }
        else{
            System.out.println("New Difference of first amount & second amount using static method : INVALID: Money Amt to be subtracted FROM needs to be larger than amount being subtracted!");
        }

        System.out.println("Check if first amount & second amount are equal: " + (first_amt.equals(second_amt) ? "Equal" : "Not Equal"));
        System.out.println("Checking addition and subtraction on Money class using instance method:");
        sumInstanceMethod = first_amt.add(second_amt);
        diffInstanceMethod = first_amt.minus(second_amt);
        System.out.println("New Sum of first amount & second amount using instance method : " + sumInstanceMethod.toString());
        if(!diffInstanceMethod.isInvalidAmount()){
            System.out.println("new Difference of first amount & second amount using instance method : " + diffInstanceMethod.toString());
        }
        else{
            System.out.println("New Difference of first amount & second amount using instance method : INVALID: Money Amt to be subtracted FROM needs to be larger than amount being subtracted!");
        }

        System.out.println("Checking minus logic when first amount is lower than second amount:");
        first_amt = new Money(8, 42);
        System.out.println("New First amount now : " + first_amt.toString());
        second_amt = new Money(9, 89);
        System.out.println("New 2nd amount now : " + second_amt.toString());
        System.out.println("Checking addition and subtraction on Money class using static method:");
        sumStaticMethod = Money.add(first_amt, second_amt);
        System.out.println("New Sum of first amount & second amount using static method : " + sumStaticMethod.toString());
        diffStaticMethod = Money.minus(first_amt, second_amt);
        if(!diffStaticMethod.isInvalidAmount()){
            System.out.println("New Difference of first amount & second amount using static method : " + diffStaticMethod.toString());
        }
        else{
            System.out.println("New Difference of first amount & second amount using static method : INVALID: Money Amt to be subtracted FROM needs to be larger than amount being subtracted!");
        }
        System.out.println("Check if first amount & second amount are equal: " + (first_amt.equals(second_amt) ? "Equal" : "Not Equal"));
        System.out.println("Checking addition and subtraction on Money class using instance method:");
        sumInstanceMethod = first_amt.add(second_amt);
//        diffInstanceMethod = first_amt.minus(second_amt);
        System.out.println("New Sum of first amount & second amount using instance method : " + sumInstanceMethod.toString());
        diffInstanceMethod = first_amt.minus(second_amt);
        if(!diffInstanceMethod.isInvalidAmount()){
            System.out.println("new Difference of first amount & second amount using instance method : " + diffInstanceMethod.toString());
        }
        else{
            System.out.println("New Difference of first amount & second amount using instance method : INVALID: Money Amt to be subtracted FROM needs to be larger than amount being subtracted!");
        }


    }
}
