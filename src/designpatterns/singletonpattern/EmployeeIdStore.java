package designpatterns.singletonpattern;

import java.util.HashMap;
import java.util.Map;

//eg of SingleTon Pattern Usage: Factory classes of Factory Design Pattern, classes managing Thread pools,
//classes managing DB connection pool, Classes designed to access Cache etc
public class EmployeeIdStore {
    private static EmployeeIdStore INSTANCE = null;
    private final Map<Integer, String> store;

    private EmployeeIdStore() {
        this.store = new HashMap<>();
        store.put(1, "Prabhjeet Singh");
        store.put(2, "James Doe");
        store.put(3, "Santa Clause");

    }

    //getInstance method is marked synchronized to make sure two different threads do not have two separate
    // copies  of INSTANCE in case of context switch causing a race condition to arise.
    public synchronized static EmployeeIdStore getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeIdStore();
        }
        return INSTANCE;
    }

    //Double check locking is performant in comparison to the above, as soon as a thread enters
    // the synchronized block, it confirms if an object is not available, before creating the instance

    //One thing to keep in mind with this pattern is that the field needs to be volatile to prevent cache
    // incoherence issues. In fact, the Java memory model allows the publication of partially initialized
    // objects and this may lead in turn to subtle bugs.

    //that is, when using double check locking, we need to initialize field as below
    // private static volatile EmployeeIdStore INSTANCE = null;

    //other alternatives are EAGER initialization of instance and initialization on demand
    // ref: https://www.baeldung.com/java-singleton-double-checked-locking
    public static EmployeeIdStore getInstanceWithDoubleCheckLocking() {
        if (INSTANCE == null) {
            synchronized (EmployeeIdStore.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EmployeeIdStore();
                }
            }
        }
        return INSTANCE;
    }

    public String getName(int employeeId) {
        if (store.containsKey(employeeId)) {
            return store.get(employeeId);
        } else {
            throw new RuntimeException("Employee Id is not present");
        }
    }



}
