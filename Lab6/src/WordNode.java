/**
 * This class creates a Word Node that extends an Abstract Node. Word nodes link to form a
 * sentence.
 */

public class WordNode extends AbstractNode {

  /**
   * Constructs a new Word Node
   *
   * @param string the string contained in the node
   * @param remaining the rest of the sentence
   * @throws IllegalArgumentException thrown if provided string is null
   */
  public WordNode(String string, Sentence remaining) throws IllegalArgumentException {
    super(string, remaining);
  }
}
