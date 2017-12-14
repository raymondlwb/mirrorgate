package com.bbva.arq.devops.ae.mirrorgate.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class LocalDateTimeHelper {

    private LocalDateTimeHelper(){}


    public static long getTimestampPeriod(long timestamp, ChronoUnit chronoUnit) {

        Instant instant = Instant.ofEpochMilli(timestamp);

        LocalDateTime metricTimestamp = LocalDateTime.ofInstant(instant,
                TimeZone.getTimeZone("UTC").toZoneId()).truncatedTo(chronoUnit);

        return metricTimestamp.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public static long getTimestampForNDaysAgo(int days, ChronoUnit chronoUnit) {

        LocalDateTime daysAgo = LocalDateTime.now(
                ZoneId.of("UTC")).minusDays(days).truncatedTo(chronoUnit);

        return daysAgo.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

}