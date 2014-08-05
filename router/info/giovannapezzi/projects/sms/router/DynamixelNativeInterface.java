package info.giovannapezzi.projects.sms.router;

class DynamixelNativeInterface
{
	public static final int MAXNUM_TXPARAM = 150;
    public static final int MAXNUM_RXPARAM = 60;

    public static final int BROADCAST_ID = 254;
	
	public static final int INST_PING = 1;
    public static final int INST_READ = 2;
    public static final int INST_WRITE = 3;
    public static final int INST_REG_WRITE = 4;
    public static final int INST_ACTION = 5;
    public static final int INST_RESET = 6;
    public static final int INST_SYNC_WRITE = 131;

    public static final int ERRBIT_VOLTAGE = 1;
    public static final int ERRBIT_ANGLE = 2;
    public static final int ERRBIT_OVERHEAT = 4;
    public static final int ERRBIT_RANGE = 8;
    public static final int ERRBIT_CHECKSUM = 16;
    public static final int ERRBIT_OVERLOAD = 32;
    public static final int ERRBIT_INSTRUCTION = 64;

    public static final int COMM_TXSUCCESS = 0;
    public static final int COMM_RXSUCCESS = 1;
    public static final int COMM_TXFAIL = 2;
    public static final int COMM_RXFAIL = 3;
    public static final int COMM_TXERROR = 4;
    public static final int COMM_RXWAITING = 5;
    public static final int COMM_RXTIMEOUT = 6;
	public static final int COMM_RXCORRUPT = 7;

	public static native int initialize();
	public static native void terminate();
	public static native int getBaud();
	public static native void setBaud(int baud);
	public static native int getResult();

	public static native void transmitPacket();
	public static native void receivePacket();
	public static native void trasmitAndReceivePacket();

	public static native void setPacketId(int id);
	public static native void setPacketInstruction(int instruction);
	public static native void setPacketParameter(int index, int value);
	public static native void setPacketLength( int length );
	public static native int getPacketError(int errorBit);
	public static native int getPacketLength();
	public static native int getPacketParameter(int index);

	public static native int makeWord(int lowByte, int highByte);
	public static native int getLowByte(int word);
	public static native int getHighByte(int word);

	public static native void ping(int id);
	public static native int readByte(int id, int address);
	public static native void writeByte(int id, int address, int value);
	public static native int readWord(int id, int address);
	public static native void writeWord(int id, int address, int value);
	
	static
	{
        System.loadLibrary("DynamixelModule");
	}
}
