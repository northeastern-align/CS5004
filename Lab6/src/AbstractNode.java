import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class creates an AbstractNode that implements the Sentence interface.
 */
public class AbstractNode implements Sentence {

  protected String string;
  protected Sentence remaining;

  /**
   * Constructs a new Abstract Node
   *
   * @param string the string contained in the node
   * @param remaining the rest of the sentence
   * @throws IllegalArgumentException thrown if provided string is null
   */
  public AbstractNode(String string, Sentence remaining) throws IllegalArgumentException {
    if (string.equals(null)) {
      throw new IllegalArgumentException("A string must be provided!");
    }
    this.string = string;
    this.remaining = remaining;
  }

  /**
   * Returns the number of words in the provided sentence.
   *
   * @param count a count of words starting at 0
   * @return the number of words in a sentence
   */
  @Override
  public int getNumberOfWords(int count) {
    return numberHelper(0);
  }

  /**
   * A helper function that assists with the counting of words in a sentence.
   *
   * @param acc an integer representing the accrued count of words
   * @return the current total of words in the sentence
   */
  @Override
  public int numberHelper(int acc) {
    if (this.getClass().getName().equals("WordNode")) {
      return this.remaining.numberHelper(1 + acc);
    }
    return this.remaining.numberHelper(acc);
  }

  /**
   * Method that finds the longest word in a sentence. Should not begin or end with punctuation.
   *
   * @return a string containing the longest word in a sentence
   */
  @Override
  public String longestWord() {
    if (this.getClass().getName().equals("WordNode")) {
      return longestHelper(this.string);
    }
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
    if (this.string.length() > word.length()) {
      return this.remaining.longestHelper(this.string);
    } else {
      return this.remaining.longestHelper(word);
    }
  }

  /**
   * Method to convert the sentence list to a single string.
   *
   * @return the sentence string
   */
  @Override
  public String toString() {

    if (this.string.equals("") && this.remaining.equals("")) {
      return "";
    }

    return stringHelper("");
  }

  /**
   * A helper function that assists with converting a sentence to a string.
   *
   * @param sentence the string portion of the sentence so far
   * @return the updated sentence string
   */
  @Override
  public String stringHelper(String sentence) {
    String output = sentence;

    if (sentence.equals("")) {
      return this.remaining.stringHelper(this.string);
    }

    if (this.getClass().getName().equals("PunctuationNode")) {
      output = new StringBuilder(output).append(this.string).toString();

    } else if (this.getClass().getName().equals("WordNode")) {
      if (this.remaining.getClass().getName().equals("EmptyNode")) {
        output = new StringBuilder(output).append(" ").append(this.string).append(".").toString();
      } else {
        output = new StringBuilder(output).append(" ").append(this.string).toString();
      }
    }
    return this.remaining.stringHelper(output);

  }

  /**
   * Method to clone (create a duplicate) a sentence object.
   *
   * @return the clone of the sentence
   */
  @Override
  public Sentence clone() {
    if (this.getClass().getName().equals("WordNode")) {
      WordNode newSentence = new WordNode(this.string, remaining.clone());
      return newSentence;
    } else {
      return new PunctuationNode(this.string, remaining.clone());
    }

  }

  /**
   * Method to combine two sentences, preserving all punctuation.
   *
   * @param other the second sentence to combine
   * @return a new sentence object that is a combination of the two sentences
   */
  @Override
  public Sentence merge(Sentence other) {
    if (this.getClass().getName().equals("WordNode")) {
      return new WordNode(this.string, remaining.merge(other));
    } else {
      return new PunctuationNode(this.string, remaining.merge(other));
    }
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
    if (node.test(this)) {
      return remaining.count(node, 1 + total);
    } else {
      return remaining.count(node, total);
    }
  }

  /**
   * Maps a string to have a different character structure based on the rules of Pig Latin.
   *
   * @param function the word and rest of the string
   * @return a new word node depending on alterations of Pig Latin
   */
  @Override
  public Sentence map(Function<String, String> function) {
    return new WordNode(function.apply(this.string), remaining.map(function));
  }

}

