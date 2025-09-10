package com.multi.designpattern;
//Factory Pattern
/*
<aside>
 팩토리 패턴(Factory Pattern)은 객체를 생성하는 인터페이스를 정의하되, 어떤 클래스의 인스턴스를 생성할지는
 서브클래스에서 결정하도록 하는 디자인 패턴입니다.
 객체 생성의 세부사항을 캡슐화하여 클라이언트 코드와 객체 생성 로직을 분리할 수 있어, 코드의 유연성과 확장성을 높이는 데 유용합니다.
 팩토리 패턴에는 주로 **단순 팩토리(Simple Factory)**, **팩토리 메소드(Factory Method)**,
 그리고 **추상 팩토리(Abstract Factory)**의 세 가지 주요 변형이 있습니다. 각 변형은 사용 목적과 구현 방식이 다르므로, 이를 각각 살펴보겠습니다.
</aside>
*/

interface Product{
    void use();
}

class ProductA implements Product{
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

class ProductB implements Product{
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

class SimpleFactory{
    public static Product createProduct(String type) /*throws Exception*/{//업캐스트
        if(type.equals("A")){
            return new ProductA();
        } else if (type.equals("B")) {
            return new ProductB();
        } //else if
        // throw new IllegalArgumentException("Unkown product type");
        return null;
    } //createProduct


}

public class FactoryMain {
    Product product=SimpleFactory.createProduct("ProductA");
}
