public class DogHouseObjectCreator2 {
    public static void main(String[] args){
        DogHouseBluePrint2 RyansDogHouse = new DogHouseBluePrint2();
        DogHouseBluePrint2 CourtneysDogHouse = new DogHouseBluePrint2();


        RyansDogHouse.setName("MyDog's House");
        RyansDogHouse.setColor("Green");
        RyansDogHouse.setHeight(1);
        RyansDogHouse.setWidth(2);

        System.out.println(RyansDogHouse.getName());

        CourtneysDogHouse.setName("Clifford");
        CourtneysDogHouse.setColor("Red");
        CourtneysDogHouse.setHeight(101);
        CourtneysDogHouse.setWidth(100);

        System.out.println(CourtneysDogHouse.getName());
        System.out.println(CourtneysDogHouse.getColor());
    }
}
