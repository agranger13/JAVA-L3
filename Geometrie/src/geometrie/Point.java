/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometrie;

/**
 *
 * @author licence
 */
public class Point {
    private double x;
    private double y;
    
    Point(){
        this.x = 0;
        this.y = 0;
    }

    Point(double parX, double parY){
        this.x = parX;
        this.y = parY;
    }
    
    public int moveTo(double parX, double parY){
        this.x = parX;
        this.y = parY;
        return 0;
    }
    
    public int rMoveTo(double parX, double parY){
        this.x += parX;
        this.y += parY;
        return 0;
    }
    
    public double distance(Point pt2){
        return Math.sqrt( Math.pow(pt2.x - this.x,2) + Math.pow(pt2.y - this.y,2) );
    } 
    
    public String toString(){
        return "x : " + this.x + " y : " + this.y;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
}
