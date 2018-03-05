package com.llt.cmd;

import com.llt.model.Context;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettingCmdTest {

    @Test
    public void listServer() {
        SettingCmd.listServer();
    }


    @Test
    public void changeServer() {
        SettingCmd.changeServer(0+"");
        SystemCmd.showDate();
        SettingCmd.changeServer(1+"");
        SystemCmd.showDate();
        SettingCmd.changeServer(0+"");
        SystemCmd.showDate();
    }
}