package com.mars.smarthouse.utils;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mars.smarthouse.net.decoder.CommInfoProtocol;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ProtocolDataPackage {

	//序列化
	public static byte[] getCommunicationDataInfoToBytes(CommInfoProtocol.CommunicationMessageRequest request){
		return request.toByteArray();
	}



	//反序列化
	public CommInfoProtocol.CommunicationMessageRequest getCommunicationData(byte[] data){
		try {
			return CommInfoProtocol.CommunicationMessageRequest.parseFrom(data);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		return null;
	}
}
