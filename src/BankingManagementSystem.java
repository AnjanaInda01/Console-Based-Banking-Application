import java.util.Scanner;

public class BankingManagementSystem {
    static  Scanner scanner = new Scanner(System.in);
    static int max = 50;
    // saving account
    static int[] savingAccNo = new int[max];
    static String[] savingNames = new String[max];
    static double[] savingBalance = new double[max];
    static double[] savingLoanAmount = new double[max];
    static String[] savingLoanDesc = new String[max];
    static int savingCount = 0;

    //current account
    static int[] currentAccNo = new int[max];
    static String[] currentNames = new String[max];
    static double[] currentBalance = new double[max];
    static double[] currentLoanAmount = new double[max];
    static String[] currentLoanDesc = new String[max];
    static int currentCount = 0;

    // wanitha wasana account
    static int[] wanithaAccNo = new int[max];
    static String[] wanithaNames = new String[max];
    static double[] wanithaBalance = new double[max];
    static double[] wanithaLoanAmount = new double[max];
    static String[] wanithaLoanDesc = new String[max];
    static int wanithaCount = 0;

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\nBanking Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Apply for Loan");
            System.out.println("6. View Loan Details");
            System.out.println("7. Transfer Funds");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    createAccount();
                    break;
                case 2:




                default:
                    System.out.println("Invalid choice!Try again.");
            }
        }while (option != 8);


    }
    public static void createAccount(){
        System.out.println("Savings Account\n" + "Current Account\n" + "Wanitha Wasana Account");
        System.out.print("Select your type: ");
        int type = scanner.nextInt();
        System.out.println("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.println("Enter Account Holder Name: ");
        String name = scanner.next();
        System.out.println("Enter Initial Deposit: ");
        double depoit = scanner.nextDouble();

        switch (type){
            case 1:
                savingAccNo[savingCount] = accNo;
                savingNames[savingCount] = name;
                savingBalance[savingCount] = depoit;
                savingCount++;
                System.out.println("Saving Account Created Successfully!");
                break;

            case 2:
                currentAccNo[currentCount] = accNo;
                currentNames[currentCount] = name;
                currentBalance[currentCount] = depoit;
                currentCount++;
                System.out.println("Current Account Created Successfully!");
                break;

            case 3:
                wanithaAccNo[wanithaCount] = accNo;
                wanithaNames[wanithaCount] = name;
                wanithaBalance[wanithaCount] = depoit;
                wanithaCount++;
                System.out.println("Wanitha Wasana Account Created Successfully!");
                break;
            default:
                System.out.println("Invalid account type!");
        }
    }
    public static void depositMoney(){

    }
    public static void getAccountDetails(){
        System.out.println("Savings Account\n" + "Current Account\n" + "Wanitha Wasana Account");
        System.out.print("Select your type: ");
        int type = scanner.nextInt();
        System.out.println("Enter account number: ");
        int accNo = scanner.nextInt();

    }
    public static void findAccountIndex(int[] accArray,int count,int accNo){
        for (int i = 0; i < count; i++) {
            if (accArray[i]==)
        }

    }
}
