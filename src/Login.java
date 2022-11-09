import java.util.Scanner;
import java.util.ArrayList;

public class Login {
    TextUI u = new TextUI();
    FileIO f = new FileIO();
    //AccountDataBase adb = new AccountDataBase();

    ArrayList<Account> userAccounts = new ArrayList<>();


    public void login(AccountDataBase adb) {

        adb.userAuthentication();


    }

    public void newUser() {
        u.displayMessage("Insert username and password");
        Scanner scanner = new Scanner(System.in);

        f.writeUserData(userAccounts);

    }
}