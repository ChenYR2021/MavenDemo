package spring.proxy.service.impl;

import spring.proxy.service.UsbSell;

public class UsbKingFactory implements UsbSell {
    @Override
    public float sell(int num) {
        System.out.println("UsbSell实现类，开始卖东西了，原价是85元");
        return 85.0f;
    }
}
