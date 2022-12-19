package jvm.pablohdz.example.imports.repository;


import static jvm.pablohdz.example.imports.LogClass.*;

import jvm.pablohdz.example.imports.LogClass;


public class UserRepository {
    private final LogClass logClass;
    
    public UserRepository(LogClass logClass) {
        this.logClass = logClass;
    }
    
    public void registerUser() {
        boolean userRegistered = false;
        if (!userRegistered) {
            logErrorStr("The use cannot be registered");
        } else {
            logStr("new user registered");
        }
    }
}
