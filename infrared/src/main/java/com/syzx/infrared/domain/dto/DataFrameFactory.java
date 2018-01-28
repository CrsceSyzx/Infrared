/**
 * Project Name:Infrared
 * File Name:DataFrameFactory.java
 * Package Name:com.syzx.infrared.domain.transmission
 * Date:2018年1月1日下午9:53:47
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.domain.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ClassName: DataFrameFactory <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月1日 下午9:53:47 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class DataFrameFactory {
    private final int DISTANCE_COUNT = 8;

    private String kilometerMark;

    //    private int[] lastDistances;
    private List<List<Integer>> distances;

    /**
     *创建一个DataFrameFactory的实例.
     *
     */

    public DataFrameFactory(String kilometerMark) {
        this.kilometerMark = kilometerMark;

        //        lastDistances = new int[DISTANCE_COUNT];
        //        for (int i = 0; i < DISTANCE_COUNT; i++) {
        //            lastDistances[i] = 0;
        //        }

        distances = new ArrayList<List<Integer>>();
        for (int i = 0; i < DISTANCE_COUNT; i++) {
            distances.add(new ArrayList<Integer>());
            distances.get(i).add(0);
        }
    }

    public void addDataUnit(DistanceDataUnit dataUnit) {
        distances.get(dataUnit.getPort()).add(dataUnit.getDistance());
    }

    public void clear() {
        for (int i = 0; i < DISTANCE_COUNT; i++) {
            distances.get(i).clear();
            distances.get(i).add(0);
        }
    }

    public DataFrame getDataFrame(DataFrameType type) {
        DataFrame dataFrameDTO = new DataFrame(kilometerMark, type);

        if (DataFrameType.DATA == type) {
            int[] distanceArray = new int[DISTANCE_COUNT];
            for (int i = 0; i < DISTANCE_COUNT; i++) {
                //                int lastDistance = distances.get(i).get(distances.get(i).size() - 1);
                //                if (distances.get(i).size() < 2) {
                //                    distanceArray[i] = distances.get(i).get(0);
                //                } else {
                //                    for (int j = 1; j < distances.get(i).size(); j++) {
                //                        if (distances.get(i).get(j - 1) != distances.get(i).get(j)) {
                //                            distanceArray[i] = distances.get(i).get(j);
                //                            break;
                //                        }
                //                    }
                //                }
                //
                //                //保留最后一个数据
                //                distances.get(i).clear();
                //                distances.get(i).add(lastDistance);
                distanceArray[i] = Collections.max(distances.get(i));
            }
            dataFrameDTO.setDistances(distanceArray);
        }

        return dataFrameDTO;
    }

    public DataFrame getDataFrame(ConcurrentLinkedQueue<DistanceDataUnit> distanceDataUnitQueue) {
        int[] distanceArray = new int[DISTANCE_COUNT];
        DataFrame dataFrameDTO = new DataFrame(kilometerMark, DataFrameType.DATA);
        DistanceDataUnit distanceDataUnit = null;
        //        if (DataFrameType.DATA == type) {
        while (!distanceDataUnitQueue.isEmpty()) {
            distanceDataUnit = distanceDataUnitQueue.remove();
            distanceArray[distanceDataUnit.getPort()] = distanceDataUnit.getDistance();
        }

        //            for (int i = 0; i < DISTANCE_COUNT; i++) {
        //                int lastDistance = distances.get(i).get(distances.get(i).size() - 1);
        //                if (distances.get(i).size() < 2) {
        //                    distanceArray[i] = distances.get(i).get(0);
        //                } else {
        //                    for (int j = 1; j < distances.get(i).size(); j++) {
        //                        if (distances.get(i).get(j - 1) != distances.get(i).get(j)) {
        //                            distanceArray[i] = distances.get(i).get(j);
        //                            break;
        //                        }
        //                    }
        //                }
        //
        //                //保留最后一个数据
        //                distances.get(i).clear();
        //                distances.get(i).add(lastDistance);
        //distanceArray[i] = Collections.max(distances.get(i));
        //            }
        dataFrameDTO.setDistances(distanceArray);
        //        }
        return dataFrameDTO;
    }
}