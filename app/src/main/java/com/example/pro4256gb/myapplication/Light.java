package com.example.pro4256gb.myapplication;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.util.Random;


public class Light implements Serializable {

    public static int counter = 0;
    public String macAddress;
    public String name;
    public String type;
    public int red;
    public int green;
    public int blue;
    public int white;
    public boolean isOn;
    public boolean isBulb;

    public Light(){
        this.macAddress = randomMACAddress();
        this.name = "Element" + counter++;
        this.type = "RGBW";
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.white = 0;
        this.isOn = false;
        this.isBulb = true;
    }

    public Light(String name, String type, boolean isBulb){
        this.macAddress = randomMACAddress();
        this.name = name;
        this.type = type;
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.white = 0;
        this.isOn = false;
        this.isBulb = isBulb;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void toggle(){
        this.isOn = !this.isOn;
    }

    private String randomMACAddress(){
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);

        macAddr[0] = (byte)(macAddr[0] & (byte)254);  //zeroing last 2 bytes to make it unicast and locally adminstrated

        StringBuilder sb = new StringBuilder(18);
        for(byte b : macAddr){

            if(sb.length() > 0)
                sb.append(":");

            sb.append(String.format("%02x", b));
        }


        return sb.toString();
    }
}

