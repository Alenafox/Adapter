package com.example.customadapterdemo;

import java.util.ArrayList;

public class User{
   String name, phoneNumber;
   Sex sex;

public User(String name, String phoneNumber, Sex sex) {
       this.name = name;
       this.phoneNumber = phoneNumber;
       this.sex = sex;
   }

}
class M {
    ArrayList<User> users;
}
