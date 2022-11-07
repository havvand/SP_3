public class Login {
    public class Login {


        public void login(Account account){
            userAuthentication(account);

        }

        public void newUser(String username, String password){
            Account account = new Account(username, password);
            userAcounts.add(account);

        }
    }

}
