public class Player {
    private final String name;
    private final String color;

    /**
     * player constructor that initializes the player's name and color
     * @param name the given name
     * @param color the given color (white or black)
     */
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * gets the color of the player
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * gets the name of the player
     * @return name
     */
    public String getName() {
        return name;
    }


}
