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
public class ScoreGenerator {
    
    private OnlinePlayerRound playerRound;

    
    public ScoreGenerator(OnlinePlayerRound playerRound) {
        this.playerRound = playerRound;
    }
    
    
    
    public VariableElement getScore(){
        VariableElement score = new VariableElement("score", 0.0);
        score.incrementValue(new WordScoreRule().getScore(playerRound).getValue());
        score.incrementValue(new PunishScoreRule().getScore(playerRound).getValue());
        return score;
    }
}
