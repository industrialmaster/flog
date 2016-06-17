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
public class WordElement extends FlogElement{
    private LetterValueElement[]  value;

    public WordElement(LetterValueElement[] value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public LetterValueElement[] getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(LetterValueElement[] value) {
        this.value = value;
    }

    
    
    
    
}
