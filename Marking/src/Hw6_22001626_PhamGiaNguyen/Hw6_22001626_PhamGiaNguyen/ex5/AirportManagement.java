package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex5;

import ex2.MinHeapPriorityQueue;

public class AirportManagement {
    private MinHeapPriorityQueue<TimeStamp, String> heapPriorityQueue = new MinHeapPriorityQueue<>();

    public void insertPlaneSchedule(FlightSchedule flightSchedule) {
        heapPriorityQueue.insert(flightSchedule.getTimeParking(), flightSchedule.getEventComing(flightSchedule.getTimeParking()));
        heapPriorityQueue.insert(flightSchedule.getTimeTakingOff(), flightSchedule.getEventComing(flightSchedule.getTimeTakingOff()));
    }
    public String getUpcoming(){
        return heapPriorityQueue.removeMin().getValue();
    }
}
