package com.mgt.findmycity.services.spring;

import com.mgt.findmycity.info.CommentsSummary;

public interface CommentsService {

	CommentsSummary findAverageUserRatings(Integer entityId,
			Integer entityTypeId);
}
