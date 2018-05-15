package com.datarepublic.simplecab;

import java.util.Date;

public interface SimpleCabService {

  void deleteCache();

  String getMedallionsSummary(Date pickupDate, String... medallions);

  String getMedallionsSummary(Date pickupDate, boolean ignoreCache, String... medallions);

}
