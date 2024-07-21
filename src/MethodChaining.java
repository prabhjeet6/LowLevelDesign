public class MethodChaining {
    public static void main(String[] args) {
        Student student = new Student("Prabhjeet", "singh.92prabhjeet@gmail.com");

        System.out.println("Before Modification ");
        System.out.println("HashCode :" + student.hashCode() + " Object Content: " + student);

        student.getModifiedObject("Prabhjeet Singh", "prabhjeet.singh92@outlook.com");

        System.out.println("After Modification ");
        System.out.println("HashCode :" + student.hashCode() + " Object Content: " + student);

    }
}

class Student {
    String name;
    String email;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;

    }

    //Method Chaining is used in Builder Pattern, instead of returning a new object,
    // same memory is utilised to modify the existing object
    Student getModifiedObject(String name, String email) {
        this.name = name;
        this.email = email;
        return this;

    }

}

