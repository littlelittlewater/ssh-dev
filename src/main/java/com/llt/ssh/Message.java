package com.llt.ssh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private int returnCode;
    private String command;

    public Message(int returnCode, String command, String msg) {
        this.returnCode = returnCode;
        this.command = command;
        this.msg = msg;
    }

    public String getCommand() {

        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    private String msg;

    public int getReturnCode() {
        return returnCode;
    }


    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "returnCode=" + returnCode +
                ", command='" + command + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String toFormatString() {
        String date = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return  "["+date+"]  "+
                "returnCode:" + returnCode +
                ",command:" + command +
                ",msg:" + msg ;
    }
}
