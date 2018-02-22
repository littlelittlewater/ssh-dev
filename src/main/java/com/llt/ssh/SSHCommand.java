package com.llt.ssh;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.IOException;

public interface SSHCommand {
    Message execute(Session session);
}
