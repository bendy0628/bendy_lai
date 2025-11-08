package apr25.Assignment;

public class AsgY2G2_ToyCar extends AsgY2G2_Car {
    public AsgY2G2_ToyCar() { super(); }

    public void on() throws Exception {
        if (isOn) throw new AlreadyOnException("The car is already on!");
        setOn(true);
    }

    public void off() throws Exception {
        if (!isOn) throw new AlreadyOffException("The car is already off!");
        if (isMoving) throw new StillMovingException("The car is moving. Stop the car before turning it off.");
        setOn(false);
    }

    public void forward() throws Exception {
        if (!isOn) throw new NotOnException("The car is off. Turn it on before moving forward.");
        setMoving(true);
        setForward(true);
        setMovingDirection(direction);
    }

    public void backward() throws Exception {
        if (!isOn) throw new NotOnException("The car is off. Turn it on before moving backward.");
        setMoving(true);
        setForward(false);
        setMovingDirection(getOppositeDirection(direction));
    }

    public void turnLeft() throws Exception {
        if (!isOn) throw new NotOnException("The car is off. Turn it on before turning left.");
        if (!isMoving) throw new NotMovingException("The car isn't moving. Move first before turning left.");
        switch (direction) {
            case "North" -> setDirection("West");
            case "East"  -> setDirection("North");
            case "South" -> setDirection("East");
            case "West"  -> setDirection("South");
        }
        if (isForward) setMovingDirection(direction);
        else setMovingDirection(getOppositeDirection(direction));
    }

    public void turnRight() throws Exception {
        if (!isOn) throw new NotOnException("The car is off. Turn it on before turning right.");
        if (!isMoving) throw new NotMovingException("The car isn't moving. Move first before turning right.");
        switch (direction) {
            case "North" -> setDirection("East");
            case "East"  -> setDirection("South");
            case "South" -> setDirection("West");
            case "West"  -> setDirection("North");
        }
        if (isForward) setMovingDirection(direction);
        else setMovingDirection(getOppositeDirection(direction));
    }

    public void stop() throws Exception {
        if (!isOn) throw new NotOnException("Turn the car on before stopping it.");
        if (!isMoving) throw new NotMovingException("The car must be moving before you can stop it.");
        setMoving(false);
    }

    // Custom Exceptions
    public static class AlreadyOnException extends Exception { public AlreadyOnException(String m){ super(m);} }
    public static class AlreadyOffException extends Exception { public AlreadyOffException(String m){ super(m);} }
    public static class NotOnException extends Exception { public NotOnException(String m){ super(m);} }
    public static class NotMovingException extends Exception { public NotMovingException(String m){ super(m);} }
    public static class StillMovingException extends Exception { public StillMovingException(String m){ super(m);} }
}
