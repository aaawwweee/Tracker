package tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerTest {
    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        long time = System.currentTimeMillis();
        Item item = new Item("USA", "LOVE", 1230);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testName", "testDesc", 1230);
        tracker.add(previous);
        Item next = new Item("testName2", "testDesc2", 1231);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("testName2"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("go", "gogo", 12341);
        tracker.add(item);
        boolean result = tracker.delete(item.getId());
        assertThat(result, is(true));
    }
    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("testName1", "testDesc1", 123);
        tracker.add(item);
        Item item1 = new Item("testName2", "testDesc2", 321);
        tracker.add(item1);
        Item[] expected = {item, item1};
        assertThat(tracker.findAll(), is(expected));
    }
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("testName", "testdesc", 123321);
        tracker.add(item);
        Item[] expected = {item};
        assertThat(tracker.findByName("testName"), is(expected));
    }
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("testName", "testdesc", 123321);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
