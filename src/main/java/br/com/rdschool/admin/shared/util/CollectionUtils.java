package br.com.rdschool.admin.shared.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class CollectionUtils {

	static public <T> Set<T> unmodifiableNullSafe(Set<T> collection) {
		return collection == null ? Collections.emptySet() : Collections.unmodifiableSet(collection);
	}

	static public <T> List<T> unmodifiableNullSafe(List<T> collection) {
		return collection == null ? Collections.emptyList() : Collections.unmodifiableList(collection);
	}

}