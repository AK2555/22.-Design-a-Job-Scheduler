package org.example.strategy;

import org.example.entities.Machine;

import java.util.List;

public interface MachineSelectionStrategy {
     Machine findMachines(List<Machine> machines);
}
