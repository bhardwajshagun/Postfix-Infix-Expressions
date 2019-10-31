import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the InfixExpression class.
 */
public class InfixExpressionTest {

  private InfixExpression test1;
  private InfixExpression test2;
  private InfixExpression test3;
  private InfixExpression test4;
  private InfixExpression test5;
  private InfixExpression test6;
  private InfixExpression test7;
  private InfixExpression test8;
  private InfixExpression test9;

  @Before
  public void setUp() {
    test1 = new InfixExpression("3 / 2 + 7 - 10 + 11 * 5");
    test2 = new InfixExpression("e - g + c / h * q");
    test3 = new InfixExpression("3   +   3   /    2");
    test4 = new InfixExpression("(  5  -  3  )  /  (  7   +   1  )  *  15");
    test5 = new InfixExpression("(    3   +   3       )  /    2");
    test6 = new InfixExpression("3 + 7 / 6 - 4");
    test7 = new InfixExpression("( ( a + b ) * ( ( c + d ) / e ) + f )");
    test8 = new InfixExpression("17   *   (   8   +    a  )   -     10    /     20");
    test9 = new InfixExpression("(   20   - 10   )   /   2   -   5");
  }

  @Test
  public void testToPostfix() {
    assertEquals("3 2 / 7 + 10 - 11 5 * +", test1.toPostfix().toString());
    assertEquals("e g - c h / q * +", test2.toPostfix().toString());
    assertEquals("3 3 2 / +", test3.toPostfix().toString());
    assertEquals("5 3 - 7 1 + / 15 *", test4.toPostfix().toString());
    assertEquals("3 3 + 2 /", test5.toPostfix().toString());
    assertEquals("3 7 6 / + 4 -", test6.toPostfix().toString());
    assertEquals("a b + c d + e / * f +", test7.toPostfix().toString());
    assertEquals("17 8 a + * 10 20 / -", test8.toPostfix().toString());
    assertEquals("20 10 - 2 / 5 -", test9.toPostfix().toString());
  }

  @Test
  public void testEvaluate() {
    assertEquals(53.5, test1.evaluate(), 0.01);
    assertEquals(4.5, test3.evaluate(), 0.01);
    assertEquals(3.75, test4.evaluate(), 0.01);
    assertEquals(3, test5.evaluate(), 0.01);
    assertEquals(0.17, test6.evaluate(), 0.01);
    assertEquals(0, test9.evaluate(), 0.01);
  }

  @Test
  public void testToString() {
    assertEquals("3 / 2 + 7 - 10 + 11 * 5", test1.toString());
    assertEquals("e - g + c / h * q", test2.toString());
    assertEquals("3 + 3 / 2", test3.toString());
    assertEquals("( 5 - 3 ) / ( 7 + 1 ) * 15", test4.toString());
    assertEquals("( 3 + 3 ) / 2", test5.toString());
    assertEquals("( ( a + b ) * ( ( c + d ) / e ) + f )", test7.toString());
    assertEquals("17 * ( 8 + a ) - 10 / 20", test8.toString());
    assertEquals("( 20 - 10 ) / 2 - 5", test9.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor1() {
    InfixExpression testIllegal1 = new InfixExpression("3 7 - 5");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor2() {
    InfixExpression testIllegal1 = new InfixExpression("10 - 7 + 5 / - 3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor3() {
    InfixExpression testIllegal1 = new InfixExpression("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor4() {
    InfixExpression testIllegal1 = new InfixExpression("( 10 - 5 ( / 2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor5() {
    InfixExpression testIllegal1 = new InfixExpression("(12 + 8) ) / 7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor6() {
    InfixExpression testIllegal1 = new InfixExpression("(12 - 8) / 2 )");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor7() {
    InfixExpression testIllegal1 = new InfixExpression("6 - 2 ) / 4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor8() {
    InfixExpression testIllegal1 = new InfixExpression("  ");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor9() {
    InfixExpression testIllegal1 = new InfixExpression(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor10() {
    InfixExpression testIllegal1 = new InfixExpression(") ) 5 + 10 ( (");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor11() {
    InfixExpression testIllegal1 = new InfixExpression("( 20 / 2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor12() {
    InfixExpression testIllegal1 = new InfixExpression("10 15 +");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor13() {
    InfixExpression testIllegal1 = new InfixExpression("14 - / 7");
  }

  @Test(expected = ArithmeticException.class)
  public void testIllegalEvaluate1() {
    assertEquals(10, test2.evaluate(), 0.01);
  }

  @Test(expected = ArithmeticException.class)
  public void testIllegalEvaluate2() {
    assertEquals(20, test7.evaluate(), 0.01);
  }

  @Test(expected = ArithmeticException.class)
  public void testIllegalEvaluate3() {
    assertEquals(1000, test8.evaluate());
  }

}