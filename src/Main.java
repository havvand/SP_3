public class Main {


    public static void main(String[] args) {
        //MainMenu test = new MainMenu();
        //test.startMenu();

        //Account a1 = new Account("Preben", "123456");
        AccountDataBase aOne = new AccountDataBase();
        Account account = new Account("Jacob", "abc");
        Login login = new Login();
        MainMenu m = new MainMenu();
        //Account a = new Account("Joe", "Joe");

        //aOne.userAuthentication();
        System.out.println("LOL");
       m.watchMedia(account);
        //login.newUser();




        //System.out.println("End Main");
/*
        Account one = new Account("Benny", "Benny1");
        Account two = new Account("Holger", "Holger1");
        Account three = new Account("Jens", "Jens1");

        AccountDataBase aOne = new AccountDataBase();

        aOne.addUser(one);
        aOne.addUser(two);
        aOne.addUser(three);
        aOne.userAuthentication(two);

*/

        System.out.println("End Main");

    }
}
