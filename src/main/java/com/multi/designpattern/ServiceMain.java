package com.multi.designpattern;

interface Service{
    void execute();
}

class ServiceImpl implements Service{
    @Override
    public void execute() {
        System.out.println("execute Service");
    }
}

class Client {
    private final Service service;

    // 생성자를 통한 의존성 주입
    public Client(Service service) {
        this.service = service;
    }

    public void performTask() {
        service.execute();
    }
}

public class ServiceMain {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        Client client = new Client(service);
        client.performTask();
    }
}
