/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank.account;

import java.util.ArrayList;
import java.util.UUID;


import java.util.Scanner;
import java.util.regex.Matcher;
/**
 *
 * @author gasimovv21
 */
public class CustomersRepository extends MainRepository {
    public ArrayList customer_data = new ArrayList<>();
    public ArrayList data_dump_freeze = new ArrayList<>();

    @Override
    public void create() {
        
        //ID
        
        UUID user_uuid = UUID.randomUUID();
        String id = user_uuid.toString();
        
        // Scanner tool
        
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter your first name: ");
        String userFirstName = sc.nextLine();
        
        Matcher matcher = Utils.patterns.get("NamePattern").matcher(userFirstName);
        
        //Testing variable

        while(! matcher.matches()){
            System.out.println("First name can't contain the: \n· numbers \n· spaces \n· symbols. \n Please try again.");
            System.out.println("");
            System.out.print("Enter your first name: ");
            userFirstName = sc.nextLine();
            matcher =  Utils.patterns.get("NamePattern").matcher(userFirstName);
        }
        
        
        // User Lastname
        
        System.out.println("");
        System.out.print("Enter your last name: ");
        String userLastName = sc.nextLine();
        matcher =  Utils.patterns.get("NamePattern").matcher(userLastName);
        
        // Testing variable

        while(! matcher.matches()){
            System.out.println("Last name can't contain the: \n· numbers \n· spaces \n· symbols. \n Please try again.");
            System.out.println("");
            System.out.print("Enter your last name: ");
            userLastName = sc.nextLine();
            matcher =  Utils.patterns.get("NamePattern").matcher(userLastName);
            
        }
        
        // User Gender
        System.out.println("");
        System.out.print("Enter your gender - Male or Female: ");
        String userGender = sc.nextLine();
        
        // Testing variable
        
        while(! userGender.equals("Male") && ! userGender.equals("Female")){
            System.out.println("Are you sure that you are correctly write your gender? \n Enter you gender with a capital letter \n Please try again. ");
            System.out.println("");
            System.out.print("Enter your gender - Male or Female: ");
            userGender = sc.nextLine();
        }
        
        
        // User Age
        System.out.println("");
        System.out.print("Enter your age: ");
        String userAge = sc.nextLine();
        matcher =  Utils.patterns.get("AgePattern").matcher(userAge);
        
        
        // Testing variable

        while(! matcher.matches()){
            System.out.println("Customer must be 18 or older. \nAge can't contain the: \n· letters \n· spaces \n· symbols \n Please try again.");
            System.out.println("");
            System.out.print("Enter your age: ");
            userAge = sc.nextLine();
            matcher =  Utils.patterns.get("AgePattern").matcher(userAge);
        }
        
        // User Address

        System.out.println("");
        System.out.print("Enter your address: ");
        String address = sc.nextLine();
        
        matcher =  Utils.patterns.get("AddressPattern").matcher(address);
        
        Address userAddress = new Address(address);
        
        // Testing Variable
        
        while(! matcher.matches()){
            System.out.println("Address can't contain the: \n· symbols \n Please try again.");
            System.out.println("");
            System.out.print("Enter your address: ");
            address = sc.nextLine();
            matcher =  Utils.patterns.get("AddressPattern").matcher(address);
            
            userAddress = new Address(address);
        }
        
        
        // Account Username
        
        System.out.println("Username must contain: \n· letters and numbers only \n· 8-20 characters \n· Minimum 8 letters.");
        System.out.println("");
        System.out.print("Enter username: ");
        String userUsername = sc.nextLine();
        
        matcher =  Utils.patterns.get("LoginPattern").matcher(userUsername);
        
        // Testing Variable
        
        while(! matcher.matches()){
            System.out.println("Username must contain: \n· letters and numbers only \n· 8-20 characters \n· Minimum 8 letters. \nPlease try again.");
            System.out.println("");
            System.out.print("Enter username: ");
            userUsername = sc.nextLine();
            matcher =  Utils.patterns.get("LoginPattern").matcher(userUsername);
        }
        
        
        // Account Password
        
        System.out.println("");
        System.out.println(" Password must contain: \n· 8-16 characters \n· one uppercase \n· one lowercase \n· one special character: space, !, @, #, $ and etc. \n· one special character.");
        System.out.print("Enter password: ");
        String userPassword = sc.nextLine();
        
        matcher =  Utils.patterns.get("PasswordPattern").matcher(userPassword);
        while(userPassword.equals(userUsername) || ! matcher.matches())
        {
            if(userPassword.equals(userUsername)){
                System.out.println("Your password can't be equall with your username.");
            }
            
            if(! matcher.matches()){
                System.out.println("Password must contain: \n· 8-16 characters \n· one uppercase \n· one lowercase \n· one digit \n· one special character: space, !, @, #, $ and etc. \n Please try again.");
            }
                System.out.println("");
                System.out.print("Enter password: ");
                userPassword = sc.nextLine();
                matcher = Utils.patterns.get("PasswordPattern").matcher(userPassword);
        }   
        
        
        // Adding customer data to ArrayList

        Customers customer = new Customers(
                id,
                userFirstName,
                userLastName,
                userGender,
                userAge,
                userAddress,
                userUsername,
                userPassword);
        
        
            customer_data.add(customer.personalId);
            customer_data.add(customer.firstName);
            customer_data.add(customer.lastName);
            customer_data.add(customer.gender);
            customer_data.add(customer.age);
            customer_data.add(userAddress.address);
            customer_data.add(customer.username);
            customer_data.add(customer.password);
            
            Utils.donwload();
            System.out.println("You are succsesfully registered in our system!");
            int j = 0;
            System.out.println("Your data: ");
            while (j != customer_data.size()){
                System.out.println(
                    Utils.getCustomerDataText(j) + customer_data.get(j));
                    Utils.sleeping(500);
                    j++;
            }
            System.out.println("");
            
    }
    
