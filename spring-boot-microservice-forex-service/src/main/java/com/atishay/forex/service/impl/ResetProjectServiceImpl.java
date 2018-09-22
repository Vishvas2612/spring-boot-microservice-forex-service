package com.atishay.forex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atishay.forex.repository.ResetProjectRepository;
import com.atishay.forex.service.ResetProjectService;

@Service
public class ResetProjectServiceImpl implements ResetProjectService {

	@Autowired
	private ResetProjectRepository resetProjectRepository;

	@Transactional
	@Override
	public <T> void remove(T t) {
		resetProjectRepository.remove(t);
	}
}
