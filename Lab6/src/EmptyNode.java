import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class creates an Empty Node that extends an Abstract Node. Nodes link to form a sentence.
 */

public class EmptyNode implements Sentence {

  /**
   * Method to count the number of words in a sentence. An empty node has a count of 0.
   *
   * @param count a count of words starting at 0
   * @return 0 for an empty node
   */
  @Override
  public int getNumberOfWords(int count) {
    return 0;
  }

  /**
   * A helper function that assists with the counting of words in a sentence.
   *
   * @param acc an integer representing the accrued count of words
   * @return the current total of words in the sentence
   */
  @Override
  public int numberHelper(int acc) {
    return acc;
  }

  /**
   * Method that finds the longest word in a sentence. Should not begin or end with punctuation. The
   * longest word in an empty node is an empty string.
   *
   * @return a string containing the longest word in a sentence, in this case an empty string
   */
  @Override
  public String longestWord() {
    return "";
  }

  /**
   * A helper function that assists with determining the longest word.
   *
   * @param word the longest current word in the sentence
   * @return the longest word in the sentence after comparison
   */
  @Override
  public String longestHelper(String word) {
    return word;
  }

  /**
   * Method to convert the sentence list to a single string. An empty node is converted to an empty
   * string.
   *
   * @return the sentence string, in this case empty
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * A helper function that assists with determining the longest word.
   *
   * @param sentence the longest current word in the sentence
   * @return the longest word in the sentence after comparison
   */
  @Override
  public String stringHelper(String sentence) {
    return sentence;
  }

  /**
   * Method to clone (create a duplicate) a sentence object.
   *
   * @return the clone of the empty node, i.e. an new empty node
   */
  @Override
  public Sentence clone() {
    return new EmptyNode();
  }

  /**
   * Method to combine two sentences, preserving all punctuation. When merging a sentence with an
   * empty node, the sentence is returned.
   *
   * @param other the second sentence to combine
   * @return a clone of the second sentence
   */
  @Override
  public Sentence merge(Sentence other) {
    return other.clone();
  }

  /**
   * Returns the total count of nodes that contain a character.
   *
   * @param node used for assignment for a lambda expression or method reference
   * @param total the total count of nodes that contain the character
   * @return the count of nodes that contain the character
   */
  @Override
  public int count(Predicate<AbstractNode> node, int total) {
    return total;
  }

  /**
   * Maps a string to have a different character structure based on the rules of Pig Latin.
   *
   * @param function the word and rest of the string
   * @return a new word node depending on alterations of Pig Latin
   */
  @Override
  public Sentence map(Function<String, String> function) {
    return new EmptyNode();
  }

}
