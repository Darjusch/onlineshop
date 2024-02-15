import java.util.NoSuchElementException;
import java.util.Scanner;

public class SignUpMenu {

    boolean signedUp = false;
    String userName;
    String userEmail;
    int age;

    public void signUp() {
        System.out.println("Welcome to the SignUp: ");
        Scanner sc = new Scanner(System.in);
        // name, email, age.
        System.out.println("Please enter your name: ");
        try {
            this.userName = sc.nextLine();
            System.out.println("Please enter your Email: ");
            this.userEmail = sc.nextLine();
            System.out.println("Please enter your age: ");
            this.age = sc.nextInt();
            System.out.println("You are successfully signedUp: " + userName);
            this.signedUp = true;
            return;
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Please enter valid information");
            // e.printStackTrace();
        }
    }
}
