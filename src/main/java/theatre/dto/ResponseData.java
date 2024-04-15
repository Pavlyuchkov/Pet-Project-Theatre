package theatre.dto;
import java.util.List;


public class ResponseData {

    private List<EventDTO> event;

    public List<EventDTO> getEvent() {
        return event;
    }
    public void setEvent(List<EventDTO> event) {
        this.event = event;
    }
}
