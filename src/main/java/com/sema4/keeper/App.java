package com.sema4.keeper;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class App {

    public static void main(String[] args) throws InterruptedException, AWTException {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("Keeper started at : " + start.format(DateTimeFormatter.ISO_DATE_TIME));

        while (true) {
            moveCursorInLine();
        }

    }

    private static void moveCursorInLine() throws AWTException, InterruptedException {
        int halfRevolution = 500;

        int xCoord = 20;
        int yCoord = 20;
        int step = 1;
        int sleepTime = 2;
        Robot robot = new Robot();
        robot.mouseMove(xCoord, yCoord);
        for (int i = halfRevolution; i >= -halfRevolution; i--) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            if(i!=0){
                int delta = i / Math.abs(i) * step;
                if(xCoord != point.x){
                    System.out.println("System exited due to manual mouse move");
                    System.exit(0);
                }
                xCoord += delta;
                yCoord += delta;
                robot.mouseMove(xCoord, yCoord);
                Thread.sleep(sleepTime);
            }


        }

    }

}
