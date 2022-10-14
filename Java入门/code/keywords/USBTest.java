package com.seu.learn.keywords;

public class USBTest {
    public static void main(String[] args) {
        Computer com = new Computer();
        //1. 创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        com.transferData(flash);
        //2. 创建了接口的非匿名实现类的匿名对象
        com.transferData(new Printer());
        //3. 创建了接口的匿名实现类的非匿名对象
        USB phone = new USB(){
            @Override
            public void start() {
                System.out.println(" 手机开始工作");
            }
            @Override
            public void stop() {
                System.out.println(" 手机结束工作");
            }
        };
        com.transferData(phone);
        //4. 创建了接口的匿名实现类的匿名对象
        com.transferData(new USB(){
            @Override
            public void start() {
                System.out.println("mp3 开始工作");
            }
            @Override
            public void stop() {
                System.out.println("mp3 结束工作");
            }
        });
    }
}

class Computer{
    public void transferData(USB usb){ //USB usb = new Flash();
        usb.start();
        System.out.println(" 具体传输数据的细节");
        usb.stop();
    }
}
interface USB{
    // 常量：定义了长、宽、最大、最小的传输速度等
    void start();
    void stop();
}
class Flash implements USB{
    @Override
    public void start() {
        System.out.println("U 盘开始工作");
    }
    @Override
    public void stop() {
        System.out.println("U 盘结束工作");
    }
}
class Printer implements USB{
    @Override
    public void start() {
        System.out.println(" 打印机开启工作");
    }
    @Override
    public void stop() {
        System.out.println(" 打印机结束工作");
    }
}

