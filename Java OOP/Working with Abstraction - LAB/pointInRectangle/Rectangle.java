package javaooplabs.pointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public boolean contains(Point point){
        if (getBottomLeft().getX() <= point.getX() && getTopRight().getX() >= point.getX()){
            if (getBottomLeft().getY() <= point.getY() && getTopRight().getY() >= point.getY() ){
                return true;
            }
        }

        return false;
    }


}
