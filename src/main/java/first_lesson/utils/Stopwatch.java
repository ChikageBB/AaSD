package first_lesson.utils;

public class Stopwatch {
    private long _start;

    /**
     * Initializes a new stopwatch
     */
    public Stopwatch() {
        _start = this.now();
    }

    private long now() {
        return System.currentTimeMillis();
    }

    /**
     * Reset the time stamp
     */
    public void reset() {
        _start = this.now();
    }

    /**
     * Returns the Elapsed time [s] since the stopwatch was reset
     * @return Elapsed time [s]
     */
    public double getElapsedTime() {
        return (this.now() - _start) / 1000.0;
    }
}