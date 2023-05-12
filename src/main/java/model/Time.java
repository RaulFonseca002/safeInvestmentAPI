package model;

public class Time {
    
    private int hours;
    private int minutes;
    private int seconds;

    Time(){
        set(0, 0, 0);
    }

    Time(String time){

        String[] splitedTime = time.split(":");

        set(Integer.parseInt(splitedTime[0]),
            Integer.parseInt(splitedTime[1]), 
            Integer.parseInt(splitedTime[2]));
    }

    public void set(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getTime(){
        return hours + " : " + minutes + " : " + seconds;
    }


}
