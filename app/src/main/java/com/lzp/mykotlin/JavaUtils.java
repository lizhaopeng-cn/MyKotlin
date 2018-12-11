package com.lzp.mykotlin;

import android.util.Log;
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

    private void judgeEquals(){
        {
            // ==基本类型比值；==包装类比引用地址；equals比引用地址
            Integer a = 127;
            Integer b = 127;
            Integer c = 128;
            Integer d = 128;
            Log.i("test","127=127" + String.valueOf(a==b)); //true java中byte(-128～127)的值会默认缓存
            Log.i("test","128=128" + String.valueOf(c==d)); //false
        }

        {
            int a = 60000;
            Integer b = a;
            boolean isEqual = a == b; // b的Integer拆箱与a比值
            Log.i("test","isEquali=" + String.valueOf(isEqual));
        }
    }

}
