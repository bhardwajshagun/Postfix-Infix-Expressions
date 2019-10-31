/**
 * The abstract class that for Expression that holds code that all Expressions share.
 */
public abstract class AbstractExpression implements Expression {

  /**
   * The expression stored as a string.
   */
  protected String expression;

  /**
   * Constructs an Expression using a string input.
   *
   * @param input the string input of the expression
   * @throws IllegalArgumentException if expression is not valid
   */
  public AbstractExpression(String input) throws IllegalArgumentException {
    if (input == null) {
      throw new IllegalArgumentException("Expression is invalid.");
    }
    if (input.equals("")) {
      throw new IllegalArgumentException("Expression is invalid.");
    }
    if (input.charAt(0) == ' ' || input.charAt(input.length() - 1) == ' ') {
      throw new IllegalArgumentException("Expression is invalid.");
    }
    expression = input.trim().replaceAll(" +", " ");
  }

  /**
   * Returns the expression as a string.
   *
   * @return the expression as a string
   */
  @Override
  public String toString() {
    return expression;
  }

}
