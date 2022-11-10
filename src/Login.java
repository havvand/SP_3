import java.util.ArrayList;

public class Login {
    TextUI u = new TextUI();
    FileIO f = new FileIO();
    //AccountDataBase adb = new AccountDataBase();

    ArrayList<Account> userAccounts = new ArrayList<>();


    public void login(AccountDataBase adb) {

        //String inputChoice = u.getUserInput("Press 1 for log-in | Press 2 to create new user.");
        //adb.userAuthentication(inputChoice);

    }

    public void newUser() {
        u.displayMessage("Insert username and password");
        //Scanner scanner = new Scanner(System.in);
        f.writeUserData();

    }
}