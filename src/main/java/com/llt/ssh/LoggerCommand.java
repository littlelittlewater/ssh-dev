package com.llt.ssh;

import com.jcraft.jsch.Session;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于记录每次的操作记录
 */
public class LoggerCommand implements SSHCommand{
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    private Message message;

    public LoggerCommand(Message message) {
        this.message = message;
    }

    public LoggerCommand() {
    }

    @Override
    //TODO 无法解决双引号截断的问题  可以执行用户
    public Message execute(Session session) {
        String name = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String command = "echo \"" + message.toFormatString()+"\" >> "+name+".log" ;
        return new SystemCommand(command).execute(session);
    }
}
