import java.util.EmptyStackException;
import java.util.Stack;

/**
 * The InfixExpression class that holds methods for a InfixExpression. It can evaluate the Expresion
 * or return it as a string.
 */
public class InfixExpression extends AbstractExpression {

  /**
   * Constructs an InfixExpression using a string input.
   *
   * @param input the string input of the expression
   * @throws IllegalArgumentException if expression is not valid
   */
  public InfixExpression(String input) {
    super(input);
    this.toPostfix();
  }

  /**
   * Converts an InfixExpression to a Postfix Expression.
   *
   * @return PostfixExpression object containing expression in postfix form
   * @throws IllegalArgumentException if expression is not valid
   */
  public PostfixExpression toPostfix() {
    String postfixInput = "";
    String infixInput = expression;
    String[] terms = infixInput.split(" ");
    int leftParanCounter = 0;
    int rightParanCounter = 0;
    int counter = -1;
    Stack<String> temp_stack = new Stack();
    for (String s : terms) {
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
        if (counter == 0) {
          throw new IllegalArgumentException("Expression is invalid.");
        }
        counter = 0;
        while (!temp_stack.empty()
                && operatorPrecedence(s) <= operatorPrecedence(temp_stack.peek())) {
          postfixInput += " " + temp_stack.pop();
        }
        temp_stack.push(s);
      } else if (s.equals("(")) {
        leftParanCounter++;
        temp_stack.push(s);
      } else if (s.equals(")")) {
        rightParanCounter++;
        while (!temp_stack.empty() && !temp_stack.peek().equals("(")) {
          postfixInput += " " + temp_stack.pop();
        }
        try {
          temp_stack.pop();
        } catch (EmptyStackException a) {
          throw new IllegalArgumentException("Expression is invalid.");
        }
      } else {
        if (counter == 1) {
          throw new IllegalArgumentException("Expression is invalid.");
        }
        counter = 1;
        postfixInput += " " + s;
      }
    }
    while (!temp_stack.empty()) {
      postfixInput += " " + temp_stack.pop();
    }
    if (leftParanCounter != rightParanCounter) {
      throw new IllegalArgumentException("Expression is invalid.");
    }
    postfixInput = postfixInput.trim().replaceAll(" +", " ");
    return new PostfixExpression(postfixInput);
  }

  /**
   * Evaluates the InfixExpression to a single number.
   *
   * @return the answer of the expression
   * @throws ArithmeticException if expression contains variables
   */
  @Override
  public double evaluate() {
    return this.toPostfix().evaluate();
  }

  /**
   * Determines which operator has precedence.
   *
   * @param operator the operator to determine the precedence of
   * @return a number representing the precedence of this operator
   */
  private int operatorPrecedence(String operator) {
    if (operator.equals("*") || operator.equals("/")) {
      return 2;
    } else if (operator.equals("+") || operator.equals("-")) {
      return 1;
    } else {
      return 0;
    }
  }

}
