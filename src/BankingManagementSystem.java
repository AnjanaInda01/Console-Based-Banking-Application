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
                    depositMoney();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:



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
        System.out.println(" Deposit Money");
        int [] accData = getAccountDetails();
        if (accData==null){
            return;
        }
        int type = accData[0];
        int index = accData[1];
        System.out.println("Enter Deposit Amount: ");
        double amount = scanner.nextDouble();
        if (type==1){
            savingBalance[index]+=amount;
        }if (type==2){
            currentBalance[index]+=amount;
        }else {
            wanithaBalance[index] +=amount;
        }
        System.out.println("Deposit Successful!");
    }
    public static void withdrawMoney() {
        System.out.println("Withdraw Money");
        int[] accData = getAccountDetails();
        if (accData==null){
            return;
        }
        int type = accData[0];
        int index = accData[1];

        System.out.println("Enter Withdraw Amount: ");
        double amount = scanner.nextDouble();
        
        if (type==1 && savingBalance[index]>=amount){
            savingBalance[index]-=amount;
        } else if (type==2 && currentBalance[index]>=amount ) {
            currentBalance[index]-=amount;
        }else if (type==3 && wanithaBalance[index]>=amount){
            wanithaBalance[index]-=amount;
        }else {
            System.out.println("Insufficient Balance");
        }
        System.out.println("Withdraw Successful");

    }
    public static void checkBalance(){
        System.out.println("Check Balance");
        int[] accData = getAccountDetails();
        if (accData == null) return;
        int type = accData[0], index = accData[1];

        double balance;
        if (type == 1){
            balance = savingBalance[index];
        } else if (type == 2){
            balance = currentBalance[index];
        } else{
            balance = wanithaBalance[index];
        }
        System.out.println("Available Baalance: "+balance);

    }
    public static void applyLoan() {
        System.out.println("Apply for Loan");
        int[] accData = getAccountDetails();
        if (accData == null) return;
        int type = accData[0], index = accData[1];

        System.out.print("Enter Loan Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Loan Description: ");
        String desc = scanner.nextLine();

        if (type == 1) {
            savingLoanAmount[index] = amount;
            savingLoanDesc[index] = desc;
        } else if (type == 2) {
            currentLoanAmount[index] = amount;
            currentLoanDesc[index] = desc;
        } else {
            wanithaLoanAmount[index] = amount;
            wanithaLoanDesc[index] = desc;
        }

        System.out.println("Loan Applied Successfully!");
    }
    public static void viewLoanDetails() {
        System.out.println("\n--- View Loan Details ---");
        int[] accData = getAccountDetails();
        if (accData == null) return;
        int type = accData[0], index = accData[1];

        double amount;
        String desc;
        if (type == 1) {
            amount = savingLoanAmount[index];
            desc = savingLoanDesc[index];
        } else if (type == 2) {
            amount = currentLoanAmount[index];
            desc = currentLoanDesc[index];
        } else {
            amount = wanithaLoanAmount[index];
            desc = wanithaLoanDesc[index];
        }

        if (amount == 0) {
            System.out.println("No loan details found!");
        }
        else{
            System.out.println("Loan Amount: " + amount + "\nDescription: " + desc);
        }
    }
    public static void transferFunds() {
        System.out.println("\n--- Transfer Funds ---");
        System.out.println("Source Account:");
        int[] fromAcc = getAccountDetails();
        if (fromAcc == null) return;

        System.out.println("\nDestination Account:");
        int[] toAcc = getAccountDetails();
        if (toAcc == null) return;

        System.out.print("Enter Amount to Transfer: ");
        double amount = scanner.nextDouble();

        double fromBalance;
        if (fromAcc[0] == 1)
            fromBalance = savingBalance[fromAcc[1]];
        else if (fromAcc[0] == 2)
            fromBalance = currentBalance[fromAcc[1]];
        else
            fromBalance = wanithaBalance[fromAcc[1]];


        if (amount > fromBalance) {
            System.out.println(" Insufficient Balance!");
            return;
        }

        if (fromAcc[0] == 1) savingBalance[fromAcc[1]] -= amount;
        else if (fromAcc[0] == 2) currentBalance[fromAcc[1]] -= amount;
        else wanithaBalance[fromAcc[1]] -= amount;

        // Add to destination
        if (toAcc[0] == 1) savingBalance[toAcc[1]] += amount;
        else if (toAcc[0] == 2) currentBalance[toAcc[1]] += amount;
        else wanithaBalance[toAcc[1]] += amount;

        System.out.println("Transfer Successful!");
    }
    
    public static int[] getAccountDetails(){
        System.out.println("1) Savings Account\n" + "2) Current Account\n" + "3) Wanitha Wasana Account");
        System.out.print("Select your type: ");
        int type = scanner.nextInt();
        System.out.println("Enter account number: ");
        int accNo = scanner.nextInt();
        
        int index = -1;
        if (type==1){
            index = findAccountIndex(savingAccNo,savingCount,accNo);
        } else if (type==2) {
            index = findAccountIndex(currentAccNo,currentCount,accNo);
        } else if (type==3) {
            index = findAccountIndex(wanithaAccNo,wanithaCount,accNo);
        }else {
            System.out.println("Invalid account type!");
        }
        if (index ==-1){
            System.out.println("Account Not Found!");
            return null;
        }
        return new int[]{type,index};
    }
    public static int findAccountIndex(int[] accArray,int count,int accNo){
        for (int i = 0; i < count; i++) {
            if (accArray[i]==accNo){
                return i;
            }

        }return -1;

    }
}
