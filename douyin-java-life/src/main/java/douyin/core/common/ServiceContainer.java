package douyin.core.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ServiceContainer
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/3/20
 * @Version V1.0
 **/
public class ServiceContainer {

    private static Map<String, Object> serviceContainer = new HashMap<>();

    public static void registerService(String name, Object service) {
        ServiceContainer.serviceContainer.put(name, service);
    }

    public static Object getService(String name) {
        return ServiceContainer.serviceContainer.get(name);
    }
}
