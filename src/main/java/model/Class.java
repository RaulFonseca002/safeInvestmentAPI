package model;

public class Class {
    
    private int code;
    private String name;
    private float grade;
    private Price price;
    private Time time;
    private int professor;
    private String area;

    public Class(int code, String name, float grade, float price, String currency, String time, int professor, String area){
        
        setCode(code);
        setName(name);
        setGrade(grade);
        setPrice(price, currency);
        setTime(time);
        setProfessor(professor);
        setArea(area);
    }

    public String getArea(){
        return area;
    }

    public int getProfessor(){
        return professor;
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price.getPrice();
    }

    public float getGrade(){
        return grade;
    }

    public String getTime(){
        return time.getTime();
    }

    public void setArea(String area){
        this.area = area;
    }

    public void setProfessor(int code){
        professor = code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGrade(float grade){
        this.grade = grade;
    }

    public void setPrice(float price, String currency){
        this.price = new Price(price, currency);
    }


    public void setTime(String time){
        this.time = new Time(time);
    }
}
