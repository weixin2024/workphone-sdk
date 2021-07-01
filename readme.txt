1、建一个名为chat1数据库,编码格式为utf8mb4，MySQL数据库版本建议到8.0以上，不然有些字符低版本的存储不了
2、使用database目录下的脚本初始化表
3、修改application.properties数据库连接信息
4、运行com.jubotech.SpringBootStarter启动服务
5、调试通讯接口略
6、后台http://127.0.0.1:13086/      
客户后台账号密码admin/123456    
管理平台账号密码 root/123456
-----------------上面是管理端账号--------------------
pc端登陆，默认了一个pctest账号，密码是123456，别搞混了

------嵌了一个网页版的pc端------
http://127.0.0.1:13086/web/index.html#/login


**************咨询请加微信happybabby110联系作者*************

读懂application.properties配置文件
#设置springboot端口--管理端web服务使用端口
server.port = 13086
#设置netty的socket端口--手机端sdk使用端口
com.jubotech.netty.socket.port=13087
#设置netty的websocket端口--pc端连接使用端口
com.jubotech.netty.websocket.port=13088

！！！！！！！！！！！超强提示，别搞错了！！！！！！！！！！！
1、手机端连续点击 当前wx版本  修改连接服务端的ip和端口
2、Pc端修改socket.js文件中的对应ip和端口即可
3、局域网调试要保证手机端和服务端在同一个局域网环境


*************************代码示例*******************************
//1、触发手机端推送通讯录列表
//TriggerFriendPushTaskMessage.Builder bd = TriggerFriendPushTaskMessage.newBuilder();
//bd.setWeChatId(req.getWeChatId());
//TriggerFriendPushTaskMessage  resp = bd.build();
//MessageUtil.sendMsg(ctx, EnumMsgType.TriggerFriendPushTask, vo.getAccessToken(), vo.getId(), resp);
