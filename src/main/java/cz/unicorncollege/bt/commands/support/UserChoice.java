package cz.unicorncollege.bt.commands.support;

import cz.unicorncollege.bt.model.MeetingCentre;

public class UserChoice {
    private String code;
    private int option;
    private static MeetingCentre chosenCenter;

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

    public void set(String input){
        if(input.contains("-") || isGoBackOption(input))
            performSet(input);
    }

    private boolean isGoBackOption(String input){
        return Integer.parseInt(input)==4;
    }


    public static MeetingCentre getChosenCenter() {
        return chosenCenter;
    }

    public static void setChosenCenter(MeetingCentre chosenCenter) {
        UserChoice.chosenCenter = chosenCenter;
    }

    private void performSet(String input){
        if(input.equals("4"))
            setOption(4);
        else
            performSetOfCodeAndOption(input);
    }

    private void performSetOfCodeAndOption(String input){
        String[] split = input.split("-",2);
        setCode(split[1]);
        setOption(Integer.parseInt(split[0]));
    }

}
