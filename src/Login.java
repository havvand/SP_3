import java.util.Scanner;
public class Login {
    public class Login {


        public void login(Account account){
            userAuthentication(account);

        }

        public void newUser(String username, String password){
            Scanner scanner = new Scanner();
            username = scanner.nextLine();
            password = scanner.nextLine();

            Account account = new Account(username, password);
            userAcounts.add(account);

        }
    }

}
