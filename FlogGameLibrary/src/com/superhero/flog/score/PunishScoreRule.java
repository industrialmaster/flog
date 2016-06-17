/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superhero.flog.score;

import com.superhero.flog.entity.Game;
import com.superhero.flog.entity.OnlinePlayerRound;
import com.superhero.flog.entity.Round;
import com.superhero.flog.schema.VariableElement;

/**
 *
 * @author Industrial Master
 */
public class PunishScoreRule implements ScoreRule {

    @Override
    public VariableElement getScore(OnlinePlayerRound roundPlayer) {
        VariableElement score = new VariableElement("score", 0.0);
        Round round = Game.getRound(roundPlayer.getRoundNo());

        if (roundPlayer.equals(round.getWeakPlayer())) {
            score.setValue((-3.0));
        }

        return score;
    }

}
