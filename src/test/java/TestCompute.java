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
  public void testElementNotInQueue() {
    MessageQueue mq = mock(MessageQueue.class);

    when(mq.size()).thenReturn(3);
    when(mq.contains(anyString())).thenReturn(false);

    c = new Compute(mq);

    int result = c.countNumberOfOccurrences("element");

    assertEquals(0, result);
  }

  @Test
  public void testCountNumberOfOccurrences_ElementInQueue() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(3);
    when(mq.contains("element")).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn("element"); // Assuming all elements are "element"

    c = new Compute(mq);

    int result = c.countNumberOfOccurrences("element");

    assertEquals(3, result);
  }

  @Test
  public void testElementInQueueButNotEqualToGivenElement() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(3);
    when(mq.contains("element")).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn("differentElement"); // Assuming elements are not all "element"

    c = new Compute(mq);

    int result = c.countNumberOfOccurrences("element");

    assertEquals(0, result);
  }
}