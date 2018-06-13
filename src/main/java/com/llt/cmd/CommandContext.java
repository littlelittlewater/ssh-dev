package com.llt.cmd;

import com.llt.model.SSHConfig;
import com.llt.model.SSHServer;

import java.util.ArrayList;
import java.util.List;

/**
 *   上下语境
 */
public class CommandContext {

    private static List<SSHConfig> config = new ArrayList<>();
    public static SSHServer sshServer =null;

    /**
     * 一定要设置为静态语句块才会执行
     */
    static {

        if(sshServer ==null){
            sshServer =new SSHServer();
            sshServer.loadConfig(config.get(1));
        }
    }


    public static SSHServer getSesion(){
        return sshServer;
    }

    public static int reloadSession(int id){
        SSHConfig thisConfig = config.get(id);
        if(thisConfig == null){
            return -1;
        }

        sshServer.reload(thisConfig);
        return 0;
    }

    public static List<SSHConfig> getConfig() {
        return config;
    }

    public static void setConfig(List<SSHConfig> config) {
        CommandContext.config = config;
    }

    public static SSHServer getSshServer() {
        return sshServer;
    }

    public static void setSshServer(SSHServer sshServer) {
        CommandContext.sshServer = sshServer;
    }

    public static int getCurConnect() {

        return  sshServer.getCurConfig().getId();
    }
}
