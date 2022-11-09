import java.util.ArrayList;
import java.util.Objects;

public class AccountDataBase
{
    FileIO file = new FileIO();
    ArrayList<Account> userAccounts = new ArrayList<>();
    private String inputUserName;
    private String inputPassWord;
    TextUI textUI = new TextUI();

    String RESET = "\033[0m";
    String GREEN_BOLD = "\033[1;32m";
    String RED_BOLD = "\033[1;31m";


    public AccountDataBase()
    {

    }

    // This method has to register and add new users.
    protected void addUser(Account account)
    {
        userAccounts.add(account);
    }

    protected void userAuthentication(){
        Login login = new Login();
        String inputChoice = textUI.getUserInput("Press 1 for log-in | Press 2 to create new user." + userAccounts);

        if(Objects.equals(inputChoice, "1")){
            inputUserName = textUI.getUserInput("Enter Username");
            inputPassWord = textUI.getUserInput("Enter Password");

            if (file.readUserCredentials(inputUserName,inputPassWord))
            {
                System.out.println("CALL TO MAIN-MENU");
            }
            else if (!file.readUserCredentials(inputUserName, inputPassWord)){
                textUI.displayMessage(GREEN_BOLD + "LOGIN FAILED! \nTRY AGAIN OR MAKE NEW USER." + RESET);
                System.out.println("USER NOT EXIST ");
                userAuthentication();
            }

        } else if (Objects.equals(inputChoice, "2")){
            System.out.println("NEW USER");
            login.newUser();
            }
        }


    public String toString()
    {
        return userAccounts.toString();
    }
}
