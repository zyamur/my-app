import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }
  @Test
  public void testOneArgument() {
    assertFalse(c.compute(4));
  }

  @Test
  public void testEvenNumberArguments() {
    assertFalse(c.compute(0,2,4,6));
  }

  @Test
  public void testArgumentIsZero() {
    try {
      c.compute(1, 0, 2);
      fail("Expected a RuntimeException to be thrown");
    } catch (RuntimeException e) {
      // Test passes if RuntimeException is caught here
    }
  }

  @Test
  public void testSumDivisibleByArgument() {
    assertTrue(c.compute(1, 2, 3, 4, 5, 6, 7));
  }

  @Test
  public void testNoConditionSatisfied() {
    boolean result = c.compute(2,4,7);
    assertFalse(result);
  }

}