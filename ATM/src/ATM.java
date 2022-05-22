import java.util.Scanner;

public class ATM {
    /* default constructor */
    public void ATM(){}

    /* variable declaration */
    public static double balance = 1000;                                      /* initial balance to allow withdrawal */
    public static double new_balance = 0;                                       /* balance after withdrawal or deposit */
    public static int deposit_frequency = 0;                                    /* deposit frequency counter */
    public static double max_deposit = 0;                                       /* maximum amount deposited */
    public static int withdrawal_frequency = 0;                                 /* withdrawal frequency counter */
    public static double max_withdrawal = 0;                                    /* maximum amount withdrew */
    public static boolean exit= false;                                          /* exit program when true */

    public static double getbalance(){
        return balance;                                                         /* return account balance */
    }

    public static boolean can_deposit(int deposit_frequency){                    /* check deposit frequency limit */
        return deposit_frequency <= 10;
    }

    public static double deposit(int deposit_amount){                           /* add deposit to balance */

        if(deposit_amount > 0){                                                 /* run only when deposit amount is more than zero */

            if(deposit_amount <= 10000){                                        /* deposit amount must be at most 10000 */
                max_deposit += deposit_amount;
                if(max_deposit <= 100000){                                      /* maximum deposit for the day must be at most 100000 */
                    System.out.printf("Current Balance: %.2f", balance);
                    System.out.println("");
                    balance += deposit_amount;
                    return balance;
                }
                else {
                    System.out.println("ERROR: You have reached the limit for maximum deposit per day.");
                }
            }

            else {
                System.out.println("ERROR: Maximum deposit amount at most 10000 L.E.");
            }

        } else {
            System.out.println("ERROR: Enter a valid amount.");
        }

        return balance;

    }

    public static boolean can_withdraw(int withdrawal_frequency){                /* check withdrawal frequency limit */
        return withdrawal_frequency <= 5;
    }

    public static double withdrawal(int withdrawal_amount){                     /* subtract withdrawal from balance */

        if(withdrawal_amount > 0){                                              /* run only if withdrawal amount is more than zero */

            if(withdrawal_amount < balance){                                    /* withdrawal amount must not be more than balance */

                if(withdrawal_amount <= 10000){                                 /* withdrawal amount must be at most 10000 */
                    max_withdrawal += withdrawal_amount;

                    if(max_withdrawal <= 50000){                                /* maximum withdrawal for the day must be at most 50000 */
                        System.out.printf("Current Balance: %.2f", balance);
                        System.out.println("");
                        balance -= withdrawal_amount;
                        return balance;
                    }

                    else {
                        System.out.println("ERROR: You have reached the limit for maximum withdrawal per day.");
                    }
                }

                else {
                    System.out.println("ERROR: Maximum withdrawal amount must be at most 10000 L.E.");
                }
            }

            else {

                System.out.printf("ERROR: Withdrawal amount is more than the balance: %.2f", balance);
                System.out.println("");

            }
        }

        else {
            System.out.println("ERROR: Enter a valid amount.");
        }

        return balance;
    }

    public static boolean quit(String answer){                                  /* exit program */

        if(answer.equals("yes") || answer.equals("YES")){                       /* exit only after confirmation from user */
            return true;
        }

        else {
            return false;
        }

    }

    public static boolean userInput(String choice){

        switch(choice){
            case "BALANCE": System.out.printf("%.2f", getbalance());            /* user wants to check balance */
                System.out.println("");
                System.out.println("Type MENU to go back");
                String menu = new Scanner(System.in).nextLine();
                break;

            case "DEPOSIT": deposit_frequency++;
                if(can_deposit(deposit_frequency)){                          /* allow only if maximum frequency not met */
                    System.out.print("Please enter the amount to deposit: ");
                    int deposit_amount = new Scanner(System.in).nextInt();
                    new_balance = deposit(deposit_amount);                  /* user wants to deposit money */
                    System.out.printf("New Balance: %.2f", new_balance);
                    System.out.println("");
                }

                else {                                                    /* maximum frequency for the day met */
                    System.out.println("ERROR: You have reached the maximum frequency of deposited per day.");
                }
                break;

            case "WITHDRAWAL": withdrawal_frequency++;
                if(can_withdraw(withdrawal_frequency)){                      /* allow only if maximum frequency not met */
                    System.out.print("Please enter the amount to withdraw: ");
                    int withdrawal_amount = new Scanner(System.in).nextInt();
                    new_balance = withdrawal(withdrawal_amount);            /* user wants to withdraw money */
                    System.out.printf("New Balance: %.2f", new_balance);
                    System.out.println("");
                }

                else {                                                    /* maximum frequncy met for the day */
                    System.out.println("ERROR: You have reach the maximum frequency of withdrawal per day.");
                }
                break;

            case "EXIT": System.out.print("Are you sure you want to exit?(YES/NO): ");
                String answer = new Scanner(System.in).nextLine();
                if(quit(answer)){                                           /* user wants to quit */
                        /*System.exit(0);
                        System.gc();*/
                    return true;
                }
                break;

            default: System.out.println("ERROR: Enter from available options");
                break;

        }
        return false;
    }



    public static void main(String[] args) {

        System.out.println("Welcome to the ATM Program");

        while(!exit){

            System.out.println("Below are the options for you to choose from:\n" +
                    "1. Type BALANCE to check your Balance\n" +
                    "2. Type DEPOSIT to deposit money\n" +
                    "3. Type WITHDRAWAL to withdraw money\n" +
                    "4. Type EXIT to exit the program");            /* Ask user for input */

            Scanner scan = new Scanner(System.in);
            String c = scan.nextLine();

            exit = userInput(c);                                                /* process user input */
        }
        System.exit(0);
        System.gc();
    }
}
