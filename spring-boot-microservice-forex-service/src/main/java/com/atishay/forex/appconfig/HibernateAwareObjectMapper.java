package com.atishay.forex.appconfig;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/***
 * This class is prevent all lazzy type object from output of api.
 * 
 * @author test
 *
 */
public class HibernateAwareObjectMapper extends ObjectMapper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HibernateAwareObjectMapper() {
		Hibernate5Module hibernate5Module = new Hibernate5Module();
		hibernate5Module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		registerModule(hibernate5Module);
	}
}

