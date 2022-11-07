import java.util.ArrayList;

public class Account
{
    private String username;
    private String password;
    protected ArrayList<String> watchedMedia = new ArrayList<>();
    protected ArrayList<String> favoriteMedia = new ArrayList<>();

    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String toString()
    {
        return username;
    }
}
