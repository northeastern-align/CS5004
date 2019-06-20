import java.util.function.Function;

/**
 * This class creates a Punctuation Node that extends an Abstract Node. Nodes link to form a
 * sentence, with Punctuation Nodes containing punctuation.
 */
public class PunctuationNode extends AbstractNode {

  /**
   * Constructs a new Punctuation Node
   *
   * @param string the punctuation contained in the node
   * @param remaining the rest of the sentence
   * @throws IllegalArgumentException thrown if provided string is null
   */
  public PunctuationNode(String string, Sentence remaining) throws IllegalArgumentException {
    super(string, remaining);
  }

  /**
   * Method that finds the longest word in a sentence. Should not begin or end with punctuation.
   *
   * @return a string containing the longest word in a sentence
   */
  @Override
  public int numberHelper(int count) {
    return this.remaining.numberHelper(count);
  }

  /**
   * Maps a string to have a different character structure based on the rules of Pig Latin.
   *
   * @param function the word or punctuation and rest of the string
   * @return a new punctuation node that is not modified by function.
   */
  @Override
  public Sentence map(Function<String, String> function) {
    return new PunctuationNode(this.string, remaining.map(function));
  }


}
