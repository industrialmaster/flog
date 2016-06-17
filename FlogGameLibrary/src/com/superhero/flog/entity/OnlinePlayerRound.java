/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superhero.flog.entity;

import com.superhero.flog.schema.DurationElement;
import com.superhero.flog.schema.WordElement;
import com.superhero.flog.score.ScoreGenerator;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Industrial Master
 */
public class OnlinePlayerRound implements Serializable, Comparable<OnlinePlayerRound> {

    private OnlinePlayer player;
    private int roundNo;
    private WordElement word;
    private WordElement givenWord;
    private DurationElement duration;
    private ScoreGenerator scoreGenerator;
    

    public OnlinePlayerRound(OnlinePlayer player, int roundNo) {
        this.player = player;
        this.roundNo = roundNo;
        Round round = Game.getRound(roundNo);
        this.duration.setStartTime(new Date().getTime());
        round.addPlayer(this);
        scoreGenerator = new ScoreGenerator(this);
    }

    /**
     * @return the player
     */
    public OnlinePlayer getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(OnlinePlayer player) {
        this.player = player;
    }

    /**
     * @return the roundNo
     */
    public int getRoundNo() {
        return roundNo;
    }

    /**
     * @param roundNo the round to set
     */
    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    /**
     * @return the word
     */
    public WordElement getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(WordElement word) {
        this.word = word;
    }

    /**
     * @return the duration
     */
    public DurationElement getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(DurationElement duration) {
        this.duration = duration;
    }

    /**
     * @return the givenWord
     */
    public WordElement getGivenWord() {
        return givenWord;
    }

    /**
     * @param givenWord the givenWord to set
     */
    public void setGivenWord(WordElement givenWord) {
        this.givenWord = givenWord;
    }

    @Override
    public int compareTo(OnlinePlayerRound other) {
        int comp = 0;
        if (this.getScoreGenerator().getScore().getValue()
                == other.getScoreGenerator().getScore().getValue()) {
            comp = 1;
        }
        return comp;
    }

    /**
     * @return the scoreGenerator
     */
    public ScoreGenerator getScoreGenerator() {
        return scoreGenerator;
    }

    /**
     * @param scoreGenerator the scoreGenerator to set
     */
    public void setScoreGenerator(ScoreGenerator scoreGenerator) {
        this.scoreGenerator = scoreGenerator;
    }
    
    public double getFinalScore(){
        return getScoreGenerator().getScore().getValue();
    }

}
