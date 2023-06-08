package io.github.fengwensheng100.common.constant;

/**
 * 数据开放服务
 */
public interface DouYinDataConstant {

    //******************************** 用户数据 ********************************

    /**
     * 获取用户视频情况
     */
    String DATA_EXTERNAL_USER_ITEM = "https://open.douyin.com/data/external/user/item/";

    //******************************** 视频数据 ********************************

    /**
     * 获取视频基础数据
     */
    String DATA_EXTERNAL_ITEM_BASE = "https://open.douyin.com/data/external/item/base/";

    //******************************** 粉丝画像数据 ********************************

    /**
     * 获取用户粉丝数据
     */
    String FANS_DATA = "https://open.douyin.com/fans/data/";

    //******************************** 热点视频数据 ********************************

    /**
     * 获取实时热点词
     */
    String HOTSEARCH_SENTENCES = "https://open.douyin.com/hotsearch/sentences/";

    /**
     * 获取上升词
     */
    String HOTSEARCH_TRENDING_SENTENCES = "https://open.douyin.com/hotsearch/trending/sentences/";

    /**
     * 获取热点词聚合的视频
     */
    String HOTSEARCH_VIDEOS = "https://open.douyin.com/hotsearch/videos/";

    //******************************** 星图数据 ********************************

    /**
     * 获取抖音星图达人热榜
     */
    String STAR_HOT_LIST = "https://open.douyin.com/star/hot_list/";

    /**
     * 获取抖音星图达人指数
     */
    String STAR_AUTHOR_SCORE = "https://open.douyin.com/star/author_score/";

    /**
     * 获取抖音星图达人指数数据 V2
     */
    String STAR_AUTHOR_SCORE_V2 = "https://open.douyin.com/star/author_score_v2/";

    //******************************** 抖音影视综艺榜单数据 ********************************

    /**
     * 获取抖音电影榜、抖音电视剧榜、抖音综艺榜
     */
    String DISCOVERY_ENT_RANK_ITEM = "https://open.douyin.com/discovery/ent/rank/item/";

    /**
     * 获取抖音影视综榜单版本
     */
    String DISCOVERY_ENT_RANK_VERSION = "https://open.douyin.com/discovery/ent/rank/version/";

    //******************************** 榜单数据 ********************************

    /**
     * 热门视频榜
     */
    String DATA_EXTERN_BILLBOARD_HOT_VIDEO = "https://open.douyin.com/data/extern/billboard/hot_video/";
}
