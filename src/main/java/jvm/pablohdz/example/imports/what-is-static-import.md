# What is a Static Import?

Imagine that you start your writing code session, and you create a class how this:

```java
public class LogClass {
    
    public static void logStr(String message) {
        System.out.println(message);
    }
}
```

Maybe the next step is to start to use this class. So imagine that you need to use this class inside another class
called ```UserRepository``` when a new user is registered. How to do to start to use this class in
your ```UserRepository``` class?

When you need to use a class inside another class, you need to import this class, the compiler needs the reference where
the class imported lives. Is how to say I need to buy some bread from the Jack's store, the bread specifically comes
from the Jack's store. It is the same situation that, I need to use the static ```dummyMethod``` from
the ```DummyClass```. Maybe your import for this program looks like ```import org.example.logtutorial.DummyClass;``` So
we need to return to the example with the LogClass.

Imagine that you need to use the LogClass inside the UserRepository how this:

```java
import jvm.pablohdz.example.imports.LogClass;

public class UserRepository {
    
    public void registerUser() {
        LogClass.logStr("new user registered");
    }
}
```

```jvm.pablohdz.example.imports.``` This corresponds to my package name, and the next element is the class that contains
the ```logStr``` method.

Java provides a better approach to import static members from a class, called static import. With the static import you
don't need to use the class name in the import ```LogClass```, you can import directly the method without this reference
you can see the next example:

```java
import static jvm.pablohdz.example.imports.LogClass.logStr;

public class UserRepository {
    
    public void registerUser() {
        logStr("new user registered");
    }
}

```

If you use the static import approach, your code comes to be more readable and clear. I think that is a good approach to
use with the next type of situation:

```java
import static jvm.pablohdz.example.imports.LogClass.logErrorStr;
import static jvm.pablohdz.example.imports.LogClass.logStr;


public class UserRepository {
    
    public void registerUser() {
        boolean userRegistered = false;
        if (!userRegistered) {
            logErrorStr("The use cannot be registered");
        } else {
            logStr("new user registered");
        }
    }
}
```

In the previous example, use two static method from the LogClass and the code looks fine, but we can do this better with
the next example:

```java
import static jvm.pablohdz.example.imports.LogClass.*;


public class UserRepository {
    
    public void registerUser() {
        boolean userRegistered = false;
        if (!userRegistered) {
            logErrorStr("The use cannot be registered");
        } else {
            logStr("new user registered");
        }
    }
}
```

The code looks more fine than the last time, because we only use one import ```import static
jvm.pablohdz.example.imports.LogClass.*;``` with use the ```*```, we can use all static member for the LogClass class.

But not all is beautiful. I remember when I start to learn about testing in Java, I see this type of code:

```java

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
```

It drove me crazy because I didn't know where ```when, thenReturn, verify and times``` methods came from, well, I
didn't know they were methods to begin
with. I was glad when I knew that these methods came from the Mockito class, right now you may be thinking how silly, as
a Java programmer I wouldn't know that, but remember everyone, we were beginners and I think this situation happened to
most of us. These days I use IntelliJ and I don't have these problems because IntelliJ knows where these methods come
from and imports them to me without any problem.

### Conclusion

The import static in Java is a good way to convert our code more readable. But remember, use when you think that is
good. So when is a good moment to use import static?. Experience in coding and reading other people's code will
answer this. 