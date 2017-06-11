/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cws.component.filter;

import com.cws.component.exeption.CauntWordsException;
import java.util.Random;

/**
 * Фильтр определяющий какой статус ответа возвр 
 * @author Matvey
 */
public class RequestFilter {
    static volatile int countResponse = 0;
    
    static volatile long milliseconds = 0L;
    
    static volatile int status = 200;

    private RequestFilter() {
    }
    
    public static void check(){
        checkStatusMilliseconds();
        if(countResponse == 10 && !checkMilliseconds()){
            setMilliseconds();
            status = 500;
            countResponse = 0;
            throw new CauntWordsException(status);
        }
        countResponse++;
    }
    
    private static void checkStatusMilliseconds(){
        if(checkMilliseconds()){
           throwStatusResponseException();    
        }else{
            if(status != 200){
               status = 200;
               countResponse = 0;
            }
        }
    }
    
    private static void throwStatusResponseException(){
        if (countResponse >= 4) {
            if (status == 500) {
                setMilliseconds();
            }
            status = 403;
        }
        countResponse++;
        throw new CauntWordsException(status);
    }
    
    
    private static boolean checkMilliseconds(){
        return RequestFilter.milliseconds >= System.currentTimeMillis();
    }
    
    private static void setMilliseconds(){
        RequestFilter.milliseconds = System.currentTimeMillis() + genRandom(10,100);
    }
    
    private static long genRandom(int min, int max) { 
        Random r = new Random(); 
        return (r.nextInt(max - min) + 10) * 1000; 
    }

}
