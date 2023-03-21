package douyin.common.constant;

/**
 * 抖音生活服务
 */
public interface DouYinLifeConstant {

    /**
     * 获取接口调用的凭证client_access_token
     */
    String CLIENT_TOKEN = "https://open.douyin.com/oauth/client_token/";

    //******************************** 门店管理 ********************************

    /**
     * 门店信息查询
     */
    String SHOP_POI_QUERY = "https://open.douyin.com/goodlife/v1/shop/poi/query/";

    /**
     * 门店信息更新
     */
    String SHOP_POI_UPDATE = "https://open.douyin.com/goodlife/v1/poi/poi/update/";

    //******************************** 团购核销 ********************************

    /**
     * 验券准备
     */
    String CERTIFICATE_PREPARE = "https://open.douyin.com/goodlife/v1/fulfilment/certificate/prepare/";

    /**
     * 验券
     */
    String CERTIFICATE_VERIFY = "https://open.douyin.com/goodlife/v1/fulfilment/certificate/verify/";

    /**
     * 撤销核销
     */
    String CERTIFICATE_CANCEL = "https://open.douyin.com/goodlife/v1/fulfilment/certificate/cancel/";

    /**
     * 券状态查询
     */
    String CERTIFICATE_GET = "https://open.douyin.com/goodlife/v1/fulfilment/certificate/get/";

    /**
     * 券状态批量查询
     */
    String CERTIFICATE_QUERY = "https://open.douyin.com/goodlife/v1/fulfilment/certificate/query/";

    //******************************** 团购对账 ********************************

    /**
     * 验券历史查询
     */
    String VERIFY_RECORD_QUERY = "https://open.douyin.com/goodlife/v1/fulfilment/certificate/verify_record/query/";

    /**
     * 账单详细查询
     */
    String DETAILED_QUERY = "https://open.douyin.com/goodlife/v1/settle/ledger/detailed_query/";

    //******************************** 会员接入 ********************************

    /**
     * 账单详细查询
     */
    String MEMBER_UPDATE = "https://open.douyin.com/goodlife/v1/member/user/update/";
}
