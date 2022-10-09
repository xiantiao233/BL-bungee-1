package top.xiantiao.blbungee1;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.bungee.event.message.passive.MiraiFriendMessageEvent;
import me.dreamvoid.miraimc.bungee.event.message.passive.MiraiGroupMessageEvent;
import net.md_5.bungee.api.ServerConnectRequest;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.Iterator;
import java.util.Locale;

public class QQ implements Listener {
    @EventHandler
    public void onFriendMessageReceive(MiraiFriendMessageEvent e){
        if(e.getMessage().equals("在线人数")) {
            MiraiBot.getBot(e.getBotID()).getFriend(e.getSenderID()).sendMessage("当前在线人数：" + BLBungee1.Plugin.getProxy().getPlayers().size()+ "人");
        }
    }
    @EventHandler
    public void onGroupMessageReceive(MiraiGroupMessageEvent e){
        if(e.getMessage().equals("在线人数")) {
            MiraiBot.getBot(e.getBotID()).getGroup(e.getGroupID()).sendMessage("当前在线人数：" + BLBungee1.Plugin.getProxy().getPlayers().size()+"人");
        }
    }

    @EventHandler
    public void onlogin(PostLoginEvent event) {
        BLBungee1.Plugin.getLogger().info("12345678");
        MiraiBot.getBot(671004109).getGroup(933389818).sendMessage("玩家" +event.getPlayer().getName() +"进入了服务器");
    }

    @EventHandler
    public void onServerDisconnect(PlayerDisconnectEvent event) {
        BLBungee1.Plugin.getLogger().info("12345678");
        MiraiBot.getBot(671004109).getGroup(933389818).sendMessage("玩家" +event.getPlayer().getName() +"退出了服务器");
    }
    @EventHandler
    public void ServerConnectEvent(ServerConnectEvent event, ProxiedPlayer player, ServerInfo target, ServerConnectEvent.Reason reason, ServerConnectRequest request) {
        MiraiBot.getBot(671004109).getGroup(933389818).sendMessage("玩家" +event.getPlayer().getName() +"链接到了" + target.getName()+"服务器");
    }
    @EventHandler
    public void onPlayerSend(ChatEvent e){
        String m = BLBungee1.Plugin.getProxy().getPlayer(String.valueOf(e.getSender())).getServer().getInfo().getName();
        String PN = String.valueOf(BLBungee1.Plugin.getProxy().getPlayer(String.valueOf(e.getSender())));
        String msg = e.getMessage();
        if(m.equals("Pure_existence")){
            String M = "纯净生存";
            SendPtoG(M,PN,msg);
        }

    }

    public void SendPtoG(String ServerName, String PlayerName, String Message){
        MiraiBot.getBot(671004109).getGroup(933389818).sendMessage("["+ServerName+"]\r玩家"+PlayerName+"说\r"+Message);
    }

    @EventHandler
    public void onGroupSend(MiraiGroupMessageEvent e) {
        if (e.getGroupID() == 933389818) {
            BLBungee1.Plugin.getLogger().info(e.getMessage());
            Iterator var17 = BLBungee1.Plugin.getProxy().getPlayers().iterator();
            while (var17.hasNext()) {
                ProxiedPlayer player1 = (ProxiedPlayer) var17.next();
                player1.sendMessage("["+e.getSenderName()+"]:"+e.getMessage());
            }
        }
    }
}
