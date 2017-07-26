///**
// *
// */
//package com;
//
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.ObjectOutputStream;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
///**
// * @author aborah
// *
// */
//public class MonitorStatBQUtil {
//
//	private static int DEF_MONITOR_STAT_BQ_THREAD_COUNT = 10;
//	private static MonitorStatBQUtil _singleInstance = null;
//	private BlockingQueue<HashMap> serverStatBq = null;
//	private ArrayList<Runnable> processorThreads = null;
//	private static final int DEF_MAX_BQ_SIZE = 100;
//	public static final String DELIMITER= ",";
//
//	private MonitorStatBQUtil() {
//		init();
//	}
//
//	private void init() {
//		serverStatBq = new LinkedBlockingQueue<HashMap>();
//		processorThreads = new ArrayList<Runnable>();
//		ThreadGroup tg = new ThreadGroup("MonitorBQ-ThreadGp");
//		int threadCount = 5;
//		for (int i=0;i<threadCount;i++) {
//			MonitorStatBQWorker t = new MonitorStatBQWorker(tg);
//			t.setName("MonitorStatBQ-Thread-" + i);
//			t.start();
//			processorThreads.add(t);
//		}
//
//		//Thread t = new Thread(new MonitorStatBQWorker());
//		//t.setName("MonitorStatBQ-Thread");
//		//t.start();
//
////		MonitorStatBQWorker t = new MonitorStatBQWorker(new ThreadGroup("MonitorBQ-ThreadGp"));
////		t.start();
//	}
//
//	public static MonitorStatBQUtil getInstance() {
//		if (_singleInstance != null) return _singleInstance;
//		synchronized (MonitorStatBQUtil.class) {
//			if (_singleInstance == null) {
//				_singleInstance = new MonitorStatBQUtil();
//			}
//		}
//		return _singleInstance;
//	}
//
//	public boolean post(HashMap serverStatsMap) {
//		boolean retVal = false;
//		try {
//
//			if (serverStatsMap != null) {
//				int sizeForP1 = 1000;
//
//				if( serverStatBq.size() > sizeForP1)
//				{
//					LogManager.error("Blocking Queue Limit crossed max limit size "+ serverStatBq.size());
//					return false;
//				}
//				serverStatBq.put(serverStatsMap);
//
//				retVal = true;
//			}
//		} catch (InterruptedException e) {
//			LogManager.error("MonitorStatBQUtil:post:: exception whil posting", e);
//		}
//		return retVal;
//	}
//
//
//	//class MonitorStatBQWorker implements Runnable {
//	class MonitorStatBQWorker extends Thread{
//
//		public MonitorStatBQWorker(ThreadGroup tg)
//        {
//            super(tg, "MonitorBQ-Thread");
//        }
//
//		public void run() {
//			try {
//				while (true) {
//					HashMap item = null;
//					try {
//						if (serverStatBq != null) {
//							item = serverStatBq.take();
//
//							process(item);
//						} else {
//
//							Thread.sleep(200L);
//						}
//					} catch (InterruptedException iex) {
//						throw iex;
//					} catch (Exception ex) {
//						throw ex;
//					}
//				}
//			} catch (Exception e) {
//			}
//		}
//
//		private void process(String kpi)
//		{
//			// Post to hubble
//			agent.captureStat(kpi, 1);
//		}
//	}
//}
