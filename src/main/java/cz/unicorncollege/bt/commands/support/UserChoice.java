package cz.unicorncollege.bt.commands.support;

public class UserChoice {
    private String code;
    private int option;

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public int getOption() {
        return option;
    }

    private void setOption(int option) {
        this.option = option;
    }


    public UserChoice set(String input){
        if(input.contains("-"))
            performSet(input);
        return this;
    }

    private void performSet(String input){
        String[] split = input.split("-",2);
        setCode(split[1]);
        setOption(Integer.parseInt(split[0]));
    }

}
