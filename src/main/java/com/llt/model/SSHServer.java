package com.llt.model;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.llt.command.LoggerCommand;
import com.llt.command.Message;
import com.llt.command.SSHCommand;

/**
 * 连接管理
 */
public class SSHServer {
    //当前配置
    private SSHConfig curConfig;
    private Session curSession;
    private LoggerCommand loggerCommand = new LoggerCommand();
    private String appUrl;
    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
    public void loadConfig(SSHConfig sshConfig){
        curConfig = sshConfig;
         load();

    }

    private void load() {
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
        curSession =  session;
    }

    public Message execute(SSHCommand sshCommand){
        Message  message = null;
        message = sshCommand.execute(curSession);
        loggerCommand.setMessage(message);
        loggerCommand.execute(curSession);
        return message;

    }

    public void reload(SSHConfig sshConfig) {
       curConfig =sshConfig;
       load();
    }

    public SSHConfig getCurConfig() {
        return curConfig;
    }

    public void setCurConfig(SSHConfig curConfig) {
        this.curConfig = curConfig;
    }

    public Session getCurSession() {
        return curSession;
    }

    public void setCurSession(Session curSession) {
        this.curSession = curSession;
    }
}
