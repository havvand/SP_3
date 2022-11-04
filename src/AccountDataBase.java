import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AccountDataBase
{
    private String userName;
    private String passWord;
    ArrayList<Account> userAccounts = new ArrayList<>();

    public AccountDataBase()
    {

    }

    void addUser(Account account)
    {
        userAccounts.add(account);
    }

    void userAuthentication(Account account)
    {

        Scanner scan = new Scanner(System.in);
        System.out.println("Type username and password for " + account);
        String inputOne = scan.nextLine();
        String inputTwo = scan.nextLine();

        if (!Objects.equals(inputOne, account.getUserName()) || !Objects.equals(inputTwo, account.getPassWord()))
        {
            System.out.println("Wrong username or password");
            userAuthentication(account);
        } else
        System.out.println("Logging in.");
    }

    public String toString()
    {

        return userAccounts.toString();
    }
}
