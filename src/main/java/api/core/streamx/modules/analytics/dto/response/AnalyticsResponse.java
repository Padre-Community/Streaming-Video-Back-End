package api.core.streamx.modules.analytics.dto.response;

public record AnalyticsResponse(String name,

                                Integer numberOfCommentsFromUser,

                                Integer numberOfVideosPostedByUser,

                                Integer numberOfLikes,

                                Integer numberOfFollowers,

                                Double average) {}
