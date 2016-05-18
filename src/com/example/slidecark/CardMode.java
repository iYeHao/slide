package com.example.slidecark;
import java.util.List;
/*
 * 定义一个类型，包括名字 年龄和照片的这一个类型
 */
public class CardMode {
    private String name;//朋友的年龄，名字，和照片
    private int year;
    private int  images;
    private String college;
    private String motherLanuage;
    private String gender;
    private String wantLanuage;
    private String address;
    

    public CardMode(String name, int year,int images,String college,String motherLanuage,String wantLanuage,String gender,String address) {
        this.name = name;
        this.year = year;
        this.images = images;
        this.college = college;
        this.motherLanuage=motherLanuage;
        this.wantLanuage=wantLanuage;
        this.gender=gender;
        this.address=address;
    }
//其他的接口
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setImages(int  images) {
        this.images = images;
    }

    public int  getImages() {
        return images;
    }
    
    public void  setcollege(String college)
    {
    	this.college = college ;
    }
    
    public String getcollege()
    {
    	return college;
    }
    public void  setwantLanuage(String wantLanuage)
    {
    	this.wantLanuage = wantLanuage;
    }
    
    public String getwantLanuage()
    {
    	return wantLanuage;
    }
    public void  setmotherLanuage(String motherLanuage)
    {
    	this.motherLanuage = motherLanuage;
    }
    
    public String getmotherLanuage()
    {
    	return motherLanuage;
    }
    public void setgender(String  gender) {
        this.gender = gender;
    }

    public String getgender() {
        return gender;
    }
    public void setaddress(String  address) {
        this.address = address;
    }

    public String getaddress() {
        return address;
    }
}

