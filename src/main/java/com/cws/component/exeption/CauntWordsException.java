/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cws.component.exeption;

/**
 *
 * @author Matvey
 */
public class CauntWordsException extends RuntimeException {
    
    private final int state;

    public CauntWordsException(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
    
}
