package com.llt;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        Scanner scanner=new Scanner(System.in);
        int num=0;
        scanner.nextLine();
        while( scanner.hasNext()){
            try
            {
                String s =scanner.nextLine();
                handler(s);

            }catch(ClassNotFoundException ex)
            {
                System.out.println("没有这个命令");
            }
        }
    }


    private static String ERRORPARM = "错误的参数长度";
    public static void handler(String s ) throws ClassNotFoundException {
        String[] parms = s.split("\\s+");
        String name = null;
        Class clazz = null;
        Method method = null;
        switch (parms.length){
            default:parms[2] = s.substring(s.indexOf(parms[2]));
            case 3:
                name = "com.llt.cmd." + parms[0].substring(0, 1).toUpperCase() + parms[0].substring(1) + "Cmd";
                clazz = Class.forName(name);
                try {
                    method = clazz.getMethod(parms[1], String.class);
                    method.invoke(clazz, parms[2]);
                } catch (NoSuchMethodException e) {
                    System.out.println("没有这个命令" + parms[1]);
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                name = "com.llt.cmd." + parms[0].substring(0, 1).toUpperCase() + parms[0].substring(1) + "Cmd";
               clazz = Class.forName(name);
                try {
                    method = clazz.getMethod(parms[1]);
                    method.invoke(clazz);
                } catch (NoSuchMethodException e) {
                    System.out.println("没有这个命令" + parms[1]);
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                System.out.println("参数不够");
        }

    }
}
