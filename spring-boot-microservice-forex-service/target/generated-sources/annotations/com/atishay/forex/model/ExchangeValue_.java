package com.atishay.forex.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExchangeValue.class)
public abstract class ExchangeValue_ {

	public static volatile SingularAttribute<ExchangeValue, String> id;
	public static volatile SingularAttribute<ExchangeValue, String> currencyTo;
	public static volatile SingularAttribute<ExchangeValue, String> currencyFrom;
	public static volatile SingularAttribute<ExchangeValue, Double> conversationRate;

}

