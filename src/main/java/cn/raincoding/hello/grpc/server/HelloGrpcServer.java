package cn.raincoding.hello.grpc.server;

import cn.raincoding.hello.grpc.server.impl.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author zengqm
 * @date 2021/11/26 10:53
 */
public class HelloGrpcServer {

    private static final int PORT = 1111;

    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(PORT)
                    .addService(new HelloServiceImpl())
                    .build();
            server.start();
            System.out.println("Server started, listening on " + PORT);
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
