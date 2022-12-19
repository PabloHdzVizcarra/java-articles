package jvm.pablohdz.example.imports.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jvm.pablohdz.example.imports.LogClass;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {
    
    private UserRepository underTest;
    @Mock
    private final LogClass logClass = new LogClass();
    
    @Test
    void name() {
        underTest = new UserRepository(logClass);
    }
    
    @Test
    void whenRegisterUser_ThenRegisterTheUserCorrect() {
        when(logClass.showMessage())
            .thenReturn("Ok");
        
        underTest.registerUser();
        
        verify(logClass, times(1))
            .showMessage();
    }
}