public class UserDataBase
{
    private String userName;
    private String passWord;

    public UserDataBase(String userName, String passWord)
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
