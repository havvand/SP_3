public class Account
{
    private String userName;
    private String passWord;

    public Account(String userName, String passWord)
    {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getPassWord()
    {
        return this.passWord;
    }
}
