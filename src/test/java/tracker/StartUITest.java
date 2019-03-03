package tracker;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class StartUITest {
    @Test
    public void whenUpdateThenUpdatedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testname", "testdesc"));
        Input input = new StubInput(new String[] {"2", item.getId(), "replacedtestname","replacedsee", "6"});
        new StartUI(input,tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("replacedtestname"));
    }
    @Test
    public void whenUserAddItemThenTrackerHasThatItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "USA", "LOVE", "6"});
        new StartUI (input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(is("USA")));
    }
    @Test
    public void whenUserDeletesItemThenTrackerDeletesItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("usa", "usa"));
        Input input = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }
    @Test
    public void whenUserFindsItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("usa", "usa"));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker);
        assertThat(tracker.findAll()[0].getName(), is("usa"));
    }
    @Test
    public void whenUserFindsItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("russia", "usa"));
        Input input = new StubInput(new String[] {"5", item.getName(), "6"});
        new StartUI(input, tracker);
        assertThat(tracker.findAll()[0].getName(), is("russia"));
    }
    @Test
    public void whenUserEntersShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("usa", "usa"));
        Input input = new StubInput(new String[] {"1", item.getId(), "6"});
        new StartUI(input, tracker);
        assertThat(tracker.findAll()[0].getName(), is("usa"));
    }
}
