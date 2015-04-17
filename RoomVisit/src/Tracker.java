class Tracker{
    int visitorId;
    int roomId;
    StartEndTime startEndTime;

    public StartEndTime getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(StartEndTime startEndTime) {
        this.startEndTime = startEndTime;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

}