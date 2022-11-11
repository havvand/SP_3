import java.util.Objects;

public class AccountDataBase{
    TextUI textUI = new TextUI();
    FileIO file = new FileIO();
    MainMenu menu = new MainMenu();
    MediaData md = new MediaData();

    String R = "\033[0m"; String GB = "\033[1;32m"; String RB = "\033[1;31m"; String YB = "\033[1;33m";

    public AccountDataBase()
    {

    }

    public void userAuthentication(){
        String inputUserName, inputPassWord;
        String inputChoice = textUI.getUserInput(GB+"Press 1 for log-in "+R+"|"+YB+" Press 2 to create new user "+R+"|"+RB+" Press Q to quit."+R);

        if(Objects.equals(inputChoice, "1"))
        {
            inputUserName = textUI.getUserInput(YB + "Enter Username" + R);
            inputPassWord = textUI.getUserInput(YB + "Enter Password" + R);

            if (file.readUserCredentials(inputUserName,inputPassWord))
            {
                md.initateSeriesList();
                md.initiateMovieList();
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
        textUI.displayMessage("Insert username and password");
        file.writeUserData();
        userAuthentication();
    }

}
