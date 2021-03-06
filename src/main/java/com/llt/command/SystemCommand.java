package com.llt.command;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 系统级别调用，如修改时间，重启电脑。
 */
public class SystemCommand implements SSHCommand {
    private String command;

    public SystemCommand(String command) {
        this.command = command;
    }

    @Override
    public Message execute(Session session)  {
        StringBuffer message = new StringBuffer();
        int  returnCode = 0;
        try {
            //打开通道，设置通道类型，和执行的命令
            Channel channel = session.openChannel("exec");
            ChannelExec channelExec = (ChannelExec)channel;
            channelExec.setCommand(command);

            channelExec.setInputStream(null);
            BufferedReader input = new BufferedReader(new InputStreamReader
                    (channelExec.getInputStream()));

            channelExec.connect();
            String line;
            while ((line = input.readLine()) != null) {
                message.append(line);
            }
            input.close();

            // 得到returnCode
            if (channelExec.isClosed()) {
                returnCode = channelExec.getExitStatus();
            }
            // 关闭通道
            channelExec.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message(returnCode,command,message.toString());
    }
}
