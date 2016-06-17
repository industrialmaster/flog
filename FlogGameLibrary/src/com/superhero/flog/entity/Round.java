/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superhero.flog.entity;

import com.superhero.flog.schema.VariableElement;
import com.superhero.flog.score.DurationScoreRule;
import com.superhero.flog.score.ScoreGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Industrial Master
 */
public class Round {

    private OnlinePlayerRound weakPlayer;
    private OnlinePlayerRound powerPlayer;

    private List<OnlinePlayerRound> players = new ArrayList<OnlinePlayerRound>();

    /**
     * @return the players
     */
    public List<OnlinePlayerRound> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<OnlinePlayerRound> players) {
        this.players = players;
    }

    public void addPlayer(OnlinePlayerRound player) {
        this.players.add(player);

    }

    public int getPlayerCount() {
        return getPlayers().size();
    }

    public void getWeakAndPowerPlayers() {

        List<OnlinePlayerRound> weakPlayers = new ArrayList<OnlinePlayerRound>();
        List<OnlinePlayerRound> powerPlayers = new ArrayList<OnlinePlayerRound>();

        double min = 0;
        double max = 0;
        for (OnlinePlayerRound onlinePlayerRound : players) {
            double score = onlinePlayerRound.getScoreGenerator().getScore().getValue();
            if (score >= max) {
                max = score;
                if (score != max) {
                    for (OnlinePlayerRound powerPlayer : powerPlayers) {
                        powerPlayers.remove(powerPlayer);
                        double oldPowerScore = powerPlayer.getFinalScore();
                        if (oldPowerScore <= min) {
                            min = oldPowerScore;
                            if (oldPowerScore != min) {
                                weakPlayers.clear();
                            }
                            weakPlayers.add(onlinePlayerRound);

                        } else if (min == 0 && weakPlayers.isEmpty()) {
                            weakPlayers.add(onlinePlayerRound);
                        }
                    }
                }
                powerPlayers.add(onlinePlayerRound);

            } else {
                if (score <= min) {
                    min = score;
                    if (score != min) {
                        weakPlayers.clear();
                    }
                    weakPlayers.add(onlinePlayerRound);

                } else if (min == 0 && weakPlayers.isEmpty()) {
                    weakPlayers.add(onlinePlayerRound);
                }
            }

        }
        
        if(powerPlayers.size() > 1){
            double minTime = 0;
            for (OnlinePlayerRound pp : powerPlayers) {
                 VariableElement timeScore =  new DurationScoreRule().getScore(pp);
                 if(minTime == 0){
                     minTime = timeScore.getValue();
                     setPowerPlayer(pp);
                 }else if(minTime > timeScore.getValue()){
                     setPowerPlayer(pp);
                     minTime = timeScore.getValue();
                 }
            }
             
        }else{
            setPowerPlayer(powerPlayers.get(0));
        }
        
        if(weakPlayers.size() > 1){
            double maxTime = 0;
            for (OnlinePlayerRound wp : weakPlayers) {
                 VariableElement timeScore =  new DurationScoreRule().getScore(wp);
                 if(maxTime == 0){
                     maxTime = timeScore.getValue();
                     setWeakPlayer(wp);
                 }else if(maxTime < timeScore.getValue()){
                     setWeakPlayer(wp);
                     maxTime = timeScore.getValue();
                 }
            }
        }else{
            setWeakPlayer(weakPlayers.get(0));
        }
        
        

    }

    /**
     * @return the weakPlayer
     */
    public OnlinePlayerRound getWeakPlayer() {
        return weakPlayer;
    }

    /**
     * @param weakPlayer the weakPlayer to set
     */
    public void setWeakPlayer(OnlinePlayerRound weakPlayer) {
        this.weakPlayer = weakPlayer;
    }

    /**
     * @return the powerPlayer
     */
    public OnlinePlayerRound getPowerPlayer() {
        return powerPlayer;
    }

    /**
     * @param powerPlayer the powerPlayer to set
     */
    public void setPowerPlayer(OnlinePlayerRound powerPlayer) {
        this.powerPlayer = powerPlayer;
    }

}
