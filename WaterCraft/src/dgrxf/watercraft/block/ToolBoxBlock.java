package dgrxf.watercraft.block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import dgrxf.watercraft.Watercraft;
import dgrxf.watercraft.lib.BlockInfo;
import dgrxf.watercraft.lib.RenderInfo;
import dgrxf.watercraft.tileentity.WCTileEntityBuoy;
import dgrxf.watercraft.tileentity.WCTileEntityToolBox;

public class ToolBoxBlock extends WCBlock {

	public ToolBoxBlock() {
		super(BlockInfo.TOOLBOX_ID, Material.iron);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockBounds(0.1F, 0F, 0.35F, 0.9F, 0.5F, 0.65F);
	}
	
	@Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, Watercraft.instance, 0, world, x, y, z);			
		}
	
		return true;
	}
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public int getRenderType() {
        return RenderInfo.BUOY_RENDER_ID;
    }
    
    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new WCTileEntityToolBox();
    }

}
