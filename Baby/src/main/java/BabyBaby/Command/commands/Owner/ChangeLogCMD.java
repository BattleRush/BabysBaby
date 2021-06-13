package BabyBaby.Command.commands.Owner;

import java.util.LinkedList;

import BabyBaby.Command.CommandContext;
import BabyBaby.Command.OwnerCMD;
import BabyBaby.Command.StandardHelp;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class ChangeLogCMD implements OwnerCMD {

    @Override
    public String getName() {
        return "anim";
    }

    @Override
    public void handleOwner(CommandContext ctx) {
        String result = "<:plusplus:816779826202411038> ";

        LinkedList<Emote> emo = new LinkedList<>();
        
        for (String var : ctx.getArgs()) {
            emo.add(ctx.getGuild().getEmotesByName(var, true).get(0));
        }

        for (Emote var : emo) {
            result += var.getAsMention() + " ";
        }
        Message tmp = ctx.getChannel().sendMessage(result).complete();

        for (Emote var : emo) {
            tmp.addReaction(var).complete();
        }
    }

    @Override
    public MessageEmbed getOwnerHelp(String prefix) {
        return StandardHelp.Help(prefix, getName(), "<emote id> {emote id}", "To send animated emotes for changelog");
    }
    
}
