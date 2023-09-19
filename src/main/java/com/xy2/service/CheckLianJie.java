package com.xy2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

@Slf4j
@Service
public class CheckLianJie {

    public boolean checkOracleIsWorking(String host,String port) {

            boolean b = checkTcpAddressIsAlive(host, port);
            if (b) {
                log.info("=========================");
                log.info("数据库 连接成功 {}, {}",host,port);
                return true;
            } else {
                log.error("!!!!!!!!!!!!!!!!!!!!!!!!!");
                log.error("数据库 连接失败，...{} ,{} ",host,port);
                return false;
            }
    }

    public boolean checkRidsIsWorking(String host,String port) {

        boolean c = checkTcpAddressIsAlive(host, port);
        if (c) {
            log.info("=========================");
            log.info("redis 连接成功 {} {}",host, port);
            return true;
        } else {
            log.error("!!!!!!!!!!!!!!!!!!!!!!!!!");
            log.error("redis 连接失败，程序自动停止...{} {}",host, port);
           return false;
        }
    }



    public static boolean checkTcpAddressIsAlive(String hostName, String port) {
        boolean isAlive = false;
        //  创建一个套接字
        SocketAddress socketAddress = new InetSocketAddress(hostName, Integer.parseInt(port));

        //  超时设置，单位毫秒
        int timeout = 2000;
        try (Socket socket = new Socket()){
            socket.connect(socketAddress, timeout);
            socket.close();
            isAlive = true;
        } catch (SocketTimeoutException exception) {
            System.out.println("SocketTimeoutException  " + hostName + " : " + port + " .  " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("IOException - Unable to connect to  " + hostName + " : " + port + " .  " + exception.getMessage());
        }
        return isAlive;
    }


}
