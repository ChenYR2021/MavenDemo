package design.facade.facade;

public class Client {
    public static void main(String[] args) {
        FamilyCinemaFacade facade = new FamilyCinemaFacade();
        facade.startWatch();
        facade.pauseWatch();
        facade.stopWatch();
    }
}
