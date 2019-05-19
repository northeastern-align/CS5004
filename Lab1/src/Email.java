/**
 * This class represents an email. An email has a username and a web address.
 */
public class Email {

  private String username;
  private String address;

  /**
   * Construct an Email object that has provided username and address.
   *
   * @param username the username of the email address
   * @param address the domain/web address of the email client
   */

  public Email(String username, String address) {
    this.username = username;
    this.address = address;
  }

  /**
   * Returns the username of the email address.
   *
   * @return the username of the address
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * Returns the address/domain of the email address.
   *
   * @return the domain of the address
   */
  public String getAddress() {
    return this.address;
  }


}
