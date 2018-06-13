package com.llt.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 維持所有的连接
 */
public class Context implements Serializable {
    private static  Context context = new Context();
    private static List<SSHServer> sshServers = new ArrayList<>();

    public static void load182() {

    }

    public static void load171() {

    }

    public static void load519() {
    }


    public void saveToFiles()
    {

    }

    public Context getFromFiles()
    {
        return this;
    }


}
