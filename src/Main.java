import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the count of numbers to be generated(Natural number less than 99):");
        int n = s.nextInt();
        while(n<=0 || n>=99) {
            System.out.println("Please enter only a natural number less than 99 inorder to support our assumption constraint:");
            n = s.nextInt();
        }
        Set<Integer> s1 = gen(n);
        System.out.println("Generated n random numbers are:");
        System.out.println(s1);
        System.out.println("Now enter n distinct numbers each in new lines:");
        Set<Integer> s2 = new HashSet<Integer>();
        int k;
        while(s2.size()<n) {
            k = s.nextInt();
            if(k<=0 || k>=99) {
                System.out.println("Please enter only a natural number less than 99 inorder to support our assumption constraint:");
                continue;
            }
            if(!s2.contains(k)) {
                s2.add(k);
            } else {
                System.out.println("The given number is already present in the set, please enter only distinct values");
            }
        }
        System.out.println("The user entered numbers are:");
        System.out.println(s2);
        int m = match(s1, s2);
        System.out.println("The number of matches are: ");
        System.out.println(m);
        int prize = win(m);
        System.out.println("Winning prize of the player is: ");
        System.out.println(prize);
        return;
    }

    public static Set<Integer> gen(int n) {
        Set<Integer> s = new HashSet<Integer>();
        Random rand = new Random();
        int upperBound = 98;
        int i,r;
        while(s.size()<n) {
            r = 1+ rand.nextInt(upperBound);
            if(!s.contains(r)) {
                s.add(r);
            }
        }
        return s;
    }

    public static int match(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> s = new HashSet<Integer>();
        int m=0;
        for(Integer value: s1)
        {
            if(s2.contains(value)) {
                s.add(value);
                m++;
            }
        }
        System.out.println("The matched winning numbers found between the both sets are:");
        System.out.println(s);
        return m;
    }

    public static int win(int c) {
        return c*c*c*1000;
    }

}