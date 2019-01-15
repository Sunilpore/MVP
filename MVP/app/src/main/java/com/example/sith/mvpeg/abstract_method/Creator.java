package com.example.sith.mvpeg.abstract_method;

public class Creator {

    public static MyAbstract getPermission (String name){

        if(name.equalsIgnoreCase("Permission")){
            return new AssignClass();
        }

      return null;
    }

}
