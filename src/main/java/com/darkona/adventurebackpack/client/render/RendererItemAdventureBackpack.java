package com.darkona.adventurebackpack.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.darkona.adventurebackpack.client.models.ModelBackpackBlock;
import com.darkona.adventurebackpack.inventory.InventoryBackpack;
import com.darkona.adventurebackpack.reference.BackpackTypes;
import com.darkona.adventurebackpack.util.Resources;

public class RendererItemAdventureBackpack implements IItemRenderer {

    private final ModelBackpackBlock model;

    public RendererItemAdventureBackpack() {
        model = new ModelBackpackBlock();
    }

    @Override
    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        switch (type) {
            case INVENTORY:
            case ENTITY:
            case EQUIPPED_FIRST_PERSON:
            case EQUIPPED:
                return true;
            case FIRST_PERSON_MAP:
                return false;
        }
        return false;
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item,
            IItemRenderer.ItemRendererHelper helper) {
        switch (type) {
            case INVENTORY:
            case ENTITY:
                return true;
            case EQUIPPED:
            case FIRST_PERSON_MAP:
            case EQUIPPED_FIRST_PERSON:
                return false;
        }
        return false;
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType renderType, ItemStack backpack, Object... data) {
        InventoryBackpack inv = new InventoryBackpack(backpack);
        ResourceLocation modelTexture = Resources.getBackpackTexture(BackpackTypes.getType(backpack));

        switch (renderType) {
            case INVENTORY:
                Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture); {
                GL11.glPushMatrix();
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                GL11.glPushMatrix();
                GL11.glTranslatef(-0.5f, 0f, -0.5f);

                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

                GL11.glPushMatrix();
                GL11.glScalef(1.9f, 1.9f, 1.9f);

                model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.05F, inv);

                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
            }
                break;

            case ENTITY:
                Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture); {
                GL11.glPushMatrix();
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                GL11.glPushMatrix();
                GL11.glTranslatef(0f, 1f, 0f);

                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

                GL11.glPushMatrix();
                GL11.glScalef(1.2f, 1.2f, 1.2f);

                model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.05F, inv);

                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
            }
                break;

            case EQUIPPED:
                Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);

                GL11.glPushMatrix();
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                GL11.glPushMatrix();
                GL11.glTranslatef(0.8f, 0.8f, 0.0f);

                GL11.glPushMatrix();
                GL11.glScalef(0.9f, 0.9f, 0.9f);

                GL11.glPushMatrix();
                GL11.glRotatef(180, 0, 0, 1);
                GL11.glRotatef(90, 0, 1, 0);

                GL11.glPushMatrix();
                GL11.glRotatef(-45, 0, 1, 0);
                model.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.05f, inv);

                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;

            case EQUIPPED_FIRST_PERSON:
                Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);

                GL11.glPushMatrix();
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                GL11.glPushMatrix();
                GL11.glTranslatef(1f, 0.8f, 0.8f);

                GL11.glPushMatrix();
                GL11.glScalef(1.5f, 1.5f, 1.5f);

                GL11.glPushMatrix();
                GL11.glRotatef(195, 0, 0, 1);

                GL11.glPushMatrix();
                GL11.glRotatef(180, 0, 1, 0);
                model.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.05f, inv);

                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;

            case FIRST_PERSON_MAP:
                break;
        }
    }
}
