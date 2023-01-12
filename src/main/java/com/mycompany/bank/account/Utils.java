package com.mycompany.bank.account;

import java.util.HashMap;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author gasimovv21
 */
public class Utils {
    public static Map<Integer, String> menu_panel;
    
    public static Map<Integer, String> customer_data_text;
    
    public static Map<Integer, String> account_panel;

    public static Map<Integer, String> account_settings_panel;
    
    public static Map<Integer, String> change_data_panel;
    
    public static Map<String, Pattern> patterns;
    
    // Flags for while
    
    public static boolean account_settings_menu_flag;
    public static boolean main_menu_flag = true;
    
    
    static {
        menu_panel = new HashMap<Integer, String>();
        menu_panel.put(1, "Log in");
        menu_panel.put(2, "Registration");
        menu_panel.put(3, "Load data");
        menu_panel.put(4, "Download your account data to txt format.");
        menu_panel.put(5, "Quit");
    }
    
     static {
        customer_data_text = new HashMap<Integer, String>();
        customer_data_text.put(0, "Customer ID: ");
        customer_data_text.put(1, "First name: ");
        customer_data_text.put(2, "Last name: ");
        customer_data_text.put(3, "Gender: ");
        customer_data_text.put(4, "Age: ");
        customer_data_text.put(5, "Address: ");
        customer_data_text.put(6, "Username: ");
        customer_data_text.put(7, "Password: ");
    }
        
    static {
        account_panel = new HashMap<Integer, String>();
        account_panel.put(1, "Withdraw");
        account_panel.put(2, "Deposit");
        account_panel.put(3, "Balance");
        account_panel.put(4, "Account settings");
        account_panel.put(5, "Go back");
    }
    
    static {
        account_settings_panel = new HashMap<Integer, String>();
        account_settings_panel.put(1, "Owner data");
        account_settings_panel.put(2, "Change data");
        account_settings_panel.put(3, "Freeze/Unfreeze account");
        account_settings_panel.put(4, "Go back");
    }
    
    static {
        change_data_panel = new HashMap<Integer, String>();
        change_data_panel.put(1, "First name");
        change_data_panel.put(2, "Last name");
        change_data_panel.put(3, "Gender");
        change_data_panel.put(4, "Age");
        change_data_panel.put(5, "Address");
        change_data_panel.put(6, "Username");
        change_data_panel.put(7, "Password");
        change_data_panel.put(8, "Go back");
    }
    
    
    
    static {
        patterns = new HashMap<String, Pattern>();
        
        Pattern NamePattern = Pattern.compile("[a-zA-Z]+");
        Pattern AgePattern = Pattern.compile("^1[8-9]|^[2-9][0-9]|^[1-9][0-9][0-9]$");
        Pattern AddressPattern = Pattern.compile("^[a-zA-Z0-9\\s]+$");
        Pattern LoginPattern = Pattern.compile("^(?=.*[a-zA-Z]{8,})([a-zA-Z0-9]{8,20})$");
        Pattern PasswordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,16}$");
        
