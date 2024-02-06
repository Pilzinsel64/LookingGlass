package com.xcompwiz.lookingglass.utils;

import net.minecraft.util.Vec3;

import io.netty.buffer.ByteBuf;

public class MathUtils {

    public static Vec3 readCoordinates(ByteBuf data) {
        Vec3 coords = Vec3.createVectorHelper(data.readDouble(), data.readDouble(), data.readDouble());
        return coords;
    }

}
