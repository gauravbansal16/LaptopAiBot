package examples;

import ai.api.model.Result;

/**
 * Created by Gaurav on 12/01/17.
 */
public class Actions {

    Result result;

    public Actions(Result result) {
        this.result = result;
    }

    public String run(){

        String action=result.getAction();
        if (action.equals("Show_Info")){
            return show_info(result.getStringParameter("SysInfo"));
        }



        else
            return "";

    }

    private String show_info(String device){

        if (device.equals("battery"))
            return "The battery is 84";
        else
            return "";
    }
}
