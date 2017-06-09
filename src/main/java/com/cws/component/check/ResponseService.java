/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cws.component.check;

import com.cws.component.CountWords;
import java.util.Random;
import spark.Response;

/**
 *
 * @author serega
 */
public abstract class ResponseService {
    
    static volatile int countResponse = 0;
    
    static volatile long milliseconds = 0L;
    
    static volatile int status = 200;
    
    final CountWords cw;
    final Response res;

    public ResponseService(CountWords cw, Response res) {
        this.cw = cw;
        this.res = res;
    }
    
    abstract public void check();

    public Response getRes() {
        return res;
    }
    
    static boolean checkMilliseconds(){
        return ResponseService.milliseconds >= System.currentTimeMillis();
    }
    
    public static void setMilliseconds(){
        ResponseService.milliseconds = System.currentTimeMillis() + genRandom(10,100);
    }
    
    static public void setStatus(int status){
        ResponseService.status = status;
    }
    
    static public int getStatus(){
        return ResponseService.status;
    }
    
    static private long genRandom(int min, int max) { 
        Random r = new Random(); 
        return (r.nextInt(max - min) + 10) * 1000; 
    }
    
}
