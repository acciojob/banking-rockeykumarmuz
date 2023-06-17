package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    private static int minBalance = 5000;
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, minBalance);
        if (balance < minBalance)
            throw new Exception("Insufficient Balance");
        this.tradeLicenseId = tradeLicenseId;

        //validateLicenseId();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int freq[] = new int[26];
        //abbcacca
        for (int i = 0; i < tradeLicenseId.length(); i++) {
            char ch = tradeLicenseId.charAt(i);
//            int x = ch - 'a';
//            System.out.println("**" + x);
            freq[ch - 'A']++;
        }

        for (int i = 0; i < freq.length; i++) {
            if(tradeLicenseId.length() % 2 == 0 && freq[i] != 0 && freq[i] > tradeLicenseId.length() / 2) {
                throw new Exception("Valid License can not be generated");
            }else if (tradeLicenseId.length() % 2 != 0 && freq[i] != 0 && freq[i] > ((tradeLicenseId.length() + 1) / 2)){
                throw new Exception("Valid License can not be generated");
            }
        }

        boolean flag = false;
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                flag = true;
                break;
            }
        }

        if (flag == false)return;

        char charArray[] = new char[tradeLicenseId.length()];
        int itr = 0;
        for(char ch : tradeLicenseId.toCharArray()) {
            if(itr + 2 < charArray.length){
                charArray[itr] = ch;
                itr += 2;
            }else {
                itr = 1;
                charArray[itr] = ch;
            }
        }

        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            stringbuilder.append(charArray[i]);
        }
        this.tradeLicenseId = stringbuilder.toString();
    }

}