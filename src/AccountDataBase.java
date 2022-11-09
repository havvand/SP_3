import java.util.Objects;

public class AccountDataBase{
    String RESET = "\033[0m";
    String GREEN_BOLD = "\033[1;32m";
    String REDB = "\033[1;31m";
    String YELB = "\033[1;33m";



    public AccountDataBase()
    {

    }

    // This method has to register and add new users.
    public void addUser(Account account)
    {
        //userAccounts.add(account);
    }

    public void userAuthentication(){
        FileIO file = new FileIO();
        TextUI textUI = new TextUI();
        Login login = new Login();
        String inputUserName, inputPassWord;
        String inputChoice = textUI.getUserInput(YELB + "Press 1 for log-in | Press 2 to create new user." + RESET);

        if(Objects.equals(inputChoice, "1")){
            inputUserName = textUI.getUserInput(YELB + "Enter Username" + RESET);
            inputPassWord = textUI.getUserInput(YELB + "Enter Password" + RESET);

            if (file.readUserCredentials(inputUserName,inputPassWord))
            {
                System.out.println("CALL TO MAIN-MENU");
            }
            else if (!file.readUserCredentials(inputUserName, inputPassWord)){
                textUI.displayMessage(REDB + "LOGIN FAILED! \nTRY AGAIN OR MAKE NEW USER." + RESET);
                userAuthentication();
            }

        } else if (Objects.equals(inputChoice, "2")){
            System.out.println("NEW USER");
            login.newUser();
            }
        }


    public String toString()
    {
        return "";
    }
}