        patterns.put("NamePattern", NamePattern);
        patterns.put("AgePattern", AgePattern);
        patterns.put("AddressPattern", AddressPattern);
        patterns.put("LoginPattern", LoginPattern);
        patterns.put("PasswordPattern", PasswordPattern);
    }
     
     
    
    public static String getMenu(Integer segment){
        for (Map.Entry<Integer, String> entry : menu_panel.entrySet()){
            if(segment.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }
    
    public static String getCustomerDataText(Integer segment){
        for (Map.Entry<Integer, String> entry : customer_data_text.entrySet()){
            if(segment.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }
    
    
    public static String getAccountPanel(Integer segment){
        for (Map.Entry<Integer, String> entry: account_panel.entrySet()){
            if(segment.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }
    
    public static String getAccountSettingsPanel(Integer segment){
        for (Map.Entry<Integer, String> entry: account_settings_panel.entrySet()){
            if(segment.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }
    
    public static String getChangeDataPanel(Integer segment){
        for (Map.Entry<Integer, String> entry: change_data_panel.entrySet()){
            if(segment.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }
    
    public static int sleeping(int sleeping_time){
        try {
            Thread.sleep(sleeping_time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    
    public static void donwload(){
        sleeping(1000);
        System.out.println("Just a moment we are creating account for you!");
        for (int i = 0; i <= 100; i++)
        {
            System.out.println("Loading: " + i + "%");
            sleeping(50);
        }
        System.out.println("");
    }
    
    public static void menu() {
        sleeping(1500);
        System.out.print(
            " \\--------------------------------[ EG Bank Menu ]----------------------------------/"
            + "\n1 => " + getMenu(1)
            + "\n2 => " + getMenu(2)
            + "\n3 => " + getMenu(3)
            + "\n4 => " + getMenu(4)
            + "\n5 => " + getMenu(5)
            + "\n Choose the operation which you want to perform: ");
    }
    
    public static void account_menu(){
        sleeping(1500);
        System.out.print(
            " \\--------------------------------[ Account Menu ]----------------------------------/"
            + "\n1 => " + Utils.getAccountPanel(1)
            + "\n2 => " + Utils.getAccountPanel(2)
            + "\n3 => " + Utils.getAccountPanel(3)
            + "\n4 => " + Utils.getAccountPanel(4)
            + "\n5 => " + Utils.getAccountPanel(5)
            + "\n Choose the operation which you want to perform: ");
    }
    
    public static void account_settings_menu(){
        sleeping(1500);
        System.out.print(
            " \\--------------------------------[ Account Settings ]----------------------------------/"
            + "\n1 => " + Utils.getAccountSettingsPanel(1)
            + "\n2 => " + Utils.getAccountSettingsPanel(2)
            + "\n3 => " + Utils.getAccountSettingsPanel(3)
            + "\n4 => " + Utils.getAccountSettingsPanel(4)
            + "\n Choose the operation which you want to perform: ");
    }
    
    public static void change_data_menu(){
        sleeping(1500);
        System.out.print(
            " \\--------------------------------[ Change Data ]----------------------------------/"
            + "\n1 => " + Utils.getChangeDataPanel(1)
            + "\n2 => " + Utils.getChangeDataPanel(2)
            + "\n3 => " + Utils.getChangeDataPanel(3)
            + "\n4 => " + Utils.getChangeDataPanel(4)
            + "\n5 => " + Utils.getChangeDataPanel(5)
            + "\n6 => " + Utils.getChangeDataPanel(6)
            + "\n7 => " + Utils.getChangeDataPanel(7)
            + "\n8 => " + Utils.getChangeDataPanel(8)        
            + "\n Choose the data which you want to change: ");
    }
    
    
    public static void redirect_to_menu(){
        System.out.println("");
        System.out.println("You are automatically will redirect to menu. ");       
        sleeping(1500);
        System.out.println("Just be patiently.");
        sleeping(2000);
        System.out.println("I hope you are still here ^_^");
        sleeping(2000);
        System.out.println("");
    }
    
    public static void login_message() {
        System.out.println("""
            Sorry but you can't Log in,
            while you are not registered in our system!""");
    }
    
    public static void registration_message(int message_type) {
        switch(message_type)
        {
            case 1 -> {
                System.out.println("Sorry but create more than 1 account, in our system fow now is not available.");
                sleeping(1000);
                System.out.println("It will be availabe soon. \nI hope you're not upset ^_^");
            }
            case 2 -> {
                System.out.println("Hello dear visitor, here you can register in our system.");
                System.out.println("");
                sleeping(3000);
                System.out.println("Enter your data correctly please. \n However, you can change it after registration.");
                System.out.println("");
                sleeping(2000);
            }
        }
    }
    
    public static void load_data_message(int message_type) {
        switch(message_type)
        {
            case 1 -> {
                sleeping(2000);
                System.out.println("");
                System.out.println("File is not found!");
                sleeping(1000);
                System.out.println("""
                    Before start upload your data. 
                    Please be sure that all of the following points are met: 
                        · name of file - customer_info 
                        · format - .txt
                        · file location - src/main/java/com/mycompany/bank/account/customer_data.txt""");
                sleeping(8000);
            }   
            case 2 -> {
                System.out.println("");
                sleeping(1500);
                System.out.println("The data in Customer_info.txt file dose not correct, please correct your data in file!");
                sleeping(1500);
                System.out.print("You are logged out!");
                sleeping(1500);
                System.out.println("");
                sleeping(1500);
                System.out.println("We will be waiting for you again. \nGood luck!");
            }
            case 3 -> {
                System.out.println("Sorry but load more than 1 account data, in our system fow now is not available.");
                sleeping(1000);
                System.out.println("It will be availabe soon. \nI hope you're not upset ^_^");
            }
        }
    }
    
    public static void donwload_data_message(int message_type) {
        switch(message_type)
        {
            case 1 -> {
                System.out.println("");
                sleeping(2000);
                System.out.println("Sorry but you can't donwload your data in txt format. \nWhile you are not still create at least one account in our system.");
                sleeping(2000);
            }
        }
    }
    
    public static void quit_message() {
        sleeping(1000);
        System.out.print("You are logged out!");
        System.out.println("");
        sleeping(2000);
        System.out.println("We will be waiting for you again. \nGood luck!");
    }
}
