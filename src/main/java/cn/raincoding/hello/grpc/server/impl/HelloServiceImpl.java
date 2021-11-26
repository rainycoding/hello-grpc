package cn.raincoding.hello.grpc.server.impl;

import cn.raincoding.hello.grpc.service.HelloRequest;
import cn.raincoding.hello.grpc.service.HelloResponse;
import cn.raincoding.hello.grpc.service.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author zengqm
 * @date 2021/11/26 10:08
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = "hello " + request.getFirstName() + " " + request.getLastName();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
