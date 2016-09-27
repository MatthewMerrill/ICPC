import java.util.Scanner;

/**
 * Created by merrillm on 9/26/16.
 */
public class WhatABind {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        scn.nextLine();
        String buff = "";
        Exception e = new Exception();
        
        try {
            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                if (line.startsWith("{")) {
                    buff += "{";
                } else if (line.startsWith("}")) {
                    buff = buff.substring(0, line.lastIndexOf('}'));
                }
                else if (line.startsWith("declare")) {
                    String suff = line.split("=")[1];
                    if (suff.startsWith("$")&&!buff.contains(suff)) {
                        throw e;
                    }
                    buff += line.split(" |=")[1]+';';
                } else if (line.startsWith("call") || line.startsWith("return")) {
                    if (!buff.contains(line.split(" ")[1])) {
                        throw e;
                    }
                }
            }
            System.out.println(0);
        } catch (Exception ex) {
            System.out.println(1);
        }
        
    }
}
