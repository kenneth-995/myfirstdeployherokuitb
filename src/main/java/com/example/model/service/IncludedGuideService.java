package com.example.model.service;

import com.example.model.entity.IncludedGuide;
import com.example.model.repository.RepositoryIncludedGuide;
import com.example.model.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncludedGuideService extends BaseService<IncludedGuide, Long, RepositoryIncludedGuide> {


}
