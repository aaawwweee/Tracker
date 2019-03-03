package tracker;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class StartUITest {
    @Test
    public void whenUpdateThenUpdatedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testname", "testdesc"));
        Input input = new StubInput(new String[] {"2", item.getId(), "replacedtestname"});
        new StartUI(input,tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("replacedtestname"));
    }
}
