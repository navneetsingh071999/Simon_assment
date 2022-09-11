package Models;

public class LogFile {
    
    private String time;
    private String machineName;
    private String event;
    private String eventNumber;
    private String status;

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getMachineName() {
        return machineName;
    }
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public String getEventNumber() {
        return eventNumber;
    }
    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
