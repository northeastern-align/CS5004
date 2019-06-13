/**
 * An interface of operations that can be executed by a sentence.
 */
public interface ISentence {

  /**
   * Method to count the number of words in a sentence.
   *
   * @param count a count of words starting at 0
   * @return the number of words in a sentence.
   */
  int getNumberOfWords(int count);

  /**
   * Method that finds the longest word in a sentence. Should not begin or end with punctuation.
   *
   * @return a string containing the longest word in a sentence
   */
  String longestWord();

  /**
   * Method to convert the sentence list to a single string.
   *
   * @return the sentence string
   */
  String toString();

  /**
   * Method to clone (create a duplicate) a sentence object.
   *
   * @return the clone of the sentence
   */
  ISentence clone();

  /**
   * Method to combine two sentences, preserving all punctuation.
   *
   * @param other the second sentence to combine
   * @return a new sentence object that is a combination of the two sentences
   */
  ISentence merge(ISentence other);
}