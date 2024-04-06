package com.example.history;

public class History {

    private int id;
    private String years;
    private String area;

    public History(int id,String years,String area){
        this.id=id;
        this.years =years;
        this.area=area;
    }
    public int getId() {
        return id;
    }
    public String getYears(){
        return years;
    }
    public String getArea(){
        return area;
    }
}
