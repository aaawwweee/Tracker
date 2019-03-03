package tracker;

import java.util.*;


public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                item.setId(id);
                this.items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                result = true;
                break;
            }
            index++;
        }
        return result;
}
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];

        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int x = 0;
        for (int index = 0; index != position; index++) {
            if (this.items[index] != null && this.items[index].getName().equals(key)) {
                result[x] = this.items[index];
                x++;
            }
        }
        return Arrays.copyOf(result, x);
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
