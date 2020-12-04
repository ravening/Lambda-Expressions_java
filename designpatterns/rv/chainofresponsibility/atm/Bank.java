package rv.chainofresponsibility.atm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    private String name;

    private Map<String, User> users;

    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.users = new ConcurrentHashMap<>();
        this.accounts = new ArrayList<>();
    }

    public String getNewUserUUId() {
        return UUID.randomUUID().toString();
    }

    public String getNewAccountUUId() {
        return UUID.randomUUID().toString();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param pin
     * @param accountType
     * @return
     * @throws NoSuchAlgorithmException
     */
    public User createUser(String firstName, String lastName, String userName, String pin, String accountType) throws NoSuchAlgorithmException {
        User user = new User(firstName, lastName, pin, userName,this);
        this.users.putIfAbsent(userName, user);

        Account account = new Account(accountType, user, this);
        user.addAccount(account);
        this.addAccount(account);

        return user;
    }

    public void addUser(User user, Account account) {
        this.users.put(user.getUserName(), user);
        this.accounts.add(account);
    }

    public Optional<User> userLogin(String userName, String pin) {
        if (users.containsKey(userName)) {
            User user = users.get(userName);
            if (validatePin(user, pin)) {
                return Optional.ofNullable(users.get(userName));
            }
        }

        return Optional.empty();
    }

    private boolean validatePin(User user, String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(pin.getBytes()), user.getPinHash());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Unable to decode pin");
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
