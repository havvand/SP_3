import java.util.Objects;

public class AccountDataBase{
    TextUI textUI = new TextUI();
    FileIO file = new FileIO();
    MainMenu menu = new MainMenu();

    String RESET = "\033[0m"; String GREEN_BOLD = "\033[1;32m"; String REDB = "\033[1;31m"; String YELB = "\033[1;33m";

    public AccountDataBase()
    {

    }

    public void userAuthentication(){
        String inputUserName, inputPassWord;
        String inputChoice = textUI.getUserInput("Press 1 for log-in | Press 2 to create new user | Press Q to quit.");

        if(Objects.equals(inputChoice, "1"))
        {
            inputUserName = textUI.getUserInput(YELB + "Enter Username" + RESET);
            inputPassWord = textUI.getUserInput(YELB + "Enter Password" + RESET);

            if (file.readUserCredentials(inputUserName,inputPassWord))
            {
                menu.startMenu();
            } else if (!file.readUserCredentials(inputUserName, inputPassWord))
              {
                textUI.displayMessage(REDB + "LOGIN FAILED! \nTRY AGAIN OR MAKE NEW USER." + RESET);
                userAuthentication();
              }

        } else if (Objects.equals(inputChoice, "2"))
          {
              newUser();
          } else if (inputChoice.equalsIgnoreCase("Q"))
            {
                System.out.println("C ya laterz mofoh!");
            }
        }

    // Handles new user call.
    public void newUser()
    {
        //System.out.println("NEW USER");
        textUI.displayMessage("Insert username and password");
        file.writeUserData();
        userAuthentication();
    }

    public String toString()
    {
        return "";
    }
}
