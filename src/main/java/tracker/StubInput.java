package tracker;

public class StubInput implements Input {
    private final String[] value;
    private int position;

    public StubInput(String[] value) {
        this.value = value;
    }
    @Override
    public String ask(String question) {
        return this.value[position++];
    }
}
