package com.mars.smarthouse.bootstrap;

import com.mars.smarthouse.constant.InitConfig;
import com.mars.smarthouse.constant.Setting;
import com.mars.smarthouse.constant.ThemeList;
import com.mars.smarthouse.net.decoder.MsgProtocol;
import com.mars.smarthouse.net.decoder.MsgRequestEncoder;
import com.mars.smarthouse.net.decoder.MsgResponseDecoder;
import com.mars.smarthouse.net.handler.ClientHandler;
import com.mars.smarthouse.ui.subpanel.MainPanel;
import com.mars.smarthouse.utils.ModuleTool;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


/**
 * Created by Administrator on 2016/5/1.
 */
public class SmatHouseBootstrap extends Application{

	public static String current_font_level = ThemeList.font_level_1;
	public static String current_theme = ThemeList.default_theme;
	private Stage stage;
	private Group root;
	private MainPanel mainPanel;

	//netty client
	private static EventLoopGroup group;
	private static Bootstrap b;

	public static void main(String[] args) throws Exception{

		launch(args);
	}

	static {
		new Thread(){
			public void run(){
				try {
					createNettyClient();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//todo: 后台对象构建
		//创建netty client客户端
//		new Thread(){
//			public void run(){
//				try {
//					createNettyClient();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}.start();


		//界面生成
		this.stage = primaryStage;
		root = new Group();
		mainPanel = new MainPanel(stage);
		root.getChildren().add(mainPanel);
//		primaryStage.initStyle(StageStyle.TRANSPARENT);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setHeight(768);
		stage.setWidth(1366);

		scene.widthProperty().addListener((observable,oldVaule,newValue)->{mainPanel.setPrefWidth(observable.getValue().doubleValue());
			double current_width = observable.getValue().doubleValue();
			if(current_width<1024){
				current_font_level = ThemeList.font_level_1;
			}else if(current_width<1280){
				current_font_level = ThemeList.font_level_2;
			}else if(current_width<1600){
				current_font_level = ThemeList.font_level_3;
			}else{
				current_font_level = ThemeList.font_level_4;
			}
			System.out.println("current font level: "+current_font_level);
			ModuleTool.setTheme(mainPanel, current_theme, current_font_level);
		});
		scene.heightProperty().addListener((observable,oldValue,newValue)->{mainPanel.setPrefHeight(observable.getValue().doubleValue());});

		stage.show();

		//todo: 全屏模式待修改，取消ESC退出选项
//		stage.setFullScreen(true);
//		stage.setResizable(false);

		//关闭程序
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.out.println("stop javafx client...");
				group.shutdownGracefully();

				System.exit(-1);
			}
		});

	}

	private static void createNettyClient() throws Exception{
		new Thread(){
			@Override
			public void run() {
//				super.run();
				//配置客户端NIO线程
				try {
					group = new NioEventLoopGroup();
					b = new Bootstrap();
					b.group(group).channel(NioSocketChannel.class);
					b.handler(new ChannelInitializer<Channel>() {
						@Override
						protected void initChannel(Channel ch) throws Exception {
							ChannelPipeline pipeline = ch.pipeline();
							pipeline.addLast("frameDecoder", new MsgResponseDecoder());
							//decode
							pipeline.addLast(new ProtobufDecoder(MsgProtocol.MsgResponse.getDefaultInstance()));
							//encode
							pipeline.addLast(new ProtobufEncoder());
							pipeline.addLast("frameEncoder", new MsgRequestEncoder());
							pipeline.addLast("handler", new ClientHandler());
						}
					});
					Setting.CHANNEL = b.connect(InitConfig.HOST, InitConfig.TCP_PORT).sync().channel();
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally {
//					System.out.println("关闭连接--------");
//					group.shutdownGracefully();
				}
			}
		}.start();

//		ClientHandler handler = channel.pipeline().get(ClientHandler.class);
	}

}
