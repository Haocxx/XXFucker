package com.haocxx.xxfucker

/**
 * Created by Haocxx
 * on 2021-1-18
 */
class ClueManager {
    public static Map<String, List<SemenModel>> mBitchNameToSemenMap = new HashMap<>()

    static class SemenModel {
        String className
        String methodName
        // save param class desc in order, call while do real fuck
        List<String> paramDescList = new ArrayList<>()
    }
}