package za.co.an.threeway;

class Rover {
    private XYCoordinate xyCoordinate = new XYCoordinate(0, 0);
    private String orientation = "";

    XYCoordinate getXyCoordinate() {
        return xyCoordinate;
    }

    void setXyCoordinate(XYCoordinate xyCoordinate) {
        this.xyCoordinate = xyCoordinate;
    }

    String getOrientation() {
        return orientation;
    }

    void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
