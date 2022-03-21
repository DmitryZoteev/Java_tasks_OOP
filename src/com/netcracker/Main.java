package com.netcracker;

import com.netcracker.figures.MyTriangle;
import com.netcracker.math.Ball;
import com.netcracker.math.Container;

public class Main {
    public static void main(String[] args) {
        MyTriangle triangle = new MyTriangle(0, 0, 1, 5, 5, 1);
        System.out.println(triangle.getType());

        Container container = new Container(10, 10, 20, 20);
        Ball ball = new Ball(15, 15, 1, 1, 45);
        System.out.println("x: " + ball.getX() + "; y: " + ball.getY() + "  " + container.collides(ball));
        while(container.collides(ball)){
            ball.move();
            System.out.println("x: " + ball.getX() + "; y: " + ball.getY() + "  " + container.collides(ball));
        }
    }
}
