import java.util.Scanner;
import java.util.ArrayList;

public class Login {
    TextUI u = new TextUI();
    FileIO f = new FileIO();
    AccountDataBase adb = new AccountDataBase();

    ArrayList<Account> userAccounts = new ArrayList<>();


    public void login(Account account) {
        adb.userAuthentication(account);

    }

    public void newUser() {
        u.displayMessage("Insert username and paswword");
        Scanner scanner = new Scanner(System.in);
        String username = u.getUserInput("Enter username");
        String password = u.getUserInput("Enter password");

        Account account = new Account(username, password);

        userAccounts.add(account);

    }
}