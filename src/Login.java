import java.util.Scanner;
import java.util.ArrayList;
public class Login {
    textUI u = new textUI();
    FileIO f = new FileIO();
    AccountDataBase adb = new AccountDataBase();

    ArrayList<Account> userAccounts = new ArrayList<>();



    public void login(Account account){
        adb.userAuthentication(account);

    }

    public void newUser(String username, String password){
        u.displayMessage("Insert username and paswword");
        Scanner scanner = new Scanner(System.in);
        username = u.getUserInput ("Enter username");
        password = u.getUserInput ("Enter password");

        Account account = new Account(username, password);

        userAccounts.add(account);

    }
}