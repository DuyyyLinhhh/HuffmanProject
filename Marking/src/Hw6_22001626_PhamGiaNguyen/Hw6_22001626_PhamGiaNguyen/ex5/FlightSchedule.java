package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex5;

public class FlightSchedule {
    private String aircraftCode;
    private TimeStamp timeParking;
    private TimeStamp timeTakingOff;

    public FlightSchedule(String aircraftCode, TimeStamp timeParking, TimeStamp timeTakingOff) {
        this.aircraftCode = aircraftCode;
        this.timeParking = timeParking;
        this.timeTakingOff = timeTakingOff;
    }

    public String getEventComing(TimeStamp timeStamp){
        if (timeStamp == this.timeParking){
            return aircraftCode +"(timeLanding:"+ timeStamp+")";
        }else {
            return aircraftCode +"(timeTakingOff:"+ timeStamp+")";
        }
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public TimeStamp getTimeParking() {
        return timeParking;
    }

    public TimeStamp getTimeTakingOff() {
        return timeTakingOff;
    }
}
