package com.llt.ssh;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class UpFileCommand implements SSHCommand {
    private String localPath;
    private String targetPath;

    public UpFileCommand(String localPath, String targetPath) {
        this.localPath = localPath;
        this.targetPath = targetPath;
    }

    @Override
    public Message execute(Session session) {

        Channel channel = null;
        try {
            //创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;
            //以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
            OutputStream outstream = sftp.put(targetPath);
            InputStream instream = new FileInputStream(new File(localPath));

            byte b[] = new byte[1024];
            int n;
            while ((n = instream.read(b)) != -1) {
                outstream.write(b, 0, n);
            }

            outstream.flush();
            outstream.close();
            instream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(1,"copy file "+localPath+" to "+targetPath,"Exception ");
        } finally {
            channel.disconnect();
        }

        return new Message(0,"copy file "+localPath+" to "+targetPath,"success");
    }
}
