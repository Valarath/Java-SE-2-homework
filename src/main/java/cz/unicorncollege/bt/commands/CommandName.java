package cz.unicorncollege.bt.commands;

public interface CommandName {

    public static <T extends Enum<T> & CommandName> T  getCommandByNumber(Class<T> clazz, int commandNumber) {
        if(clazz.getEnumConstants().length < commandNumber || 1>commandNumber)
            throw new UnknownCommandException();
            commandNumber--;
        return clazz.getEnumConstants()[commandNumber];
    }

    String getDescription();

    class UnknownCommandException extends RuntimeException{}
}
