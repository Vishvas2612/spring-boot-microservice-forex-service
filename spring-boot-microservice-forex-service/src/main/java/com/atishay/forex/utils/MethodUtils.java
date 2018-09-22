package com.atishay.forex.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerMapping;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MethodUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodUtils.class);

	/***
	 * This generic method is used to check whether object is null or empty. if
	 * object t is null or empty then it throws NullPointerException.
	 * 
	 * @param   <T> indicates any type of Generic object.
	 * @param t indicates any zero or more objects like String,List,Set etc.
	 */
	// @formatter:on
	@SuppressWarnings("unchecked")
	public static <T> boolean isObjectisNullOrEmpty(T... t) {
		for (T ob : t) {
			if (ob == null || ob.toString().trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static <T> boolean isListIsNullOrEmpty(List<T> listT) {

		if (listT == null || listT.isEmpty()) {
			return true;
		}
		return false;
	}

	public static <T> boolean isCopyOnWriteArraySetIsNullOrEmpty(CopyOnWriteArraySet<T> copyOnWriteArraySetT) {

		if (copyOnWriteArraySetT == null || copyOnWriteArraySetT.isEmpty()) {
			return true;
		}
		return false;
	}

	public static <T> boolean isCopyOnWriteArrayListIsNullOrEmpty(CopyOnWriteArrayList<T> copyOnWriteArrayListT) {

		if (copyOnWriteArrayListT == null || copyOnWriteArrayListT.isEmpty()) {
			return true;
		}
		return false;
	}

	public static <T> boolean isSetIsNullOrEmpty(Set<T> setT) {

		if (setT == null || setT.isEmpty()) {
			return true;
		}
		return false;
	}

	public static <T> boolean isMapIsNullOrEmpty(Map<String, T> mapOfT) {
		if (mapOfT == null || mapOfT.isEmpty()) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getObjectFromMap(Map<String, Object> mapFromObject, T t) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return (T) mapper.convertValue(mapFromObject, t.getClass());
	}

	/**
	 * This method gets full api path from http servlet request.
	 * 
	 * @param httpServletRequest indicates http servlet request.
	 * @return returns full api path.
	 */
	public static String getApiPathFromHttpServletRequest(HttpServletRequest httpServletRequest) {
		return httpServletRequest.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
	}
}
