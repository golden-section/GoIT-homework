package module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import module13.models.Post;
import module13.models.Todos;
import module13.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class HttpUtilities {
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static User createUser(User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }

    public static User updateUser(User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", USERS_URL, user.getId())))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }

    public static void deleteUser(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", USERS_URL, user.getId())))
                .DELETE()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("deleteUser response status code is " + response.statusCode() + "\n");
    }

    public static List<User> getAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .GET()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), new TypeToken<List<User>>() {}.getType());
    }

    public static User getUserById(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", USERS_URL, userId)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }

    public static User getUserByUsername(String username) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s?username=%s", USERS_URL, username)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        User[] userByUsername = GSON.fromJson(response.body(), User[].class);

        return userByUsername[0];
    }

    public static void getLastPostCommentsByUserId(int userId) throws IOException, InterruptedException {
        List<Post> posts = getPostList(userId);
        int maxPostId = getMaxPostId(posts);
        HttpResponse<String> comments = getStringOfCommentsByPostId(maxPostId);

        writeCommentsToFile(userId, maxPostId, comments);
    }

    private static void writeCommentsToFile(int userId, int postId, HttpResponse<String> comments) {
        File file = new File(String.format("./files/user-%d-post-%d-comments.json", userId, postId));
        try {
            Writer writer = new FileWriter(file);
            writer.write(comments.body());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static HttpResponse<String> getStringOfCommentsByPostId(int postId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d/comments", POSTS_URL, postId)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        return CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static int getMaxPostId(List<Post> posts) {
        return posts.stream()
                .mapToInt(Post::getId)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private static List<Post> getPostList(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d/posts", USERS_URL, userId)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), new TypeToken<List<Post>>() {}.getType());
    }

    public static List<Todos> getUncompletedTodosByUserId(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d/todos?completed=false", USERS_URL, userId)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), new TypeToken<List<Todos>>() {}.getType());
    }
}