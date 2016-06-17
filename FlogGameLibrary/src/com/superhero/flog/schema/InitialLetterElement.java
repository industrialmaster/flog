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
public class InitialLetterElement extends LetterValueElement{

    
    
    
    public InitialLetterElement(char value) {
        super(value);
        setScore(new VariableElement("default", 5.0));
    }
    
}
