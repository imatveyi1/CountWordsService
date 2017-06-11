/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cws;

import com.cws.component.CountWords;
import com.cws.component.exeption.CauntWordsException;
import com.cws.component.filter.RequestFilter;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 *
 * @author Matvey
 */
public class CountWordsService {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Spark.before("/count", (Request req, Response res) -> {
            try{
                RequestFilter.check();
            } catch(CauntWordsException ex){
                Spark.halt(ex.getState(), ex.getState() == 500 ? "SERVER ERROR" : "ACCESS DENIED");
            }
        });
        
        Spark.get("/count", (Request req, Response res) -> {
            return new CountWords(req.queryParams("str")).get();
        });
    }
    
}
