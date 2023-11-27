package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex5;

public class Test {
    public static void main(String[] args) {
        AirportManagement airportManagement = new AirportManagement();
        airportManagement.insertPlaneSchedule(new FlightSchedule("MH799",new TimeStamp(1,1,1),new TimeStamp(2,2,2)));
        airportManagement.insertPlaneSchedule(new FlightSchedule("AIRBONE 789",new TimeStamp(2,30,19),new TimeStamp(3,2,2)));
        airportManagement.insertPlaneSchedule(new FlightSchedule("VN-531",new TimeStamp(0,40,1),new TimeStamp(20,2,2)));
        airportManagement.insertPlaneSchedule(new FlightSchedule("Yasou104",new TimeStamp(10,1,15),new TimeStamp(12,2,2)));
        airportManagement.insertPlaneSchedule(new FlightSchedule("VN-342",new TimeStamp(14,3,1),new TimeStamp(22,2,2)));
        airportManagement.insertPlaneSchedule(new FlightSchedule("KK7323",new TimeStamp(12,1,1),new TimeStamp(12,2,2)));
        airportManagement.insertPlaneSchedule(new FlightSchedule("ML3432",new TimeStamp(15,17,12),new TimeStamp(23,2,2)));
        airportManagement.insertPlaneSchedule(new FlightSchedule("MU3432",new TimeStamp(17,12,1),new TimeStamp(23,2,2)));
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());
        System.out.println(airportManagement.getUpcoming());

    }
}
