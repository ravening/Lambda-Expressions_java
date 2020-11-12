package rv.builder;

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

        System.out.println(customer);
    }
}
