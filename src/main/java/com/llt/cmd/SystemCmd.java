package com.llt.cmd;

import com.llt.ssh.Message;
import com.llt.ssh.SSHServer;
import com.llt.ssh.SystemCommand;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.llt.ssh.Constant.BASHCONFIG;

public class SystemCmd {
    public static void show(String s){
        System.out.println(s);
    }

    public static void changeDate(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd mm:HH:ss");
        try {
            Date str =simpleDateFormat.parse(s);
            SSHServer sshServer = CommandContext.getSesion();
            Message ms =sshServer.execute(new SystemCommand("date -s " + " '" + s + "'"));
            if(ms.getReturnCode() == 0)
                System.out.println("成功，现在服务器时间是"+ ms.getMsg());
        } catch (ParseException e) {
            System.out.println("请使用 2018/3/1 11:09:09 这种格式输入");
        }
    }

    public static void showDate(){
        SSHServer sshServer = CommandContext.getSesion();
        Message ms =sshServer.execute(new SystemCommand("date"));
        if(ms.getReturnCode() == 0)
            System.out.println("成功，现在服务器时间是"+ ms.getMsg());
    }

    public static void restartGameServer(){
        SSHServer sshServer = CommandContext.getSesion();
        String cmd = "sh "+ BASHCONFIG + "restartGameServer.sh";
        Message ms = sshServer.execute(new SystemCommand("sh  /home/coovanftp/ftp/apps/s1/proxy/Linux/proxy/proxyHero/run.sh restart "));
        if(ms.getReturnCode() == 0)
            System.out.println("成功");
        else
            System.out.println("失败");
    }
}
