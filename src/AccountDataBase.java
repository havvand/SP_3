import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AccountDataBase
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Account> userAccounts = new ArrayList<>();
    private String inputUserName;
    private String inputPassWord;

    public AccountDataBase()
    {

    }

    // This method has to register and add new users.
    protected void addUser(Account account)
    {
        userAccounts.add(account);
    }

    protected void userAuthentication(Account account)
    {
        System.out.println("Type username and password for " + account);
        inputUserName = scan.nextLine();
        inputPassWord = scan.nextLine();
        if (!Objects.equals(inputUserName, account.getUsername()) || !Objects.equals(inputPassWord, account.getPassword()))
        {
            userExists(userAccounts,account);
            // SOUT Would you like to create a new user? - INPUT?
            // TODO: 04-11-2022  Make call for login.newUser();
        } else
        System.out.println("Login Success - CALL MAIN-MENU");
    }

    // This method checks if the user exists.
    protected void userExists(ArrayList<Account> userAccounts, Account account)
    {
        for(int i = 0; i < userAccounts.size(); i++)
        {
            //System.out.println("ONE = " + one + "USER = " +  userAccounts.get(i));
            if(account == userAccounts.get(i) && !Objects.equals(inputUserName, account.getUsername()))
            {
                System.out.println("Wrong username - try again: "  + account + " : " + userAccounts.get(i));
                userAuthentication(account);
            } else if (account == userAccounts.get(i) && Objects.equals(inputUserName, account.getUsername())) {
                System.out.println("Wrong password - try again");
                userAuthentication(account);
            }
        }
    }

    public String toString()
    {

        return userAccounts.toString();
    }
}
