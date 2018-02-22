package com.llt.model;

/**
 * 连接信息
 */
public class SSHConfig {
    private int id;
    private String ip;
    private int port;
    private String name;
    private String password;


    public int getPort() {
        return port;
    }

    public SSHConfig(int id, String ip, int port, String name, String password) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.name = name;
        this.password = password;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public SSHConfig() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}