package designpatterns;
//Creational Design Pattern
public class BuilderDesignPattern {
    public static void main(String[] arg) {
        User user = new User.UserBuilder("Prabhjeet", 6)
                .phoneNumber("1234")
                .age(31)
                .build();
        System.out.println(user);
    }

}

class User {
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    private final String name;
    private final int id;
    private final int age;//optional
    private final String phoneNumber;//optional

    //if we approach everytime an additional filed is needed
    // with constructor overloading/chaining, it may explode if there are too many such fields

    //if we add setters for every additional filed, we use immutability
    User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.id = userBuilder.id;
        this.age = userBuilder.age;
        this.phoneNumber = userBuilder.phoneNumber;
    }

    //Builder class is static so that, it can be used without the instance of the Outer class,
    // instead, builder class' object is used to create User's instance
    //Builder class contains all the fields of User class.
    static class UserBuilder {
        private final String name;
        private final int id;

        //Please note that optional fields age and phoneNumber of Builder class are not final, but,
        // User's optional fields are final, restoring its immutability
        private int age; //optional

        private String phoneNumber;//optional


        UserBuilder(String name, int id) {
            this.name = name;
            this.id = id;
            this.age = 0;
            this.phoneNumber = "";
        }

        UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        //instead of setField(...) we use field(...) as convention for builder pattern.
        //Every setter of Builder class returns the instance of Builder after setting the field
        UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        //As User class takes Builder instance as an argument, build method of Builder class
        // returns the instance of the outer class
        User build() {
            return new User(this);
        }


    }
}

