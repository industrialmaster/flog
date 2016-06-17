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
public class VariableElement extends FlogElement{
    private String name;
    private Double value;
    
    public VariableElement(String name, Double value){
        this.name = name;
        this.value = value;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setValue(Double value){
        this.value = value;
    }
    
    public Double getValue(){
        return this.value;
    }
    
    public Double incrementValue(Double value){
        this.value += value;
        return this.value;
    }
}
