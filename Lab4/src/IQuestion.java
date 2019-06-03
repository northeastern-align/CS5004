/**
 * An interface for the questionnaire including the question text, required/optional, and an
 * answer.
 */

public interface IQuestion {

  public String getQuestionText();

  public boolean getQuestionRequired();

  void answer(String answer);
}
