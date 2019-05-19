package ua.edu.chmnu.fks.oop.Lab05;

import ua.edu.chmnu.fks.oop.Lab05.Exceptions.*;

public class Cube {

    private double edge;

    public Cube(double edge) throws NegativeEdgeException {
        this.setEdge(edge);
    }

    public Cube() {
        this.edge = 0;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) throws NegativeEdgeException {
        if (edge >= 0)
            this.edge = edge;
        else
            throw new NegativeEdgeException("negative edge");
    }

    public double getVolume() {
        return 6 * edge * edge;
    }

    public double getDiagonal() {
        return Math.sqrt(3) * edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;

        Cube cube = (Cube) o;

        return Double.compare(cube.getEdge(), getEdge()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getEdge());
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Cube{" +
                "edge=" + edge +
                '}';
    }
}
