package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.MathHelper;
import org.apache.commons.lang3.Validate;

public class S29PacketSoundEffect implements Packet
{
    private String field_149219_a;
    private int field_149217_b;
    private int field_149218_c = Integer.MAX_VALUE;
    private int field_149215_d;
    private float field_149216_e;
    private int field_149214_f;
    private static final String __OBFID = "CL_00001309";

    public S29PacketSoundEffect() {}

    public S29PacketSoundEffect(String p_i45200_1_, double p_i45200_2_, double p_i45200_4_, double p_i45200_6_, float p_i45200_8_, float p_i45200_9_)
    {
        Validate.notNull(p_i45200_1_, "name", new Object[0]);
        this.field_149219_a = p_i45200_1_;
        this.field_149217_b = (int)(p_i45200_2_ * 8.0D);
        this.field_149218_c = (int)(p_i45200_4_ * 8.0D);
        this.field_149215_d = (int)(p_i45200_6_ * 8.0D);
        this.field_149216_e = p_i45200_8_;
        this.field_149214_f = (int)(p_i45200_9_ * 63.0F);
        p_i45200_9_ = MathHelper.clamp_float(p_i45200_9_, 0.0F, 255.0F);
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer data) throws IOException
    {
        this.field_149219_a = data.readStringFromBuffer(256);
        this.field_149217_b = data.readInt();
        this.field_149218_c = data.readInt();
        this.field_149215_d = data.readInt();
        this.field_149216_e = data.readFloat();
        this.field_149214_f = data.readUnsignedByte();
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer data) throws IOException
    {
        data.writeString(this.field_149219_a);
        data.writeInt(this.field_149217_b);
        data.writeInt(this.field_149218_c);
        data.writeInt(this.field_149215_d);
        data.writeFloat(this.field_149216_e);
        data.writeByte(this.field_149214_f);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayClient handler)
    {
        handler.handleSoundEffect(this);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandler handler)
    {
        this.processPacket((INetHandlerPlayClient)handler);
    }
}