    @Override
    public void update() {
        Utils.account_settings_menu_flag = false;
        boolean change_data_menu_flag = true;
        while(change_data_menu_flag){  
            Scanner sc_change_data = new Scanner(System.in);
            Utils.change_data_menu();                   
            while(!sc_change_data.hasNextInt()){
                Utils.sleeping(1500);
                System.out.println("Please enter only numbers!");
                Utils.change_data_menu();            
                sc_change_data.nextLine();
            }
            int change_data_console = sc_change_data.nextInt();
            Scanner sc_data = new Scanner(System.in);
            switch(change_data_console){
                case 1 -> {
                    System.out.println("Your current first name: " + customer_data.get(1));
                    Utils.sleeping(1500);
                    System.out.print("Please enter the new first name: ");
                    String new_userFirstName = sc_data.nextLine();
                    Matcher matcher = Utils.patterns.get("NamePattern").matcher(new_userFirstName);
                    
                    //Testing variable

                    while(! matcher.matches()){
                        System.out.println("First name can't contain the: \n· numbers \n· spaces \n· symbols. \n Please try again.");
                        System.out.println("");
                        System.out.print("Please enter the new first name: ");
                        new_userFirstName = sc_data.nextLine();
                        matcher =  Utils.patterns.get("NamePattern").matcher(new_userFirstName);
                    }
                    
                    customer_data.set(1, new_userFirstName);
                    Utils.sleeping(1500);
                    System.out.println("Your new first name: " + customer_data.get(1));
                }
                case 2 -> {
                    System.out.println("Your current last name: " + customer_data.get(2));
                    Utils.sleeping(1500);
                    System.out.print("Please enter the new last name: ");
                    String new_userLastName = sc_data.nextLine();
                    Matcher matcher = Utils.patterns.get("NamePattern").matcher(new_userLastName);
                    
                    //Testing variable

                    while(! matcher.matches()){
                        System.out.println("Last name can't contain the: \n· numbers \n· spaces \n· symbols. \n Please try again.");
                        System.out.println("");
                        System.out.print("Please enter the new last name: ");
                        new_userLastName = sc_data.nextLine();
                        matcher =  Utils.patterns.get("NamePattern").matcher(new_userLastName);
                    }
                    
                    customer_data.set(2, new_userLastName);
                    Utils.sleeping(1500);
                    System.out.println("Your new last name: " + customer_data.get(2));        
                }
                case 3 -> {
                    System.out.println("Your current gender: " + customer_data.get(3));
                    System.out.print("Enter your new gender - Male or Female: ");
                    String new_userGender = sc_data.nextLine();
        
                    // Testing variable
        
                    while(! new_userGender.equals("Male") && ! new_userGender.equals("Female")){
                        System.out.println("Are you sure that you are correctly write your gender? \n Enter your gender with a capital letter \n Please try again. ");
                        System.out.println("");
                        System.out.print("Enter your new gender - Male or Female: ");
                        new_userGender = sc_data.nextLine();
                    }
                    
                    customer_data.set(3, new_userGender);
                    Utils.sleeping(1500);
                    System.out.println("Your new gender: " + customer_data.get(3));
                }
                case 4 -> {
                    System.out.println("Your current age: " + customer_data.get(4));
                    System.out.print("Enter your new age: ");
                    String new_userAge = sc_data.nextLine();
                    Matcher matcher = Utils.patterns.get("AgePattern").matcher(new_userAge);
        
        
                    // Testing variable

                    while(! matcher.matches()){
                        System.out.println("Customer must be 18 or older. \nAge can't contain the: \n· letters \n· spaces \n· symbols \n Please try again.");
                        System.out.println("");
                        System.out.print("Enter your new age: ");
                        new_userAge = sc_data.nextLine();
                        matcher =  Utils.patterns.get("AgePattern").matcher(new_userAge);
                    }
                    
                    customer_data.set(4, new_userAge);
                    Utils.sleeping(1500);
                    System.out.println("Your new age: " + customer_data.get(4));
                }
                case 5 -> {
                    System.out.println("Your current address: " + customer_data.get(5));
                    System.out.print("Enter your new address: ");
                    String new_address = sc_data.nextLine();
        
                    Matcher matcher =  Utils.patterns.get("AddressPattern").matcher(new_address);
        
                    Address new_userAddress = new Address(new_address);
        
                    // Testing Variable
        
                    while(! matcher.matches()){
                        System.out.println("Address can't contain the: \n· symbols \n Please try again.");
                        System.out.println("");
                        System.out.print("Enter your new address: ");
                        new_address = sc_data.nextLine();
                        matcher =  Utils.patterns.get("AddressPattern").matcher(new_address);
            
                        new_userAddress = new Address(new_address);
                    }
                    customer_data.set(5, new_userAddress.address);
                    Utils.sleeping(1500);
                    System.out.println("Your new address: " + customer_data.get(5));
                }
                case 6 -> {
                    System.out.println("Your current username: " + customer_data.get(6));
                    
                    System.out.print("Enter your new username: ");
                    String new_userUsername = sc_data.nextLine();
        
                    Matcher matcher =  Utils.patterns.get("LoginPattern").matcher(new_userUsername);
        
                    // Testing Variable
        
                    while(! matcher.matches()){
                        System.out.println("Username must contain: \n· letters and numbers only \n· 8-20 characters \n· Minimum 8 letters. \nPlease try again.");
                        System.out.println("");
                        System.out.print("Enter your new username: ");
                        new_userUsername = sc_data.nextLine();
                        matcher =  Utils.patterns.get("LoginPattern").matcher(new_userUsername);
                    }
                    customer_data.set(6, new_userUsername);
                    Utils.sleeping(1500);
                    System.out.println("Your new username: " + customer_data.get(6));
                }
                case 7 -> {
                    System.out.println("Your current password: " + customer_data.get(7));
                    
                    System.out.print("Enter your new password: ");
                    String new_userPassword = sc_data.nextLine();
        
                    Matcher matcher =  Utils.patterns.get("PasswordPattern").matcher(new_userPassword);
                    while(new_userPassword.equals(customer_data.get(6)) || ! matcher.matches()){
                        if(new_userPassword.equals(customer_data.get(6))){
                            System.out.println("Your password can't be equall with your username.");
                        }
                        if(! matcher.matches()){
                            System.out.println("Password must contain: \n· 8-16 characters \n· one uppercase \n· one lowercase \n· one digit \n· one special character: space, !, @, #, $ and etc. \n Please try again.");
                        }
                        System.out.println("");
                        System.out.print("Enter your new password: ");
                        new_userPassword = sc_data.nextLine();
                        matcher = Utils.patterns.get("PasswordPattern").matcher(new_userPassword);
                    }
                    customer_data.set(7, new_userPassword);
                    Utils.sleeping(1500);
                    System.out.println("Your new password: " + customer_data.get(7));
                }
                case 8 -> {
                    Utils.account_settings_menu_flag = true;
                    change_data_menu_flag = false;
                    System.out.println("You are going back to Account Settings...");
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
    
    @Override
    public void freeze() {
        if (customer_data != null){
            System.out.println("Please wait a minute, we are trying to protect your data and freeze it.");
            Utils.sleeping(1500);
            data_dump_freeze.addAll(customer_data);
            customer_data = null;
            Utils.sleeping(2000);
            System.out.println("Your account was frozen!");
            Utils.main_menu_flag = true;
            Utils.account_settings_menu_flag = false;
            
        }
    }
    
}