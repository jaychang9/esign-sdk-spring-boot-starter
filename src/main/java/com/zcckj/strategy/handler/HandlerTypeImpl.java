package com.zcckj.strategy.handler;


import com.zcckj.strategy.annonation.HandlerType;

import java.lang.annotation.Annotation;

/**
 * 策略模型业务类型注解实现类
 *
 * @author pangu
 * @date 2020-10-5
 */
public class HandlerTypeImpl implements HandlerType {

	private final String type;
	private final String subType;

	HandlerTypeImpl(String type, String subType) {
		this.subType = subType;
		this.type = type;
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode += (127 * "type".hashCode()) ^ type.hashCode();
		hashCode += (127 * "subType".hashCode()) ^ subType.hashCode();
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HandlerType)) {
			return false;
		}
		HandlerType other = (HandlerType) obj;
		return type.equals(other.type()) && subType.equals(other.subType());
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		return HandlerType.class;
	}

	@Override
	public String type() {
		return type;
	}

	@Override
	public String subType() {
		return subType;
	}
}
