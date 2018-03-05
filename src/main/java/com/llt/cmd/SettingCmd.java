package com.llt.cmd;

import com.llt.model.Context;
import com.llt.model.SSHConfig;
import com.llt.ssh.SSHServer;

import java.util.HashMap;

public class SettingCmd {

    public static  void listServer(){

        System.out.println("支持的连接有：");
        for (SSHConfig value : CommandContext.getConfig()) {
            System.out.println(value.getId() + ". ip为" + value.getIp()  );
        }
        System.out.println("当前连接编号是 "+ CommandContext.getConfig().get(CommandContext.getCurConnect()).getId());
    }

    public static  void changeServer(String id){
        CommandContext.reloadSession(Integer.valueOf(id));
        System.out.println("当前连接编号是 "+ CommandContext.getConfig().get(CommandContext.getCurConnect()).getId());
    }
}
