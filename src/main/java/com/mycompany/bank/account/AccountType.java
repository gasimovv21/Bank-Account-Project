/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank.account;

/**
 *
 * @author gasimovv21
 */
public class AccountType extends BankAccount{
    
    public int balance, withdraw, deposit; 
    public double commission_percentage;
    public int cash = 10000;
    public int accounType_menu_choose;
    public static String accountType_choice;

    @Override
    public void NormalAccount() {
        balance = 500;
        commission_percentage = 0.05;
        
    }

    @Override
    public void StudentAccount() {
        balance = 950;
        commission_percentage = 0.03;
    }

    @Override
    public void ForOlderPeaopleAccount() {
        balance = 1500;
        commission_percentage = 0.01;
    }
    
}
