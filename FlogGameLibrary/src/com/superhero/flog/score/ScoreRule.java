/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.superhero.flog.score;

import com.superhero.flog.entity.OnlinePlayerRound;
import com.superhero.flog.schema.VariableElement;

/**
 *
 * @author Industrial Master
 */
public interface ScoreRule {
    
    public VariableElement getScore(OnlinePlayerRound round);
    
}
