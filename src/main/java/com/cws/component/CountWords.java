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
    
    private static final String PUNCT = "\\p{P}?[ \\t\\n\\r]+";
    
    private final String str;
    
    public CountWords (String str){
        this.str = str;
    }
    
    public int get(){
        return str.split(PUNCT).length;
    }
    
}
