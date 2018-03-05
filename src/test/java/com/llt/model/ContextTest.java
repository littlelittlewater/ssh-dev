package com.llt.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContextTest {

    @Test
    public void saveToFiles() {
        Context context = Context.getContext();

        Project p1 = new Project(1,"刀塔传奇");
        Project p2 = new Project(2, "王者荣耀");
        Project p3 = new Project(3, "小米超神");
        SSHConfig s1 = new SSHConfig(1,"10.0.6.182",22,"root","yxh=123456");
        SSHConfig s2 = new SSHConfig(2,"10.0.6.182",22,"root","yxh=123456");
        SSHConfig s3 = new SSHConfig(3,"10.0.6.182",22,"root","yxh=123456");
        SSHConfig[] sz1 = {s1,s2} ;
        p1.setSshConfig(sz1);
        Project[] list = {p1,p2,p3};
        context.setProject(list);
        context.saveToFiles();
    }


    @Test
    public void getFromFiles() {
        System.out.println(Context.getContext().getFromFiles().getProject().length);
    }
}