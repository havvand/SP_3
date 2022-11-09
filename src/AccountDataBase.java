import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AccountDataBase
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Account> userAccounts = new ArrayList<>();
    private String inputUserName;
    private String inputPassWord;
    TextUI textUI = new TextUI();


    public AccountDataBase()
    {

    }

    // This method has to register and add new users.
    protected void addUser(Account account)
    {
        userAccounts.add(account);
    }

    protected void userAuthentication(Account account){
            Login login = new Login();

        String inputChoice = textUI.getUserInput("Press 1 for log-in | Press 2 to create new user.");

        if(Objects.equals(inputChoice, "1")){
            System.out.println("INPUT 1");
            inputUserName = textUI.getUserInput("Enter Username");
            inputPassWord = textUI.getUserInput("Enter Password");

            if (!Objects.equals(inputUserName, account.getUsername()) || !Objects.equals(inputPassWord, account.getPassword()))
            {
                userExists(userAccounts,account);
            } else
                textUI.getUserInput("LOGIN SUCCESS!");
            MainMenu m = new MainMenu();
              m.startMenu();
        } else if (Objects.equals(inputChoice, "2")){
            System.out.println("NEW USER");
            login.newUser();
        }
        System.out.println("ERROR");
        }



    // This method checks if the user exists.
    protected void userExists(ArrayList<Account> userAccounts, Account account)
    {
        for(int i = 0; i < userAccounts.size(); i++)
        {
            //System.out.println("ONE = " + one + "USER = " +  userAccounts.get(i));
            if(account == userAccounts.get(i) && !Objects.equals(inputUserName, account.getUsername())) {
                textUI.displayMessage("Wrong username - try again! ");
                userAuthentication(account);
            } else if (account == userAccounts.get(i) && Objects.equals(inputUserName, account.getUsername())) {
                textUI.displayMessage("Wrong password - try again! ");
                userAuthentication(account);
            }
        }
    }

    public String toString()
    {

        return userAccounts.toString();
    }
}
