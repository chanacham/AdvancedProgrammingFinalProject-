package src;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
public class People {
    private int IDnum;
    private int floorNum;
    private String eName;

    public People (int id, int dept, String name){
        this.IDnum = id;
        this.floorNum = dept;
        this.eName = name;
    }
    public String toString (){
        return "Employee/ Department : " + eName + "with ID: " + IDnum + " is at floor " + floorNum;
    }
    public int getIDnum(){
        return IDnum;
    }
    public int getFloorNum(){
        return floorNum;
    }
    public String geteName(){
        return eName;
    }


}
