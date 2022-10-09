package top.xiantiao.blbungee1;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Hub extends Command {
    public Hub(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage("§c后台不能使用此命令!");
            return;
        } else {
            ProxiedPlayer p = (ProxiedPlayer)sender;
            p.connect(ProxyServer.getInstance().getServerInfo("lobby"));
        }

    }
}


