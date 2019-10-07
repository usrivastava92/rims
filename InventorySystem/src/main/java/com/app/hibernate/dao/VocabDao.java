package com.app.hibernate.dao;

import java.util.List;
import java.util.Map;

import com.app.hibernate.entity.masters.UserPo;

public interface VocabDao {

	public List<Long> getAdaptiveWordObjectList(UserPo user);

	public List<Long> getWordList(Long startIndex, Long endIndex, UserPo user);

	public Map<String, Float> getSetCompletionAvg(int setSize, UserPo user);

	public List<Long> getBookmarkSet(UserPo loggedInUsers);

	public List<Long> getRevisionSet(UserPo loggedInUsers);

}