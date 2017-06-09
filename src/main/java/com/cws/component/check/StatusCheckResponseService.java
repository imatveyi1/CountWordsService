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
public class StatusCheckResponseService extends ResponseService {
    
    public StatusCheckResponseService(CountWords cw, Response res) {
        super(cw, res);
    }

    @Override
    public void check() {
        if (countResponse < 5) {
            res.status(status);
        } else {
            if (status == 500) {
                setMilliseconds();
            }
            status = 403;
            res.status(status);
        }
    }
    
    
    
}
