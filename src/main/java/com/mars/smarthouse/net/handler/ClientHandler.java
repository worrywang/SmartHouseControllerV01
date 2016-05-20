package com.mars.smarthouse.net.handler;

import com.alibaba.fastjson.JSON;
import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.bean.iocd.Machine;
import com.mars.smarthouse.bean.protocol.CommunicationRequest;
import com.mars.smarthouse.net.decoder.MsgProtocol;
import com.mars.smarthouse.ui.subpanel.MainPanel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/5/4.
 */
public class ClientHandler extends SimpleChannelInboundHandler<MsgProtocol.MsgResponse> {
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, MsgProtocol.MsgResponse msg) throws Exception {
		System.out.println("TestClientHandler--channelRead0: is reading...");
		MsgProtocol.Head head = msg.getHead();
		MsgProtocol.Content content = msg.getContent();
//		System.out.println("[content]: id=" + head.toString() + "; body=" + content.getMsgList());
		for (MsgProtocol.Msg e: content.getMsgList()){
			System.out.println("current msg id: " + e.getId() + " ; type: " + e.getType());

//			String value = Arrays.toString(e.getBody().toByteArray());
			String value = e.getBody().toStringUtf8();
//			value = e.getBody().toString();
			System.out.println("value : "+value);
			//前期测试
			Device device = JSON.parseObject(value,Device.class);
//			System.out.println(device.getId());
			//传输数据
			CommunicationRequest cr = JSON.parseObject(value,CommunicationRequest.class);

			if (cr.getBuilding()!=null) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						MainPanel.mainPad.setBuilding(cr.getBuilding());
						MainPanel.mainPad.setStreetRootMonitor(true);
					}
				});
//				MainPanel.mainPad.setBuilding(cr.getBuilding());
//				MainPanel.mainPad.setStreetRootMonitor(true);

			}
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("[" + ctx.channel().remoteAddress() + "] : throw an exception......");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("[" + ctx.channel().remoteAddress() + "] : is inactive......");

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("[" + ctx.channel().remoteAddress() + "] : is active......");
	}
}
