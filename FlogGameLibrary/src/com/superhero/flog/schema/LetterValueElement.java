/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.superhero.flog.schema;

import java.io.Serializable;

/**
 *
 * @author Industrial Master
 */
public class LetterValueElement extends FlogElement implements Serializable,Comparable<LetterValueElement>{
    private char value;
    
    private VariableElement score;

    public LetterValueElement(char value) {
        this.value = value;
        setScore(new VariableElement("default", 1.0));
    }

    /**
     * @return the value
     */
    public char getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     * @return the score
     */
    public VariableElement getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(VariableElement score) {
        this.score = score;
    }
    
    @Override
    public int compareTo(LetterValueElement other) {
        int comp = 0;
        if(this.getValue()==other.getValue()){
            comp = 1;
        }
        return comp;
    }

    
    
}
