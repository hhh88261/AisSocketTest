package org.example;

import org.example.Model.SelectShipModel;
import org.example.Model.ShipModel;

import java.util.List;

public interface ShipMapper {

    void insertShip(ShipModel shipModel);

    void insertPastData(SelectShipModel selectshipModel);
}