package designpatterns.singletonpattern;

public class Tester {
    public static void main(String as[]) throws CloneNotSupportedException, NoSuchMethodException {
        EmployeeIdStore employeeIdStore1=EmployeeIdStore.getInstance();
        EmployeeIdStore employeeIdStore2=EmployeeIdStore.getInstance();

        String name=employeeIdStore1.getName(1);
        System.out.println(employeeIdStore1==employeeIdStore2);
        System.out.println(name);

    }

}
