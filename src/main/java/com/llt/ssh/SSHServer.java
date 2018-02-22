package com.llt.ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.llt.model.SSHConfig;

import java.io.IOException;

public class SSHServer {
    //当前配置
    private SSHConfig curConfig;
    private Session session;
    private LoggerCommand loggerCommand = new LoggerCommand();

    public void loadConfig(SSHConfig sshConfig){
        curConfig = sshConfig;
        session = this.load();

    }

    private Session load() {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(curConfig.getName(), curConfig.getIp(), curConfig.getPort());
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(curConfig.getPassword());
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return session;
    }

    public  Message execute(SSHCommand sshCommand){
        Message  message = null;
        message = sshCommand.execute(session);
        loggerCommand.setMessage(message);
        loggerCommand.execute(session);
        return message;
    }
}
