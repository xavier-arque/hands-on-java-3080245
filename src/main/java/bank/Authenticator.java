package bank;

import java.io.IOError;
import java.io.IOException;

import javax.security.auth.login.LoginException;

public class Authenticator {

  public static Customer login(String username, String password) throws LoginException {

    Customer customer = DataSource.getCustomer(username);

    if (customer == null) {
      throw new LoginException("sorry something happened. User name not found");
    }
    if (customer.getPassword().equals(password)) {
      customer.setAuthenticated(true);
      return customer;
    } else {
      throw new LoginException("the password is not correct");
    }
  }

  public static void logout(Customer customer) {
    customer.setAuthenticated(false);
  }
}
