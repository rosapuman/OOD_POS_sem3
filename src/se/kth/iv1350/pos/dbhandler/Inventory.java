package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.model.Sale;

import java.util.ArrayList;

public class Inventory
{
    int validation;
    private ArrayList<ItemDTO> items;

    public Inventory()
    {
        items = new ArrayList<>();

        items.add(new ItemDTO("INVALID", 0, 0, 0, 0));
        items.add(new ItemDTO("choklad",5, 0.1,30, 10));
        items.add(new ItemDTO("nocco cola",9, 0.12,55, 30));
        items.add(new ItemDTO("tamponger",7, 0.15,64, 15));
        items.add(new ItemDTO("chips",3, 0.1,23, 11));
    }

    public boolean checkItemID(int itemID)
    {
        for(ItemDTO currentItem : items){
            if(currentItem.getIdentifier() == itemID)
                return true;
        }
        return false;
    }

    public ItemDTO getItem(int itemID){

        for(ItemDTO currentItem : items){
            if(currentItem.getIdentifier() == itemID)
            {
                ItemDTO newItem = new ItemDTO(currentItem);
                newItem.quantity = 1;
                return newItem;
            }

        }
        return null;
    }

    public void updateInventory(Sale completedSale)
    {
    }

}
