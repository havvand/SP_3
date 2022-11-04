import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AccountDataBase
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Account> userAccounts = new ArrayList<>();
    private String inputOne;
    private String inputTwo;

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
        inputOne = scan.nextLine();
        inputTwo = scan.nextLine();
        if (!Objects.equals(inputOne, account.getUserName()) || !Objects.equals(inputTwo, account.getPassWord()))
        {
            // CALL userExist
            System.out.println(account.getUserName());
            System.out.println(userAccounts);
            userExists(userAccounts,account);
            System.out.println("After userEx");

            // SOUT Would you like to create a new user? - INPUT?
            // TODO: 04-11-2022  Make call for login.newUser();
        } else
        System.out.println("CALL MAIN-MENU");
    }

    // This method checks if the user exists.
    protected boolean userExists(ArrayList<Account> userAccounts, Account account)
    {

        for (Account a: userAccounts)
        {
            a = userAccounts.get(1);
            if(Objects.equals(a.getUserName(), account.getUserName()))
            {
                System.out.println("Wrong username");
                userAuthentication(account);
                return true;
            }
            System.out.println("FUCK" + a.getUserName() + account.getUserName());
            return false;
        }
        //if (!Object.equals(account.getPassWord() || !Objects.equals(account.getPassWord()))
        System.out.println("Would you like to create a new user?");
        return false;
    }

    public String toString()
    {

        return userAccounts.toString();
    }
}
