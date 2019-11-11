package me.darkeyedragon.flyingcarpet.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;

@CommandAlias("carpet")
public class CarpetCommand extends BaseCommand {

    @Default
    @Subcommand("create")
    @CommandCompletion("@blocklist")
    @Description("Create a carpet")
    @Syntax("[block]")
    public static void createCarpet(){

    }
}
