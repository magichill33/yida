package com.ly.yida.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.codec.binary.Base64;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


/**
 * SharePreferences操作工具�?
 */
public class SharePrefUtil {
	private static String tag = SharePrefUtil.class.getSimpleName();
	private final static String SP_NAME = "config";
	private static SharedPreferences sp;

	public interface KEY {
		
		String FUNCTION_ALL_JSON = "all_function_json";//�?有的Funcation Json
		String FUNCTION_SELECTED_ID = "selcted_function_ids";//选中的function ids
		
		String CATE_ALL_JSON = "all_cate_json";//�?有的新闻目录 Json
		String CATE_SELECTED_JSON = "selcted_cate_json";//选中的新闻目录ids
		String CATE_EXTEND_ID = "extend_cate_ids";//推荐的新�? 目录ids
		
		String VOTE_SELECTED_ID = "selcted_vote_ids";//选中的function ids
	}

	/**
	 * 保存布尔�?
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveBoolean(Context context, String key, boolean value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		    sp.edit().putBoolean(key, value).commit();
	}

	/**
	 * 保存字符�?
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveString(Context context, String key, String value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putString(key, value).commit();
		
	}
	
	public static void clear(Context context){
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().clear().commit();
	}

	/**
	 * 保存long�?
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveLong(Context context, String key, long value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putLong(key, value).commit();
	}

	/**
	 * 保存int�?
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveInt(Context context, String key, int value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putInt(key, value).commit();
	}

	/**
	 * 保存float�?
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveFloat(Context context, String key, float value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putFloat(key, value).commit();
	}

	/**
	 * 获取字符�?
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String getString(Context context, String key, String defValue) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		return sp.getString(key, defValue);
	}

	/**
	 * 获取int�?
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static int getInt(Context context, String key, int defValue) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		return sp.getInt(key, defValue);
	}

	/**
	 * 获取long�?
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static long getLong(Context context, String key, long defValue) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		return sp.getLong(key, defValue);
	}

	/**
	 * 获取float�?
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static float getFloat(Context context, String key, float defValue) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		return sp.getFloat(key, defValue);
	}

	/**
	 * 获取布尔�?
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static boolean getBoolean(Context context, String key,
			boolean defValue) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		return sp.getBoolean(key, defValue);
	}
	
	/**
	 * 将对象进行base64编码后保存到SharePref�?
	 * 
	 * @param context
	 * @param key
	 * @param object
	 */
	public static void saveObj(Context context, String key, Object object) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			// 将对象的转为base64�?
			String objBase64 = new String(Base64.encodeBase64(baos
					.toByteArray()));

			sp.edit()
					.putString(key,objBase64).commit();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将SharePref中经过base64编码的对象读取出�?
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static Object getObj(Context context, String key) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		String objBase64 = sp.getString(key, null);
		if (TextUtils.isEmpty(objBase64))
			return null;

		// 对Base64格式的字符串进行解码
		byte[] base64Bytes = Base64.decodeBase64(objBase64.getBytes());
		ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);

		ObjectInputStream ois;
		Object obj = null;
		try {
			ois = new ObjectInputStream(bais);
			obj = (Object) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
