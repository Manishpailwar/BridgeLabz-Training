import java.util.*;
public class CreateContact {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("== Contact Organiser ==");
        System.out.println("Currently No Contact is saved !");
        System.out.print("Enter No. of Contacts to be Saved : ");
        int contacts = sc.nextInt();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Long> numbers = new ArrayList<>();
        for(int i=0;i<contacts;i++){
            try{
                System.out.print("Enter Name : ");
                String name = sc.next();
                names.add(name);
                System.out.print("Enter Phone Number : ");
                long num = sc.nextLong();
                if(num < 1000000000L || num > 9999999999L)
                    throw new Exception("Phone Number must be 10 digits !");
                if(numbers.contains(num))
                    throw new Exception("Phone Number Already Exists !");
                numbers.add(num);
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Phone Number !");
                names.remove(i);
                i--;
                sc.next();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                names.remove(i);
                i--;
            }
        }
        for(int i=0;i<contacts;i++){
            System.out.println(names.get(i)+" : "+numbers.get(i));
        }
        sc.close();
    }
}
