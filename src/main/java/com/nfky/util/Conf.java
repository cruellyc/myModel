package com.nfky.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
* Conf
* @author liyc
* @version 创建时间：2018年5月4日 上午10:26:39
*/
public class Conf {
	private static Map<String, Object> properties = new HashMap<String, Object>();

	public static int getSize() {
		return properties.size();
	}

	private static final Logger logger = Logger.getLogger(Conf.class);
	private HashMap<String, String> map;

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public String getStr(String o) {
		return this.getMap().get(o);
	}

	public String getStr(String o, String def) {
		String ret = this.getMap().get(o);
		return ret == null ? def : ret;
	}

	public int getInt(String o) {
		return Integer.parseInt(this.getMap().get(o));
	}

	public int getInt(String o, int def) {
		String ret = this.getMap().get(o);
		return ret == null ? def : Integer.parseInt(ret);
	}

	public void put(String key, String value) {
		this.getMap().put(key, value);
	}

	public void put(String key, int value) {
		this.getMap().put(key, String.format("%d", value));
	}
		/**
		 * @Title: loadProperties
		 * @Description: TODO(装载property)
		 * @return void 返回类型
		 * @param props
		 */
		public static void loadProperties(Properties props) {
			Iterator<Entry<Object, Object>> it = props.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Object, Object> entry = it.next();
				String key = (String) entry.getKey();
				Object value = entry.getValue();
				properties.put(key, value);
				logger.info(key + "=" + value);
			}
			logger.debug("<" + properties.size() + ">");
			/*
			try {
				logger.info("\n"
						+ ASCIIArt.draw("SEEDTEC", "*", 110, 30, 10, 20, 21));
			} catch (IOException e) {
				logger.error("no this font skip.");
			}
			*/
		}
}
