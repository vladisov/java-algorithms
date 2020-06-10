package dev.algos.snatch.data_structures.consistent_hashing;

public class Machine {
    int start;
    int end;
    int id;

    public Machine(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getInterval() {
        return end - start;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}
