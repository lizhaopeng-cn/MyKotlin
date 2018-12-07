package com.lzp.mykotlin;

public class JavaUtils {

    public Person getP(){
        Person p = new Person("lisi", 12, false);
        //get
        p.getName();
        p.getAge();
        p.isMarried(); //is前缀get方法不变

        //set
        p.setAge(20);
        p.setMarried(true); //is前缀把is变为set
        return p;
    }

}
