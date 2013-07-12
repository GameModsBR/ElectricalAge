package mods.eln.generic;

import java.util.ArrayList;
import java.util.List;

import mods.eln.Eln;
import mods.eln.ItemStackFilter;
import mods.eln.gui.ISlotSkin;
import mods.eln.gui.ISlotWithComment;
import mods.eln.gui.SlotWithSkin;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class GenericItemUsingDamageSlot extends SlotWithSkin implements ISlotWithComment {

	//public GenericItemUsingDamage item;
	
	public GenericItemUsingDamageSlot(
			IInventory inventory, int slot,
			int x, int y,
			int stackLimit,Class[] descriptorClassList,SlotSkin skin,String[] comment
			)
	{
		super(inventory, slot, x, y,skin);
		this.stackLimit = stackLimit;
		this.descriptorClassList = descriptorClassList;
		this.comment = comment;
	}
	String[] comment;
	public GenericItemUsingDamageSlot(
			IInventory inventory, int slot,
			int x, int y,
			int stackLimit,Class descriptorClassList,SlotSkin skin,String[] comment
			)
	{
		super(inventory, slot, x, y,skin);
		this.stackLimit = stackLimit;
		this.descriptorClassList = new Class[]{descriptorClassList};
		this.comment = comment;
	}

	Class[] descriptorClassList;
	int stackLimit;
	

	
    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack itemStack)
    {
    //	if(itemStack.getItem() != item) return false;
    	if((itemStack.getItem() instanceof GenericItemUsingDamage) == false) return false;
    	GenericItemUsingDamageDescriptor descriptor = ((GenericItemUsingDamage)itemStack.getItem()).getDescriptor(itemStack);
    	if(descriptor == null) return false;
        for(Class classFilter : descriptorClassList)
        {     
        	
        	Class c =  descriptor.getClass();
        	while(c != null)
        	{
        		if(c == classFilter) return true;
        		c = c.getSuperclass();
        	}
        }
        
        return false;
    }

    
    @Override
    public int getSlotStackLimit() {
    	// TODO Auto-generated method stub
    	//return super.getSlotStackLimit();
    	return stackLimit;
    }
	@Override
	public void getComment(ArrayList<String> list) {
		for(String str : comment)
			list.add(str);
	}

}
