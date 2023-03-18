package module10.task2;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectUsers {
   public static ArrayList<User> readData(Scanner reader) {
       ArrayList<User> usersData = new ArrayList<>();

       reader.nextLine(); // skip the first line in the input file
       while (reader.hasNextLine()){
           String tempLine = reader.nextLine();
           String[] tempArray = tempLine.split(" ");
           User user = new User(tempArray[0], Integer.parseInt(tempArray[1]));
           usersData.add(user);
       }
        return usersData;
   }
}
