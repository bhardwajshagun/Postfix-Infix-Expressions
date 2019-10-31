import java.util.EmptyStackException;
import java.util.Stack;

/**
 * The PostFixExpression class that holds methods for a PostfixExpression. It can evaluate the
 * Expresion or return it as a string.
 */
public class PostfixExpression extends AbstractExpression {

  /**
   * Constructs a PostfixExpression using a string input.
   *
   * @param input the string input of the expression
   * @throws IllegalArgumentException if expression is not valid
   */
  public PostfixExpression(String input) throws IllegalArgumentException {
    super(input);
    String num2;
    String num1;
    Stack<String> test_stack = new Stack();
    String equation = expression;
    String[] terms = equation.split(" ");
    try {
      for (String s : terms) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
          try {
            num2 = test_stack.pop();
            try {
              num1 = test_stack.pop();
              if (s.equals("+")) {
                test_stack.push(String.valueOf(Double.parseDouble(num1)
                        + Double.parseDouble(num2)));
              } else if (s.equals("-")) {
                test_stack.push(String.valueOf(Double.parseDouble(num1)
                        - Double.parseDouble(num2)));
              } else if (s.equals("*")) {
                test_stack.push(String.valueOf(Double.parseDouble(num1)
                        * Double.parseDouble(num2)));
              } else if (s.equals("/")) {
                test_stack.push(String.valueOf(Double.parseDouble(num1)
                        / Double.parseDouble(num2)));
              }
            } catch (NumberFormatException b) {
              test_stack.push("temp");
            }
          } catch (NumberFormatException a) {
            test_stack.pop();
            test_stack.push("temp");
          }
        } else {
          test_stack.push(s);
        }
      }
    } catch (EmptyStackException e) {
      throw new IllegalArgumentException("Expression is invalid.");
    }
    try {
      test_stack.pop();
    } catch (EmptyStackException e) {
      throw new IllegalArgumentException("Expression is invalid.");
    }
    if (!test_stack.empty()) {
      throw new IllegalArgumentException("Expression is invalid.");
    }
  }

  /**
   * Evaluates the PostFixExpression to a single number.
   *
   * @return the answer of the expression
   * @throws ArithmeticException if expression contains variables
   */
  @Override
  public double evaluate() throws ArithmeticException {
    String num2;
    String num1;
    Stack<String> test_stack = new Stack();
    String equation = expression;
    String[] terms = equation.split(" ");
    for (String s : terms) {
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
        try {
          num2 = test_stack.pop();
          num1 = test_stack.pop();
          if (s.equals("+")) {
            test_stack.push(String.valueOf(Double.parseDouble(num1) + Double.parseDouble(num2)));
          } else if (s.equals("-")) {
            test_stack.push(String.valueOf(Double.parseDouble(num1) - Double.parseDouble(num2)));
          } else if (s.equals("*")) {
            test_stack.push(String.valueOf(Double.parseDouble(num1) * Double.parseDouble(num2)));
          } else if (s.equals("/")) {
            test_stack.push(String.valueOf(Double.parseDouble(num1) / Double.parseDouble(num2)));
          }
        } catch (NumberFormatException a) {
          throw new ArithmeticException("Cannot evaluate expression with variable.");
        }
      } else {
        test_stack.push(s);
      }
    }
    return Double.parseDouble(test_stack.pop());
  }

}
