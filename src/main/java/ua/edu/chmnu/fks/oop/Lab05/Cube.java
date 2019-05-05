package ua.edu.chmnu.fks.oop.Lab05;

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

    //CubeExceptions
    public class CubeException extends Exception {
        public CubeException(String message) {
            super(message);
        }
    }

    public class NegativeEdgeException extends CubeException {
        public NegativeEdgeException(String message) {
            super(message);
        }
    }
    //CubeExceptions
}