package com.lzp.mykotlin;

import com.lzp.yourkotlin.TopClass;
import org.jetbrains.annotations.NotNull;

public class JavaUtils {

    public Person getP() {
        Person p = new Person("lisi", "上海",12, false);
        //get
        p.getName();
        p.getAge();
        p.isMarried(); //is前缀get方法不变

        //set
        p.setAge(20);
        p.setMarried(true); //is前缀把is变为set
        return p;
    }

    public void getTopMethod() {
//        KotlinUtilsKt.topMethod();
        String top = TopClass.topMethod();
        int c = TopClass.getCount();
        String s = TopClass.topString;
        boolean b = TopClass.isNumFirst("qwe123");
        char s1 = TopClass.getLastChar("android");
    }

    public static String qqq(){
        return "java";
    }

    class KA implements com.lzp.mykotlin.ClickableB{

        @NotNull
        @Override
        public String showText() {
            return null;
        }

        @Override
        public void click() {

        }
    }

    interface Ja{
        String a = "aaa";
    }

}
