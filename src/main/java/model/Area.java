package model;

public class Area {
    
    private int code;
    private String acronym;
    private String name;
    public String superArea;
    
    //seta a Area vazia com objetos sem valor para evitar o retorno de null;
    public areaReturns returns = new areaReturns();


    Area(){
        code = 0;
        acronym = "";
        name = "";
        superArea = null; //superArea da superArea e null
    }

    public Area(int code, String acronym, String name, String returns, String superAreaAcronym){

        setCode(code);
        setAcronym(acronym);
        setName(name);
        setReturns(returns);
        setSuperArea(superAreaAcronym);
        
    }

    public String getName(){
        return name;
    }

    public int getCode(){
        return code;
    }

    public String getAcronym(){
        return acronym;
    }

    public String getReturns(){
        return returns.getAll();
    }

    public String getSuperArea(){
        return superArea;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCode(int code){
        this.code = code;
    }

    public void setAcronym(String acronym){
        this.acronym = acronym;
    }

    public void setSuperArea(String acronym){
        this.superArea = acronym;
    }

    public void setReturns(String returns){

        String[] splitedReturns = returns.split(",");
        setReturns(splitedReturns[0], splitedReturns[1], splitedReturns[2], splitedReturns[3]);
    }

    public void setReturns(String type, String security, String Quality, String time){
        returns.setAll(type, security, Quality, time);
    }
}
