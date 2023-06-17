package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount bankAccount = new BankAccount("Rockey", 5000, 2000);
        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount.getName());
        try {
            System.out.println(bankAccount.generateAccountNumber(100, 9));
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
//        System.out.println("Bank Account Done");
        CurrentAccount currentAccount = new CurrentAccount("Chandra", 50000, "AAABBCAACC");
        try {
            currentAccount.validateLicenseId();
            System.out.println(currentAccount.tradeLicenseId);
        }catch (Exception exception) {
            System.out.println(exception.toString());
        }

    }
}