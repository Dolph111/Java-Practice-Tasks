class ModelZ extends Tezla {
    protected double acceleration;
    protected double maxSpeed;

    public ModelZ() {
        speed = 0;
        acceleration = 100;
        maxSpeed = 300;
    }

    @Override
    public void accelerate() {
        if (speed < maxSpeed) {
            speed += acceleration;
        } else {
            speed = maxSpeed;
        }
    }

    @Override
    public void brake() {
            speed -= brakingSpeed;
        if (speed < 0) {
            speed = 0;
        }
    }
}