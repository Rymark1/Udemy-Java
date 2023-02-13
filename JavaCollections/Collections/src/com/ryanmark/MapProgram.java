package com.ryanmark;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        languages.put("Java","a compiled high level, object-oriented, platform independent language");
        languages.put("Python", "an interpreted object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if (languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        }
        else
            languages.put("Java", "This course is about Java");

        System.out.println(languages.get("Java"));
        System.out.println(languages.put("Java", "This course is about Java"));
        System.out.println(languages.get("Java"));


        System.out.println("=================================");

 //     languages.remove("Lisp");
        if (languages.remove("Algol", "a family of algorithmic languages"))
            System.out.println("Algol removed");
        else
            System.out.println("Algol not removed.  key/value pair not found");

        System.out.println(languages.replace("Lisp", "a functional programming language with imperitive features"));
        System.out.println(languages.replace("Scala", "This will not work"));
        for (String key: languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
