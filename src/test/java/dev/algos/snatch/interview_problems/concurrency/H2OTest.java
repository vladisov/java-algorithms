package dev.algos.snatch.interview_problems.concurrency;

import org.junit.jupiter.api.Test;

class H2OTest {

    @Test
    void testMutex() {
        H2O h2O = new H2O_Mutex();
        print(h2O, "OOOHHHHHH");
        System.out.println();
        print(h2O, "HHO");
    }

    @Test
    void testPhaser() {
        H2O h2O = new H2O_Barrier();
        print(h2O, "OOOHHHHHH");
        System.out.println();
        print(h2O, "HHO");
    }

    private void print(H2O h2O, String s) {
        for (char c : s.toCharArray()) {
            Thread t;
            if (c == 'H') {
                t = new Thread(() -> {
                    try {
                        h2O.hydrogen(() -> System.out.print(c));
                    } catch (InterruptedException ignored) {
                    }
                });
            } else {
                t = new Thread(() -> {
                    try {
                        h2O.oxygen(() -> System.out.print(c));
                    } catch (InterruptedException ignored) {
                    }
                });
            }
            t.start();
        }
    }
}
