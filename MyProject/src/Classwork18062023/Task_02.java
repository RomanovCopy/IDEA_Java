package Classwork18062023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task_02 {


    public Task_02(){

        var scan=new Scanner(System.in);
        System.out.print("Первая строка : ");
        var line1=scan.nextLine();
        System.out.print("Вторая строка : ");
        var line2=scan.nextLine();
        scan.close();
        if(isIsomorphic(line1, line2)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }


    private boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length() || str1.length()==0) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (mapping.containsKey(c1)) {
                if (mapping.get(c1) != c2) {
                    return false;
                }
            } else {
                if (mappedChars.contains(c2)) {
                    return false;
                }
                mapping.put(c1, c2);
                mappedChars.add(c2);
            }
        }

        return true;
    }
    
}
