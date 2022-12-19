package jvm.pablohdz.example.imports;


import jvm.pablohdz.example.imports.example.ExampleClass;

public class LogClass {
    
    public String showMessage() {
        return null;
    }
    
    public static void logStr(String message) {
        new ExampleClass();
        System.out.println(message);
    }
    
    public static void logErrorStr(String message) {
        System.err.println(message);
    }
}
