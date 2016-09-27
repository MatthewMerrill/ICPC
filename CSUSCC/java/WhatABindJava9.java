import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

import java.util.Scanner;

/**
 * Created by merrillm on 9/26/16.
 */
public class WhatABindJava9 {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        JShell repl = JShell.create();
        
        scn.nextLine();
        
        try {
            while (scn.hasNextLine()) {
                SnippetEvent se = repl.eval(scn.nextLine()
                        .replace("declare", "Object")
                        .replace('$', '_')
                        .replace("call ","")).get(0);
                System.out.printf("%s\n", se.toString());
            }
            System.out.println(0);
        } catch (Exception e) {
            System.out.println(1);
        }
        
        repl.close();
    }
}
