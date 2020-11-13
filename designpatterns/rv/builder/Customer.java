package rv.builder;

import java.util.function.Consumer;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    private final String phone;
    private final Sex sex;

    Customer(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
        this.sex = builder.sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    static class Builder {
        public String firstName;
        public String lastName;
        public int age;
        public String address;
        public String phone;
        public Sex sex;

        Builder() {}

        public Builder(String fName, String lName) {
            this.firstName = fName;
            this.lastName = lName;
        }

        public Builder builder() {
            return new Builder();
        }
        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
    static enum Sex {
        MALE,
        FEMALE
        ;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                '}';
    }
}
