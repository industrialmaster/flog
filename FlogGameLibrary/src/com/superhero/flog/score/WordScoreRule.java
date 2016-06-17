/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.superhero.flog.score;

import com.superhero.flog.common.Constants;
import com.superhero.flog.entity.Game;
import com.superhero.flog.entity.OnlinePlayerRound;
import com.superhero.flog.entity.Round;
import com.superhero.flog.schema.LetterValueElement;
import com.superhero.flog.schema.VariableElement;
import com.superhero.flog.schema.WordElement;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Industrial Master
 */
public class WordScoreRule implements ScoreRule{

    @Override
    public VariableElement getScore(OnlinePlayerRound round) {
        VariableElement score = new  VariableElement("score",0.0);
        
        VariableElement alfa = getWordCountScore(round.getWord());
        VariableElement beta = getWordFullLengthScore(round,alfa);
        VariableElement theta = getWordNotUsedScore(round);
        score.setValue(alfa.getValue() + beta.getValue() - theta.getValue());
        return score;
    }
    
    
    public VariableElement getWordCountScore(WordElement word){
        VariableElement score = new  VariableElement("score",0.0);
        LetterValueElement[] letters = word.getValue();
        for (LetterValueElement letterValueElement : letters) {
            score.setValue(letterValueElement.getScore().getValue());
        }
        return score;
    }
    
    public VariableElement getWordFullLengthScore(OnlinePlayerRound round, VariableElement alfa){
        VariableElement score = new  VariableElement("score",0.0);
        if(round.getWord().getValue().length == Constants.WORD_MAX_COUNT.getValue()){
            Round thisRound = Game.getRound(round.getRoundNo());
            int playerCount = thisRound.getPlayerCount();
            score.setValue(alfa.getValue() * playerCount);
        }
        
        return score;
    }
    
    public VariableElement getWordNotUsedScore(OnlinePlayerRound round){
        VariableElement score = new  VariableElement("score",0.0);
        
        LetterValueElement givenWord[] = round.getGivenWord().getValue();
        LetterValueElement createdWord[] = round.getWord().getValue();
        List createdWordList = Arrays.asList(createdWord);
         
        for (LetterValueElement letterValueElement : givenWord) {
            if(!createdWordList.contains(letterValueElement)){
                score.incrementValue(letterValueElement.getScore().getValue());
            }
        }
        
        
        return score;
    }
    
    
    
}
