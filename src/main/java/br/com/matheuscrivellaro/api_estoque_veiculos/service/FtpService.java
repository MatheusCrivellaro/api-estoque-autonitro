package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Service
public class FtpService {

    private final FTPClient ftpClient;

    public FtpService() {
        ftpClient = new FTPClient();
    }

    public void connect(String server, int port, String user, String password) throws IOException {
        ftpClient.connect(server, port);
        ftpClient.login(user, password);
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
    }

    public String downloadFileAsString(String remoteFilePath) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        boolean success = ftpClient.retrieveFile(remoteFilePath, outputStream);
        if (success)
            return outputStream.toString(StandardCharsets.UTF_8);
        else
            throw new IOException("Falha ao baixar o arquivo.");
    }

    public void disconnect() throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }

    public String getXml(String remoteFilePath, String server, int port, String user, String password) throws IOException {
        connect(server, port, user, password);
        String xmlContent = downloadFileAsString(remoteFilePath);
        disconnect();
        return xmlContent;
    }

}
