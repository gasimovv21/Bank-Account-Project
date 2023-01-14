/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bank.account;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gasimovv21
 */

public class BankAccount {

    public static void main(String[] args)
    {
        CustomersRepository cr = new CustomersRepository();
        Scanner selected_method_main_menu = new Scanner(System.in);
        boolean account_menu_flag = false;
        int balance = 1500, withdraw, deposit;

        System.out.println("\\----------------------------< Welcome to EG Bank >--------------------------------/");
        while(Utils.main_menu_flag){
            Utils.menu();
            while (! selected_method_main_menu.hasNextInt()){
                Utils.sleeping(1500);
                System.out.println("Please enter only numbers!");
                Utils.menu();
                selected_method_main_menu.nextLine();
            }
            int menu_console_choice = selected_method_main_menu.nextInt();
            switch(menu_console_choice)
            {
                case 1 -> {
                    if (cr.customer_data != null){
                        if (cr.customer_data.isEmpty()){
                            Utils.login_message();
                            Utils.redirect_to_menu();
                        } else {
                            Scanner sc_log_pass = new Scanner(System.in);

                            System.out.println("");
                            System.out.print("Login: ");
                            String login = sc_log_pass.nextLine();

                            System.out.println("");
                            System.out.print("Password: ");
                            String password = sc_log_pass.nextLine();
                                if (login.equals(cr.customer_data.get(6)) && password.equals(cr.customer_data.get(7))){
                                        Utils.main_menu_flag = false;
                                        account_menu_flag = true;
                                        System.out.println("You successfully entered to the bank-account!");
                                        while (account_menu_flag){
                                            Scanner selected_method_account_menu = new Scanner(System.in);
            
                                            Utils.account_menu();
                                            while(! selected_method_account_menu.hasNextInt()){
                                                Utils.sleeping(1500);
                                                System.out.println("Please enter only numbers!");
                                                Utils.account_menu();
                                                selected_method_account_menu.nextLine();
                                            }
            
                                            int account_console = selected_method_account_menu.nextInt();
                                            switch(account_console){
                                                case 1 -> {
                                                    Scanner sc_withdraw = new Scanner(System.in);
                                                    Utils.sleeping(1000);
                                                    System.out.print("Enter money to be withdrawed: ");
                                                    withdraw = sc_withdraw.nextInt();
                                                    if(balance >= withdraw){
                                                        balance = balance - withdraw;
                                                        System.out.println("Your balance: " + balance + "€");
                                                        Utils.sleeping(1000);
                                                        System.out.println("Please collect your money: " + withdraw + " €");
                                                    }
                                                    else {
                                                        Utils.sleeping(1000);
                                                        System.out.println("Insufficient Balance");
                                                        System.out.println("");
                                                        break;
                                                    }   
                                                }
                                                case 2 -> {
                                                    Utils.sleeping(1000);
                                                    Scanner sc_deposit = new Scanner(System.in);
                                                    System.out.print("Enter money to be deposited: ");
                                                    deposit = sc_deposit.nextInt();
                                                    balance = balance + deposit;
                                                    System.out.println("Your balance: " + balance + " €");
                                                    Utils.sleeping(1000);
                                                    System.out.println("Your money has been successfully deposited");
                                                    System.out.println("");
                                                    break;
                                                }
                                                case 3 -> {
                                                    Utils.sleeping(1000);
                                                    System.out.println("Your balance: " + balance + " €");
                                                }
                                                case 4 -> {
                                                    account_menu_flag = false;
                                                    Utils.account_settings_menu_flag = true;
                                                    while(Utils.account_settings_menu_flag){
                                                        Scanner sc_data = new Scanner(System.in);
                                                        Utils.account_settings_menu();      
                                                        while(!sc_data.hasNextInt()){
                                                            Utils.sleeping(1500);
                                                            System.out.println("Please enter only numbers!");
                                                            Utils.account_settings_menu();           
                                                            sc_data.nextLine();
                                                        }
                                                        int account_settings_console = sc_data.nextInt();
                                                        switch(account_settings_console){
                                                            case 1 -> {
                                                                if ( cr.customer_data != null){
                                                                    int k = 0;
                                                                    Utils.sleeping(2000);
                                                                    System.out.println("Your data: ");
                                                                    Utils.sleeping(2000);
                                                                    while (k != cr.customer_data.size()){
                                                                        System.out.println(Utils.getCustomerDataText(k) + cr.customer_data.get(k));
                                                                        Utils.sleeping(500);
                                                                        k++;
                                                                    }
                                                                } else{
                                                                    Utils.sleeping(1500);
                                                                    System.out.println("Sorry but you data not availabe to see. However you account frozen.");
                                                                    System.out.println("If you want to unfrozze your account select 3 button in Account Settings.");
                                                                }
                                                            }
                                                            case 2 -> {
                                                                cr.update();
                                                            }
                                                            case 3 -> {
                                                                cr.freeze();
                                                            }
                                                            case 4 -> {
                                                                account_menu_flag = true;
                                                                Utils.account_settings_menu_flag = false;
                                                                System.out.println("You are going back to Account Menu...");
                                                                Utils.sleeping(2000);
                                                                break;
                                                            }
                                                            default -> {
                                                                Utils.sleeping(1500);
                                                                System.out.print("Not available method!\n");
                                                            }
                                                        }
                                                    }
                                                }
                                                case 5 -> {
                                                    account_menu_flag = false;
                                                    Utils.main_menu_flag = true;
                                                    System.out.println("You are going back to EQ Bank Menu...");
                                                }
                                                default -> {
                                                    Utils.sleeping(1500);
                                                    System.out.print("Not available method!\n");
                                                }
                                            }
                                        }
                                }
                                else{
                                    System.out.println("Wrong login or password!");
                                    System.out.println("Try one more time please.");
                                }  
                        }
                    } else {
                        Scanner sc_unfroze = new Scanner(System.in);
                        System.out.println("Sorry but you can't Log in to your account. However your account frozen.");
                        System.out.print("If you want to unfroze your account, just write 'unfroze': ");
                        String unfroze_answer = sc_unfroze.nextLine();
                        if("unfroze".equals(unfroze_answer)){
                            System.out.println("Please wait a second, we are trying to unfreze your data.");
                            Utils.sleeping(1500);
                            cr.customer_data = new ArrayList<>();
                            cr.customer_data.addAll(cr.data_dump_freeze);
                            Utils.sleeping(1500);
                            System.out.println("Your account unfrozed successfully!");
                        }
                    }
                }
                case 2 -> {
                    if (! cr.customer_data.isEmpty()){
                        Utils.registration_message(1);
                        Utils.redirect_to_menu();
                    }
                    else {
                        Utils.registration_message(2);
                        cr.create();
                    }
                }
                
                case 3 -> {
                    if (cr.customer_data.isEmpty()){
                        // Opening file
                        File file = new File("src/main/java/com/mycompany/bank/account/customer_data.txt");
                        if (! file.exists()) {
                            Utils.load_data_message(1);
                            Utils.redirect_to_menu();
                        } else {
                            Utils.sleeping(2000);
                            System.out.println("File is found!");
                            Scanner scanner = null;
                            try {
                                scanner = new Scanner(file);
                            } catch (FileNotFoundException e) {
                            }

                            // Reading data and upload data to array
                            int i = 0;
                            while (scanner.hasNextLine()) {
                                cr.customer_data.add(i, scanner.nextLine());
                                i++;
                            }

                            // Closing file and show
                            scanner.close();
                    
                            // Check all lines of file, to be sure that everything is correct.
                    
                            Matcher first_name = Utils.patterns.get("NamePattern").matcher((CharSequence) cr.customer_data.get(1));
                            Matcher last_name = Utils.patterns.get("NamePattern").matcher((CharSequence) cr.customer_data.get(2));
                            boolean gender_flag = false;
                            if (cr.customer_data.get(3).equals("Male") || cr.customer_data.get(3).equals("Female")){
                                gender_flag = true;
                            }
                            Matcher age =  Utils.patterns.get("AgePattern").matcher((CharSequence) cr.customer_data.get(4));
                            Matcher address =  Utils.patterns.get("AddressPattern").matcher((CharSequence) cr.customer_data.get(5));
                            Matcher login_mtch =  Utils.patterns.get("LoginPattern").matcher((CharSequence) cr.customer_data.get(6));
                            Matcher password_mtch =  Utils.patterns.get("PasswordPattern").matcher((CharSequence) cr.customer_data.get(7));
                    
                            if (
                                first_name.matches() && 
                                last_name.matches() &&
                                gender_flag &&
                                age.matches() && 
                                address.matches() && 
                                login_mtch.matches() && 
                                password_mtch.matches())
                            {
                                Utils.donwload();
                                System.out.println("You are succsesfully upload your data!");
                                int j = 0;
                                Utils.sleeping(2000);
                                System.out.println("Your data: ");
                                Utils.sleeping(2000);
                                while (j != cr.customer_data.size()){
                                    System.out.println(Utils.getCustomerDataText(j) + cr.customer_data.get(j));
                                    Utils.sleeping(500);
                                    j++;
                                }
                                System.out.println("");
                            } else {
                                Utils.load_data_message(2);
                                Utils.main_menu_flag = false;
                            }
                        }
                    } else {
                        Utils.load_data_message(3);
                        Utils.redirect_to_menu();
                    }
                }
                case 4 -> {
                    if (cr.customer_data.isEmpty()){
                        Utils.donwload_data_message(1);
                        Utils.redirect_to_menu();
                    }
                    else {
                        File file = new File("src/main/java/com/mycompany/bank/account/customer_data.txt");
                        if (!file.exists()) {
                            try {
                                file.createNewFile();
                            } catch (IOException ex) {
                                Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FileWriter fw = null;
                        try {
                            fw = new FileWriter(file);
                        } catch (IOException ex) {
                            Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        BufferedWriter bw = new BufferedWriter(fw);

                        for (Object element : cr.customer_data) {
                            try {
                                bw.write((String) element);
                            } catch (IOException ex) {
                                Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                bw.newLine();
                            } catch (IOException ex) {
                                Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        try {
                            bw.close();
                        } catch (IOException ex) {
                            Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                case 5 -> {
                    Utils.quit_message();
                    Utils.main_menu_flag = false;
                }
                default -> {
                    Utils.sleeping(1500);
                    System.out.print("Not available method!\n");
                }
            }
        }
    }
}
