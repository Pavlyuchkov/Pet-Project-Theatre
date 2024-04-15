package theatre.model;

import jakarta.persistence.*;

@Entity
@Table(name = "saved_filter")
public class SavedFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chat_id")
    private long chatId;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "event_name_id")
    private EventName eventName;

    @Column(name = "title")
    private String title;

    public SavedFilter() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getChatId() {
        return chatId;
    }
    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
    public void setEventName(EventName eventName) {
        this.eventName = eventName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
