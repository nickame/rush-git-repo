package com.javarush.test.level21.lesson16.big01;

/**
 * Created by nickame on 07.02.16.
 */
public class Horse
{
   String name;
   double speed, distance;

    public Horse(String name, double speed, double distance )
    {
        this.distance = distance;
        this.speed = speed;
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void move(){
        distance+=speed*Math.random();
    }

    public void print (){
        String dist="";
        for(int i =0; i < Math.round(distance);i++){
            dist+=".";
        }
        dist+=name;
        System.out.println(dist);
    }
}
