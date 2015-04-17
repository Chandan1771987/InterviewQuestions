import javax.sound.midi.Track;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by chandan.marathe on 4/17/2015.
 */
public class RoomCheckinCheckoutTracker {
    int enteredTime;
    int departTime;
    TreeMap<Integer, Tracker> roomCheckInTracker = new TreeMap<Integer, Tracker>();
    TreeMap<Integer,ArrayList<Tracker>> allVisitorsOfRoom = new TreeMap<Integer,ArrayList<Tracker>>();
    VisitorRoomMap visitorRoomMap = new VisitorRoomMap();


    // visitorId, roomId, I or O, time

    public void trackRoomCheckIn(int roomId,int visitorId, boolean isEntering, int time ){
        if(!isEntering){
            visitorRoomMap.updateVisitorRoomEntry(visitorId, roomId, time);
            String key = String.valueOf(roomId)+String.valueOf(visitorId);
            Tracker tracker = new Tracker();
            tracker.setVisitorId(visitorId);
            tracker.setRoomId(roomId);
            tracker.setStartEndTime(visitorRoomMap.getStartEndTime(visitorId,roomId));
            roomCheckInTracker.put(Integer.valueOf(key),tracker);
            ArrayList<Tracker> listOfTrackers;
            if(!allVisitorsOfRoom.containsKey(Integer.valueOf(key)/10)) {
                listOfTrackers = new ArrayList<Tracker>();
            }
            else{
                listOfTrackers = allVisitorsOfRoom.get(Integer.valueOf(key)/10);
            }
            listOfTrackers.add(tracker);
            allVisitorsOfRoom.put(Integer.valueOf(key)/10, listOfTrackers);
        }
        else {
            visitorRoomMap.addNewVisitorRoomEntry(visitorId, roomId, time, 9999);
        }
    }

    public TreeMap<Integer, ArrayList<Tracker>> getAllVisitorsOfRoom() {
        return allVisitorsOfRoom;
    }

    public static void main(String[] args) throws FileNotFoundException {
        RoomCheckinCheckoutTracker roomCheckinCheckoutTracker = new RoomCheckinCheckoutTracker();
        System.out.println("Enter the number of visits ");
        Scanner scanner = new Scanner(System.in);
        int totalInputs = Integer.parseInt(scanner.nextLine());
        int count=0;
        while(count<totalInputs){
            System.out.println("The total number of inputs is "+totalInputs);
            System.out.println("Now enter the intput in the format VisitorId, roomId, I, Time");
            String[] inputs = scanner.nextLine().split(" ");
            System.out.println("Size is "+inputs.length);
            roomCheckinCheckoutTracker.trackRoomCheckIn(Integer.parseInt(inputs[1]),Integer.parseInt(inputs[0]),inputs[2].equals("I"),Integer.parseInt(inputs[3]));
            count++;
        }


        TreeMap<Integer,ArrayList<Tracker>> allVisitorsOfRoom = roomCheckinCheckoutTracker.getAllVisitorsOfRoom();
        for (Integer roomId : allVisitorsOfRoom.keySet()){
            int totalTime = 0;
            StartEndTime startEndTime;
            for (Tracker tracker : allVisitorsOfRoom.get(roomId)){
                    startEndTime = tracker.getStartEndTime();
                    totalTime +=startEndTime.getEndTime()-startEndTime.getStarTime();
            }
            int numberOfVisitors = allVisitorsOfRoom.get(roomId).size();
            System.out.println(" Room ID "+roomId+ " "+totalTime/numberOfVisitors+ " minute average visit, "+numberOfVisitors+
            " visitor(s) total");
        }
    }
}
