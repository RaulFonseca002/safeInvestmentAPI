package model;

public class areaReturns {
    
    private String type;
    private String security;
    private String quality;
    private String time;

    areaReturns(){
        setAll("none", "none", "none", "none");
    }

    areaReturns(String type, String security, String quality, String time){

        setAll(type, security, quality, time);
    }

    public void setType(String type){
        this.type = type;
    }

    public void setSecurity(String security){
        this.security = security;
    }

    public void setQuality(String quality){
        this.quality = quality;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setAll(String type, String security, String quality, String time){
        setQuality(quality);
        setType(type);
        setSecurity(security);
        setTime(time);
    }

    public String getType(){
        return type;
    }

    public String getSecurity(){
        return security;
    }

    public String getQuality(){
        return quality;
    }

    public String getTime(){
        return time;
    }

    public String getAll(){

        return  getQuality() + " " + 
                getSecurity() + " " + 
                getTime() + " " + 
                getType();
    }

}
