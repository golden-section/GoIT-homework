package module13;

import module13.models.*;

import java.io.IOException;
import java.util.List;

public class HttpRequestsTests {
    public static void main(String[] args) throws IOException, InterruptedException {

        Address demoAddress = new Address("Green", "Suite 123", "Test City", "123-1234", new Geo("35.1294", "19.2377"));
        User demoUser = new User (10,"Dave", "Doe", "demo@demo.tld", demoAddress, "123-11-22-33", "demo.tld", new Company("Custom Company", "Java", "bs"));


        // Create a new user
        User createdUser = HttpUtilities.createUser(demoUser);
        System.out.println("createdUser = " + createdUser + "\n");

        // Update created user's name, email and website
        demoUser.setName("Bill");
        demoUser.setEmail("test@test.tld");
        demoUser.setWebsite("demo-user.tld");

        User updatedUser = HttpUtilities.updateUser(demoUser);
        System.out.println("updatedUser = " + updatedUser + "\n");

        // Delete the user
        HttpUtilities.deleteUser(demoUser);

        // Get all users
        List<User> allUsers =  HttpUtilities.getAllUsers();
        System.out.println("All users:");
        for (User user: allUsers) {
            System.out.println(user);
        }

        // Get user by ID
        User userById = HttpUtilities.getUserById(9);
        System.out.println("\nuserById = " + userById + "\n");

        // Get user by username
        User userByUsername = HttpUtilities.getUserByUsername("Samantha");
        System.out.println("userByUsername = " + userByUsername + "\n");

        // Get all last post comments for the specific user ID and write the result to the "user-X-post-Y-comments.json" file
        HttpUtilities.getLastPostCommentsByUserId(7);

        // Get user uncompleted todos by the user ID
        System.out.println("Uncompleted todos:");
        List<Todos> uncompletedTodos = HttpUtilities.getUncompletedTodosByUserId(3);
        for (Todos todo: uncompletedTodos) {
            System.out.println(todo);
        }
    }
}