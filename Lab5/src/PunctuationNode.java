/**
 * This class represents a node in a sentence that contains punctuation. This class implements the
 * interface ISentence.
 */
public class PunctuationNode implements ISentence {

  private String punctuation;
  private ISentence restOfSentence;

  /**
   * Construct a WordNode object that is passed the word contained in the node and the remainder of
   * the sentence.
   *
   * @param punctuation the word contained in the actual node
   * @param restOfSentence the remainder of the sentence
   */
  public PunctuationNode(String punctuation, ISentence restOfSentence) {
    this.punctuation = punctuation;
    this.restOfSentence = restOfSentence;
  }

  /**
   * A method from ISentence that returns the total number of words.
   *
   * @param count a count of words starting at 0
   * @return a recursive expression that totals the sentence words (punctuation does not increment)
   */
  @Override
  public int getNumberOfWords(int count) {
    return this.restOfSentence.getNumberOfWords(count);
  }

  /**
   * A method from ISentence that returns the longest word in a sentence.
   *
   * @return the longest word in the sentence (recursion)
   */
  @Override
  public String longestWord() {
    if (this.punctuation.length() > this.restOfSentence.longestWord().length()) {
      return this.punctuation;
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
    return punctuation + restOfSentence.toString();
  }

  /**
   * A method from ISentence to duplicate the object to an identical copy.
   *
   * @return the identical sentence object
   */
  @Override
  public ISentence clone() {
    PunctuationNode newSentence = new PunctuationNode(this.punctuation, restOfSentence.clone());
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
      return new PunctuationNode(punctuation, other);
    } else {
      return new PunctuationNode(punctuation, restOfSentence.merge(other));
    }
  }


}