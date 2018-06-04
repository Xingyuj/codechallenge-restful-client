package com.ethanji.simplecab;

public interface SimpleCabService {

  void deleteCache();

  String getMedallionsSummary(String pickupDate, String medallions);

  String getMedallionsSummary(String pickupDate, boolean ignoreCache, String medallions);

}
