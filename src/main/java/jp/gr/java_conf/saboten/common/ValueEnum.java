package jp.gr.java_conf.saboten.common;

import java.io.Serializable;

public class ValueEnum {

	public interface IValueEnum<V extends Serializable> {
		V getValue();
	}

	public interface IValueLabelEnum<V extends Serializable> extends IValueEnum<V> {
		String getLabel();
	}



	public static <E extends Enum<? extends IValueEnum<?>>, T extends Serializable> E get(Class<E> clazz, T value) {
		for (E t : clazz.getEnumConstants()) {
			if (((IValueEnum<?>) t).getValue().equals(value))
				return t;
		}
		return null;
	}

	// Wicket関連クラスへの依存を作らない！
//	public static <E extends Enum<? extends IValueEnum<?>>, T extends Serializable> String getStr(Class<E> clazz, T value) {
//		return EnumUtil.getResourceStr(get(clazz, value));
//	}
}
