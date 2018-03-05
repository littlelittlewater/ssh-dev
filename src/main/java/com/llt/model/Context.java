package com.llt.model;

import java.io.*;
import java.util.List;

import static com.llt.ssh.Constant.LocalConfig;

public class Context implements Serializable{
    private static  Context context = new Context();

    public static void setContext(Context context) {
        Context.context = context;
    }

    public Project[] getProject() {
        return project;
    }

    public void setProject(Project[] project) {
        this.project = project;
    }

    private Project[] project;
    private SSHConfig[] sshConfig;

    public SSHConfig[] getSshConfig() {
        return sshConfig;
    }

    public void setSshConfig(SSHConfig[] sshConfig) {
        this.sshConfig = sshConfig;
    }

    private Context(){

    }

    public static Context getContext(){
        return context;
    }


    public void saveToFiles()
    {
        File file = new File(LocalConfig);
        ObjectOutputStream oout = null;
        try {
            oout = new ObjectOutputStream(new FileOutputStream(file));
            oout.writeObject(project);
            oout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Context getFromFiles()
    {
        File file = new File(LocalConfig);
        ObjectOutputStream oout = null;
        try {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
            project = (Project[]) oin.readObject(); // 没有强制转换到Person类型
            oin.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }
}
