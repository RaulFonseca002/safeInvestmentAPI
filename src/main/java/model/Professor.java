package model;

public class Professor {
    
    private int userCode;
    private int professorCode;
    private float avgGrade;
    private String stamp;
    private String fullName;

    public Professor(int userCode, int professorCode, float avgGrade, String stamp, String fullName){
        setAll(userCode, professorCode, avgGrade, stamp, fullName);
    }

    public int getUserCode(){
        return userCode;
    }

    public int getProfessorCode(){
        return professorCode;
    }

    public float getAvgGrade(){
        return avgGrade;
    }

    public String getStamp(){
        return stamp;
    }

    public String getFullName(){
        return fullName;
    }

    public void setAll(int Ucode, int Pcode, float avgGrade, String stamp, String fullName){

        setUserCode(Ucode);
        setProfessorCode(Pcode);
        setAvgGrade(avgGrade);
        setStamp(stamp);
        setFullName(fullName);

    }

    public void setUserCode(int code){
        userCode = code;
    }

    public void setProfessorCode(int code){
        professorCode = code;
    }

    public void setAvgGrade(float avgGrade){
        this.avgGrade = avgGrade;
    }

    public void setStamp(String stamp){
        this.stamp = stamp;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }



}
