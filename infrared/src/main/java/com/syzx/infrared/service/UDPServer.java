/**
 * Project Name:Infrared
 * File Name:UDPServer.java
 * Package Name:com.syzx.infrared.service
 * Date:2018年1月2日下午10:32:56
 * Copyright (c) 2018, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

/**
 * ClassName: UDPServer <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2018年1月2日 下午10:32:56 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class UDPServer {
    //    private Map<String, MonitorPoint> monitorPoints;
    //    private UDPReceiverThread receiveThread;
    //    private UDPSenderThread sendThread;
    //    private MessageQueue messageQueue;
    //    private DataFrameFactory dataFrameDTOFactory;
    //
    //    /**
    //     *创建一个UDPServer的实例.
    //     *
    //     * @param monitorPoints
    //     * @param receiveThread
    //     * @param sendThread
    //     */
    //
    //    public UDPServer(int serverPort) {
    //        monitorPoints = new HashMap<String, MonitorPoint>();
    //
    //        receiveThread = new UDPReceiverThread(serverPort);
    //        receiveThread.setCycleFinishedEventHandler(new UDPServerReceiverHandler());
    //
    //        sendThread = new UDPSenderThread(messageQueue.getSenderQueue());
    //    }
    //
    //    public void start() {
    //        receiveThread.start();
    //        sendThread.start();
    //    }
    //
    //    public void stop() {
    //        receiveThread.stopTimer();
    //        sendThread.stopTimer();
    //    }
    //
    //    public void sendCommand(String kilometerMark, DataFrameCommand command) {
    //        if (monitorPoints.containsKey(kilometerMark)) {
    //            MonitorPoint monitorPoint = monitorPoints.get(kilometerMark);
    //            if (isAlive(monitorPoint)) {
    //                messageQueue.pollSenderMessage(
    //                        new UDPMessage(monitorPoint.getSocketAddress(), dataFrameDTOFactory.getCommandFrame(command)));
    //            }
    //        }
    //    }
    //
    //    private boolean isAlive(MonitorPoint monitorPoint) {
    //        Duration duration = Duration.between(LocalDateTime.now(), monitorPoint.getLastUpdateTime());
    //        return duration.toMillis() / 1000 < 30;
    //    }
    //
    //    /**
    //     * 
    //     * ClassName: UDPServerReceiverHandler <br/>
    //     * Function: TODO 描述类的功能. <br/>
    //     * date: 2018年1月3日 上午7:48:43 <br/>
    //     *
    //     * @author Zxy
    //     * @version UDPServer
    //     * @since JDK 1.8
    //     */
    //    class UDPServerReceiverHandler implements ITimerEventHandler {
    //
    //        /**
    //         * TODO 简单描述该方法的实现功能（可选）.
    //         * @see com.syzx.infrared.infrastructure.interfaces.ITimerEventHandler#doEventHandler(java.lang.Object, com.syzx.infrared.infrastructure.TimerEventArgs)
    //         */
    //        public void doEventHandler(Object sender, TimerEventArgs e) {
    //            ReceiverTimerEventArgs args = (ReceiverTimerEventArgs) e.getTimerData();
    //            DataFrame dataFrameDTO = JsonCodec.toDataFrame(args.getTimerData().toString());
    //            switch (dataFrameDTO.getType()) {
    //            case HEART:
    //                if (monitorPoints.containsKey(dataFrameDTO.getKilometerMark())) {
    //                    monitorPoints.get(dataFrameDTO.getKilometerMark())
    //                            .setLastUpdateTime(LocalDateTime.parse(dataFrameDTO.getTime()));
    //                }
    //                break;
    //
    //            case DATA:
    //                if(monitorPoints.containsKey(dataFrameDTO.getKilometerMark())) {
    //                monitorPoints.put(dataFrameDTO.getKilometerMark(),
    //                        new MonitorPoint(dataFrameDTO, args.getSourceAddress()));
    //                }else {
    //                    monitorPoints.put(dataFrameDTO.getKilometerMark(),
    //                            new MonitorPoint(dataFrameDTO, args.getSourceAddress()));
    //                }
    //                break;
    //
    //            case COMMAND:
    //                break;
    //
    //            default:
    //                break;
    //            }
    //        }
    //
    //    }
}
