package org.example.factory;

import org.example.strategy.LeastUnfinishedJobsMachineSelectionStrategy;
import org.example.strategy.MachineSelectionStrategy;
import org.example.strategy.MostFinishedJobsMachineSelectionStrategy;

public class StrategyFactory {
    public static MachineSelectionStrategy getStrategy(int criteria){
        if(criteria==0){
            return new LeastUnfinishedJobsMachineSelectionStrategy();
        }else if(criteria==1){
            return new MostFinishedJobsMachineSelectionStrategy();
        }else{
            return null;
        }
    }
}
