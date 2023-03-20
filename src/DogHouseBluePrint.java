public class DogHouseBluePrint {

    //INSTANCE VARIABLES
    private int height, width;
    private String name, color;


    //constructor
    public DogHouseBluePrint(String name){
        this.name =name;
        this.color="Blue";

            }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

}