/**
 * This class represents a Likert question that has a question, if it is required, and an answer.
 */

public class Likert implements IQuestion {

  private String question;
  private boolean required;
  private String answer;

  /**
   * Construct a Likert question object that is passed a question (string) and if it is required
   * (boolean).
   *
   * @param question a string representing the question being asked
   * @param required a boolean representing if the question is required or optional
   */
  public Likert(String question, boolean required) {
    this.question = question;
    this.required = required;
  }

  /**
   * Returns the string of the question being asked.
   *
   * @return the string of the question being asked
   */
  public String getQuestionText() {
    return this.question;
  }

  /**
   * Returns the boolean representing if the question is required.
   *
   * @return if the question is required (boolean)
   */
  public boolean getQuestionRequired() {
    return this.required;
  }

  /**
   * Returns the answer of the question.
   *
   * @return the answer of the question
   */
  public String getAnswer() {
    return this.answer;
  }

  /**
   * Checks if the provided answer is allowable under the 5-point Likert scale (i.e. Strongly Agree,
   * , Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree). Throws an exception if a
   * different answer is provided. Does not return a value.
   *
   * @param answer the answer provided by a user
   * @throws IllegalArgumentException if the answer does not follow the Likert scale
   */
  public void answer(String answer) throws IllegalArgumentException {
    if (answer.equals("Strongly Agree")
        || answer.equals("Agree")
        || answer.equals("Neither Agree nor Disagree")
        || answer.equals("Disagree")
        || answer.equals("Strongly Disagree")) {
      this.answer = answer;
    } else {
      throw new IllegalArgumentException("Answer needs to follow the 5-point Likert scale!");
    }
  }
}
