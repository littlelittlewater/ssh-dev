package com.llt.model;

import java.io.Serializable;

public class Project implements Serializable{
    private int id;
    private String name ;

    public SSHConfig[] getSshConfig() {
        return sshConfig;
    }

    public void setSshConfig(SSHConfig[] sshConfig) {
        this.sshConfig = sshConfig;
    }

    private SSHConfig[] sshConfig;

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
