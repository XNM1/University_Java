package ua.edu.chmnu.fks.oop.Lab09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSameDoubleSearcher {

    private double accuracy = 0.001;
    private String fileReadPath;
    private String fileWritePath;
    private int countOfSymbInLine;

    public FileSameDoubleSearcher(String fileReadPath, String fileWritePath, int countOfSymbInLine, double accuracy) throws Exception {
        setAccuracy(accuracy);
        this.fileReadPath = fileReadPath;
        this.fileWritePath = fileWritePath;
        setCountOfSymbInLine(countOfSymbInLine);
    }

    public FileSameDoubleSearcher(String fileReadPath, String fileWritePath, int countOfSymbInLine) throws Exception {
        this.fileReadPath = fileReadPath;
        this.fileWritePath = fileWritePath;
        setCountOfSymbInLine(countOfSymbInLine);
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) throws Exception {
        if (accuracy < 0)
            throw new Exception("count of symbols in line is negative");
        if (accuracy == 0)
            throw new Exception("count of symbols in line is zero");
        this.accuracy = accuracy;
    }

    public String getFileReadPath() {
        return fileReadPath;
    }

    public void setFileReadPath(String fileReadPath) {
        this.fileReadPath = fileReadPath;
    }

    public String getFileWritePath() {
        return fileWritePath;
    }

    public void setFileWritePath(String fileWritePath) {
        this.fileWritePath = fileWritePath;
    }

    public int getCountOfSymbInLine() {
        return countOfSymbInLine;
    }

    public void setCountOfSymbInLine(int countOfSymbInLine) throws Exception {
        if (countOfSymbInLine < 0)
            throw new Exception("count of symbols in line is negative");
        if (countOfSymbInLine == 0)
            throw new Exception("count of symbols in line is zero");
        this.countOfSymbInLine = countOfSymbInLine;
    }

    public void search() throws Exception {
        File file = new File(fileWritePath);
        if(!file.exists()) {
            file.createNewFile();
        }
        try(RandomAccessFile fileReader = new RandomAccessFile(fileReadPath, "r");
            FileWriter writer = new FileWriter(fileWritePath, false)) {

            countOfSymbInLine += 2;
            String lineSeparator = System.getProperty("line.separator");
            long countOfLine = fileReader.length() / countOfSymbInLine;
            Double ai, aj;
            List<Double> exists = new ArrayList<Double>();
            writer.write("Results:" + lineSeparator);

            for (long i = 0; i < countOfLine; i++) {
                fileReader.seek(i * countOfSymbInLine);
                ai = Double.parseDouble(fileReader.readLine());
                if(exists.contains(ai))
                    continue;
                while(fileReader.getFilePointer() < fileReader.length()) {
                    aj = Double.parseDouble(fileReader.readLine());
                    if (Math.abs(Math.abs(ai) - Math.abs(aj)) < accuracy) {
                        writer.write(ai.toString() + " = " + aj.toString() + lineSeparator);
                        exists.add(Math.abs(ai));
                        break;
                    }
                }
            }

            writer.flush();
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileSameDoubleSearcher)) return false;

        FileSameDoubleSearcher that = (FileSameDoubleSearcher) o;

        if (Double.compare(that.getAccuracy(), getAccuracy()) != 0) return false;
        if (getCountOfSymbInLine() != that.getCountOfSymbInLine()) return false;
        if (!getFileReadPath().equals(that.getFileReadPath())) return false;
        return getFileWritePath().equals(that.getFileWritePath());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getAccuracy());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getFileReadPath().hashCode();
        result = 31 * result + getFileWritePath().hashCode();
        result = 31 * result + getCountOfSymbInLine();
        return result;
    }

    @Override
    public String toString() {
        return "FileSameDoubleSearcher{" +
                "accuracy=" + accuracy +
                ", fileReadPath='" + fileReadPath + '\'' +
                ", fileWritePath='" + fileWritePath + '\'' +
                ", countOfSymbInLine=" + countOfSymbInLine +
                '}';
    }
}
