package cz.unicorncollege.controller;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.CommandName;
import cz.unicorncollege.bt.commands.MainControllerCommandName;
import cz.unicorncollege.bt.commands.support.GetCommand;
import cz.unicorncollege.bt.commands.support.Process;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Controller {

    protected List<String> initChoices(Set<? extends CommandName> commandNames){
        return commandNames.stream()
                .map(CommandName::getDescription)
                .collect(Collectors.toList());
    }

    protected void run(Map<? extends CommandName, Command> commands, Process program, GetCommand getCommand) {
        List<String> choices = initChoices(commands.keySet());
        while (program.run())
            performCommands(commands, choices, getCommand);
    }

    private void performCommands(Map<? extends CommandName, Command> commands, List<String> choices,GetCommand getCommand) {
        try {
            commands.get(getCommand.perform(choices)).perform();
        }catch (MainControllerCommandName.UnknownCommandException e){
            System.out.println("You have typed unknown command, use known command");
        }
    }

}
