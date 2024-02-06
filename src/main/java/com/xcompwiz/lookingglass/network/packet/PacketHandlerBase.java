package com.xcompwiz.lookingglass.network.packet;

import net.minecraft.entity.player.EntityPlayer;

import com.xcompwiz.lookingglass.network.LookingGlassPacketManager;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * This class is the parent of the packet handling classes for our network communication. Mostly contains helper
 * functions.
 */
public abstract class PacketHandlerBase {

    /**
     * Called by our packet manager to process packet data
     */
    public abstract void handle(ByteBuf data, EntityPlayer player);

    /**
     * Used by the progeny of this class in order to produce and prepare the buffer for packet data. Includes writing
     * the correct packet id for the packet.
     */
    public static ByteBuf createDataBuffer(Class<? extends PacketHandlerBase> handlerclass) {
        ByteBuf data = Unpooled.buffer();
        data.writeByte(LookingGlassPacketManager.getId(handlerclass));
        return data;
    }

    /**
     * Used by the progeny of this class in order to produce a packet object from the data buffer. Automatically uses
     * our packet channel so that the manager on
     * the other side will receive the packet.
     */
    protected static FMLProxyPacket buildPacket(ByteBuf payload) {
        return new FMLProxyPacket(payload, LookingGlassPacketManager.CHANNEL);
    }
}
