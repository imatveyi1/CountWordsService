/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cws;

import com.cws.component.CountWords;
import com.cws.component.check.CountOkResponseService;
import com.cws.component.check.ResponseService;
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
        
        Spark.get("/count", (Request req, Response res) -> {
            ResponseService rs = new CountOkResponseService(new CountWords(req.queryParams("str")), res);
            rs.check();
            return rs.getRes().body() == null ? "" : rs.getRes().body();
        });
    }
    
}
