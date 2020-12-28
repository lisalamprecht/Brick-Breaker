public class Bricks {
    //Global Variables
    private int brickX;
    private int brickY;
    private int brickWidth;
    private int brickHeight;
    private boolean visible;

    public Bricks(int bX, int bY, int bWidth, int bHeight, boolean visible) {
        this.setBrickX(bX);
        this.setBrickY(bY);
        this.setBrickWidth(bWidth);
        this.setBrickHeight(bHeight);
        this.setVisible(visible);
    }

    // create get and set methods for attributes
    public int getBrickX() {
        return brickX;
    }

    public void setBrickX(int bX) {
        this.brickX = bX;
    }

    public int getBrickY() {
        return brickY;
    }

    public void setBrickY(int bY) {
        this.brickY = bY;
    }

    public int getBrickWidth() {
        return brickWidth;
    }

    public void setBrickWidth(int bWidth) {
        this.brickWidth = bWidth;
    }

    public int getBrickHeight() {
        return brickHeight;
    }

    public void setBrickHeight(int bHeight) {
        this.brickHeight = bHeight;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getVisible() {
        return visible;
    }
}
