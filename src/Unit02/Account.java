/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit02;

import java.util.Scanner;

/**
 *
 * @author 1SANDRESCO
 */
public class Account {

    private String holderFirstName;
    private String holderLastName;
    private int accountNumber;
    private int bankNumber;
    private int accountType;
    private int pin;
    private double balance;
    private boolean active = false;

    ;


    public Account() {

    }

    public Account(int accountNumber, int bankNumber, int accountType) {

    }

    public String getHolderFirstName() {
        return holderFirstName;
    }

    public String getHolderLastName() {
        return holderLastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public int getAccountType() {
        return accountType;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setHolderFirstName(String holderFirstName) {
        this.holderFirstName = holderFirstName;
    }

    public void setHolderLastName(String holderLastName) {
        this.holderLastName = holderLastName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //@Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.accountNumber;
        hash = 41 * hash + this.bankNumber;
        return hash;
    }

    //@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.accountNumber != other.accountNumber) {
            return false;
        }
        if (this.bankNumber != other.bankNumber) {
            return false;
        }
        return true;
    }

    //@Override
    public String toString() {
        return "Account{" + "holderFirstName=" + holderFirstName + ", holderLastName=" + holderLastName + ", accountNumber=" + accountNumber + ", bankNumber=" + bankNumber + ", accountType=" + accountType + ", pin=" + pin + ", balance=" + balance + ", active=" + active + '}';
    }

    public boolean checkPin(int pin) {
        if (pin == this.pin) {
            return true;
        } else {
            return false;
        }
    }

    public double deposit(double inputMoney, int pin) {
        if (this.isActive() == true && checkPin(pin) == true) {
            this.balance += inputMoney;
        }
        return balance;
    }
    
    public double withdraw(double exitMoney, int pin){
        if (this.isActive() == true && checkPin(pin) == true){
            this.balance -= exitMoney;
        }
        return balance;
    }
    
    public boolean activate (boolean wantToActivate){
        this.active = wantToActivate;
        return active;
    }

}
