/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cws.component.check;

import com.cws.component.CountWords;
import spark.Response;

/**
 *
 * @author serega
 */
public class CountOkResponseService extends MillisCheckResponseService {
    
    public CountOkResponseService(CountWords cw, Response res) {
        super(cw, res);
    }
    
    @Override
    public void check() {
        super.check();
        if(countResponse == 10 && !checkMilliseconds()){
            setMilliseconds();
            status = 500;
            res.status(status);
            countResponse = 0;
        }
        res.body(status == 200 ? Short.toString(cw.get()):"");
        countResponse++;
    }
    
}
