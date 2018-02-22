package com.llt.ssh;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.llt.model.SSHConfig;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class SSHServerTest {

    @Test
    public void loadConfig() {
        SSHConfig sshConfig = new SSHConfig(1,"10.0.6.182",22,"root","yxh=123456");
        new SSHServer().loadConfig(sshConfig);
    }

    @Test
    public void execute() {
        SSHConfig sshConfig = new SSHConfig(1,"10.0.6.182",22,"root","yxh=123456");
        SSHServer sshServer = new SSHServer();
        sshServer.loadConfig(sshConfig);
        sshServer.execute((session)->{
            Channel channel = null;
            try {
                channel = session.openChannel("exec");
                ChannelExec channelExec = (ChannelExec)channel;
                channelExec.setCommand("date ");

                channelExec.setInputStream(null);
                BufferedReader input = new BufferedReader(new InputStreamReader
                        (channelExec.getInputStream()));

                channelExec.connect();
                System.out.println("The remote command is : date" );

                //接收远程服务器执行命令的结果
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
                input.close();

                // 得到returnCode
                if (channelExec.isClosed()) {
                    int returnCode = channelExec.getExitStatus();
                }

                // 关闭通道
                channelExec.disconnect();
            } catch (JSchException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        });
    }
}