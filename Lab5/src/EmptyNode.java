/**
 * This class represents a node in a sentence that is empty. This class implements the interface
 * ISentence.
 */
public class EmptyNode implements ISentence {

  /**
   * A method from ISentence that returns the total number of words.
   *
   * @param count a count of words starting at 0
   * @return the count, which is 0 for an EmptyNode
   */
  @Override
  public int getNumberOfWords(int count) {
    return count;
  }

  /**
   * A method from ISentence that returns the longest word in a sentence.
   *
   * @return the longest word, which is an empty string for an EmptyNode
   */
  @Override
  public String longestWord() {
    return "";
  }

  /**
   * A method from ISentence to convert the sentence to a string of words.
   *
   * @return the sentence as a string, which is an empty string for an EmptyNode
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * A method from ISentence to duplicate the object to an identical copy.
   *
   * @return the identical copy of the object, which is a new EmptyNode for an EmptyNode
   */
  @Override
  public ISentence clone() {
    return new EmptyNode();
  }

  /**
   * A method from ISentence to merge two sentence objects into a new object.
   *
   * @param other the second sentence to combine
   * @return the other sentence, as this is just an EmptyNode
   */
  @Override
  public ISentence merge(ISentence other) {
    return other;
  }
}