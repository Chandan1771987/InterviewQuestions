import java.util.HashMap;

class VisitorRoomMap{
    private HashMap<String,StartEndTime> visitorRoomMap = new HashMap<String, StartEndTime>();
    int roomId;
    int visitorId;

    public void addNewVisitorRoomEntry(int visitorId,int roomId,int startTime,int endTime){
        String key = String.valueOf(visitorId)+String.valueOf(roomId);
        StartEndTime startEndTime = new StartEndTime();
        startEndTime.setEndTime(endTime);
        startEndTime.setStarTime(startTime);
        visitorRoomMap.put(key,startEndTime);
    }

    public void updateVisitorRoomEntry(int visitorId,int roomId,int time){
        String key = String.valueOf(visitorId)+String.valueOf(roomId);
        StartEndTime startEndTime = visitorRoomMap.get(key);
        startEndTime.setEndTime(time);
        visitorRoomMap.put(key,startEndTime);
    }

    public StartEndTime getStartEndTime(int visitorId,int roomId){
        String key = String.valueOf(visitorId)+String.valueOf(roomId);
        return visitorRoomMap.get(key);
    }

}