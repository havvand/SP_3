public class Main {


    public static void main(String[] args) {
        MainMenu test = new MainMenu();
        Login login = new Login();
        AccountDataBase aOne = new AccountDataBase();
        //test.startMenu();
        login.login(aOne);
        //login.newUser();


        System.out.println("End Main");

    }
}
