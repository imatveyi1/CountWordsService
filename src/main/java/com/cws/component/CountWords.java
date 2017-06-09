/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cws.component;

/**
 *
 * @author Matvey
 */
public class CountWords {
    
    private final String str;
    
    public CountWords (String str){
        this.str = str;
    }
    
    public short get(){
        return (short) str.split(" ").length;
    }
    
}
