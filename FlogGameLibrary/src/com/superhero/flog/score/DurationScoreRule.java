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
public class DurationScoreRule implements ScoreRule{

    @Override
    public VariableElement getScore(OnlinePlayerRound round) {
        VariableElement score = new  VariableElement("score",Double.valueOf(round.getDuration().getDuration()));
        
        return score;
    }
    
    
    
}
