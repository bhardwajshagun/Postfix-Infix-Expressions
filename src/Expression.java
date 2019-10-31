/**
 * This interface contains all operations that all types of Expressions should support.
 */
public interface Expression {

  /**
   * Evaluates the Expression to a single number.
   *
   * @return the answer of the expression
   * @throws ArithmeticException if expression contains variables
   */
  double evaluate();

  /**
   * Returns the expression as a string.
   *
   * @return the expression as a string
   */
  String toString();

}
