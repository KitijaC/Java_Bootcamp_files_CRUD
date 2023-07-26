import java.util.UUID;

public class SampleContent {
    private UUID id;
    private String description;

    public SampleContent(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public SampleContent(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        // if we use csv, then each value in item is separated by a comma, last field does not need comma
        return  id + "," + description + "\n";
    }
}
