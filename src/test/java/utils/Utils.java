package utils;

public class Utils {

    public static class User {
        public String userName;
        public String firstName;
        public String lastName;

        public User(String userName, String firstName, String lastName) {
            this.userName = userName;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public User generateUser() {
        String userName = "StarLord";
        String firstName = "Bell";
        String lastName = "Star";

        return new User(userName, firstName, lastName);
    }

    public static void main(String[] args) {
        Utils generator = new Utils();
        User user = generator.generateUser();

        System.out.println(user);
    }
}