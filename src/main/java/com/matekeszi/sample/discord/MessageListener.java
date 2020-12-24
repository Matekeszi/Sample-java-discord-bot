package com.matekeszi.sample.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter {

  //Lets override onMessageReceived and add the !sampleBot-help command.
  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    if(event.getMessage().getContentRaw().equals("!sampleBot-help")) {
      event.getMessage().getChannel().sendMessage("This is the help commands answer").queue();
    }
  }
}
