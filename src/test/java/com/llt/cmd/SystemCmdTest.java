package com.llt.cmd;

import org.junit.Test;

import static org.junit.Assert.*;

public class SystemCmdTest {

    @Test
    public void show() {
    }

    @Test
    public void changeDate() {
        SystemCmd.changeDate("2018/03/05 11:21:22");
    }

    @Test
    public void restartGameServer() {
        SystemCmd.restartGameServer();
    }
}