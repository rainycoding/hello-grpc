package cn.raincoding.hello.grpc.client;

import cn.raincoding.hello.grpc.service.HelloRequest;
import cn.raincoding.hello.grpc.service.HelloResponse;
import cn.raincoding.hello.grpc.service.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author zengqm
 * @date 2021/11/26 10:56
 */
public class HelloGrpcClient {

    private static final int PORT = 1111;

    public static void main(String[] args) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("127.0.0.1", PORT)
                    .usePlaintext()
                    .build();
            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            HelloResponse helloResponse = stub.hello(
                    HelloRequest.newBuilder()
                            .setFirstName("zhang")
                            .setLastName("san")
                            .build());
            System.out.println(helloResponse.getGreeting());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
