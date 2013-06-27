package mods.eln.lampsocket;

import mods.eln.BasicContainer;
import mods.eln.electricalcable.ElectricalCableDescriptor;
import mods.eln.item.LampSlot;
import mods.eln.node.SixNodeItemSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class LampSocketContainer extends BasicContainer {

	public static final int lampSlotId = 0;
	public static final int cableSlotId = 1;
	
	public LampSocketContainer(EntityPlayer player, IInventory inventory,LampSocketDescriptor descriptor) {
		super(player, inventory,new Slot[]{
				new LampSlot(inventory,lampSlotId,62 +  0,17,1,descriptor.socketType),
				//new SixNodeItemSlot(inventory,0,1,62 + 0,17,new Class[]{ElectricalCableDescriptor.class}),
				new SixNodeItemSlot(inventory,cableSlotId,62 + 18,17,1,new Class[]{ElectricalCableDescriptor.class})
			});
		
		// TODO Auto-generated constructor stub
	}

}