import java.util.*;
class User{
    String name ;
    int userId ;
    int age ;
    User next ;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();

    User(String name, int userId, int age){
        this.name = name ;
        this.userId = userId ;
        this.age = age ;
        this.next = null ;
    }
}



public class SocialMediaFriendConnections {
    User head ;
    static Scanner sc = new Scanner (System.in);
    int id = 0 ;

    void addUser(){
        System.out.print("Enter User Name : ");
        String name = sc.nextLine();
        int userId = id++ ;
        System.out.print("Enter User Age : ");
        int age = sc.nextInt();
        User user = new User(name, userId, age);

        if(head == null)
            head = user ;
        else{
            User temp = head ;
            while(temp.next != null){
                temp = temp.next ;
            }
            temp.next = user ;
        }
        System.out.println("User Added Successfully !");
        System.out.println("Name : "+user.name);
        System.out.println("Age : "+user.age);
        System.out.println("Id : "+user.userId);
        System.out.println();
    }

    void addConnection(){
        if(head == null){
            System.out.println("No User Exist !");
            return ;
        }
        System.out.print("Enter first User Id : ");
        int userId1 = sc.nextInt();
        System.out.print("Enter Second User Id : ");
        int userId2 = sc.nextInt();
        User temp1 = head ;
        while(temp1 != null){
            if(temp1.userId == userId1)
                break ;
            temp1 = temp1.next ;
        }
        User temp2 = head ;
        while(temp2 != null){
            if(temp2.userId == userId2)
                break ;
            temp2 = temp2.next ;
        }
        boolean b = false ;
        if(temp1 == null ){
            System.out.println("User (Id : "+userId1+") Does not Exist !");
            b = true ;
        }
        if(temp2 == null){
            System.out.println("User (Id : "+userId2+") Does not Exist !");
            b = true ;
        }
        if(b)
            return ;

        temp1.list.add(userId2);
        temp1.names.add(temp2.name);
        temp2.list.add(userId1);
        temp2.names.add(temp1.name);
        System.out.println("Connection Added !");
    }

    void removeConnection(){
        if(head == null){
            System.out.println("No User Exist !");
            return ;
        }
        System.out.println("Enter First User Id : ");
        int userId1 = sc.nextInt();
        System.out.println("Enter Second User Id : ");
        int userId2 = sc.nextInt();
        User temp1 = head ;
        while(temp1 != null){
            if(temp1.userId == userId1)
                break ;
            temp1 = temp1.next ;
        }
        User temp2 = head ;
        while(temp1 != null){
            if(temp2.userId == userId2)
                break ;
            temp2 = temp2.next ;
        }
        if(temp1 == null || temp2 == null){
            System.out.println("User Does not Exist !");
            return ;
        }
        if(temp1.list.contains(userId2)){
            for(int i=0;i<temp1.list.size();i++){
                if(temp1.list.get(i) == userId2){
                    temp1.list.remove(i);
                    temp1.names.remove(i);
                    break ;
                }
            }
        }
        if(temp2.list.contains(userId1)){
            for(int i=0;i<temp2.list.size();i++){
                if(temp2.list.get(i) == userId1){
                    temp2.list.remove(i);
                    temp2.names.remove(i);
                    break ;
                }
            }
        }
        System.out.println("Connection Removed !");
    }

    void mutualFriends(){
        if(head == null){
            System.out.println("No User Exist !");
            return ;
        }
        System.out.println("Enter First User Id : ");
        int userId1 = sc.nextInt();
        System.out.println("Enter Second User Id : ");
        int userId2 = sc.nextInt();
        User temp1 = head ;
        while(temp1 != null){
            if(temp1.userId == userId1)
                break ;
            temp1 = temp1.next ;
        }
        User temp2 = head ;
        while(temp1 != null){
            if(temp2.userId == userId2)
                break ;
            temp2 = temp2.next ;
        }
        boolean b = false ;
        for(int i=0;i<temp1.list.size();i++){
            if(temp2.list.contains(temp1.list.get(i))){
                System.out.println("Mutual Friend is : "+temp1.names.get(i)+", Id : "+temp1.list.get(i));
                b = true ;
            }
        }
        if(!b){
            System.out.println("No Mutual Friends !");
        }
    }

    void displayAllFriends(){
        if(head == null){
            System.out.println("No User Exist !");
            return ;
        }
        System.out.println("Enter User Id : ");
        int userId = sc.nextInt();
        User temp = head ;
        while(temp != null){
            if(temp.userId == userId)
                break ;
            temp = temp.next ;
        }
        boolean b = false ;
        for(int i=0;i<temp.list.size();i++){
            System.out.println(temp.names.get(i)+", Id : "+temp.list.get(i));
            b = true ;
        }
        if(!b){
            System.out.println("No Friends !");
        }
    }

    void searchUser(){
        if(head == null){
            System.out.println("No User Exist !");
            return ;
        }
        System.out.println("Enter User Id : ");
        int userId = sc.nextInt();
        User temp = head ;
        while(temp != null){
            if(temp.userId == userId)
                break ;
            temp = temp.next ;
        }
        System.out.println("Name : "+temp.name);
        System.out.println("Age : "+temp.age);
        System.out.println("Id : "+temp.userId);
    }

    void DisplayAllUsers(){
        if(head == null){
            System.out.println("No User Exist !");
            return ;
        }
        User temp = head ;
        while(temp != null){
            System.out.println(temp.name);
            System.out.println(temp.age);
            System.out.println(temp.userId);
            System.out.println();
            temp = temp.next ;
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections socialMediaFriendConnections = new SocialMediaFriendConnections();
        while(true){
            System.out.println();
            System.out.println("1. Add User");
            System.out.println("2. Add Connection B/W Two Users");
            System.out.println("3. Remove Connection B/W Two Users");
            System.out.println("4. Mutual Friends B/W Two Users");
            System.out.println("5. Display All Friends of a User");
            System.out.println("6. Search User");
            System.out.println("7. Display All Users");
            System.out.println("8. Exit");
            System.out.println();
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();
            System.out.println();
            sc.nextLine();

            switch (choice) {
                case 1: socialMediaFriendConnections.addUser();
                    break;
                case 2: socialMediaFriendConnections.addConnection();
                    break;
                case 3: socialMediaFriendConnections.removeConnection();
                    break;
                case 4: socialMediaFriendConnections.mutualFriends();
                    break;
                case 5: socialMediaFriendConnections.displayAllFriends();
                    break;
                case 6: socialMediaFriendConnections.searchUser();
                    break;
                case 7: socialMediaFriendConnections.DisplayAllUsers();
                    break;
                case 8: return ;
                default: System.out.println("Invalid Choice !");
                    break;
            }
        }
    }
}
