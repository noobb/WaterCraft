package dgrxf.watercraft.item;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import dgrxf.watercraft.Watercraft;
import dgrxf.watercraft.entity.WCEntityBoat;
import dgrxf.watercraft.lib.ItemInfo;

/**
 * Class Made By: Gory_Moon
 * 
 * Class Last Edited By: Gory_Moon Class Last Edited On: 7/11/2013 D/M/Y
 * 
 */

public class ItemBoat extends Item {
    
    public ItemBoat() {
        super(ItemInfo.BOAT_ID);
        setUnlocalizedName(ItemInfo.BOAT_UNLOCALIZED_NAME);
        setCreativeTab(Watercraft.tab);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (world.isRemote)
            return itemStack;
        
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);
        
        if (movingobjectposition == null) {
            return itemStack;
        } else {
            if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
                
                int x1 = movingobjectposition.blockX;
                int y1 = movingobjectposition.blockY;
                int z1 = movingobjectposition.blockZ;
                
                if (world.getBlockMaterial(x1, y1, z1) == Material.water && world.isAirBlock(x1, y1 + 1, z1)) {
                    WCEntityBoat boat = new WCEntityBoat(world, x1, y1 + 1, z1);
                    
                    world.spawnEntityInWorld(boat);
                    
                    if (!player.capabilities.isCreativeMode) {
                        --itemStack.stackSize;
                    }
                }
            }
            
            return itemStack;
        }
    }
}
