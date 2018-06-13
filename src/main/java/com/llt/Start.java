package com.llt;

import com.llt.command.*;
import com.llt.model.Context;

import com.llt.model.SSHServer;
import com.llt.util.DateUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.llt.command.Constant.BAKEPATH;
import static com.llt.command.Constant.RESOURCEPATH;

public class Start {
    public static void main(String[] args) {


        Properties pro = new Properties();
        String version ;
        String filename;
        File file = new File(System.getProperty("user.dir")+File.separator+"config");
        try {
            pro.load(new FileInputStream(file));
            version = pro.getProperty("version");
            filename = pro.getProperty("filename");
            switch (version){
                case "182":
                    Context.load182();
                    break;
                case "171":
                    Context.load171();
                    break;
                case "519":
                    Context.load519();
                    break;
                default:
                    System.out.println("配置错误");
                    return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String dateName = DateUtil.getStringAllDate();
        Context.getContext().getSshServers().stream()
                .forEach(sshServer -> {
                    //初始化
                    sshServer.execute(new InitCommand());
                    System.out.println("初始化完成，开始服务文件");
                    //备份文件
                    sshServer.execute(new SystemCommand("tar -cvf "+BAKEPATH+"server"+dateName + ".tar.gz  "+sshServer.getAppUrl()+" --exclude Log"));

                    System.out.println("备份文件完成，开始上传文件");
                   // File file = new File(System.getProperty("user.dir")+File.separator+"1zip");
                    String [] fileName = file.list();
                    System.out.println("上传文件完成");
                    //上传补丁包
                    String upFile = RESOURCEPATH+"wzdt_cn_server_v6.000.8.zip" ;
                    sshServer.execute(new UpFileCommand("1.txt",RESOURCEPATH+"2.txtcd"));

                    //关闭服务的命令
                   /* String[] stop = {
                            "service php-fpm stop",
                            "cd /home/coovanftp/ftp/apps/s1/proxy/Linux/proxy/proxyHero && sh run.sh stop",
                            "killall memcached",
                    };*/
                    //   Arrays.stream(stop).forEach(s -> sshServer.execute(new SystemCommand(s)));

                    //开启服务的命令

                /*    String[] start = {
                            "service php-fpm start",
                            "cd /home/coovanftp/ftp/apps/s1/proxy/Linux/proxy/proxyHero && sh run.sh start",
                            "memcachedstart",
                    };
                   Arrays.stream(start).forEach(s -> sshServer.execute(new SystemCommand(s)));*/
                    //解压文件
                    //sshServer.execute(new SystemCommand("unzip -o "+ upFile+" -d  "+ sshServer.getAppUrl()  ));
                });

    }


}
