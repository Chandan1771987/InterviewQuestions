import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by chandan.marathe on 4/17/2015.
 */
public class TestCheckInCheckoutTracker {



    @Test
    public void testTracking(){
        RoomCheckinCheckoutTracker roomCheckinCheckoutTracker = new RoomCheckinCheckoutTracker();
        roomCheckinCheckoutTracker.trackRoomCheckIn(0,0,true,140);
        roomCheckinCheckoutTracker.trackRoomCheckIn(0,0,false,360);
        TreeMap<Integer,ArrayList<Tracker>> allVisitorsOfRoom = roomCheckinCheckoutTracker.getAllVisitorsOfRoom();
        for (Integer roomId : allVisitorsOfRoom.keySet()){
            int totalTime = 0;
            StartEndTime startEndTime;
            for (Tracker tracker : allVisitorsOfRoom.get(roomId)){
                startEndTime = tracker.getStartEndTime();
                totalTime +=startEndTime.getEndTime()-startEndTime.getStarTime();
            }
            int numberOfVisitors = allVisitorsOfRoom.get(roomId).size();
            Assert.assertEquals(220,totalTime/numberOfVisitors);
        }

    }



}
