/**
 * This class represents an essay question that has a question, if it is required, and an answer.
 */

public class Essay implements IQuestion {

  private String question;
  private boolean required;
  private String answer;

  /**
   * Construct an Essay question object that is passed a question (string) and if it is required
   * (boolean).
   *
   * @param question a string representing the question being asked
   * @param required a boolean representing if the question is required or optional
   */
  public Essay(String question, boolean required) {
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
   * Checks if the provided answer is not blank and less than 140 characters, throws an exception if
   * outside this character range. Does not return a value.
   *
   * @param answer the answer provided by a user
   * @throws IllegalArgumentException if the answer is blank or more than 140 characters
   */
  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer.length() > 0 && answer.length() <= 140) {
      this.answer = answer;
    } else {
      throw new IllegalArgumentException("Answer must be between 1 and 140 characters!");
    }

  }

}
