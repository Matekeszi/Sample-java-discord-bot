package com.matekeszi.sample.discord;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class SampleDiscordBot {

  public static void main(String[] args) throws InterruptedException, LoginException {

    //args[0] will contain the token of your bot. It shouldn't be hardcoded for security reasons
    JDA jda = JDABuilder.createDefault(args[0])
        /*With this combination of policy and intent, the application will cache all members,
         and update the cache on member update/leave/join.*/
        .setMemberCachePolicy(MemberCachePolicy.ALL)
        .enableIntents(GatewayIntent.GUILD_MEMBERS)
        .setChunkingFilter(ChunkingFilter.ALL)
        //TODO: Add event listener: .addEventListener()
        //It will set the bots activity to !sampleBot-help, so users will know the help command for this bot.
        //TODO: Add the actual help command.
        .setActivity(Activity.playing("!sampleBot-help"))
        .build();
    //We should wait until the connection is ready
    jda.awaitReady();
  }
}
