package lesson06;

public class Lift {
    private int currentFloor;
    private int prevFloor;
    private final int minFloor;
    private final int maxFloor;

    public Lift(int minFloor, int maxFloor) {
        if (minFloor >= maxFloor) {
            throw new IllegalArgumentException("Максимальный этаж должен быть больше минимального");
        }

        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.prevFloor = this.currentFloor = minFloor;
    }

    public Lift(int maxFloor) {
        this(1, maxFloor);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String move(int floor) {
        if (floor < this.minFloor || floor > this.maxFloor) {
            return "Некорректно задан этаж.";
        } else  if (floor == this.currentFloor) {
            return "Никуда не едем. Это и есть этаж " + this.currentFloor;
        } else {
            this.prevFloor = this.currentFloor;
            this.currentFloor = floor;
            return this.toString();
        }
    }

    @Override
    public String toString() {
        return String.format("Лифт [%d, %d] едем %d -> %d", this.minFloor, this.maxFloor, this.prevFloor, this.currentFloor);
    }
}
