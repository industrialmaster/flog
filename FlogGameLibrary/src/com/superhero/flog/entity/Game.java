/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.superhero.flog.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Industrial Master
 */
public class Game {
    private static Map<Integer,Round> rounds = new HashMap<Integer, Round>();

    public Game(int roundCount) {
        for (int i = 1; i <= roundCount; i++) {
            rounds.put(i, new Round());
        }
    }

    
    
    /**
     * @return the rounds
     */
    public static Map<Integer,Round> getRounds() {
        return rounds;
    }
    
    public static Round getRound(Integer no){
        return rounds.get(no);
    }

   
    
    
}
