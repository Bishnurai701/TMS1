package com.tms.model;

public class Board {
    private int Board_id;
    private String BoardName;
    private int Qualification_id;

    /* Constructors */
    public Board(int Board_id){}
    public Board(int Board_id,String BoardName){
        this.Board_id=Board_id;
        this.BoardName=BoardName;
    }
    public Board(String BoardName){
        this.BoardName=BoardName;
    }

    /* Here is Getter*/
    public int getBoard_id(){
        return Board_id;
    }
    public String getBoardName(){
        return BoardName;
    }

    /* Here is Setter*/
    public void setBoard_id(int Board_id){
        this.Board_id=Board_id;
    }
    public void setBoardName(String BoardName){
        this.BoardName=BoardName;
    }

}
