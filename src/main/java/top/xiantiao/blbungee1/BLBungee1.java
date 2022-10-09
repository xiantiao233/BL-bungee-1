package top.xiantiao.blbungee1;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.bungee.event.message.passive.MiraiFriendMessageEvent;
import me.dreamvoid.miraimc.bungee.event.message.passive.MiraiGroupMessageEvent;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.event.TargetedEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

import java.util.function.Supplier;

public class BLBungee1 extends Plugin implements Listener {
    public static BLBungee1 Plugin;

    public static String bot;
    @Override
    public void onEnable() {
        Plugin = this;
        bot = "MiraiBot.getBot(671004109).getGroup(933389818))";
        getProxy().getPluginManager().registerListener(this, this);
        getProxy().getPluginManager().registerListener(this, new QQ());
        installCMD();

        getLogger().info("BLBungee-1加载成功");
    }
    @Override
    public void onDisable() {
        Plugin = null;
        getLogger().info("BLBungee-1卸载成功");
    }
    @EventHandler
    public void ServerDisconnect(ServerDisconnectEvent player, ServerInfo target) {
        BLBungee1.Plugin.getLogger().info("12345678");
        MiraiBot.getBot(671004109).getGroup(933389818).sendMessage("玩家"  + player.getPlayer().getName() +"退出了服务器");
    }

    @EventHandler
    public void onServerDisconnect(ServerDisconnectEvent player, ServerInfo target) {
        BLBungee1.Plugin.getLogger().info("12345678");
        MiraiBot.getBot(671004109).getGroup(933389818).sendMessage("玩家"  + player.getPlayer().getName() +"退出了服务器");
    }

    private void installCMD() {
        getProxy().getPluginManager().registerCommand(this, new Hub("hub"));
    }
}
