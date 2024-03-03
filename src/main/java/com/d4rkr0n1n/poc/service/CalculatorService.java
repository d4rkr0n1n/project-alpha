package com.d4rkr0n1n.poc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  public Map<String, Object> getTime() {

    HashMap<String, Object> timeHashMap = new HashMap<>();
    HashMap<String, String> systemTimeData = new HashMap<>();
    HashMap<String, Object> calendarData = new HashMap<>();
    LocalDate date = LocalDate.now();

    systemTimeData.put("Time", getFormattedLocalTime(LocalTime.now()));
    systemTimeData.put("TimeZone Long", getDefaultTimeZone(ZoneId.systemDefault(), TimeZone.LONG));
    systemTimeData.put("TimeZone Short", getDefaultTimeZone(ZoneId.systemDefault(), TimeZone.SHORT));

    calendarData.put("Date", date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
    calendarData.put("Day of Week", date.getDayOfWeek());
    calendarData.put("Day of Year", date.getDayOfYear());
    calendarData.put("Week of Year", date.get(WeekFields.of(Locale.getDefault()).weekOfYear()));

    timeHashMap.put("System", systemTimeData);
    timeHashMap.put("EST", getFormattedZonedTime("EST5EDT"));
    timeHashMap.put("CST", getFormattedZonedTime("CST6CDT"));
    timeHashMap.put("USTV Time", getUSTVTime());
    timeHashMap.put("Calendar", calendarData);

    return timeHashMap;
  }

  private String getDefaultTimeZone(ZoneId zoneId, int timeZone) {
    return TimeZone.getTimeZone(zoneId).getDisplayName(false, timeZone, Locale.getDefault(Locale.Category.DISPLAY));
  }

  private Object getUSTVTime() {
    return Math.abs(getZonedTime("EST5EDT").getHour() - 12) + "/" + Math.abs(getZonedTime("CST6CDT").getHour() - 12)
        + "c";
  }

  private LocalTime getZonedTime(String zoneId) {
    return LocalDateTime.now().atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of(zoneId)).toLocalTime();
  }

  private String getFormattedZonedTime(String zoneId) {
    return getFormattedLocalTime(getZonedTime(zoneId));
  }

  private String getFormattedLocalTime(LocalTime now) {
    return now.format(DateTimeFormatter.ofPattern("hh:mm a"));
  }

}
