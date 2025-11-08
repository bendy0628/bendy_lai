package apr25.Assignment;

public abstract class AsgY2G2_Car implements AsgY2G2_Movable {
    protected boolean isOn;
    protected boolean isMoving;
    protected boolean isForward;
    protected String movingDirection;
    protected String direction;

    public AsgY2G2_Car() {
        isOn = false;
        isMoving = false;
        isForward = true;
        movingDirection = direction;
        direction = "North";
    }

    public boolean isOn() { return isOn; }
    public void setOn(boolean isOn) { this.isOn = isOn; }

    public boolean isMoving() { return isMoving; }
    public void setMoving(boolean isMoving) { this.isMoving = isMoving; }

    public void setForward(boolean isForward) { this.isForward = isForward; }

    public String getMovingDirection() { return movingDirection; }
    public void setMovingDirection(String movingDirection) { this.movingDirection = movingDirection; }

    public void setDirection(String direction) { this.direction = direction; }
    public String getDirection() { return direction; }

    protected String getOppositeDirection(String direction) {
        return switch (direction) {
            case "North" -> "South";
            case "South" -> "North";
            case "East"  -> "West";
            case "West"  -> "East";
            default -> direction;
        };
    }

    public String toString() {
        String status;
        if (isOn) {
            status = "On/Off status: On\n";
            if (isMoving) {
                status += "Moving status: Moving\n";
                status += "Facing direction: " + direction + "\n";
                status += "Moving direction: " + movingDirection + "\n";
            } else {
                status += "Moving Status: Not Moving\n";
                status += "Facing Direction: " + direction + "\n";
            }
        } else {
            status = "On/Off status: Off\n";
            status += "Facing Direction: " + direction + "\n";
        }
        return status + "\n";
    }

    public abstract void on() throws Exception;
    public abstract void off() throws Exception;
}
