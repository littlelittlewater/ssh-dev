package com.llt.ssh;

import com.llt.model.SSHConfig;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerCommandTest {

    @Test
    public void execute() {
        SSHConfig sshConfig = new SSHConfig(1,"10.0.6.182",22,"root","yxh=123456");
        SSHServer sshServer = new SSHServer();
        sshServer.loadConfig(sshConfig);

        LoggerCommand systemCommand = new LoggerCommand(new Message(0,"date","1 3"));
        Message m =  sshServer.execute(systemCommand);
        System.out.println(m.toString());
    }
}