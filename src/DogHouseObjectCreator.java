public class DogHouseObjectCreator {
    public static void main(String[] args){
//using constructor
        DogHouseBluePrint MarksDogHouse = new DogHouseBluePrint("MarksDog");
        DogHouseBluePrint LukesDogHouse = new DogHouseBluePrint("LukesDog");


        System.out.println(MarksDogHouse.getName());
        System.out.println(LukesDogHouse.getColor());

    }
}
