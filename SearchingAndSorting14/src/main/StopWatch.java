/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author joshortiz
 */
public class StopWatch {

    private long elapsedTime;
    private long startTime;
    private boolean isRunning;

    /**
     * Constructs a stopwatch that is in the stopped state and has no time
     * accumulated.
     */
    public StopWatch() {
        reset();
    }

    /**
     * Starts the stopwatch. Time starts accumulating now.
     */
    public void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        startTime = System.currentTimeMillis();
    }

    /**
     * Stops the stopwatch. Time stops accumulating and is is added to the
     * elapsed time.
     */
    public void stop() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        long endTime = System.currentTimeMillis();
        elapsedTime = elapsedTime + endTime - startTime;
    }

    /**
     * Returns the total elapsed time.
     *
     * @return the total elapsed time
     */
    public long getElapsedTime() {
        if (isRunning) {
            long endTime = System.currentTimeMillis();
            return elapsedTime + endTime - startTime;
        } else {
            return elapsedTime;
        }
    }

    /**
     * Stops the watch and resets the elapsed time to 0.
     */
    public void reset() {
        elapsedTime = 0;
        isRunning = false;
    }
}
