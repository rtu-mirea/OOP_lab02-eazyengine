package com.company;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }

    public static void main(String[] args) throws IOException {
        int ok=0,n=0;
        while (ok!=1) {
            System.out.print("1. 1 задание \n2. 2 задание\n3. 3 задание\n");
            Scanner in = new Scanner(System.in);
            do {
                System.out.print("Введите номер задания от 1 до 3:");
                while (!in.hasNextInt()) {
                    System.out.print("Это не число! Повторите ввод:");
                    in.next();
                }
                n = in.nextInt();
            } while (n < 1 || n > 3);
            switch (n) {
                case (1):{
                    String buf= readUsingScanner("txt.txt");
                    Task1 t1=new Task1(buf);
                    System.out.println(t1.getText());
                    t1.ToLower();
                    System.out.println(t1.getText());
                    System.out.println(Arrays.toString(t1.ToArr()));
                    t1.WordAm();
                    System.out.print("Введите префикс: ");
                    String pref=in.nextLine();
                    pref=in.nextLine();
                    System.out.println("Слов с этим префиксом :"+t1.prefam(pref));
                    break;
                }
                case (2):{
                    String buf= readUsingScanner("txt.txt");
                    Task2 t2=new Task2(buf);
                    System.out.println(t2.getText());
                    t2.DigitSwaper();
                    System.out.println(t2.getText());
                    t2.End();
                    System.out.println(t2.getText());
                    t2.DigitSwaper3();
                    System.out.println(t2.getText());
                    break;
                }
                case(3):{
                    System.out.print("Введите дату: ");
                    String data=in.nextLine();
                    data=in.nextLine();
                    Task3 t3=new Task3(data);
                    if (t3.rightRus(t3.getData())){System.out.println("Дата корректна в русском формате");}
                    if (t3.rightUS(t3.getData())){System.out.println("Дата корректна в американском формате");}
                    if (!t3.rightUS(t3.getData()) && !t3.rightRus(t3.getData())) {System.out.println("Дата не коректна");}
                    String buf= readUsingScanner("txt.txt");
                    Task3 t31=new Task3(buf);
                    System.out.println(buf);
                    System.out.println(t31.swap());
                    break;
                }
            }
        }
    }
}
