/**
 * This class represents a yes or no question that has a question, if it is required, and an
 * answer.
 */

public class YesNo implements IQuestion {

  private String question;
  private boolean required;
  private String answer;

  /**
   * Construct a YesNo question object that is passed a question (string) and if it is required
   * (boolean).
   *
   * @param question a string representing the question being asked
   * @param required a boolean representing if the question is required or optional
   */
  public YesNo(String question, boolean required) {
    this.question = question;
    this.required = required;
  }

  /**
   * Returns the string of the question being asked.
   *
   * @return the string of the question being asked.
   */
  @Override
  public String getQuestionText() {
    return this.question;
  }

  /**
   * Returns the boolean representing if the question is required.
   *
   * @return if the question is required (boolean)
   */
  @Override
  public boolean getQuestionRequired() {
    return this.required;
  }

  /**
   * Checks if the provided answer is strictly Yes or No. Throws exception if anything else is
   * provided. Does not return a value.
   *
   * @param answer the answer provided by a user
   * @throws IllegalArgumentException if the answer is not exactly Yes or No
   */
  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer.equals("Yes") || answer.equals("No")) {
      this.answer = answer;
    } else {
      throw new IllegalArgumentException("Answer must be yes or no!");
    }
  }
}
