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
public class Geometrie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Point pt1 = new Point();
        Point pt2 = new Point(2,3);
        Point pt3 = new Point(5,5);
        Point pt4 = new Point(2,0);
        
        System.out.println(pt1.toString());  
        
        pt1.moveTo(9, 4);
        System.out.println(pt1.toString());
        
        pt1.rMoveTo(-3, 1);
        System.out.println(pt1.toString());
        
        
        System.out.println(pt3.distance(pt2));

        
    }
    
}
