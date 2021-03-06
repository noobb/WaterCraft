package dgrxf.watercraft.client.gui.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dgrxf.watercraft.client.gui.container.ToolboxContainer;
import dgrxf.watercraft.tileentity.WCTileEntityToolBox;

public class ToolBoxGUI extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation("watercraft", "textures/gui/toolbox.png");
	
	public ToolBoxGUI(InventoryPlayer inventory, WCTileEntityToolBox te) {
		super(new ToolboxContainer(inventory, te));
		
		xSize = 176;
		ySize = 218;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
