package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

public class Glyph {
    private final int MAX_HEIGHT = 10;
    private final int MAX_WIDTH = 50;
    private Song song;
    private TextShape topText;
    private TextShape bottomText;
    private Shape middleBar;
    private Shape firstLeft;
    private Shape firstRight;
    private Shape secondLeft;
    private Shape secondRight;
    private Shape thirdLeft;
    private Shape thirdRight;
    private Shape fourthLeft;
    private Shape fourthRight;


    /**
     * Creates a glyph
     * 
     * @param song
     *            the song being displayed
     * @param x
     *            top left of the glyph shape
     * @param y
     *            top left of the glyph shape
     * @param enumer
     *            what parameter it'll evaluate
     */
    public Glyph(Song song, int x, int y, int enumer) {
        this.song = song;
        this.topText = new TextShape(x, y, song.getTitle());
        this.bottomText = new TextShape(x, y + 10, "Genre: " + song.getGenre());

        int middleX = x + MAX_WIDTH - 2;

        this.middleBar = new Shape(middleX, y + 20, 4, 4 * MAX_HEIGHT,
            Color.BLACK);

        int num1 = (int)processor.getTotalOfResponses(song, enumer, 1, 1);
        this.firstLeft = new Shape(middleX - num1, y + 20, num1, MAX_HEIGHT,
            Color.RED);
        window.addShape(firstLeft);

        int num2 = (int)processor.getTotalOfResponses(song, enumer, 1, 2);
        this.firstRight = new Shape(middleX + 4, y + 20, num2, MAX_HEIGHT,
            Color.RED);
        window.addShape(firstRight);

        int num3 = (int)processor.getTotalOfResponses(song, enumer, 2, 1);
        this.secondLeft = new Shape(middleX - num3, y + 20 + MAX_HEIGHT, num3,
            MAX_HEIGHT, Color.BLUE);
        window.addShape(secondLeft);

        int num4 = (int)processor.getTotalOfResponses(song, enumer, 2, 2);
        this.secondRight = new Shape(middleX + 4, y + 20 + MAX_HEIGHT, num4,
            MAX_HEIGHT, Color.BLUE);
        window.addShape(secondRight);

        int num5 = (int)processor.getTotalOfResponses(song, enumer, 3, 1);
        this.thirdLeft = new Shape(middleX - num5, y + 20 + 2 * MAX_HEIGHT,
            num5, MAX_HEIGHT, Color.YELLOW);
        window.addShape(thirdLeft);

        int num6 = (int)processor.getTotalOfResponses(song, enumer, 3, 2);
        this.thirdRight = new Shape(middleX + 4, y + 20 + 2 * MAX_HEIGHT, num6,
            MAX_HEIGHT, Color.YELLOW);
        window.addShape(thirdRight);

        int num7 = (int)processor.getTotalOfResponses(song, enumer, 4, 1);
        this.fourthLeft = new Shape(middleX - num6, y + 20 + 3 * MAX_HEIGHT,
            num7, MAX_HEIGHT, Color.GREEN);
        window.addShape(fourthLeft);

        int num8 = (int)processor.getTotalOfResponses(song, enumer, 4, 2);
        this.fourthRight = new Shape(middleX + 4, y + 20 + 3 * MAX_HEIGHT, num8,
            MAX_HEIGHT, Color.GREEN);
        window.addShape(fourthRight);
    }


    /**
     * gets the height of a shape
     * 
     * @param shape
     *            shape being evaluated
     * @return the height of the bar (though visually its width)
     */
    public double getHeight(Shape shape) {
        return shape.getWidth();
    }


    /**
     * sets the height of a shape to a new value
     * 
     * @param shape
     *            shape being evaluated
     * @param newHeight
     *            the new height of the shape
     */
    public void setHeight(Shape shape, int newHeight) {
        int height = shape.getHeight();
        int x = shape.getX();
        int y = shape.getY();

        shape = new Shape(x, y, height, newHeight);
    }


    /**
     * changes the height of every shape
     * 
     * @param fiL
     *            firstLeft
     * @param fiR
     *            firstRight
     * @param sL
     *            secondLeft
     * @param sR
     *            secondRight
     * @param tL
     *            thirdLeft
     * @param tR
     *            thirdRight
     * @param foL
     *            fourthLeft
     * @param foR
     *            fourthRight
     */
    public void updateGlyph(
        int fiL,
        int fiR,
        int sL,
        int sR,
        int tL,
        int tR,
        int foL,
        int foR) {

        this.setHeight(firstLeft, fiL);
        this.setHeight(firstRight, fiR);
        this.setHeight(secondLeft, sL);
        this.setHeight(secondRight, sR);
        this.setHeight(thirdLeft, tL);
        this.setHeight(thirdRight, tR);
        this.setHeight(fourthLeft, foL);
        this.setHeight(fourthRight, foR);

    }
}
