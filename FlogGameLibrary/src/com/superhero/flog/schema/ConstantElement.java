/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.superhero.flog.schema;

/**
 *
 * @author Industrial Master
 */
public class ConstantElement extends FlogElement{
    private Double value;
    
    public ConstantElement(Double value){
        this.value = value;
    }
    
    public Double getValue(){
        return this.value;
    }
}
