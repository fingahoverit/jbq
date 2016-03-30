package com.github.fingahoverit.jbq.magicbox.stringstress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StressStats {

	public static final String KEY_OPERATOR = "operator";
	public static final String KEY_CONCAT = "concat";
	public static final String KEY_STRINGBUILDER = "stringbuilder";
	public static final String KEY_STRINGBUFFER = "stringbuffer";

	Map<String, Integer> errorCountMap = new HashMap<String, Integer>();
	Map<String, List<Long>> durationMap = new HashMap<String, List<Long>>();

	synchronized public void addDuration(String key, long duration) {

		List<Long> durationList = durationMap.get(key);
		if (durationList != null) {
			durationList.add(duration);
		} else {
			durationList = new ArrayList<Long>();
			durationList.add(duration);
			durationMap.put(key, durationList);
		}
	}

	synchronized public void addError(String key) {

		Integer errorCount = errorCountMap.get(key);
		if (errorCount != null) {
			errorCountMap.put(key, ++errorCount);
		} else {
			errorCountMap.put(key, 1);
		}
	}

	public void printStats() {

		System.out.println("=ERROR COUNTS======================");
		for (String errorKey : errorCountMap.keySet()) {
			System.out.println(errorKey + ":" + errorCountMap.get(errorKey));
		}
		System.out.println("===================================");
		System.out.println(" ");

		System.out.println("=DURATION   ======================");
		for (String durationKey : durationMap.keySet()) {
			List<Long> durationList = durationMap.get(durationKey);
			System.out.println(durationKey + ":"
					+ (durationList.stream().mapToLong(Long::longValue).sum() / durationList.size()) + "ms");

		}
		System.out.println("===================================");

	}
}
