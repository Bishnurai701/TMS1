package com.tms.model;

public class Level {
    private int Level_id;
    private String LevelName;

    /* constructor */
    public Level(int Level_id){}
    public Level(int Level_id,String LevelName){
        this.Level_id=Level_id;
        this.LevelName=LevelName;
    }
    public Level(String LevelName){
        this.LevelName=LevelName;
    }
    /* Here is getter */

    public int getLevel_id() {
        return Level_id;
    }

    public String getLevelName() {
        return LevelName;
    }
    /* Here is Setter */

    public void setLevel_id(int Level_id) {
        this.Level_id = Level_id;
    }

    public void setLevelName(String LevelName) {
        this.LevelName = LevelName;
    }
}
