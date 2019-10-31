import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the PostfixExpression class.
 */
public class PostfixExpressionTest {

  private PostfixExpression test1;
  private PostfixExpression test2;
  private PostfixExpression test3;
  private PostfixExpression test4;
  private PostfixExpression test5;
  private PostfixExpression test6;
  private PostfixExpression test7;
  private PostfixExpression test8;
  private PostfixExpression test9;


  @Before
  public void setUp() {
    test1 = new PostfixExpression("1 5 + 3 4 + *");
    test2 = new PostfixExpression("1 5 + 3 4 + * 3 /");
    test3 = new PostfixExpression("1     5 +  3 4 +     *");
    test4 = new PostfixExpression("1  5   + 3   4  +   *  3  /");
    test5 = new PostfixExpression("3 7 6 / + 4 -");
    test6 = new PostfixExpression("a b -");
    test7 = new PostfixExpression("1 b +");
    test8 = new PostfixExpression("a 5 *");
    test9 = new PostfixExpression("25   4    *    100     -");
  }

  @Test
  public void testEvaluate() {
    assertEquals(42, test1.evaluate(), 0.01);
    assertEquals(14, test2.evaluate(), 0.01);
    assertEquals(42, test3.evaluate(), 0.01);
    assertEquals(14, test4.evaluate(), 0.01);
    assertEquals(0.17, test5.evaluate(), 0.01);
    assertEquals(0, test9.evaluate(), 0.01);
  }

  @Test
  public void testToString() {
    assertEquals("1 5 + 3 4 + *", test1.toString());
    assertEquals("1 5 + 3 4 + * 3 /", test2.toString());
    assertEquals("1 5 + 3 4 + *", test3.toString());
    assertEquals("1 5 + 3 4 + * 3 /", test4.toString());
    assertEquals("3 7 6 / + 4 -", test5.toString());
    assertEquals("a b -", test6.toString());
    assertEquals("1 b +", test7.toString());
    assertEquals("a 5 *", test8.toString());
    assertEquals("25 4 * 100 -", test9.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor1() {
    PostfixExpression testIllegal1 = new PostfixExpression("b 5 + 3 + * e /");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor2() {
    PostfixExpression testIllegal1 = new PostfixExpression("1 + 3 4 + *");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor3() {
    PostfixExpression testIllegal1 = new PostfixExpression("* 3 4 +");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor4() {
    PostfixExpression testIllegal1 = new PostfixExpression("+ 6");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor5() {
    PostfixExpression testIllegal1 = new PostfixExpression("5 6");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor6() {
    PostfixExpression testIllegal1 = new PostfixExpression("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor7() {
    PostfixExpression testIllegal1 = new PostfixExpression("  ");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor8() {
    PostfixExpression testIllegal1 = new PostfixExpression(" 3 ");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor9() {
    PostfixExpression testIllegal1 = new PostfixExpression(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor10() {
    PostfixExpression testIllegal1 = new PostfixExpression("5 + 7 / 2");
  }

  @Test(expected = ArithmeticException.class)
  public void testIllegalEvaluate1() {
    assertEquals(10, test6.evaluate(), 0.01);
  }

  @Test(expected = ArithmeticException.class)
  public void testIllegalEvaluate2() {
    assertEquals(30, test7.evaluate(), 0.01);
  }

  @Test(expected = ArithmeticException.class)
  public void testIllegalEvaluate3() {
    assertEquals(100, test8.evaluate(), 0.01);
  }

}
