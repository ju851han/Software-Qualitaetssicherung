import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StackMapEntryTest {
    private StackMapEntry stackMapEntry; // = System Under Test
    @Before
    public void setUp() {
        stackMapEntry = new StackMapEntry(0,1, new String[]{"a"},new String[]{"c", "d"});
    }

    @After
    public void tearDown() {
       stackMapEntry = null;
    }

    @Test
    public void testLocalsAndStackItemsLengthBiggerThanZero(){
        assertEquals(stackMapEntry.toString(),"(ft=0, off=1, locals={a}, items={c, d})");
    }

    @Test
    public void testLocalsLengthLessOrEqualsThanZero(){
        StackMapEntry s =new StackMapEntry(0,1,new String[]{}, new String[]{"c","d"});
        assertEquals(s.toString(),"(ft=0, off=1, items={c, d})");
    }

    @Test
    public void testStackItemsLengthLessOrEqualsThanZero(){
        StackMapEntry s =new StackMapEntry(0,1,new String[]{"a"}, new String[]{});
        assertEquals(s.toString(),"(ft=0, off=1, locals={a})");
    }
}