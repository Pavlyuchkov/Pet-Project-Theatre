package theatre.dto;

public class SavedFilterDTO {

    private long id;
    private long chatId;
    private long eventId;
    private long eventNameId;
    private String title;

    public SavedFilterDTO() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getchatId() {
        return chatId;
    }
    public long getEventNameId() {
        return eventNameId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
