package cz.unicorncollege.bt.commands.support;

import cz.unicorncollege.bt.commands.CommandName;

import java.util.List;

public interface GetCommand {

    CommandName perform( List<String> choices);
}
