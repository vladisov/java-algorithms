package dev.algos.snatch.interview_problems.concurrency;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ScheduledExecutorService implements AutoCloseable {
    private final PriorityQueue<ScheduledJob> queue;
    private final ExecutorService executorService;
    private final AtomicBoolean finished;

    public ScheduledExecutorService() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        queue = new PriorityQueue<>(Comparable::compareTo);
        finished = new AtomicBoolean(false);
        Runnable checker = () -> {
            while (!finished.get()) {
                Instant now = Instant.now();
                if (!queue.isEmpty() && queue.peek().getNextRunTime().isBefore(now)) {
                    var job = queue.poll();
                    executorService.submit(job.getCommandAndUpdateTime());
                    if (job.getNextRunTime() != null) {
                        queue.add(job);
                    }
                }
            }
        };
        executorService.submit(checker);
    }

    /**
     * Creates and executes a one-shot action that becomes enabled after the given delay.
     */
    public void schedule(Runnable command, long delay, TimeUnit unit) {
        queue.add(new ScheduledJobWithDelay(command, delay, unit));
    }

    /**
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given period; that is executions will commence after initialDelay then
     * initialDelay+period, then initialDelay + 2 * period, and so on.
     */
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        queue.add(new ScheduledJobFixedRate(command, initialDelay, period, unit));
    }

    /**
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given delay between the termination of one execution and the commencement of the next.
     */
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        queue.add(new ScheduledJobFixedRateWithDelay(command, initialDelay, delay, unit));
    }

    @Override
    public void close() throws Exception {
        finished.set(true);
        executorService.shutdown();
    }

    interface ScheduledJob extends Comparable<ScheduledJob> {
        Instant getNextRunTime();

        @Nonnull
        Runnable getCommandAndUpdateTime();

        @Override
        default int compareTo(@NotNull ScheduledJob scheduledJob) {
            if (this.getNextRunTime() == null) return 1;
            if (scheduledJob.getNextRunTime() == null) return -1;
            return this.getNextRunTime().compareTo(scheduledJob.getNextRunTime());
        }

    }

    static class ScheduledJobWithDelay implements ScheduledJob {
        private final Runnable command;
        private Instant runDate;

        public ScheduledJobWithDelay(Runnable command, long delay, TimeUnit unit) {
            this.command = command;
            this.runDate = Instant.now().plus(delay, unit.toChronoUnit());
        }

        @Override
        public Instant getNextRunTime() {
            return runDate;
        }

        @Override
        public @Nonnull
        Runnable getCommandAndUpdateTime() {
            this.runDate = null;
            return command;
        }
    }

    static class ScheduledJobFixedRate implements ScheduledJob {
        private final Runnable command;
        private final long period;
        private final TimeUnit unit;
        private Instant runDate;

        public ScheduledJobFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            this.command = command;
            this.period = period;
            this.unit = unit;
            this.runDate = Instant.now().plus(initialDelay, unit.toChronoUnit());
        }

        @Override
        public @Nonnull
        Runnable getCommandAndUpdateTime() {
            this.runDate = runDate.plus(period, unit.toChronoUnit());
            return command;
        }

        @Override
        public Instant getNextRunTime() {
            return runDate;
        }
    }

    static class ScheduledJobFixedRateWithDelay implements ScheduledJob {
        private final Runnable command;
        private final long delay;
        private final TimeUnit unit;
        private Instant runDate;

        public ScheduledJobFixedRateWithDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            this.command = command;
            this.delay = delay;
            this.unit = unit;
            this.runDate = Instant.now().plus(initialDelay, unit.toChronoUnit());
        }

        @Override
        public @Nonnull
        Runnable getCommandAndUpdateTime() {
            this.runDate = Instant.now().plus(delay, unit.toChronoUnit()); // has to be a callback
            return command;
        }

        @Override
        public Instant getNextRunTime() {
            return runDate;
        }
    }
}
