/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank.account;

/**
 *
 * @author gasimovv21
 */
public class Customers {
    String personalId;
    String firstName;
    String lastName;
    String gender;
    String age;
    Address address;
    String username;
    String password;

    public Customers(
            String personalId,
            String firstName,
            String lastName,
            String gender,
            String age,
            Address address,
            String username,
            String password
    )
    {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
    }
}
