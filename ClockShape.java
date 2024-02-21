import java.awt.*;
        import java.awt.geom.*;
        import java.util.*;
        import java.awt.Color;
        import java.lang.Math.*;

public class ClockShape implements Moveable{
    public int h;
    public int m;
    public int count;
    public int x;
    public int y;
    public int width;
    public double theta = 1;
    public double alpha = 1;
    public double omega = 1;
    public Point2D.Double origin;
    public Point2D.Double endHour;
    public Point2D.Double endMinuet;
    public Point2D.Double endSecond;
  
    public ClockShape(int x, int y, int width, int h, int m, double count){
        x=this.x;
        y=this.y;
        width=this.width;
        h=this.h;
        m=this.m;
        count=this.count;
    }

  public void draw(Graphics2D g2){

        endSecond = new Point2D.Double(300 + 110*Math.cos(theta), 300 + 110*Math.sin(theta));

        endMinuet = new Point2D.Double(200 + 110*Math.sin(alpha), 200 + 110*Math.sin(alpha));

        endHour = new Point2D.Double(100 + 110*Math.cos(omega), 100 + 110*Math.sin(omega));

        origin = new Point2D.Double(300,300);
        Shape seconds = new Line2D.Double(origin, endSecond);
        Shape minuets = new Line2D.Double(origin, endMinuet);
        Shape hours = new Line2D.Double(origin, endHour);
        g2.setStroke(new BasicStroke(3));
	g2.fill(seconds);
	g2.draw(seconds);
	g2.fill(minuets);
	g2.draw(minuets);
	g2.fill(hours);
	g2.draw(hours);
	
        for(double j=0; j<60; j++){

            Ellipse2D.Double point = new Ellipse2D.Double(300 + 170*Math.cos(j * Math.PI/30), 300 + 170*Math.sin(j*Math.PI/30),1,1);
		g2.fill(point);
		g2.draw(point);

        }

        for(double i=0; i<60; i++){
            Ellipse2D.Double pointHour = new Ellipse2D.Double(300 + 170*Math.cos(i * Math.PI/6), 300 + 170*Math.sin(i*Math.PI/6),1,1);
		g2.fill(pointHour);
		g2.draw(pointHour);

        }
    }


    public void translate(int dx, int dy){

        endSecond.setLocation(Math.PI / 30, Math.PI / 30);
        count++;

        if (count % 60 == 0) {

            endMinuet.setLocation(Math.PI / 30, Math.PI / 30);
        }

        if (count % 720 == 0) {

            endHour.setLocation(Math.PI / 30, Math.PI / 30);
        }
    }


}





