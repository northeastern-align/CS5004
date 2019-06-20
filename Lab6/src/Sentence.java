import java.util.function.Function;
import java.util.function.Predicate;

/**
 * An interface of operations that can be executed by a sentence - a list of words.
 */
public interface Sentence {

  /**
   * Method to count the number of words in a sentence. Punctuation is not added to count.
   *
   * @param count a count of words starting at 0
   * @return the number of words in a sentence
   */
  int getNumberOfWords(int count);

  /**
   * A helper function that assists with the counting of words in a sentence.
   *
   * @param acc an integer representing the accrued count of words
   * @return the current total of words in the sentence
   */
  int numberHelper(int acc);

  /**
   * Method that finds the longest word in a sentence. Should not begin or end with punctuation.
   *
   * @return a string containing the longest word in a sentence
   */
  String longestWord();

  /**
   * A helper function that assists with determining the longest word.
   *
   * @param word the longest current word in the sentence
   * @return the longest word in the sentence after comparison
   */
  String longestHelper(String word);

  /**
   * Method to convert the sentence list to a single string.
   *
   * @return the sentence string
   */
  String toString();

  /**
   * A helper function that assists with determining the longest word.
   *
   * @param sentence the longest current word in the sentence
   * @return the longest word in the sentence after comparison
   */
  String stringHelper(String sentence);

  /**
   * Method to clone (create a duplicate) a sentence object.
   *
   * @return the clone of the sentence
   */
  Sentence clone();

  /**
   * Method to combine two sentences, preserving all punctuation.
   *
   * @param other the second sentence to combine
   * @return a new sentence object that is a combination of the two sentences
   */
  Sentence merge(Sentence other);

  /**
   * Returns the total count of nodes that contain a character.
   *
   * @param node used for assignment for a lambda expression or method reference
   * @param total the total count of nodes that contain the character
   * @return the count of nodes that contain the character
   */
  int count(Predicate<AbstractNode> node, int total);

  /**
   * Maps a string to have a different character structure based on the rules of Pig Latin.
   *
   * @param function the word and rest of the string
   * @return a new word node depending on alterations of Pig Latin
   */
  Sentence map(Function<String, String> function);

}