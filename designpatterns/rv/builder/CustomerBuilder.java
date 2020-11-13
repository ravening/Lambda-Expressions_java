package rv.builder;

import java.util.Comparator;

public class CustomerBuilder {
    public static void main(String[] args) {
        Customer customer = Customer.builder()
                .with(builder -> {
                    builder.firstName = "John";
                    builder.lastName = "Doe";
                    builder.age = 30;
                    builder.address = "SFO";
                    builder.phone = "1234567890";
                    builder.sex = Customer.Sex.MALE;
                }).build();

        Customer customer1 = Customer.builder()
                .with(builder -> {
                    builder.firstName = "Foo";
                    builder.lastName = "Bar";
                    builder.age = 35;
                })
                .build();

        Comparator<Customer> customerComparator = Comparator.comparing(Customer::getFirstName)
                .thenComparing(Customer::getAge);

        System.out.println(customer);

        System.out.println("Foo > John ? " + (customerComparator.compare(customer1, customer) > 0));
    }
}
