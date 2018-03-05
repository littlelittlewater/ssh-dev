package com.llt.ssh;

import com.llt.model.SSHConfig;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpFileCommandTest {
    @Test
    public void execute() {
        SSHConfig sshConfig = new SSHConfig(1,"10.0.6.182",22,"root","yxh=123456");
        SSHServer sshServer = new SSHServer();
        sshServer.loadConfig(sshConfig);

        UpFileCommand upFileCommand = new UpFileCommand("D:/1.txt","/root/1.txt");
        Message m =  sshServer.execute(upFileCommand);
        System.out.println(m.toString());
    }
}