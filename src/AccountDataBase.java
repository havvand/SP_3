import java.util.ArrayList;
import java.util.Objects;

public class AccountDataBase
{
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

        String inputChoice = textUI.getUserInput("Press 1 for log-in | Press 2 to create new user.");

        if(inputChoice.equals("1")){
            inputUserName = textUI.getUserInput("Enter Username");
            inputPassWord = textUI.getUserInput("Enter Password");

            if (userExists(userAccounts, inputUserName, inputPassWord)){
                System.out.println("CALL TO MAIN-MENU");
            }
            else if (!userExists(userAccounts, inputUserName, inputPassWord)){
                textUI.displayMessage(GREEN_BOLD + "LOGIN FAILED! \nTRY AGAIN OR MAKE NEW USER." + RESET);
                System.out.println(userAccounts);
                userAuthentication();
            }

        } else if (Objects.equals(inputChoice, "2")){
            System.out.println("NEW USER");
            login.newUser();
            }
        }



    // This method checks if the user exists.
    protected boolean userExists(ArrayList<Account> userAccounts, String username, String password)
    {
        boolean doExist = false;
        //System.out.println("ARGHHHHHH");
        for(int i = 0; i < userAccounts.size(); i++)
        {
            if (Objects.equals(username, userAccounts.get(i).getUsername()) && Objects.equals(password, userAccounts.get(i).getPassword())) {
                textUI.displayMessage(GREEN_BOLD + "LOGIN WORKED! \n" + userAccounts.get(i).getUsername() + " is logged in." +  RESET);
                return true;
            } /*else if (!Objects.equals(username, userAccounts.get(i).getUsername()) || !Objects.equals(password, userAccounts.get(i).getPassword())) {
                System.out.println("LOGIN DIDNT WORK " + i +userAccounts.get(i).getUsername());
                doExist = false;
            } */
        }
        return doExist;
    }

    public String toString()
    {

        return userAccounts.toString();
    }
}
