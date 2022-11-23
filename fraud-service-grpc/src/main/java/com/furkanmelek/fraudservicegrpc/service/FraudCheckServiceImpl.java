package com.furkanmelek.fraudservicegrpc.service;

import com.microservices.fraudgrpc.FraudCheck.FraudCheckRequest;
import com.microservices.fraudgrpc.FraudCheck.FraudCheckResponse;
import com.microservices.fraudgrpc.FraudCheckServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class FraudCheckServiceImpl extends FraudCheckServiceGrpc.FraudCheckServiceImplBase {
    @Override
    public void isFraudulentCustomer(FraudCheckRequest request, StreamObserver<FraudCheckResponse> responseObserver) {

        FraudCheckResponse response = FraudCheckResponse.newBuilder().setIsFraudster(
                        request.getName().equalsIgnoreCase("Ali") || request.getSurname().equalsIgnoreCase("Veli"))
                .build();

        System.out.println("Fraud check for customer " + request.getName() + " " + request.getSurname() + " is " + response.getIsFraudster());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
