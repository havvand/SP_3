public class Main {

    public static void main(String[] args) {


        Account one = new Account("Benny", "Benny1");
        Account two = new Account("Holger", "Holger1");
        Account three = new Account("Jens", "Jens1");

        AccountDataBase aOne = new AccountDataBase();

        aOne.addUser(one);
        aOne.addUser(two);
        aOne.addUser(three);
        aOne.userAuthentication(two);



        System.out.println("End Main");

    }
}
