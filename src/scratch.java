import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class scratch {
    public static void main(String[] args) {
        Board b = new Board();
        b.print();

        System.out.println(b.getPiece(3,3).getCharacter());
    }
}
