package com.atishay.forex.repository;

import java.util.List;

public interface ResetProjectRepository {

	public <T> List<T> getAllRecords(T t);

	public <T> void remove(T t);
}
