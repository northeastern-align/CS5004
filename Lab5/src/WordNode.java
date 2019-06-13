/**
 * This class represents a node in a sentence that contains a word. This class implements the
 * interface ISentence.
 */
public class WordNode implements ISentence {

  private String word;
  private ISentence restOfSentence;

  /**
   * Construct a WordNode object that is passed the word contained in the node and the remainder of
   * the sentence.
   *
   * @param word the word contained in the actual node
   * @param restOfSentence the remainder of the sentence
   */
  public WordNode(String word, ISentence restOfSentence) {
    this.word = word;
    this.restOfSentence = restOfSentence;
  }

  /**
   * A method from ISentence that returns the total number of words.
   *
   * @param count a count of words starting at 0
   * @return a recursive expression that totals the word in the sentence by incrementing count
   */
  @Override
  public int getNumberOfWords(int count) {
    return restOfSentence.getNumberOfWords(count + 1);
  }

  /**
   * A method from ISentence that returns the longest word in a sentence.
   *
   * @return the longest word in the sentence (recursion)
   */
  @Override
  public String longestWord() {
    if (this.word.length() > this.restOfSentence.longestWord().length()) {
      return this.word;
    }
    return this.restOfSentence.longestWord();
  }

  /**
   * A method from ISentence to convert the sentence to a string of words.
   *
   * @return the sentence as a string
   */
  @Override
  public String toString() {
    if (restOfSentence instanceof WordNode) {
      return word + " " + restOfSentence.toString();
    } else if (restOfSentence instanceof EmptyNode) {
      return word + "." + restOfSentence.toString();
    } else {
      return word + restOfSentence.toString();
    }
  }

  /**
   * A method from ISentence to duplicate the object to an identical copy.
   *
   * @return the identical sentence object
   */
  @Override
  public ISentence clone() {
    WordNode newSentence = new WordNode(this.word, restOfSentence.clone());
    return newSentence;
  }

  /**
   * A method from ISentence to merge two sentence objects into a new object.
   *
   * @param other the second sentence to combine
   * @return the new sentence object including both sentences
   */
  @Override
  public ISentence merge(ISentence other) {
    if (restOfSentence instanceof EmptyNode) {
      return new WordNode(word, other);
    } else {
      return new WordNode(word, restOfSentence.merge(other));
    }
  }
}