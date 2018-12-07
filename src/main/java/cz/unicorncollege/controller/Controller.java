package cz.unicorncollege.controller;

import cz.unicorncollege.bt.commands.CommandName;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Controller {

    protected List<String> initChoices(Set<? extends CommandName> commandNames){
        return commandNames.stream()
                .map(CommandName::getDescription)
                .collect(Collectors.toList());
    }
}
