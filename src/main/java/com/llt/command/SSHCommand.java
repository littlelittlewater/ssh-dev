package com.llt.command;

import com.jcraft.jsch.Session;

public interface SSHCommand {
    Message execute(Session session);
}
