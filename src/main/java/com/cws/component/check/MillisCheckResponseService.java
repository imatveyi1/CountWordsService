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
public class MillisCheckResponseService extends StatusCheckResponseService {
    
    public MillisCheckResponseService(CountWords cw, Response res) {
        super(cw, res);
    }

    @Override
    public void check() {
        if(checkMilliseconds()){
           super.check();
        }else{
            if(status != 200){
               status = 200;
               countResponse = 0;
            }
        }
    }
    
}
