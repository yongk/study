package com.ruirui.ignite.id;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicSequence;
import org.apache.ignite.Ignition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IgniteIdGenerator {

    Ignite ignite = Ignition.start();

    IgniteAtomicSequence getSequence() {
        return ignite.atomicSequence("seqName", 0, true);
    }

    IgniteAtomicSequence getSequenceBasedDate() {
        long initVal = Long.valueOf(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE)) * 10000;
        return ignite.atomicSequence("seqNameBasedDate", initVal, true);
    }

    /* refer https://my.oschina.net/liyuj/blog/617472 */
    IgniteAtomicSequence getSequenceBasedDateTime() {
        long initVal = Long.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))) * 10000;
        return ignite.atomicSequence("seqNameBasedDateTime", initVal, true);
    }

    void close() {
        ignite.close();
    }

    public static void main(String[] args) {
        IgniteIdGenerator ignite = new IgniteIdGenerator();

        IgniteAtomicSequence seq = ignite.getSequence();
        for (int i = 0; i < 10; i++) {
            long currentValue = seq.get();
            long newValue = seq.incrementAndGet();
            System.out.println(currentValue + " next is: " + newValue);
        }

        IgniteAtomicSequence seqBasedDate = ignite.getSequenceBasedDate();
        for (int i = 0; i < 10; i++) {
            long currentValue = seqBasedDate.get();
            long newValue = seqBasedDate.incrementAndGet();
            System.out.println(currentValue + " next is: " + newValue);
        }

        IgniteAtomicSequence seqBasedDateTime = ignite.getSequenceBasedDateTime();
        for (int i = 0; i < 10; i++) {
            long currentValue = seqBasedDateTime.get();
            long newValue = seqBasedDateTime.incrementAndGet();
            System.out.println(currentValue + " next is: " + newValue);
        }

        ignite.close();
    }
}
