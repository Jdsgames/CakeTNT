package dev.jdsgames.caketnt.data;

import dev.jdsgames.caketnt.items.AbstractCakeTNT;

import java.util.ArrayList;

public class CakeHandler
{
    private static ArrayList<AbstractCakeTNT> placedCakeTNT;

    public CakeHandler()
    {
        if(placedCakeTNT == null)
            placedCakeTNT = new ArrayList<>();
    }

    // Get the placed cake list
    public ArrayList<AbstractCakeTNT> getPlacedCakeTNT()
    {
        return placedCakeTNT;
    }

    // Set the placed cake list
    public void setPlacedCakeTNT(ArrayList<AbstractCakeTNT> newCakeList)
    {
        placedCakeTNT = newCakeList;
    }

    // Add a CakeTNT to the list
    public void addPlacedCake(AbstractCakeTNT addedCakeTNT)
    {
        if(addedCakeTNT != null)
            placedCakeTNT.add(addedCakeTNT);
    }

    // Remove a CakeTNT from the list
    public void removePlacedCake(AbstractCakeTNT removedCakeTNT)
    {
        if(removedCakeTNT != null)
            placedCakeTNT.remove(removedCakeTNT);
    }

    // Remove a list of CakeTNT from the list
    public void removePlacedCakes(ArrayList<AbstractCakeTNT> removedCakeTNT)
    {
        if(removedCakeTNT != null)
            for(AbstractCakeTNT abstractCakeTNT: removedCakeTNT)
            {
                placedCakeTNT.remove(abstractCakeTNT);
            }
    }

    // Detonate selected CakeTNT
    public void detonatePlacedCake(AbstractCakeTNT detonateCake)
    {
        if(detonateCake != null)
            detonateCake.detonate();
    }


}
