import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }
  @Test
  public void testEmptyQueue() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);
    c = new Compute(mq);

    int result = c.countNumberOfOccurrences("element");
    assertEquals(-1, result);
  }

  @Test
  public void testStringNotInTheQueue() {
    MessageQueue mq = mock(MessageQueue.class);

    when(mq.size()).thenReturn(3);
    when(mq.contains(anyString())).thenReturn(false);

    c = new Compute(mq);

    int result = c.countNumberOfOccurrences("string");

    assertEquals(0, result);
  }

  @Test
  public void testStringInTheQueue() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(3);
    when(mq.contains("string")).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn("string");

    c = new Compute(mq);

    int result = c.countNumberOfOccurrences("string");

    assertEquals(3, result);
  }


  @Test
  public void testStringInTheQueueNotEqualToGivenString() {
    //we are writing this test in order to cover all branches
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(3);
    when(mq.contains("string")).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn("differentstrings");

    c = new Compute(mq);

    int result = c.countNumberOfOccurrences("string");

    assertEquals(0, result);
  }
}